create user 'security'@'%' identified by 'security';
grant all privileges on *.* to 'security'@'%';
create database security;
use security;

select * from user;