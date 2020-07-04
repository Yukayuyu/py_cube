#! /bin/bash

#echo $0 $1 $2

array01=("$@")  # does not include the $0
echo ${array01[-1]}
echo ${array01[0]}

echo $@ #pring all
echo ${#array01[@]} #echo the length
echo $#
