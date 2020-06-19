#!/usr/bin/perl
use strict;
use warnings;
use CGI qw(:standard);

##read from data
my $str01 = param('cgiIn');

##display the result
print header;
print start_html("starthtml");
print "hi\n";
print $str01;

print end_html;
