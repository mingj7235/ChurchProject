
--청년부 멤버테이블
CREATE TABLE churchmember (
	user_num number(4) PRIMARY KEY,
	name varchar2(20) NOT NULL,
	phonenum varchar2(20) UNIQUE,
	age varchar2(10),
	grade varchar(20) 
	);

DROP TABLE CHURCHMEMBER ;



CREATE SEQUENCE member_seq
	START WITH 1
	INCREMENT BY 1;

--관리자 테이블
CREATE TABLE membergrade (
	user_id varchar2(10) PRIMARY KEY,
	pw varchar2(10) NOT NULL,
	detail varchar2(20)
)
--관리자 계정 (3개)
INSERT INTO membergrade VALUES ('admin', 'admin1234', '목사님계정');
INSERT INTO membergrade VALUES ('youth', 'youth1234', '임원들계정');
INSERT INTO membergrade VALUES ('newface', 'newface12', '새가족팀계정');

SELECT * FROM MEMBERGRADE WHERE USER_ID = 'admin';
SELECT * FROM CHURCHMEMBER;

COMMIT;