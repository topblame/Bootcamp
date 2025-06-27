create table member(
id varchar2(20),
pass1 varchar2(20),
pass2 varchar2(20),
email varchar2(20),
gender varchar2(20),
address varchar2(40),
phone varchar2(20),
hobby varchar2(20),
job varchar2(20),
age varchar2(20),
info varchar2(40)
);
select * from member;

commit;

----
-- Board
-- Sequence 생성
drop sequence board_seq;

create sequence board_seq
start with 1
increment by 1
minvalue 1
maxvalue 1000;

create table board(
    NUM         NUMBER PRIMARY KEY ,
    writer      VARCHAR2(20) NOT NULL,
    email       VARCHAR2(50) NOT NULL,
    SUBJECT     VARCHAR2(50) NOT NULL,
    PASSWORD    VARCHAR2(10) NOT NULL,
    reg_date    date,
    REF         NUMBER NOT NULL,
    RE_STEP     NUMBER NOT NULL,
    RE_LEVEL    NUMBER NOT NULL,
    READCOUNT   NUMBER NOT NULL,
    CONTENT    VARCHAR2(5) NOT NULL
);

select * from board;