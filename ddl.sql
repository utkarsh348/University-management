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
