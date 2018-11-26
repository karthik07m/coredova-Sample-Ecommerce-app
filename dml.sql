use ftp93;

/*This is employee data is  for employee table*/
insert into employee values
(3000,'Gaurav','gaurav32@hexaware.com',9908059770,'2018-10-11','Trainee',10,2000);
insert into employee values(3001,'Mani Karthik','karthik453@hexaware.com',9956382741,'2018-10-11','Trainee',2,2001);
insert into employee values(3002,'Pratyusha','pratyusha423@hexaware.com',9874563214,'2018-10-11','Trainee',6,2000);
insert into employee values(3003,'Kavitha','kavitha123@hexaware.com',98747659214,'2018-10-11','Trainee',7,2001);
desc employee;

/*This is manager data  for employee table */

insert into employee values(2000,'Vimala','vimala@hexaware.com',8908059770,'2003-08-12','Manager',1,1000);
insert into employee values(2001,'Muruganadham','muruganadham53@hexaware.com',8856382741,'2001-02-13','Manager',2,1000);

/*This data is for CEO table */
insert into employee values
(1000,'Sri Krishna','krishna@hexaware.com',9956992791,'2004-01-20','CEO',12,NULL);
select * from employee;

/* This data is for leave details*/
insert into leave_details values
(3000,1230,3,'2018-12-20','2018-12-23','EL','A','fever','2018-12-19','granted');
insert into leave_details values(3001,1231,2,'2018-12-18','2018-12-20','EL','A','function','2018-12-12','Always taking leaves');
insert into leave_details values(3002,1234,3,'2018-11-23','2018-11-25','EL','D','Native Place','2018-11-22','Permission denied');
insert into leave_details values(3003,1235,2,'2018-11-19','2018-11-21','EL','A','Health problem','2018-11-19','Granted');
UPDATE leave_details
SET LVD_LEAVE_STATUS ='A' where emp_id=3003;
select * from leave_details;