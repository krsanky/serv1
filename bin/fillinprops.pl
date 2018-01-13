#!/usr/bin/env perl

# pkg install p5-Config-Properties
# (do whatever is equivalent for your OS)

use strict;
use warnings;

use Cwd;
use Config::Properties;

### MAIN ###

#chdir $ENV{'HOME'}.'/JAVA/serv1';
chdir "$ENV{'HOME'}/JAVA/serv1";
#print getcwd . "\n";

# read properties:
my $props_file = 'src/main/resources/settings.properties';
open my $fh, '<', $props_file
    or die "unable to open properties file";

my $properties = Config::Properties->new();
$properties->load($fh);

# gather files to fill in:
my @fillins = (
    'src/main/webapp/META-INF/context.xml',
);

#...
my $key = 'db_password';
my $value = $properties->getProperty($key);
print "$value\n";

### SUBS ###
sub make_key { # $file_line
    my $file_line;
    if (defined($_[0])) {$file_line = $_[0];}
    else { die "make_key() needs 1 arg : $? \n"; }

    return substr( $file_line, 0, 14);
}

