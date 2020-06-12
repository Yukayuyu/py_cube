SELECT id, name, dept, gender, score ,
CASE WHEN score >= 80 THEN "優"
WHEN 80 > score AND score >= 70 THEN "良"
WHEN 70 > score AND score >= 60 THEN "可"
WHEN 60 > score THEN "不可"
ELSE "未測定"
END AS "評価"
FROM name_dept_gender_score;
/*-------------------------------------------------------*/
CREATE TABLE user(name TEXT, address TEXT);

INSERT INTO user VALUES('A_Electric', 'Tokyo');
INSERT INTO user VALUES('B_Motor', 'Chiba');
INSERT INTO user VALUES('C_Mobile', 'Kanagawa');
INSERT INTO user VALUES('D_Shipping', 'Osaka');

SELECT
  name, address, 
  CASE address
    WHEN 'Tokyo' THEN 'Yamada'
    WHEN 'Kanagawa' THEN 'Furuta'
    WHEN 'Chiba' THEN 'Yamada'
    ELSE 'Endo'
  END AS sales
FROM user;
/*-------------------------------------------------------*/
CREATE TABLE department (id VARCHAR(45) NOT NULL, department_name VARCHAR(45) NOT NULL, PRIMARY KEY (id))
CREATE TABLE pos (id VARCHAR(45) NOT NULL, pos_name VARCHAR(45) NOT NULL, PRIMARY KEY (id))
CREATE TABLE employee (
    id VARCHAR(45)NOT NULL,
    pos_name VARCHAR(45),
    PRIMARY KEY (id)))
/*-------------------------------------------------------*/

