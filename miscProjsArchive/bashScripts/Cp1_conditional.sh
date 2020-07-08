#! /bin/bash
# this is single line comment
: 'a multi-line comment. the space afther the initial column
is necessay.'
cat << thistext
conditional statement
thistext

count=10
#gt lt ne eq 
if [ $count -lt 10 ]
then
    echo "lt"
elif (( $count == 10 ))
then
    echo "eq"
fi

#3 syntax:
#if [ "$count" -gt 1 ] && [ "$count" -gt 2 ]
#if [ "$count" -gt 1  -a  "$count" -gt 2 ]
if [[ "$count" -gt 1  ||  "$count" -gt 2 ]]
then
    echo "true"
fi

# case statment
car=$1
case $car in
    "BMW" )
        echo "BMW it is";;
    "HONDA" )
        ECHO "HONDA it is";;
    *)
        echo "whatever it is";;
esac
