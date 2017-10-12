-- 고객 테이블

comment on table CUSTOMER is '고객 테이블';

comment on column CUSTOMER.C_ID is '고객 아이디';
comment on column CUSTOMER.C_PW is '고객 비밀번호';
comment on column CUSTOMER.C_KNAME is '고객 한글 이름';
comment on column CUSTOMER.C_ELNAME is '고객 영문 (성)';
comment on column CUSTOMER.C_EFNAME is '고객 영문 (이름)';
comment on column CUSTOMER.C_SEX is '고객 성별';
comment on column CUSTOMER.C_BIRTH is '고객 생년월일';
comment on column CUSTOMER.C_NATION is '고객 국가';
comment on column CUSTOMER.C_MOBILE is '고객 전화번호';
comment on column CUSTOMER.C_EMAIL is '고객 이메일';
comment on column CUSTOMER.C_EMAILCH is '고객 이메일 수신 동의';
comment on column CUSTOMER.C_MOBILECH is '고객 전화번호 수신 동의';
comment on column CUSTOMER.C_ADDRESS is '고객 주소';
comment on column CUSTOMER.C_GRADE is '고객 등급';
comment on column CUSTOMER.C_MILE is '고객 마일리지';
comment on column CUSTOMER.TOTALMILE is '고객 총 합 마일리지';

-- 직원 comment
comment on table EMPLOYEE is '직원 테이블';

comment on column EMPLOYEE.E_ID is '직원 아이디';
comment on column EMPLOYEE.E_PW is '직원 비밀번호';
comment on column EMPLOYEE.E_KNAME is '직원 한글 이름';
comment on column EMPLOYEE.E_EFNAME is '직원 영문 (성)';
comment on column EMPLOYEE.E_ELNAME is '직원 영문 (이름)';
comment on column EMPLOYEE.E_SEX is '직원 성별';
comment on column EMPLOYEE.E_BIRTH is '직원 생년월일';
comment on column EMPLOYEE.E_MOBILE is '직원 전화번호';
comment on column EMPLOYEE.E_EMAIL is '직원 이메일';
comment on column EMPLOYEE.E_ADDRESS is '직원 주소';
comment on column EMPLOYEE.E_STATUS is '직원 관리자 구분';

-- 직원 comment
comment on table AIRPLANE is '비행기 테이블';

comment on column AIRPLANE.A_NUM is '비행기 고유번호';
comment on column AIRPLANE.A_KIND is '비행기 기종';
comment on column AIRPLANE.A_TYPE is '비행기 종류';
comment on column AIRPLANE.A_PAX is '비행기 최대 탑승 인원';
comment on column AIRPLANE.A_MDATE is '비행기 제작년도';
comment on column AIRPLANE.A_MAKE is '비행기 제조사';
comment on column AIRPLANE.A_STATE is '비행기 상태(운항, 수리 etc)';
comment on column AIRPLANE.A_FIRROW is '비행기 퍼스트 좌석 행';
comment on column AIRPLANE.A_FIRCOL is '비행기 퍼스트 좌석 열';
comment on column AIRPLANE.A_BINROW is '비행기 비즈니스 좌석 행';
comment on column AIRPLANE.A_BINCOL is '비행기 비즈니스 좌석 열';
comment on column AIRPLANE.A_ECOROW is '비행기 이코노미 좌석 행';
comment on column AIRPLANE.A_ECOCOL is '비행기 이코노미 좌석 열';

-- 운항일지 comment
comment on table FLIGHT is '운항일지 테이블';

comment on column FLIGHT.F_DATE is '운항일자';
comment on column FLIGHT.F_ANUM is '비행기 번호';
comment on column FLIGHT.F_FNAME is '편명';
comment on column FLIGHT.F_LEAVE is '출발지';
comment on column FLIGHT.F_LEVDATE is '출발일자';
comment on column FLIGHT.F_ARRIVE is '도착지';
comment on column FLIGHT.F_ARRIDATE is '도착일자';
comment on column FLIGHT.F_GATE is '비행기 게이트';

-- 예매 comment
comment on table RESERVATION is '예매 테이블';

comment on column RESERVATION.R_NUM is '예매 번호';
comment on column RESERVATION.R_NAME is '예매자 명';
comment on column RESERVATION.R_DEPARTURE is '출발지';
comment on column RESERVATION.R_DEPARTURETIME is '출발일자';
comment on column RESERVATION.R_ARRIVAL is '도착지';
comment on column RESERVATION.R_ARRIVALTIME is '도착일자';
comment on column RESERVATION.R_SEAT is '좌석';
comment on column RESERVATION.R_ANUM is '비행기 번호';
comment on column RESERVATION.R_DATE is '예매 날짜';
comment on column RESERVATION.R_FNAME is '편명';
comment on column RESERVATION.R_CLASS is '클래스';

-- 표 comment
comment on table TICKET is '비행기 표 테이블';

comment on column TICKET.T_NAME is '비행기 탑승자';
comment on column TICKET.T_DATE is '비행 일자';
comment on column TICKET.T_SEAT is '좌석';
comment on column TICKET.T_DEPARTURE is '출발지';
comment on column TICKET.T_DEPARTURETIME is '출발일자';
comment on column TICKET.T_ARRIVAL is '도착지';
comment on column TICKET.T_ARRIVALTIME is '도착일자';
comment on column TICKET.T_CLASS is '클래스';
comment on column TICKET.T_GATE is '게이트';
comment on column TICKET.T_FNAME is '편명';
comment on column TICKET.T_BAGNUM is '수하물 번호';

-- 공지사항 comment
comment on table NOTICE is '공지사항 테이블';

comment on column NOTICE.N_NUM is '게시물 번호';
comment on column NOTICE.N_TITLE is '제목';
comment on column NOTICE.N_CONTENTS is '내용';
comment on column NOTICE.N_DATE is '등록 일자';

-- 게시판 comment
comment on table BOARD is '게시판 테이블';

comment on column BOARD.B_NUM is '게시물 번호';
comment on column BOARD.B_TITLE is '제목';
comment on column BOARD.B_CONTENTS is '내용';
comment on column BOARD.B_ID is '작성자';
comment on column BOARD.B_DATE is '작성일';
comment on column BOARD.B_CHECK is '답변 유무';

-- 게시판 comment
comment on table REPLY is '답변 테이블';

comment on column REPLY.REP_NUM is '답변 번호';
comment on column REPLY.REP_CONTENTS is '내용';
comment on column REPLY.REP_DATE is '답변 일자';

-- 우편번호(도로명) comment
comment on table POST is '주소 테이블';

comment on column POST.P_POST is '우편 번호';
comment on column POST.P_DO is '도 단위';
comment on column POST.P_GU is '구 단위';
comment on column POST.P_ROAD is '도로명';
comment on column POST.P_RFIRST is '도로명 번호(주)';
comment on column POST.P_RSECOND is '도로명 번호(부)';
comment on column POST.P_BUILD is '건물명';
comment on column POST.P_DONG is '동 단위';
comment on column POST.P_SUBDONG is '동(부) 단위';
comment on column POST.P_DFIRST is '동 번호(주)';
comment on column POST.P_DSECOND is '동 번호(부)';



