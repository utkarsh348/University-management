DROP TABLE STUDENT;
DROP TABLE login;
DROP TABLE courses;
DROP TABLE student_table;
DROP TABLE professor;
DROP table faculty;
CREATE TABLE STUDENT(
    student_id varchar(10) NOT NULL, 
    student_name varchar, 
    phone_num varchar(10), 
    address varchar, 
    feeStat boolean,
    admissionStat varchar,
    batch varchar,
    PRIMARY KEY(student_id)
);
create table login(username varchar not null unique,password varchar not null,role varchar not null,primary key(username));
INSERT INTO login values('admin','admin','admin');
INSERT INTO login values('student','student','student');
INSERT into student values('1','Varun','9113240914','17115-Bella Vista','true','admitted','2019');
CREATE TABLE courses(
    Course_name varchar not null unique,
    semester varchar,
    description varchar,
    type varchar
);
CREATE Table student_table (
    student_id varchar(10) NOT NULL unique, 
    student_name varchar,
    semester varchar, 
    course_1 varchar,
    course_2 varchar,
    course_3 varchar,
    course_4 varchar,
    course_5 varchar,
    PRIMARY KEY(student_id)
);

Create table professor(
    professor_id varchar(10) NOT NULL unique,
    professor_name varchar,
    phone_num varchar(10),
    department varchar,
    PRIMARY KEY(professor_id),
    course_1 varchar,
    course_2 varchar,
    course_3 varchar,
    semc1 varchar,
    semc2 varchar,
    semc3 varchar
);
CREATE TABLE faculty(
    faculty_id varchar(10) NOT NULL unique,
    faculty_name varchar,
    phone_num varchar(10),
    core varchar,
    address varchar,
    PRIMARY KEY(faculty_id)
);
INSERT into faculty values('1','Rahul','9113240914','Computer Science','B415-Prestige Song of South');
INSERT into professor values('1','Rahul','9113240914','Computer Science','Maths','DBMS','DAA','2','3','4');