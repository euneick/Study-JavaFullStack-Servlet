create table t_member(
    id          varchar2(10) PRIMARY KEY,
    pwd         varchar2(10),
    name        varchar2(50),
    email       varchar2(50),
    joimnDate   date default sysdate
);