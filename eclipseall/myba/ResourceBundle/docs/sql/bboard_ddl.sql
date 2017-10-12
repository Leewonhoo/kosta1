-- bboard 테이블

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


-- bboard 제약조건 추가

alter table bboard modify b_time default sysdate;
alter table bboard modify b_visit default '0';
alter table bboard add constraint ff_bbor_bmem foreign key(b_id) references bmember(m_id);

alter table bboard add constraint cc_bbor_id check(length(b_id)>=4);
alter table bboard add constraint cc_bbor_nick check(length(b_nick)>=2);
alter table bboard add constraint cc_bbor_title check(length(b_title)>=2);
alter table bboard add constraint cc_bbor_visit check(b_visit>=0);


-- bboard 주석

comment on table bboard is '게시판 테이블';

comment on column bboard.b_id is '게시글 작성한 아이디';
comment on column bboard.b_nick is '게시글 작성한 닉네임';
comment on column bboard.b_pw is '게시글의 비밀번호';
comment on column bboard.b_num is '게시글 번호';
comment on column bboard.b_title is '게시글 제목';
comment on column bboard.b_memo is '게시글 내용';
comment on column bboard.b_time is '게시글 작성한 시간';
comment on column bboard.b_visit is '게시글 방문수';
comment on column bboard.b_tag is '게시글 태그';