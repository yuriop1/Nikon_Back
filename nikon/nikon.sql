String mid = rs.getString("mid");
            String mpw = rs.getString("mpw");
            String mname = rs.getString("mname");
            String mtel = rs.getString("mtel");
            String memail = rs.getString("memail");
            String mzipcode = rs.getString("mzipcode");
            String maddr1 = rs.getString("maddr1");
            String maddr2 = rs.getString("maddr2");          
create table nikonmember(mid varchar2(100) primary key, 
mpw varchar2(100) not null,
mname varchar2(100) not null,
mtel varchar2(100),
memail varchar2(100),
mzipcode varchar2(100),
maddr1 varchar2(100),
maddr2 varchar2(100))

drop table nikonmember

select * from nikonmember
select * from NIKONnotice

int bno = rs.getInt("bno");
            String bcom = rs.getString("bcom");
            String baddr = rs.getString("baddr");
            String btel = rs.getString("btel");           
create table nikonbox(bno number(8) primary key,             
bcom varchar2(100) not null,
baddr varchar2(100),
btel varchar2(100))



company.setCcode(ccode);
            company.setCtel(ctel);    
create table nikoncompany(ccode varchar2(100) primary key, ctel varchar2(100))            



int seq = rs.getInt("seq");
            String nname = rs.getString("nname");
            String ntit = rs.getString("ntit");
            String ncon = rs.getString("ncon");
            Date regdate = rs.getDate("nregdate");
            int nvisited = rs.getInt("nvisited");
create table nikonnotice(
seq number(8) primary key, 
nname varchar2(100) not null,
ntit varchar2(100),
ncon varchar2(100),
nregdate date,
nvisited number(8))


int payno = rs.getInt("payno");
            String paycom = rs.getString("paycom");
            Date paydate = rs.getDate("paydate");
            String payname = rs.getString("payname");
            int payprice = rs.getInt("payprice");      
create table nikonpay 
(payno number(8) primary key,
paycom varchar2(100),
paydate date,
payname varchar2(100),
payprice number(8))
create sequence system.nikonpay_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

drop table nikonpay

create table nikonpay(payid varchar2(40) primary key, 
userid varchar2(16), proid number(8), 
cnt number(8), 
addr1 varchar2(100), 
contact varchar2(40), 
paytype number(2), 
creditnum varchar2(30), 
credipw varchar2(10));
alter table payment modify paytype number(4);

drop table nikonpay

create sequence system.nikonpay_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

insert into paytype values (paytype_seq.nextval, '카드', '신한카드', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '농협카드', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '우리카드', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '롯데카드', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '현대카드', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '아메리칸익스프레스', '000-000-000');
insert into paytype values (paytype_seq.nextval, '카드', '하나카드', '000-000-000');

insert into paytype values (paytype_seq.nextval, '계좌이체', '우리은행', '002-279121-18-311');
insert into paytype values (paytype_seq.nextval, '계좌이체', '국민은행', '119590-12-799819');
insert into paytype values (paytype_seq.nextval, '계좌이체', '하나은행', '464-908739-14037');
insert into paytype values (paytype_seq.nextval, '계좌이체', '외환은행', '921-043726-639');
insert into paytype values (paytype_seq.nextval, '계좌이체', '시티은행', '453-57359-926-04');
insert into paytype values (paytype_seq.nextval, '계좌이체', '신한은행', '249-90128-912310');
insert into paytype values (paytype_seq.nextval, '계좌이체', '농협은행', '108207-64-391366');
insert into paytype values (paytype_seq.nextval, '계좌이체', '기업은행', '594-166721-97-361');
insert into paytype values (paytype_seq.nextval, '계좌이체', '우체국', '820833-80-633870');
insert into paytype values (paytype_seq.nextval, '계좌이체', '카카오뱅크', '3333-1234-4321-12');
insert into paytype values (paytype_seq.nextval, '계좌이체', '토스뱅크', '272-3421-3723-927');

insert into paytype values (paytype_seq.nextval, '포인트결제', 'OK캐시백', '123-1234-123456');

insert into paytype values (paytype_seq.nextval, '지역화폐', '경기도', '');
insert into paytype values (paytype_seq.nextval, '지역화폐', '서울시', ' ');
insert into paytype values (paytype_seq.nextval, '지역화폐', '고양시', ' ');
insert into paytype values (paytype_seq.nextval, '지역화폐', '일산동구', ' ');



select * from nikonpay



String pcode = rs.getString("pcode");
            String pname = rs.getString("pname");
            String pinfo = rs.getString("pinfo");
            int pprice = rs.getInt("pprice");
            String pimg = rs.getString("pimg");
create table nikonproduct
(pcode varchar2(100) primary key,
pname varchar2(100) not null,
pinfo varchar2(100),
pprice number(8),
pimg varchar2(100))


String scode = rs.getString("scode");
            String sid = rs.getString("sid");
            int sprice = rs.getInt("sprice");
            String splace = rs.getString("splace");
            String srecieve = rs.getString("srecieve");
create table nikonsales (scode varchar2(100) primary key,
sid varchar2(100) not null,
sprice number(8),
splace varchar2(100),
sercieve varchar2(100))


create table nikonin (icode number(8) primary key,
iid varchar2(100) not null,
iname varchar2(100),
iprice number(8))


create table nikonin (icode number(8) primary key,
iid varchar2(100) not null,
iname varchar2(100),
iprice varchar2(100))
create sequence system.nikonin_icode increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

select * from NIKONIN
insert into nikonin values (1, 'baobob', '에어팟프로', '310000');
