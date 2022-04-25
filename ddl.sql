DROP TABLE STUDENT;
DROP TABLE login;
DROP TABLE courses;
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
create table login(username varchar not null unique,password varchar not null,primary key(username));
INSERT INTO TABLE login('admin','admin','admin');
CREATE TABLE courses(Course_name varchar not null,semester varchar,description varchar,type varchar);
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