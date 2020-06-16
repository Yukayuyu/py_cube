-- 1、 Student TBLのSname、Ssex、Class列を全部表示
SELECT sname, ssex,`class` FROM student;
-- 2、 重複なしのDepart（現有学部一覧）。
SELECT depart FROM teacher GROUP BY depart;
-- 3、 Student TBLの全部レコード。
SELECT * FROM student;
-- 4、 Score　TBLに60～80の全部レコード。
SELECT * FROM score WHERE degree BETWEEN 60 AND 80;
-- 5、 Score TBLに成績85，86又は88のレコード。
SELECT * FROM score WHERE degree IN(85, 86, 88);
-- 6、 Student TBLに“95031”クラスまたは性別=“女”のレコード。
SELECT * FROM student WHERE `class` = 95031 OR ssex = 'F';
-- 7、 Student TBLの全部レコード（Classで降順）。
SELECT * FROM student ORDER BY `class` DESC;
-- 8、 Score TBLの全部レコード(Cno昇順、Degree降順)。
SELECT * FROM score ORDER BY `cno` ASC, `degree` DESC;
-- 9、 “95031”Classの生徒人数。
SELECT COUNT(sno) as 'pplNo.' FROM student GROUP BY `class` HAVING `class` = '95031';
-- 10、ScoreTBLに実績最高の生徒の生徒番号、課程名称。
SELECT sno, cno FROM score WHERE degree = (SELECT MAX(degree) FROM score);
-- 11、課程 ‘3-105’の平均得点。
SELECT AVG(degree) as 'AVG of 3-105' FROM score GROUP BY cno HAVING cno = '3-105';
-- 12、ScoreTBLに5人以上が履修登録をし、頭文字「3」の課程の平均点数。
-- ! careful, no result: SELECT AVG(degree) FROM score WHERE cno LIKE '^3%' GROUP BY cno HAVING COUNT(sno) > 5;
SELECT AVG(degree) FROM score WHERE cno LIKE '^3%' AND COUNT(sno) > 5 GROUP BY cno ;
-- 13、全部課程の成績70～ 90の学生Sno。
-- ! careful, SELECT sno is ambiguous returns no result.
SELECT student.sno FROM student RIGHT JOIN score ON student.sno = score.sno WHERE degree BETWEEN 70 AND 90;
-- 14、全部学生のSname、Cno、Degree列。
SELECT sname, cno, degree FROM score LEFT JOIN student ON student.sno = score.sno;
-- 15、全部学生のSno、Cname、Degree列。
SELECT score.sno, cname, degree FROM score LEFT JOIN course ON course.cno = score.cno;
-- 16、全部学生のSname、Cname、Degree列。
SELECT sname, cname, degree FROM score LEFT JOIN course ON course.cno = score.cno LEFT JOIN student ON student.sno = score.sno;
-- 17、クラス“95033”の生徒の全部課程の平均点数。
SELECT AVG(degree) FROM score LEFT JOIN student ON student.sno = score.sno WHERE `class` = '95033';
-- 18、gradeTBL作る：
-- create table grade(low   number(3,0),upp   number(3),rank   char(1));
-- insert into grade values(90,100,’A’);
-- insert into grade values(80,89,’B’);
-- insert into grade values(70,79,’C’);
-- insert into grade values(60,69,’D’);
-- insert into grade values(0,59,’E’);
-- commit;
-- 全部学生のSno、Cno、rank列。
-- ! a peculiar method
SELECT score.sno, score.cno, rank FROM score, grade WHERE degree BETWEEN grade.low_number AND grade.upp_number ORDER BY rank;
-- 19、“3-105”課程を選修している、成績が番号“109”の生徒より良い生徒。
SELECT sname FROM student JOIN score ON student.sno=score.sno WHERE `cno`='3-105' AND degree > (SELECT degree FROM score WHERE sno = '109' AND cno = '3-105');
-- 20、scoreTBLに選修課程二科以上（>=2）の生徒の点数が最高点数ではないレコード。
SELECT sno, cno, MAX(degree) as md FROM score GROUP BY cno HAVING EXISTS
(SELECT sno, cno FROM score GROUP BY cno HAVING Count(cno) > 1);
-- 21、成績が生徒番号“109”、課程“3-105の成績より高い成績の全部レコード。
SELECT * FROM score WHERE degree > (SELECT degree FROM score WHERE sno = '109' AND cno = '3-105');
-- 22、生徒番号108の生徒と同じ年に生まれた全部生徒のSno、Sname、Sbirthday列。
SELECT student.sno, sname, sbirthday FROM student WHERE YEAR(sbirthday) = (SELECT YEAR(sbirthday) FROM student WHERE sno = '108');
-- 23、“小林“先生の生徒たちの成績。
SELECT degree FROM score LEFT JOIN course ON score.cno = course.cno
JOIN teacher ON course.tno = teacher.tno AND tname = 'Kobayashi';

