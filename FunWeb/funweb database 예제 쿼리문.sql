-- DB 사용자 생성
create user 'euneick'@'%' identified by '1234';

create database funweb;

use funweb;

-- 권한 부여
grant all privileges on funweb.* to 'euneick'@'%';

create table member(
	id 			varchar(12) primary key,
    pwd 		varchar(12) not null,
    name 		varchar(20) not null,
    join_date 	datetime not null
);

alter table member add age 		int;    		-- age열(회원 나이)을 추가
alter table member add gender 	varchar(5);    	-- gender열(회원성별)을 추가
alter table member add email 	varchar(30);	-- email열(회원이메일)을 추가
alter table member add address 	varchar(500);	-- address열(회원주소)을 추가
alter table member add tel 		varchar(20);	-- tel열(회원전화번호)을 추가
alter table member add mtel 	varchar(20);	-- mtel열(회원휴대폰번호)을 추가

insert into member(id, pwd, name, join_date, age, gender, email, address, tel, mtel)
values('lee', '1234', '이순신', now(), 20, '남', 'lee@joseon.com', '부산', '05112341234', '01012341234');

select * from member;

-- 영구 반영
commit;

create table board(
	num 		int primary key auto_increment, -- 글번호    auto_increment제약조건추가  insert하지 않아도 자동으로 1씩 늘어나면서 추가됨 
    name 		varchar(20), -- 글쓴이(글작성자명)
    pwd 		varchar(20), -- 글의 비밀번호 
    subject 	varchar(50), -- 글 제목
    content 	varchar(2000), -- 글 내용 
    pos 		int, -- 주글(부모글)로부터 파생된 답변글(자식글)들이 같은 값을 가지기 위한 그룹값 
    depth 		int, -- 답변글을 글목록에 보여주기 위한 들여쓰기 정도값 
    count 		int, -- 글 조회수 
    ip 			varchar(50),  -- 글을 작성한 사람의 IP주소 
    join_date 	datetime, -- 글 작성한 날짜 
    id 			varchar(12), -- 가입한 글을 작성하는 사람의 아이디 
    
    foreign key (id) references member(id) -- member테이블의 가입한 회원만 글을 작성할수 있게 제약조건 설정
   -- board테이블의 id열 을 외래키로 설정하고
   -- member테이블의 id열을 기본키로 설정 해서  서로 연결을 시켜 준다.
)AUTO_INCREMENT = 1;

-- board테이블에  글정보들 추가

insert into board(name, pwd, subject, content, pos, depth, count, ip, join_date, id)
values('이순신', '1234', '제목1', '글내용1', 0, 0, 0, 'localhost', now(), 'lee');

insert into board(name, pwd, subject, content, pos, depth, count, ip, join_date, id)
values('이순신', '1234', '제목22', '글내용22', 0, 0, 0, 'localhost', now(), 'lee');

insert into board(name, pwd, subject, content, pos, depth, count, ip, join_date, id)
values('이순신', '1234', '제목333', '글내용333', 0, 0, 0, 'localhost', now(), 'lee');

delete from board;
drop table board;

select * from board;
























