create table t_member(
    id          varchar2(10) PRIMARY KEY,
    pwd         varchar2(10),
    name        varchar2(50),
    email       varchar2(50),
    joinDate   date default sysdate
);

insert into t_member
values('hong', '1212', 'È«±æµ¿', 'hong@gmail.com', sysdate);

insert into t_member
values('lee', '1212', 'ÀÌ¼ø½Å', 'lee@test.com', sysdate);

insert into t_member
values('kim', '1212', '±èÀ¯½Å', 'kim@jweb.com', sysdate);

commit;

select * from t_member;
