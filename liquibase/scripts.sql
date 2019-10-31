select * from dbw.r_database_type
select * from dbw.c_database

update dbw.c_database set when_available = current_timestamp;


insert into dbw.c_database
values (1,'ORACLE','Oracle AWS','jdbc:oracle:thin:@oracle.aws.io-tahoe.com:1521:orcl','admin','admin-password')

