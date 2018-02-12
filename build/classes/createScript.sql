create schema mydb;


create table student (
	id int primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name varchar(40));


create table grade (
	id int primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	subject varchar(40),
	score varchar(3),
	userid int
	);