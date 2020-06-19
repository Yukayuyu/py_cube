#!/bin/bash
echo "Content-type: text/html"
echo ""
echo '<html>'
echo '<head>'
echo '<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">'
echo '<title>Hello World</title>'
echo '</head>'
echo '<body>'
echo '<pre>'
echo $QUERY_STRING
echo $CONTENT_LENGTH
while read line; do
    echo $line
done
cat
echo '</pre>'
echo 'Env:'
echo '<pre>'
/usr/bin/env
echo '</pre>'
echo '</body>'
echo '</html>'
 
exit 0
