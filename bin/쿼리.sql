drop table if exists member;

create table member(
    memberid varchar(20) primary key  comment '아이디',
    name varchar(10) comment '이름',
    pw varchar(20) comment '암호',
    phone char(13) comment '전화번호',
    email varchar(30) comment '이메일',
    regtime datetime comment '등록일'
) comment '회원명단';

insert into member values ('duly','둘리','2222','010-1234-5678','duly@naver.com','2023-03-29 14:06:10');
insert into member values ('hani','하니','1234','010-5678-1234','hani@nate.com',now());
insert into member values ('micol','마이콜','5555','010-8888-3234','micol@mbc.com',curdate());
delete from member where memberid = 'kbs';
