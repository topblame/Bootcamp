-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-06-02 17:06:31 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE
drop table hs_class_office;
drop table regis_course;
drop table hs_lecture;
drop table hs_student;
drop table hs_professor;

CREATE TABLE hs_class_office (
    class_off_id    VARCHAR2(10) NOT NULL,
    class_off_name  VARCHAR2(20),
    class_off_phone VARCHAR2(15),
    hs_stu_id       VARCHAR2(10) NOT NULL,
    prof_id         VARCHAR2(10) NOT NULL,
    lec_id          VARCHAR2(10) NOT NULL
);

ALTER TABLE hs_class_office ADD CONSTRAINT hs_class_office_pk PRIMARY KEY ( class_off_id );

CREATE TABLE hs_lecture (
    lec_id         VARCHAR2(10) NOT NULL,
    lec_name       VARCHAR2(15),
    lec_arch_grade CHAR(1),
    lec_time       NUMBER(1),
    lec_room       VARCHAR2(10),
    prof_id      VARCHAR2(10) NOT NULL
);

ALTER TABLE hs_lecture ADD CONSTRAINT hs_lecture_pk PRIMARY KEY ( lec_id );

CREATE TABLE hs_professor (
    prof_id      VARCHAR2(10) NOT NULL,
    class_off_id VARCHAR2(10),
    prof_name    VARCHAR2(15),
    prof_jumin   VARCHAR2(14),
    prof_addr    VARCHAR2(100),
    prof_phnum   VARCHAR2(15),
    prof_email   VARCHAR2(100)
);

ALTER TABLE hs_professor ADD CONSTRAINT hs_professor_pk PRIMARY KEY ( prof_id );

CREATE TABLE hs_student (
    hs_stu_id    VARCHAR2(10) NOT NULL,
    hs_class_id  VARCHAR2(10),
    hs_prof_id  VARCHAR2(10) NOT NULL,
    hs_stu_name  VARCHAR2(15) NOT NULL,
    hs_stu_num   VARCHAR2(14) NOT NULL,
    hs_stu_addr  VARCHAR2(100) NOT NULL,
    hs_stu_phnum VARCHAR2(15) NOT NULL,
    hs_stu_email VARCHAR2(100) NOT NULL
);

ALTER TABLE hs_student ADD CONSTRAINT hs_student_pk PRIMARY KEY ( hs_stu_id );

CREATE TABLE regis_course (
    class_code         VARCHAR2(10) NOT NULL,
    rc_atten_grade     VARCHAR2(10),
    rc_midterm_grade   VARCHAR2(10),
    rc_finalterm_grade VARCHAR2(10),
    rc_else_grade      VARCHAR2(10),
    rc_total           VARCHAR2(10),
    rc_avg_grade       VARCHAR2(10),
    lec_id             VARCHAR2(10) NOT NULL,
    stu_id             VARCHAR2(10) NOT NULL
);

ALTER TABLE regis_course
    ADD CONSTRAINT regis_course_pk PRIMARY KEY ( class_code,
                                                 lec_id,
                                                 stu_id );

ALTER TABLE hs_class_office
    ADD CONSTRAINT hs_class_office_hs_lecture_fk FOREIGN KEY ( lec_id )
        REFERENCES hs_lecture ( lec_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE hs_class_office
    ADD CONSTRAINT hs_class_office_hs_professor_fk FOREIGN KEY ( prof_id )
        REFERENCES hs_professor ( prof_id );

ALTER TABLE hs_class_office
    ADD CONSTRAINT hs_class_office_hs_student_fk FOREIGN KEY ( hs_stu_id )
        REFERENCES hs_student ( hs_stu_id );

ALTER TABLE hs_lecture
    ADD CONSTRAINT hs_lecture_hs_professor_fk FOREIGN KEY ( prof_id )
        REFERENCES hs_professor ( prof_id );

ALTER TABLE hs_student
    ADD CONSTRAINT hs_student_hs_professor_fk FOREIGN KEY ( hs_prof_id )
        REFERENCES hs_professor ( prof_id );

ALTER TABLE regis_course
    ADD CONSTRAINT regis_course_hs_lecture_fk FOREIGN KEY ( lec_id )
        REFERENCES hs_lecture ( lec_id );

ALTER TABLE regis_course
    ADD CONSTRAINT regis_course_hs_student_fk FOREIGN KEY ( stu_id )
        REFERENCES hs_student ( hs_stu_id );



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   3
-- WARNINGS                                 0
