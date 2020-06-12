CREATE TABLE student
(sno VARCHAR(45) NOT NULL,
sname VARCHAR(45) NOT NULL,
ssex VARCHAR(2) NOT NULL,
sbirthday DATETIME,
class VARCHAR(45),
primary key (sno));

CREATE TABLE teacher
(tno VARCHAR(45) NOT NULL,
tname VARCHAR(45) NOT NULL, TSEX VARCHAR(2) NOT NULL,
tbirthday DATETIME NOT NULL, PROF VARCHAR(45),
depart VARCHAR(45) NOT NULL,
primary key (tno));

CREATE TABLE course (
    cno VARCHAR(45) NOT NULL,
    cname VARCHAR(45) NOT NULL,
    tno VARCHAR(45) NOT NULL,
primary key (cno),
foreign key (tno)
    references teacher(tno));

CREATE TABLE score
(sno VARCHAR(45) NOT NULL,
cno VARCHAR(45) NOT NULL,
degree NUMERIC(10, 1) NOT NULL,
foreign key (sno)
    references student(sno),
foreign key (cno)
    references course(cno));

