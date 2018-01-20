package org.oldcode.javaweb;

import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;

import java.util.Base64;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class Password {

    private static final DigestRandomGenerator generator = new DigestRandomGenerator(new SHA3Digest(512));

    private Password() {}

    public static String hash(String plainPassword) {
        return hash(plainPassword, salt(128), 512, 101501);
    }

    public static String hash(String plainPassword, byte[] salt) {
        return hash(plainPassword, salt, 512, 101501);
    }

    public static String hash(String plainPassword, byte[] salt, int keyLength, int iterations) {
        checkArgument(!isNullOrEmpty(plainPassword), "password can not be empty or null");
        checkArgument(keyLength > 0, "the key length must be greater than 0");
        checkArgument(iterations >= 0, "the number of iterations must be positive");

        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
        generator.init(PBEParametersGenerator.PKCS5PasswordToBytes(
                plainPassword.toCharArray()),
                salt,
                iterations);

        return format("%s|%s",
                encode(salt),
                encode(((KeyParameter) generator.generateDerivedParameters(keyLength)).getKey()));
    }

    public static boolean verify(String plainPassword, String hash) {
        checkArgument(!isNullOrEmpty(plainPassword));
        checkArgument(!isNullOrEmpty(hash));
        return hash(plainPassword, decode(extractSalt(hash))).equals(hash);
    }

    private static byte[] salt(int count) {
        byte[] salt = new byte[count];
        generator.nextBytes(salt);
        return salt;
    }

    private static String encode(byte[] input) {
        return Base64.getEncoder().encodeToString(input);
    }

    private static byte[] decode(String input) {
        return Base64.getDecoder().decode(input.getBytes(UTF_8));
    }

    private static String extractSalt(String input) {
        return input.substring(0, input.indexOf("|"));
    }

}
/*
    To Store a Password

    Generate a long random salt using a CSPRNG.  Prepend the salt
        to the password and hash it with a standard password hashing
        function like Argon2, bcrypt, scrypt, or PBKDF2.  Save both the
        salt and the hash in the user's database record.

        To Validate a Password

        Retrieve the user's salt and hash from the database.  Prepend
        the salt to the given password and hash it using the same hash
        function.  Compare the hash of the given password with the hash
        from the database.  If they match, the password is correct.
        Otherwise, the password is incorrect.

        -------------------------
        Leverage Keyed functions

        Keyed functions, such as HMACs, compute a one-way (irreversible)
        transform using a private key and given input.  For example, HMACs
        inherit properties of hash functions including their speed, allowing
        for near instant verification.  Key size imposes infeasible size-
        and/or space- requirements on compromise--even for common credentials
        (aka password = ‘password’).  Designers protecting stored credentials
        with keyed functions:

        Use a single “site-wide” key;
        Protect this key as any private key using best practices;
        Store the key outside the credential store (aka: not in the database);
        Generate the key using cryptographically-strong pseudo-random data;
        Do not worry about output block size (i.e. SHA-256 vs. SHA-512).

        Example protect() pseudo-code follows:

        return [salt] + HMAC-SHA-256([key], [salt] + [credential]);


        --------------------------

        Leverage an adaptive one-way function

        Adaptive one-way functions compute a one-way (irreversible) transform.
        Each function allows configuration of ‘work factor’.  Underlying
        mechanisms used to achieve irreversibility and govern work factors
        (such as time, space, and parallelism) vary between functions and
        remain unimportant to this discussion.

        Select:

        Argon2[*7] is the winner of the password hashing competition
        and should be considered as your first choice for new applications;
        PBKDF2 [*4] when FIPS certification or enterprise support on
        many platforms is required; scrypt [*5] where resisting any/all
        hardware accelerated attacks is necessary but support isn’t.
        bcrypt where PBKDF2 or scrypt support is not available.

        Example protect() pseudo-code follows:

        return [salt] + pbkdf2([salt], [credential], c=10000);

        Designers select one-way adaptive functions to implement protect()
        because these functions can be configured to cost (linearly or
        exponentially) more than a hash function to execute.  Defenders
        adjust work factor to keep pace with threats’ increasing hardware
        capabilities.  Those implementing adaptive one-way functions must
        tune work factors so as to impede attackers while providing acceptable
        user experience and scale.

        Additionally, adaptive one-way functions do not effectively prevent
        reversal of common dictionary-based credentials (users with password
        ‘password’) regardless of user population size or salt usage.
        */



