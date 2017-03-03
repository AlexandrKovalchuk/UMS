CREATE DATABASE institute;
USE institute;
create table institute(id int(6), longName varchar(70), shortName varchar(10), primary key (id));
INSERT INTO institute (id, longName, shortName) VALUES (0,'NONE', 'NONE');
INSERT INTO institute (id, longName, shortName) VALUES (1,'Київський Політехнічний Інститут', 'КПИ');
create table faculty(id int(6), longName varchar(70), shortName varchar(10), instituteID int(6), primary key (id));
INSERT INTO faculty (id, longName, shortName, instituteID) VALUES (0,'NONE', 'NONE', 0);
INSERT INTO faculty (id, longName, shortName, instituteID) VALUES (1,'Зварювальний факультет', 'ЗФ', 1);
create table department(id int(6), longName varchar(70), shortName varchar(10), facultyID int(6), primary key (id));
INSERT INTO department (id, longName, shortName, facultyID) VALUES (0,'NONE', 'NONE', 0);
INSERT INTO department (id, longName, shortName, facultyID) VALUES (1,'Кафедра зварювального виробництва', 'ЗВ', 1);
create table loginpass(id int(10), login varchar(70), password varchar(70), access_type varchar(20), primary key (id));
INSERT INTO loginpass (id,login, password, access_type) VALUES (0,'admin', '12345', 'admin');
create table employee(name varchar(40), lastName varchar(50), fathersName varchar(40), personalID varchar(10), sex varchar(1),
email varchar(100), phoneNumber varchar(20), dateOfBorn date, address varchar(200), passport varchar(200),
login varchar(100), office varchar(100), ID int(6), departmentID int(6), primary key (ID));
INSERT INTO employee(name, lastName, fathersName, personalID, sex, email, phoneNumber,  address,
passport, login, office, ID, departmentID) VALUES ('Employee','Employee','Employee', '12345', 'm', 'email@email.com',
 '1234567','adress test','pasport test','email@email.com','test',0,1);
INSERT INTO loginpass (id, login, password, access_type) VALUES (1,'email@email.com', '12345', 'employee');
create table discipline(
id int(10),
nameOfDiscipline varchar(200),
countOfLessons int(2),
exam varchar(4),
primary key (id)
);
create table disciplineTeacherDependency(
id int(10),
disciplineID int(10),
teacherID int(10),
primary key (id)
);
create table gtgroup(
id int(10),
fullGroupName varchar(30),
courseNumber int(1),
departmentID int(10),
primary key (id)
);
create table student(
name varchar(40),
lastName varchar(50),
fathersName varchar(40),
personalID varchar(10),
sex varchar(1),
email varchar(100),
phoneNumber varchar(20),
dateOfBorn date,
address varchar(200),
passport varchar(200),
login varchar(100),
indexBook varchar(100),
ID int(6),
groupID int(6),
primary key (ID)
);
create table teacher(
name varchar(40),
lastName varchar(50),
fathersName varchar(40),
personalID varchar(10),
sex varchar(1),
email varchar(100),
phoneNumber varchar(20),
dateOfBorn date,
address varchar(200),
passport varchar(200),
login varchar(100),
office varchar(100),
level varchar(100),
ID int(6),
departmentID int(6),
primary key (ID)
);
create table disciplineDepartmentDependency(
id int(10),
disciplineID int(10),
departmentID int(10),
courseNumber int(2),
semesterNumber int(2),
primary key (id)
);
create table attendance(
id int(10),
disciplineID int(10),
studentID int(10),
lesson1 varchar(1), lesson2 varchar(1), lesson3 varchar(1), lesson4 varchar(1), lesson5 varchar(1),
lesson6 varchar(1), lesson7 varchar(1), lesson8 varchar(1), lesson9 varchar(1), lesson10 varchar(1),
lesson11 varchar(1), lesson12 varchar(1), lesson13 varchar(1), lesson14 varchar(1), lesson15 varchar(1),
lesson16 varchar(1), lesson17 varchar(1), lesson18 varchar(1), lesson19 varchar(1), lesson20 varchar(1),
lesson21 varchar(1), lesson22 varchar(1), lesson23 varchar(1), lesson24 varchar(1), lesson25 varchar(1),
lesson26 varchar(1), lesson27 varchar(1), lesson28 varchar(1), lesson29 varchar(1), lesson30 varchar(1),
lesson31 varchar(1), lesson32 varchar(1), lesson33 varchar(1), lesson34 varchar(1), lesson35 varchar(1),
lesson36 varchar(1), lesson37 varchar(1), lesson38 varchar(1), lesson39 varchar(1), lesson40 varchar(1),
primary key (id)
);
create table progress(
id int(10),
disciplineID int(10),
studentID int(10),
examResult varchar(10),
lesson1 varchar(1), lesson2 varchar(1), lesson3 varchar(1), lesson4 varchar(1), lesson5 varchar(1),
lesson6 varchar(1), lesson7 varchar(1), lesson8 varchar(1), lesson9 varchar(1), lesson10 varchar(1),
lesson11 varchar(1), lesson12 varchar(1), lesson13 varchar(1), lesson14 varchar(1), lesson15 varchar(1),
lesson16 varchar(1), lesson17 varchar(1), lesson18 varchar(1), lesson19 varchar(1), lesson20 varchar(1),
lesson21 varchar(1), lesson22 varchar(1), lesson23 varchar(1), lesson24 varchar(1), lesson25 varchar(1),
lesson26 varchar(1), lesson27 varchar(1), lesson28 varchar(1), lesson29 varchar(1), lesson30 varchar(1),
lesson31 varchar(1), lesson32 varchar(1), lesson33 varchar(1), lesson34 varchar(1), lesson35 varchar(1),
lesson36 varchar(1), lesson37 varchar(1), lesson38 varchar(1), lesson39 varchar(1), lesson40 varchar(1),
primary key (id)
);
create table dayRequirements(
id int(10),
departmentID int(10),
countOfDaysInWeek int(1),
countOfLessonsInADay int(2),
lesson1 varchar(10),
lesson2 varchar(10),
lesson3 varchar(10),
lesson4 varchar(10),
lesson5 varchar(10),
lesson6 varchar(10),
lesson7 varchar(10),
lesson8 varchar(10),
lesson9 varchar(10),
lesson10 varchar(10),
lesson11 varchar(10),
lesson12 varchar(10),
lesson13 varchar(10),
lesson14 varchar(10),
lesson15 varchar(10),
lesson16 varchar(10),
lesson17 varchar(10),
lesson18 varchar(10),
lesson19 varchar(10),
lesson20 varchar(10),
primary key (id)
);
create table timetable(
id int(10),
dayNumber int(1),
lessonNumberInDay int(2),
departmentID int(10),
groupID int(10),
disciplineID int(10),
teacherID int(10),
primary key (id)
);
