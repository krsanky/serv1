package org.oldcode.javaweb;

import com.google.common.base.Charsets;
import org.junit.Test;

import java.util.Base64;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.oldcode.javaweb.Password.hash;
import static org.oldcode.javaweb.Password.verify;

public class PasswordTest {

    @Test public void
    hash_password_with_PKCS5() {
        String password = hash("password", Base64.getEncoder().encode("HelloWorld".getBytes(Charsets.UTF_8)));
        assertThat(password, equalTo("U0dWc2JHOVhiM0pzWkE9PQ==|9oIHmBVsNFeUkoajyncM928Hsqb34IhY7csx0odLr/r6/9vlZPQMmUlcYW+jv2zQKz+3h4rWu3sEOblzpi8Acg=="));
    }

    @Test public void
    verify_password() {
        boolean match = verify("password", hash("password"));
        assertThat("the passwords should have matched", match, equalTo(true));
    }

    @Test public void
    throws_exception_if_password_is_null() {
        try {
            hash(null);
        } catch (Exception e) {
            assertThat(e.getMessage(), equalTo("password can not be empty or null"));
        }
    }

    @Test public void
    throws_exception_if_password_is_empty() {
        try {
            hash(" ");
        } catch (Exception e) {
            assertThat(e.getMessage(), equalTo("password can not be empty or null"));
        }
    }
}
