SELECT name as 'customerName', SUM(price) as 'pricesum' FROM mySimpleDBSchema.gb1
LEFT JOIN gb2
ON gb1.fk = gb2.id
GROUP BY name;
/*-----------------------------------------------------------------------------*/
SELECT users.id, users.name, users.mail, COUNT(posts.id) AS post_number, COUNT(favorites.id) AS favorites_number 
FROM users        
LEFT JOIN posts
ON users.id = posts.user
LEFT JOIN favorites 
ON users.id = favorites.user
WHERE users.act = 1 
AND posts.act = 1 
GROUP BY users.id 
ORDER BY users.id DESC;
