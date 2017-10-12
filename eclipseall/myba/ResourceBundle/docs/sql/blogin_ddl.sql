-- blogin 테이블

create table blogin(
l_id varchar2(12),
l_start date,
l_end date,
l_status varchar2(2) not null,
l_ip varchar2(16)
);


-- blogin 제약조건 추가

alter table blogin modify l_id not null;
alter table blogin modify l_start default sysdate;
alter table blogin modify l_status default 'R';
alter table blogin add constraint ff_bblog_bmem foreign key(l_id) references bmember(m_id);

alter table blogin add constraint cc_bblog_id check(length(l_id)>=4);


-- blogin 주석

comment on table blogin is '로그 테이블';

comment on column blogin.l_id is '접속한 아이디';
comment on column blogin.l_start is '접속 시간';
comment on column blogin.l_end is '로그아웃 시간';
comment on column blogin.l_status is '접속한 아이디 상태';
comment on column blogin.l_ip is '접속한 장소의 ip';