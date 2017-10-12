-- bmember 테이블

create table bmember(
m_id varchar2(12),
m_pw varchar2(20) not null,
m_name varchar2(14) not null,
m_nick varchar2(20) not null,
m_birth date,  //not null
m_phone varchar2(15),
m_mail varchar2(30),
m_gender varchar2(2) not null,
m_address varchar2(40),
m_quest number,  //not null
m_answer varchar2(50)  //not null
// m_cash number
);


-- bmember 제약조건 추가

alter table bmember add constraint pp_bmem_id primary key(m_id);
alter table bmember add constraint uu_bmem_nick unique(m_nick);
alter table bmember modify m_birth default to_date(sysdate,'yyyy-mm-dd');
alter table bmember modify m_gender default 'M';
alter table bmember modify m_birth not null;
alter table bmember modify m_quest not null;
alter table bmember modify m_answer not null;

alter table bmember modify m_phone default '';
alter table bmember modify m_mail default '';
alter table bmember modify m_address default '';

alter table bmember add constraint cc_bmem_id check(length(m_id)>=4);
alter table bmember add constraint cc_bmem_pw check(length(m_pw)>=6);
alter table bmember add constraint cc_bmem_nick check(length(m_nick)>=2);


-- bmember 주석

comment on table bmember is '회원 테이블';

comment on column bmember.m_id is '회원 아이디';
comment on column bmember.m_pw is '회원 비밀번호';
comment on column bmember.m_name is '회원 이름';
comment on column bmember.m_nick is '회원 닉네임';
comment on column bmember.m_birth is '회원 생일';
comment on column bmember.m_phone is '회원 휴대번호';
comment on column bmember.m_mail is '회원 메일';
comment on column bmember.m_gender is '회원 성별';
comment on column bmember.m_address  is '회원 주소';
comment on column bmember.m_quest is '회원 질문 번호';
comment on column bmember.m_answer is '회원 답변';


-- bboard 시퀀스
			
create sequence bbor_seq
start with 6               
increment by 1
minvalue 1
nomaxvalue
nocycle
;