
CREATE TABLE churchmember (
	user_num number(4) PRIMARY KEY,
	name varchar2(10) NOT NULL,
	phonenum varchar2(20) NOT NULL UNIQUE,
	age varchar2(10),
	grade varchar(20), 
	chief varchar2(10)
	);

CREATE SEQUENCE member_seq
	START WITH 1
	INCREMENT BY 1;

CREATE TABLE membergrade (
	


)

COMMIT;