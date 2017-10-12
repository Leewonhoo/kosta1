-- blogin ���̺�

create table blogin(
l_id varchar2(12),
l_start date,
l_end date,
l_status varchar2(2) not null,
l_ip varchar2(16)
);


-- blogin �������� �߰�

alter table blogin modify l_id not null;
alter table blogin modify l_start default sysdate;
alter table blogin modify l_status default 'R';
alter table blogin add constraint ff_bblog_bmem foreign key(l_id) references bmember(m_id);

alter table blogin add constraint cc_bblog_id check(length(l_id)>=4);


-- blogin �ּ�

comment on table blogin is '�α� ���̺�';

comment on column blogin.l_id is '������ ���̵�';
comment on column blogin.l_start is '���� �ð�';
comment on column blogin.l_end is '�α׾ƿ� �ð�';
comment on column blogin.l_status is '������ ���̵� ����';
comment on column blogin.l_ip is '������ ����� ip';