SELECT s.sno, s.sname, s.ssex FROM student s JOIN score sc ON s.sno = sc.sno WHERE sc.cno IN (SELECT c.cno FROM course c JOIN teacher t ON c.tno = t.tno WHERE tname = 'Kobayashi');
-- 24、選修生徒人数は5名上の課程の担当教師の姓名。
SELECT tname FROM teacher LEFT JOIN course ON course.tno = teacher.tno LEFT JOIN score ON score.cno = course.cno  GROUP BY course.cno HAVING COUNT(sno) > 5;
-- 25、95033と 95031のクラスの全部学生の情報。
SELECT * FROM student WHERE `class` IN ('95033', '95031');
-- 26、85点以上を取得した生徒がいる課程のCno. 
SELECT cno FROM score WHERE MAX(degree) > 85 GROUP BY cno;
-- 27、“情報学部“先生の全部課程の生徒の成績
SELECT sno, degree FROM score LEFT JOIN course ON course.cno = score.cno LEFT JOIN teacher ON course.tno = teacher.tno WHERE teacher.depart = 'CS';
-- 28、“情報学部”の先生の中に、“電子学部“の先生らが持っていないPROFを持つ先生のTnameとProf。
SELECT tname, PROF FROM teacher WHERE depart = 'CS' AND PROF NOT IN (SELECT PROF FROM teacher WHERE depart = 'Electric');
-- 29、 課程“3-105“を履修している成績が課程“3-245”の成績のいずれより良い生徒のCno、Sno、Degree, Degree降順で取得。
SELECT cno, student.sno, degree FROM student LEFT JOIN score ON student.sno = score.sno WHERE score.cno = '3-105' AND degree > ANY (SELECT degree FROM score WHERE cno = '3-245');

