-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-06-02 14:56:21 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE tb_std (
    id         NUMBER(10) NOT NULL,
    std_name   VARCHAR2(20),
    gender     VARCHAR2(10),
    email      VARCHAR2(20)
);

ALTER TABLE tb_std ADD CONSTRAINT tb_std_pk PRIMARY KEY ( id );

CREATE TABLE tb_user (
    id      NUMBER(10) NOT NULL,
    name    VARCHAR2(20),
    address VARCHAR2(50),
    phone   VARCHAR2(20)
);

ALTER TABLE tb_user ADD CONSTRAINT tb_user_pk PRIMARY KEY ( id );

ALTER TABLE tb_std
    ADD CONSTRAINT tb_std_tb_user_fk FOREIGN KEY ( id )
        REFERENCES tb_user ( id );



SELECT *FROM TB_STD;