-- student table schema
-- SELECT roll, name, marks from student

drop table student;

create table student (
	roll number(3) primary key,
	name varchar2(10) not null,
	marks number(3) not null
);


insert into student values('101', 'John', '87'); 
insert into student values('102', 'Naman', '90');  
insert into student values('103', 'Chirag', '85');  
insert into student values('104', 'David', '92');  
insert into student values('105', 'Kelly', '81');  
insert into student values('106', 'Charles', '77');  
insert into student values('107', 'Jerry', '91');  
insert into student values('108', 'Beth', '75');  
insert into student values('109', 'Caroline', '82');  
insert into student values('110', 'Hanen', '71');  
insert into student values('111', 'Douglas', '57');  
insert into student values('112', 'Tim', '86');  
insert into student values('113', 'Michael', '68');  
insert into student values('114', 'Kimbley', '88');  
insert into student values('115', 'Christina', '72'); 

commit;

