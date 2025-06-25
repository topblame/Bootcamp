-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-06-04 10:22:19 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE 고객 (
    cust_jumin VARCHAR2(10) NOT NULL,
    고객명        VARCHAR2(20) 
--  ERROR: VARCHAR2 size not specified 
    ,
    고객주소       VARCHAR2(50)
--  ERROR: VARCHAR2 size not specified 
    ,
    고객생년월일     VARCHAR2(20) 
--  ERROR: VARCHAR2 size not specified 
    ,
    고객이메일      VARCHAR2(50)
--  ERROR: VARCHAR2 size not specified 
    ,
    고객전화번호     VARCHAR2 (20)
--  ERROR: VARCHAR2 size not specified 
    ,
    고객직업       VARCHAR2(20)
--  ERROR: VARCHAR2 size not specified 

);

ALTER TABLE 고객 ADD CONSTRAINT 고객_pk PRIMARY KEY ( cust_jumin );

CREATE TABLE 예금계좌 (
    예금계좌id     VARCHAR2(10) NOT NULL,
    cust_jumin VARCHAR2(10) NOT NULL,
    예금계좌종류     VARCHAR2(20),
    예금잔고       NUMBER(10),
    카드신청여부     VARCHAR2(5),
    예금개설일      DATE,
    예금자이름      VARCHAR2(20),
    전화번호       VARCHAR2(20),
    이메일        VARCHAR2(50)
);

ALTER TABLE 예금계좌 ADD CONSTRAINT 예금계좌_pk PRIMARY KEY ( 예금계좌id );

CREATE TABLE 예금계좌거래내역 (
    acc_id VARCHAR2(10) NOT NULL,
    입출금날짜  DATE NOT NULL,
    거래번호   NUMBER(10) NOT NULL,
    예금구분   VARCHAR2(20),
    예금내용   VARCHAR2(50),
    거래금액   NUMBER(30),
    예금잔고   NUMBER(10)
);

ALTER TABLE 예금계좌거래내역
    ADD CONSTRAINT 예금계좌거래내역_pk PRIMARY KEY ( acc_id,
                                             입출금날짜,
                                             거래번호 );

CREATE TABLE 카드 (
    card_id            VARCHAR2(15) NOT NULL,
    cust_jumin         VARCHAR2(10) NOT NULL,
    acc_id             VARCHAR2(10) NOT NULL,
    card_register_date DATE,
    card_limit_money   NUMBER(10),
    card_approve_date  DATE,
    card_type          VARCHAR2(10) NOT NULL
);

ALTER TABLE 카드 ADD CONSTRAINT 카드_pk PRIMARY KEY ( card_id );

ALTER TABLE 카드
    ADD CONSTRAINT acc_id FOREIGN KEY ( acc_id )
        REFERENCES 예금계좌 ( 예금계좌id );

ALTER TABLE 카드
    ADD CONSTRAINT cust_jumin FOREIGN KEY ( cust_jumin )
        REFERENCES 고객 ( cust_jumin );

ALTER TABLE 예금계좌
    ADD CONSTRAINT cust_juminv1 FOREIGN KEY ( cust_jumin )
        REFERENCES 고객 ( cust_jumin );

ALTER TABLE 예금계좌거래내역
    ADD CONSTRAINT 예금계좌거래내역_예금계좌_fk FOREIGN KEY ( acc_id )
        REFERENCES 예금계좌 ( 예금계좌id );



