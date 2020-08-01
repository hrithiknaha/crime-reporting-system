show databases;

create DATABASE crime_reporting_system;
use crime_reporting_system;
drop database crime_reporting_system;

insert into admin values(1,"Roy Jason");
insert into user values(10,1,"admin","ROLE_ADMIN","admin",1,null,null);

show tables;

select * from emergency_complaint;
select * from user;
select * from people;
select * from crime;
select * from complaint;
select * from admin;
select * from citizen;

update complaint
set status = "Completed"
where id = 3;



select * from police;

insert into police values(1,"Manohar Parikar");
insert into user values(20,1,"police","ROLE_POLICE","police",null,null,1);



/*For VS CODE EXTENSION, HAS NOTHING TO DO WITH THE PROJECT*/
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '<RN{59@(m' ;

flush privileges;