-- 30、課程“3-105“を選修している成績が課程“3-245”の成績より良い生徒のCno、Sno、Degree, Degree降順で取得。
-- IMPORTANT tmpA cannot be called like: tmpA AS tmpB;
-- ! wrong query SELECT * FROM score WHERE degree>ALL(SELECT degree FROM score WHERE cno='3-245') ORDER BY degree DESC;
-- step 1:
SELECT * FROM (SELECT sno, degree, cno FROM score A WHERE cno = '3-105') AS tmpA JOIN (SELECT sno, degree, cno FROM score A WHERE cno = '3-245')AS tmpB ON tmpA.sno = tmpB.sno;
-- step 2:
SELECT tmpA.sno, tmpA.degree FROM (SELECT sno, degree, cno FROM score A WHERE cno = '3-105') AS tmpA JOIN (SELECT sno, degree, cno FROM score A WHERE cno = '3-245')AS tmpB ON tmpA.sno = tmpB.sno AND tmpA.degree > tmpB.degree;
-- 31、先生と生徒全員のname、sexとbirthday
SELECT sname AS `name`, ssex AS sex, sbirthday AS birthday FROM student
UNION
SELECT tname AS `name`, TSEX AS sex, tbirthday AS birthday FROM teacher;
-- 32、女性の先生と生徒全員のnameとbirthday
SELECT sname AS `name`, ssex AS sex, sbirthday AS birthday FROM student
UNION
SELECT tname AS `name`, TSEX AS sex, tbirthday AS birthday FROM teacher WHERE TSEX = 'F';
-- 33、成績が該当課程の平均成績より低いの生徒の成績表
SELECT degree, cno, sno FROM score A WHERE degree < (SELECT AVG(degree) FROM score B WHERE A.cno = B.cno GROUP BY cno);
SELECT tblA.*, tblB.savg FROM (SELECT degree, cno, sno FROM score A WHERE degree < (SELECT AVG(degree) FROM score B GROUP BY cno HAVING A.cno = B.cno)) AS tblA LEFT JOIN (SELECT cno, AVG(degree) AS savg FROM score GROUP BY cno) AS tblB ON tblA.cno = tblB.cno;
-- Best:
SELECT degree, score.cno, sno, avgT1.savg FROM score LEFT JOIN 
(SELECT cno, AVG(degree) AS savg FROM score GROUP BY cno) AS avgT1
ON score.cno = avgT1.cno
WHERE score.degree < avgT1.savg;
-- 34、課程を開講している先生のTnameとDepart.
SELECT tname, depart FROM teacher LEFT JOIN course ON teacher.tno = course.tno WHERE cno IS NOT NULL;
-- 36、男性人数は2名以上超えているクラスのCNO
SELECT cno FROM student LEFT JOIN score ON student.sno = score.sno WHERE EXISTS (SELECT `class` FROM student GROUP BY `class`, `ssex` HAVING COUNT(ssex) >= 2 );
-- 37、Student TBLに “麒麟”ではない生徒
SELECT * FROM student WHERE sname NOT LIKE 'Kirin';
-- 38、Student TBLに全部生徒の姓名と年齢
SELECT sname AS `name`, (YEAR(NOW()) - YEAR(sbirthday)) AS age FROM student;
-- 39、Student TBLに最大と最小のSbirthdayのDate
SELECT MAX(sbirthday) FROM student
UNION
SELECT MIN(sbirthday) FROM student;
-- 40、クラスと年齢の降順でStudent　TBLに全員のレコード
SELECT * FROM student ORDER BY `class` DESC,
sbirthday ASC;
-- 41、男性先生と開講課程の一覧
SELECT tname, depart FROM teacher LEFT JOIN course ON teacher.tno = course.tno WHERE cno IS NOT NULL AND teacher.TSEX = 'M';
-- 42、最高成績の生徒のSno、Cno、Degree
SELECT score.sno, score.cno, score.degree FROM score WHERE degree = (SELECT MAX(degree) FROM score);
-- 43、“麒麟”と同じ性別の生徒のSname.
SELECT sname FROM student WHERE ssex = (SELECT ssex FROM student WHERE sname = 'Kirin');
-- 44、“麒麟”と同じ性別の同クラスの生徒のSname.
SELECT sname FROM student WHERE ssex = (SELECT ssex FROM student WHERE sname = 'Kirin') AND `class` = (SELECT `class` FROM student WHERE sname = 'Kirin');
-- 45、“コンピュータ”を選修している男性生徒の成績表
SELECT score.sno, score.cno, degree FROM score LEFT JOIN student ON score.sno = student.sno
LEFT JOIN course ON score.cno = course.cno
WHERE cname = 'Computer' AND ssex = 'M';
-- IMPORTANT!!! 46、”小林”先生の担当課程に成績の一番良い生徒
SELECT ktbl.kst AS student, MAX(ktbl.kdg) AS HighestScore FROM (SELECT score.sno AS kst, score.degree AS kdg FROM score LEFT JOIN course ON score.cno = course.cno
LEFT JOIN teacher ON teacher.tno = course.tno
WHERE tname = 'Kobayashi') AS ktbl;
-- 47、各課程の成績最高の生徒
SELECT score.sno, MAX(score.degree) AS 'MaxDegree' FROM score GROUP BY cno;
-- 48、各課程の成績最高の生徒の前2位
-- TOP N --
-- IMPORTANT --
WITH tmp AS (SELECT score.sno, score.cno, score.degree FROM score ORDER BY cno, degree)
SELECT t1.* FROM tmp t1 LEFT JOIN tmp t2
ON (t1.cno = t2.cno AND t1.degree > t2.degree) GROUP BY t1.sno, t1.cno
HAVING COUNT(*) < 2;


-- 49、各生徒の番号、姓名、選修課程数、全部課程の総点数
SELECT student.sno, student.sname, COUNT(cno), SUM(degree) FROM student JOIN score ON student.sno = score.sno GROUP BY student.sno;
-- 50、今月また来月、誕生日の生徒
SELECT student.sno, student.sname FROM student WHERE ((MONTH(sbirthday) - MONTH(NOW())) <= 2);

-- 51, Select student whose overallAverage(avg of all courses) is higher than the average(everybody's) overallAverage .
-- IMPORTANT!! --
-- step1:
SELECT score.degree, score.cno, score.sno, savg FROM score 
LEFT JOIN (SELECT AVG(score.degree) AS savg, sno FROM score GROUP BY sno) AS avtT
ON (score.sno = avtT.sno);
-- step2:
WITH tmp AS (
SELECT score.degree, score.cno, score.sno, savg FROM score 
LEFT JOIN (SELECT AVG(score.degree) AS savg, sno FROM score GROUP BY sno) AS avtT
ON (score.sno = avtT.sno)
),
tavg AS (
SELECT AVG(savg) as tavg FROM tmp 
)
SELECT * FROM tmp
CROSS JOIN tavg -- append tavg to the all results --
WHERE degree > tavg;
