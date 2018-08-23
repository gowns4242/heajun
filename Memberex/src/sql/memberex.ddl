DROP TABLE member_table1 CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: 회원정보 테이블 */
/**********************************/
CREATE TABLE member_table1(
		id                            		VARCHAR2(20)		 NOT NULL		 PRIMARY KEY,
		pw                            		VARCHAR2(20)		 NOT NULL,
		name                          		VARCHAR2(50)		 NOT NULL,
		gender                        		CHAR(5)		 NOT NULL,
		email                         		VARCHAR2(50)		 NOT NULL,
		mobile                        		VARCHAR2(15)		 NOT NULL,
		phone                         		VARCHAR2(15)		 NULL ,
		zip                           		CHAR(5)		 NULL ,
		address                       		VARCHAR2(200)		 NULL ,
		birthday                      		DATE		 NOT NULL,
		joindate                      		DATE		 NOT NULL
);

COMMENT ON TABLE member_table1 is '회원정보 테이블';
COMMENT ON COLUMN member_table1.id is '아이디';
COMMENT ON COLUMN member_table1.pw is '패쓰워드';
COMMENT ON COLUMN member_table1.name is '이름';
COMMENT ON COLUMN member_table1.gender is '성별';
COMMENT ON COLUMN member_table1.email is '메일주소';
COMMENT ON COLUMN member_table1.mobile is '연락처1';
COMMENT ON COLUMN member_table1.phone is '연락처2';
COMMENT ON COLUMN member_table1.zip is '도로명 우편번호';
COMMENT ON COLUMN member_table1.address is '도로명 주소';
COMMENT ON COLUMN member_table1.birthday is '생년월일';
COMMENT ON COLUMN member_table1.joindate is '가입일';


