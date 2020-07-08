#! /bin/bash
echo "Enter dir name to check if exist"
read dirName

if [ -d "$dirName" ]
then
    echo "$dirName exists"
else
    echo "$dirName does not exists"
fi

