CREATE DATABASE MEETTDB; -- db 생성

CREATE USER meett@localhost; -- 사용자 생성tbl_room

GRANT all privileges on  *.* TO meett@localhost; -- 권한부여

ALTER USER 'meett'@'localhost'
identified WITH mysql_native_password BY 'meett12345';
flush privileges;

select * from tbl_user;
select* from tbl_schedule;
select * from tbl_team;
select * from tbl_team_schedule;
select * from tbl_room;

select *
from tbl_room R left join tbl_team T
	on R.team_id = T.t_team_id
WHERE R.team_id = "Team1";

select * from tbl_team_schedule TT
where TT.team_id  = "Team5";

use meettdb;

SELECT * 
FROM tbl_room, tbl_team;


drop table tbl_user;
drop table tbl_schedule;
drop table tbl_room;
drop table tbl_team;
drop table tbl_team_schedule;
drop table hibernate_sequence;

SELECT * FROM information_schema.table_constraints
where tbl_team;

 SHOW INDEXES IN tbl_team;
 
 select * from information_schema.table_constraints where table_schema="meettdb" and table_name="tbl_team";
 
 
