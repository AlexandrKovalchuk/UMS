Project name:
Umiversity Management System (UMS).

Description:
This is a demo project which is called to help in managing a structure like university.

Environment:
- apache-maven (used 3.3.9);
- apache-tomcat (used 8.0.24-windows-x64);
- mysql (used 5.6.31-winx64);

Data Base setup:
- set up mysql credentials;
- update credentials in file UMS\src\main\java\net\ukr\vixtibon\dao\config.properties;
- set up base using file base_setup.sql;

Installation:
- make package via maven;
- launch app via tomcat;

Functions:
App has different access areas for different users, each area has own functions.
To access any area user should log in.

Areas:
- Admin area;
- Employee area;
- Teacher area;
- Student area;

Main sections by areas:
Admin Area:
- Manage University Credentials (Create, Update, Delete, Show Info);
- Manage Faculty Credentials (Create, Update, Move, Delete, Show Info);
- Manage Department Credentials (Create, Update, Move, Delete, Show Info);
- Manage Employee Credentials (Create, Update, Move, Delete, Show Info);
Employee area:
- Manage Discipline Credentials (Create, Update,Set Dependency, Delete, Show Info);
- Manage Group Credentials (Create, Update, Move, Delete, Show Info);
- Manage Teacher Credentials (Create, Update, Move, Delete, Show Info);
- Manage Student Credentials (Create, Update, Move, Delete, Show Info);
- Manage Timetable Credentials (Create, Update);
- Set Day Requirements;
Teacher area:
- Update Attendance;
- Update Progress;
-Time Table;
Student area:
- Show Attendance;
- Show Progress;
- Time Table;
