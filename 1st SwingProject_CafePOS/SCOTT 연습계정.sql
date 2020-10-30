drop SEQUENCE cafe_sq;

drop table cafe;

CREATE TABLE cafe(
    no NUMBER,
    time TIMESTAMP(6) DEFAULT sysdate  CONSTRAINT emp_time_nn NOT NULL,
    menu VARCHAR2(20) CONSTRAINT emp_menu_nn NOT NULL,
    temperture VARCHAR2(10),
    price number CONSTRAINT emp_price_nn NOT NULL,
    pay VARCHAR2(20) CONSTRAINT emp_pay_ch CHECK (pay IN('현금', '카드'))
);

CREATE SEQUENCE cafe_sq;

select * from cafe;

commit;

insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페모카', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/01/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페모카', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/02/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페모카', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '카페모카', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/03/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페라떼', 'Ice', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '바닐라라떼', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페라떼', 'Ice', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '바닐라라떼', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '청포도에이드', 'Ice', '3500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '청포도에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/04/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페라떼', 'Ice', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '바닐라라떼', 'Ice', '2500', '카드')
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페모카', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '카페라떼', 'Ice', 2000'', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '레몬에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '레몬에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/05/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Hot', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Hot', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페모카', 'Ice', '2500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페라떼', 'Ice', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Ice', '2500', '카드')
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페라떼', 'Hot', 2000'', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Hot', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페모카', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '카페라떼', 'Ice', 2000'', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '레몬에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '레몬에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/06/01 10:00:00', '딸기스무디', 'Ice', '3500', '카드');

insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '아메리카노', 'Ice', '1500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '바닐라라떼', 'Ice', '2500', '현금');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '망고스무디', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '레몬에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '자몽에이드', 'Ice', '3500', '카드');
insert into cafe values(cafe_sq.nextval,'2020/07/01 10:00:00', '망고기스무디', 'Ice', '3500', '카드');
