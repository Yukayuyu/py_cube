SELECT i1.*
FROM item i1
LEFT OUTER JOIN item i2
  ON (i1.category_id = i2.category_id AND i1.item_id < i2.item_id)
GROUP BY i1.item_id
HAVING COUNT(*) < 4
ORDER BY category_id, date_listed;
-- https://stackoverflow.com/questions/1442527/how-to-select-the-newest-four-items-per-category/1442867#1442867 --

-- sqlPractice 01 --
WITH tmp AS (SELECT score.sno, score.cno, score.degree FROM score ORDER BY cno, degree)
SELECT t1.* FROM tmp t1 LEFT JOIN tmp t2
ON (t1.cno = t2.cno AND t1.degree > t2.degree) GROUP BY t1.sno, t1.cno
HAVING COUNT(*) < 2;
