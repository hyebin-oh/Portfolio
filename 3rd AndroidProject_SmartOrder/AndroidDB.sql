--------------------------------------------------------
--  ������ ������ - �ݿ���-10��-30-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ORDERNUM
--------------------------------------------------------

   CREATE SEQUENCE  "P_ANDROID"."ORDERNUM"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 301 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_CART
--------------------------------------------------------

   CREATE SEQUENCE  "P_ANDROID"."SEQ_CART"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 128 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SHOP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "P_ANDROID"."SHOP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 9 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CART
--------------------------------------------------------

  CREATE TABLE "P_ANDROID"."CART" 
   (	"NUM" NUMBER, 
	"SHOP" VARCHAR2(50 BYTE), 
	"ORDERNUM" VARCHAR2(50 BYTE), 
	"TYPE" VARCHAR2(50 BYTE), 
	"MENU" VARCHAR2(50 BYTE), 
	"COST" NUMBER, 
	"COUNT" NUMBER, 
	"TOTAL" NUMBER, 
	"TIME" VARCHAR2(500 BYTE) DEFAULT sysdate, 
	"TEMP" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MENU
--------------------------------------------------------

  CREATE TABLE "P_ANDROID"."MENU" 
   (	"MENU" VARCHAR2(100 BYTE), 
	"TYPE" VARCHAR2(20 BYTE), 
	"COST" VARCHAR2(20 BYTE), 
	"PICTURE" VARCHAR2(800 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SHOP
--------------------------------------------------------

  CREATE TABLE "P_ANDROID"."SHOP" 
   (	"NUM" NUMBER, 
	"NAME" VARCHAR2(100 BYTE), 
	"TEL" VARCHAR2(50 BYTE), 
	"ADDR" VARCHAR2(500 BYTE), 
	"FILENAME" VARCHAR2(2000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into P_ANDROID.CART
SET DEFINE OFF;
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (10,'����1ȣ��','2-119','fruit','����Ƽ',2500,1,2500,'20/10/26','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (12,'����1ȣ��','2-120','cafein','ī���ī',3000,1,3000,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (14,'����1ȣ��','5-124','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (15,'�ؿ��1ȣ��','5-138','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (16,'����2ȣ��','5-139','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (17,'�ؿ��1ȣ��','5-140','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (18,'����2ȣ��','3-144','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (19,'����1ȣ��','1-162','cafein','īǪġ��',2500,1,2500,'20/10/27','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (20,'����1ȣ��','2-163','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (58,'����1ȣ��','2-222','cafein','īǪġ��',2500,1,2500,'20/10/29','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (59,'����1ȣ��','1-223','cafein','ī���ī',3000,1,3000,'20/10/29','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (23,'����1ȣ��','2-205','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (24,'����1ȣ��','2-206','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (25,'����1ȣ��','2-207','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (26,'����1ȣ��','2-207','fruit','��Ƽ',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (27,'����2ȣ��','1-208','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (28,'����2ȣ��','1-208','cafein','�񿣳�Ŀ��',3500,1,3500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (29,'����2ȣ��','1-208','cafein','�񿣳�Ŀ��',3500,1,3500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (30,'����1ȣ��','5-209','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (31,'����1ȣ��','2-210','cafein','ī���ī',3000,1,3000,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (32,'����1ȣ��','3-211','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (33,'����1ȣ��','1-212','cafein','ī���ī',3000,1,3000,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (34,'����1ȣ��','1-213','cafein','īǪġ��',2500,1,2500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (47,'����1ȣ��','2-220','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (48,'����1ȣ��','2-220','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (49,'����1ȣ��','2-220','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (8,'����1ȣ��','2-117','cafein','īǪġ��',2500,3,7500,'20/10/26','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (9,'����1ȣ��','2-119','fruit','�׸�Ƽ',2500,1,2500,'20/10/26','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (38,'����2ȣ��','2-216','cafein','ī���ī',3000,1,3000,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (39,'����1ȣ��','2-217','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
Insert into P_ANDROID.CART (NUM,SHOP,ORDERNUM,TYPE,MENU,COST,COUNT,TOTAL,TIME,TEMP) values (50,'����1ȣ��','2-220','cafein','�Ƹ޸�ī��',1500,1,1500,'20/10/28','Ice');
REM INSERTING into P_ANDROID.MENU
SET DEFINE OFF;
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('�Ƹ޸�ī��','cafein','1500','americano.PNG');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('īǪġ��','cafein','2500','cappuccino.PNG');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('ī���ī','cafein','3000','moca.PNG');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('�񿣳�Ŀ��','cafein','3500','viena.PNG');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('��Ƽ','fruit','2500','blacktea.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('�׸�Ƽ','fruit','2500','greantea.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('����Ƽ','fruit','2500','redtea.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('����Ƽ','fruit','2500','remontea.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('�����','fruit','3500','strawberrylatte.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('����Ǫġ��','fruit','4000','frappuccino.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('��������ũ','food','5000','strawberrycake.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('�������ũ','food','5000','carrotcake.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('������ũ','food','7000','pancake.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('���Ϻ���','food','6000','shavedice.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('���̽�ũ��','food','3000','icecream.png');
Insert into P_ANDROID.MENU (MENU,TYPE,COST,PICTURE) values ('ī���','cafein','2000','latte.PNG');
REM INSERTING into P_ANDROID.SHOP
SET DEFINE OFF;
Insert into P_ANDROID.SHOP (NUM,NAME,TEL,ADDR,FILENAME) values (5,'����1ȣ��','051-700-7000','�λ걤���� �λ����� ����� 11','shop1.jpg');
Insert into P_ANDROID.SHOP (NUM,NAME,TEL,ADDR,FILENAME) values (6,'����2ȣ��','051-700-7100','�λ걤���� �λ����� ����� 22','shop2.jpg');
Insert into P_ANDROID.SHOP (NUM,NAME,TEL,ADDR,FILENAME) values (7,'�ؿ��1ȣ��','051-610-6000','�λ걤���� �ؿ�뱸 �ؿ��� 11','shop3.jpg');
Insert into P_ANDROID.SHOP (NUM,NAME,TEL,ADDR,FILENAME) values (8,'�ؿ��2ȣ��','051-610-6100','�λ걤���� �ؿ�뱸 �ؿ��� 22','shop4.jpg');
--------------------------------------------------------
--  DDL for Index CART_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "P_ANDROID"."CART_PK" ON "P_ANDROID"."CART" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SHOP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "P_ANDROID"."SHOP_PK" ON "P_ANDROID"."SHOP" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CART
--------------------------------------------------------

  ALTER TABLE "P_ANDROID"."CART" ADD CONSTRAINT "CART_PK" PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "P_ANDROID"."CART" MODIFY ("NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MENU
--------------------------------------------------------

  ALTER TABLE "P_ANDROID"."MENU" MODIFY ("PICTURE" NOT NULL ENABLE);
  ALTER TABLE "P_ANDROID"."MENU" MODIFY ("COST" NOT NULL ENABLE);
  ALTER TABLE "P_ANDROID"."MENU" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "P_ANDROID"."MENU" MODIFY ("MENU" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SHOP
--------------------------------------------------------

  ALTER TABLE "P_ANDROID"."SHOP" ADD CONSTRAINT "SHOP_PK" PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "P_ANDROID"."SHOP" MODIFY ("NUM" NOT NULL ENABLE);
