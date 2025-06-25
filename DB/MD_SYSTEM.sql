-- 18c 계정 등록 권한 
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

--계정생성(member)
create user OVERFLOW IDENTIFIED by 12345;

-- 기본 접속 권한 부여 
grant CONNECT, RESOURCE to OVERFLOW;
-- view, sequence 생성 권한 부여
grant create view, create sequence to OVERFLOW;

-- 용량 할당 
ALTER USER OVERFLOW DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;



-- ---------------------------------------------
create user soldesk IDENTIFIED by 12345;

grant CONNECT, RESOURCE to soldesk;

grant create view, create sequence to soldesk;

ALTER USER soldesk DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;