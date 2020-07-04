#! /bin/bash

while read line
do
    echo "$line"
done < "${1:-/dev/stdin}"

#the default-value syntax
#use C-d to print foo
echo ${2:-foo}
