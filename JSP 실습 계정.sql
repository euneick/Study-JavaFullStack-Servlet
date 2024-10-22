create table t_member(
    id          varchar2(10) PRIMARY KEY,
    pwd         varchar2(10),
    name        varchar2(50),
    email       varchar2(50),
    joinDate   date default sysdate
);

insert into t_member
values('kang', '1212', '강감찬', 'kang@goguryeo.com', sysdate);

insert into t_member
values('lee', '1212', '이순신', 'lee@joseon.com', sysdate);

insert into t_member
values('kim', '1212', '김유신', 'kim@silla.com', sysdate);

commit;

select * from t_member;

desc t_member;