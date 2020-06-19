#!/usr/bin/perl
use strict;
use warnings;
use CGI;
my $cgi = CGI->new();
print $cgi=>header;

<!DOCTYPE html>
#<html>
#  <body>
#    <p>
$line=<STDIN>;
if($line eq "n"){
    print "blank line";
} else{
    print "$line"
}
#    </p>
#  </body>
#</html>
print <<'END';
