-- 고객 테이블 DML

insert into customer values ('idisa1', 'password1', '이원호', 'Lee', 'wonho', 'M', to_date('1993. 12. 11', 'yyyy. mm. dd'), 'korea', '010-3611-3608', 'leewonho93@naver.com', 'N', 'Y', '', 'vip', 50000, 50000);
insert into customer values ('idisa2', 'password2', '김주원', 'Kang', 'guwon', 'F', to_date('2001. 02. 10', 'yyyy. mm. dd'), 'korea', '010-1233-4545', 'leewonho93@naver.com', 'Y', 'Y', '', 'silver', 400, 400);
insert into customer values ('idisa3', 'password3', '홍길이', 'Hong', 'gilelee', 'F', to_date('1998. 08. 08', 'yyyy. mm. dd'), 'usa', '010-3524-6567', 'leewonho93@naver.com', 'Y', 'N', '', 'gold', 8000, 12000);
insert into customer values ('idisa4', 'password4', '홍길동', 'Hong', 'giledong', 'M', to_date('1973. 05. 02', 'yyyy. mm. dd'), 'japen', '010-5678-6645', 'leewonho93@naver.com', 'N', 'N', '', 'silver', 350, 350);
insert into customer values ('idisa5', 'password5', '길라임', 'Gile', 'ralim', 'M', to_date('1962. 11. 25', 'yyyy. mm. dd'), 'china', '010-2583-5621', 'leewonho93@naver.com', 'N', 'Y', '', 'gold', 12450, 51420);

-- 직원 테이블 DML

insert into employee values (201212, 'emp123', '길무원', 'Gile', 'muwon', 'M', to_date('1962. 11. 25', 'yyyy. mm. dd'), '010-3214-5621', 'leewonho93@naver.com', '', 'E');
insert into employee values (185401, 'emp456', '비행자', 'Bee', 'hangja', 'M', to_date('1982. 01. 07', 'yyyy. mm. dd'), '010-3575-4565', 'bihang@hanmail.net', '', 'E');
insert into employee values (154821, 'emp789', '김무리', 'Kim', 'muri', 'F', to_date('1995. 04. 05', 'yyyy. mm. dd'), '010-6458-5621', 'sangsang@naver.com', '', 'E');
insert into employee values (587689, 'emp741', '이리듐', 'Lee', 'ridum', 'F', to_date('1965. 06. 21', 'yyyy. mm. dd'), '010-7642-5756', 'goodes@hanmail.net', '', 'E');
insert into employee values (542321, 'emp852', '강미영', 'Kang', 'miyoung', 'F', to_date('1980. 07. 29', 'yyyy. mm. dd'), '010-1245-3568', 'dgdgfd@naver.com', '', 'E');
insert into employee values (1111111, '', '', '', '', '', to_date('', ''), '', '', '', 'A');

-- 비행기 테이블 DML

insert into airplane values (25421, 'ABC-123', '여객기', 200, to_date('1993. 05. 02', 'yyyy. mm. dd'), 'bisu', '운항 가능', 2, 'c', 4, 'd', 10, 'f');
insert into airplane values (15412, 'ABC-123', '여객기', 200, to_date('1993. 08. 22', 'yyyy. mm. dd'), 'bisu', '운항 가능', 2, 'c', 4, 'd', 10, 'f');
insert into airplane values (25879, 'BCD-657', '화물기', 20, to_date('1997. 06. 05', 'yyyy. mm. dd'), 'bee', '운항 가능', 0, 'A', 0, 'd', 10, 'B');
insert into airplane values (46564, 'ABC-123', '여객기', 200, to_date('2003. 05. 02', 'yyyy. mm. dd'), 'bisu', '수리중', 2, 'c', 4, 'd', 10, 'f');
insert into airplane values (21212, 'BCD-657', '화물기', 20, to_date('1996. 08. 08', 'yyyy. mm. dd'), 'bee', '운항 가능', 0, 'A', 0, 'd', 10, 'B');

-- 게시판 테이블 DML

insert into board values(1, '질문입니다', '질문이 있습니다', 'idisa1', to_date(sysdate, 'yyyy. mm. dd'), 'Y');
insert into board values(2, '안녕하세요', '안녕하십니까', 'idisa1', to_date(sysdate, 'yyyy. mm. dd'), 'N');
insert into board values(3, 'test입니다', 'test', 'idisa3', to_date(sysdate, 'yyyy. mm. dd'), 'N');
insert into board values(4, 'testtest', 'testtest', 'idisa3', to_date(sysdate, 'yyyy. mm. dd'), 'N');
insert into board values(5, '테스트', '테스트입니다', 'idisa3', to_date(sysdate, 'yyyy. mm. dd'), 'N');

-- 공지사항 테이블 DML

insert into notice values(1, '필독', '공지사항게시판입니다', to_date('2017. 09. 26','yyyy. mm. dd'));
insert into notice values(2, '필독해주세요', '공지사항게시판입니다', to_date('2017. 09. 25','yyyy. mm. dd'));
insert into notice values(3, '공지사항', '공지사항게시판입니다', to_date('2017. 09. 24','yyyy. mm. dd'));
insert into notice values(4, '사이트 점검 안내', '공지사항게시판입니다', to_date('2017. 09. 23','yyyy. mm. dd'));
insert into notice values(5, '야간 점검 안내', '공지사항게시판입니다', to_date('2017. 09. 22','yyyy. mm. dd'));

-- 답글 테이블 DML
insert into reply values(1, '안녕하세요', to_date(sysdate, 'yyyy. mm. dd'));
insert into reply values(2, '반갑습니다', to_date('2017. 09. 29','yyyy. mm. dd'));
insert into reply values(3, '누구세요', to_date('2017. 09. 28','yyyy. mm. dd'));
insert into reply values(4, '반가워요', to_date('2017. 09. 27','yyyy. mm. dd'));
insert into reply values(5, '스마일', to_date('2017. 09. 26','yyyy. mm. dd'));


