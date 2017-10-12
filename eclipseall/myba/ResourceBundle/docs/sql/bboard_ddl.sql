-- bboard ���̺�

create table bboard(
b_id varchar2(12),
b_nick varchar2(20) not null,
b_pw varchar2(20) not null,
b_num number not null,
b_title varchar2(50) not null,
b_memo varchar2(1000),
b_time date,
b_visit number,
b_tag varchar2(500)
);


-- bboard �������� �߰�

alter table bboard modify b_time default sysdate;
alter table bboard modify b_visit default '0';
alter table bboard add constraint ff_bbor_bmem foreign key(b_id) references bmember(m_id);

alter table bboard add constraint cc_bbor_id check(length(b_id)>=4);
alter table bboard add constraint cc_bbor_nick check(length(b_nick)>=2);
alter table bboard add constraint cc_bbor_title check(length(b_title)>=2);
alter table bboard add constraint cc_bbor_visit check(b_visit>=0);


-- bboard �ּ�

comment on table bboard is '�Խ��� ���̺�';

comment on column bboard.b_id is '�Խñ� �ۼ��� ���̵�';
comment on column bboard.b_nick is '�Խñ� �ۼ��� �г���';
comment on column bboard.b_pw is '�Խñ��� ��й�ȣ';
comment on column bboard.b_num is '�Խñ� ��ȣ';
comment on column bboard.b_title is '�Խñ� ����';
comment on column bboard.b_memo is '�Խñ� ����';
comment on column bboard.b_time is '�Խñ� �ۼ��� �ð�';
comment on column bboard.b_visit is '�Խñ� �湮��';
comment on column bboard.b_tag is '�Խñ� �±�';