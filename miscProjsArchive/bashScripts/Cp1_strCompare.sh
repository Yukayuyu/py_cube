#! /bin/bash
echo "enter first str"
read str1
echo "enter second str"
read str2


if [ "str1" \< "$str2" ]
then
    echo "str1 smaller"
else
    echo "str1 larger"
fi
