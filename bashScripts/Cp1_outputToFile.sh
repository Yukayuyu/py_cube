#! /bin/bash
# this is single line comment
: 'a multi-line comment. the space afther the initial column
is necessay.'
# cat >> Cp1_outputfile.txt

cat << thistext
print test.
without "EOF" it works
thistext



