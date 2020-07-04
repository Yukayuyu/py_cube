#! /bin/bash

number=1
while [ $number -lt 10 ]
do
    echo "$number"
    number=$(( number+1 ))
    (( number++ ))
done

b=1
(( b++ ))
echo "b = $b"  
echo "c = $(( 1+2 ))"

for i in 1 2 3 4 5
do
    echo $i
done

#{do..start..end}
for i in {0..10..2}
do
    echo $i
done

echo "-----------------"
for (( j=0; j<3; j++ ))
do
    echo $j
    if [ $j -eq 1 ]
    then
        continue
    else
        echo $j
    fi
done

