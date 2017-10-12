-- bmember ���̺�

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


-- bmember �������� �߰�

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


-- bmember �ּ�

comment on table bmember is 'ȸ�� ���̺�';

comment on column bmember.m_id is 'ȸ�� ���̵�';
comment on column bmember.m_pw is 'ȸ�� ��й�ȣ';
comment on column bmember.m_name is 'ȸ�� �̸�';
comment on column bmember.m_nick is 'ȸ�� �г���';
comment on column bmember.m_birth is 'ȸ�� ����';
comment on column bmember.m_phone is 'ȸ�� �޴��ȣ';
comment on column bmember.m_mail is 'ȸ�� ����';
comment on column bmember.m_gender is 'ȸ�� ����';
comment on column bmember.m_address  is 'ȸ�� �ּ�';
comment on column bmember.m_quest is 'ȸ�� ���� ��ȣ';
comment on column bmember.m_answer is 'ȸ�� �亯';


-- bboard ������
			
create sequence bbor_seq
start with 6               
increment by 1
minvalue 1
nomaxvalue
nocycle
;