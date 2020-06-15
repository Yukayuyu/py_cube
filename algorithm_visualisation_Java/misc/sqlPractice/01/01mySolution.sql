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
-- 9、 “95031”Classの生徒人数。
-- 10、ScoreTBLに実績最高の生徒の生徒番号、課程名称。
-- 11、課程 ‘3-105’の平均得点。
-- 12、ScoreTBLに5人以上選修、頭文字「3」の課程の平均点数。
-- 13、全部課程の成績70～ 90の学生Sno。
-- 14、全部学生のSname、Cno、Degree列。
-- 15、全部学生のSno、Cname、Degree列。
-- 16、全部学生のSname、Cname、Degree列。
-- 17、クラス“95033”の生徒の全部課程の平均点数。
-- 18、gradeTBL作る：
-- create table grade(low   number(3,0),upp   number(3),rank   char(1));
-- insert into grade values(90,100,’A’);
-- insert into grade values(80,89,’B’);
-- insert into grade values(70,79,’C’);
-- insert into grade values(60,69,’D’);
-- insert into grade values(0,59,’E’);
-- commit;
-- 全部学生のSno、Cno、rank列。
-- 19、“3-105”課程を選修している、成績が番号“109”の生徒より良い生徒。
SELECT sname FROM student JOIN score ON student.sno=score.sno WHERE `cno`='3-105' AND degree > (SELECT degree FROM score WHERE sno = '109' AND cno = '3-105');
-- 20、scoreTBLに選修課程二科以上（>=2）の生徒の点数が最高点数ではないレコード。
SELECT sno, cno, MAX(degree) as md FROM score GROUP BY cno HAVING EXISTS
(SELECT sno, cno FROM score GROUP BY cno HAVING Count(cno) > 1);
             -- 21、成績が生徒番号“109”、課程“3-105の成績より高い成績の全部レコード。
-- 22、生徒番号108の生徒と同じ年に生まれた全部生徒のSno、Sname、Sbirthday列。
-- 23、“小林“先生の生徒たちの成績。
-- 24、選修生徒人数は5名上の課程の担当教師の姓名。
-- 25、95033と 95031のクラスの全部学生の情報。
-- 26、生徒成績が85以上ある課程のCno.
-- 27、“情報学部“先生の全部課程の生徒の成績
-- 28、“情報学部”の 先生は“電子学部“の先生の所有職位と違う先生のTnameと Prof。
-- 29、 課程“3-105“を選修している成績が課程“3-245”の成績のいずれより良い生徒のCno、Sno、Degree, Degree降順で取得。
-- 30、課程“3-105“を選修している成績が課程“3-245”の成績より良い生徒のCno、Sno、Degree, Degree降順で取得。
-- 31、先生と生徒全員のname、sexとbirthday
-- 32、女性の先生と生徒全員のnameとbirthday
-- 33、成績が該当課程の平均成績より低いの生徒の成績表
-- 34、課程を開講している先生のTnameとDepart.
-- 35、 課程を開講している先生のTnameとDepart.
-- 36、男性人数は2名以上超えているクラスのCNO
-- 37、Student TBLに “麒麟”ではない生徒
-- 38、Student TBLに全部生徒の姓名と年齢
-- 39、Student TBLに最大と最小のSbirthdayのDate
-- 40、クラスと年齢の降順でStudent　TBLに全員のレコード
-- 41、男性先生と開講課程の一覧
-- 42、最高成績の生徒のSno、Cno、Degree
-- 43、“麒麟”と同じ性別の生徒のSname.
-- 44、“麒麟”と同じ性別の同クラスの生徒のSname.
-- 45、“コンピュータ”を選修している男性生徒の成績表
-- 46、”小林”先生の担当課程に成績の一番良い生徒
-- 47、各課程の成績最高の生徒
-- 48、各課程の成績最高の生徒の前2位
-- 49、各生徒の番号、姓名、選修課程数、全部課程の総点数
-- 50、今月また来月、誕生日の生徒
