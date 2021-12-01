create user 'security'@'%' identified by 'security';
grant all privileges on *.* to 'security'@'%';
create database security;
use security;

select * from user;

desc user;

update user set role = 'ROLE_MANAGER' where id = 2;
update user set role = 'ROLE_ADMIN' where id = 3;

 