---
---  Inserts for sample schema, tailored for MySQL
---
delete from "order";
delete from customer;
update office set mgr=null;
delete from employee;
delete from office;
delete from product;
commit;

---
---  PRODUCT
---
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('REI','2A45C','Ratchet Link',79.00,210);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','4100Y','Widget Remover',2750.00,25);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('QSA','XK47 ','Reducer',355.00,38);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('BIC','41627','Plate',180.00,0);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','779C ','900-LB Brace',1875.00,9);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','41003','Size 3 Widget',107.00,207);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','41004','Size 4 Widget',117.00,139);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('BIC','41003','Handle',652.00,3);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','887P ','Brace Pin',250.00,24);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('QSA','XK48 ','Reducer',134.00,203);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('REI','2A44L','Left Hinge',4500.00,12);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('FEA','112  ','Housing',148.00,115);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','887H ','Brace Holder',54.00,223);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('BIC','41089','Retainer',225.00,78);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','41001','Size 1 Wiget',55.00,277);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','775C ','500-lb Brace',1425.00,5);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','4100Z','Widget Installer',2500.00,28);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('QSA','XK48A','Reducer',177.00,37);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','41002','Size 2 Widget',76.00,167);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('REI','2A44R','Right Hinge',4500.00,12);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','773C ','300-lb Brace',975.00,28);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('ACI','4100X','Widget Adjuster',25.00,37);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('FEA','114  ','Motor Mount',243.00,15);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('IMM','887X ','Brace Retainer',475.00,32);
INSERT INTO PRODUCT (mfr_id, product_id, description, price, qty_on_hand) VALUES('REI','2A44G','Hinge Pin',350.00,14);
commit;

---
---  OFFICE
---
INSERT INTO OFFICE (office, city, region, mgr, sales, target) VALUES(22,'Denver','Western',null,300000.00,186042.00);
INSERT INTO OFFICE (office, city, region, mgr, sales, target) VALUES(11,'New York','Eastern',null,575000.00,692637.00);
INSERT INTO OFFICE (office, city, region, mgr, sales, target) VALUES(12,'Chicago','Eastern',null,800000.00,735042.00);
INSERT INTO OFFICE (office, city, region, mgr, sales, target) VALUES(13,'Atlanta','Eastern',null,350000.00,367911.00);
INSERT INTO OFFICE (office, city, region, mgr, sales, target) VALUES(21,'Los Angeles','Western',null,725000.00,835915.00);
commit;

---
---  EMPLOYEE
---
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (106,'Sam Clark',52,11,'VP Sales','2006-06-14',null,275000.00,299912.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (109,'Mary Jones',31,11,'Sales Rep','2007-10-12',106,300000.00,392725.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (104,'Bob Smith',33,12,'Sales Mgr','2005-05-19',106,200000.00,142594.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (108,'Larry Fitch',62,21,'Sales Mgr','2007-10-12',106,350000.00,361865.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (105,'Bill Adams',37,13,'Sales Rep','2006-02-12',104,350000.00,367911.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (102,'Sue Smith',48,21,'Sales Rep','2004-12-10',108,350000.00,474050.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (101,'Dan Roberts',45,12,'Sales Rep','2004-10-20',104,300000.00,305673.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (110,'Tom Snyder',41,null,'Sales Rep','2008-01-13',101,null,75985.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (103,'Paul Cruz',29,12,'Sales Rep','2005-03-01',104,275000.00,286775.00);
INSERT INTO EMPLOYEE (empl_num, name, age, empl_office, title, hire_date, manager, quota, sales) VALUES (107,'Nancy Angelli',49,22,'Sales Rep','2006-11-14',108,300000.00,186042.00);
commit;

---
---   OFFICE MANAGERS
---
UPDATE OFFICE SET MGR=108 WHERE OFFICE=22;
UPDATE OFFICE SET MGR=106 WHERE OFFICE=11;
UPDATE OFFICE SET MGR=104 WHERE OFFICE=12;
UPDATE OFFICE SET MGR=105 WHERE OFFICE=13;
UPDATE OFFICE SET MGR=108 WHERE OFFICE=21;
commit;

---
---   CUSTOMER
---
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2111,'JCP Inc.',103,50000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2102,'First Corp.',101,65000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2103,'Acme Mfg.',105,50000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2123,'Carter & Sons',102,40000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2107,'Ace International',110,35000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2115,'Smithson Corp.',101,20000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2101,'Jones Mfg.',106,65000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2112,'Zetacorp',108,50000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2121,'QMA Assoc.',103,45000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2114,'Orion Corp.',102,20000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2124,'Peter Brothers',107,40000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2108,'Holm & Landis',109,55000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2117,'J.P. Sinclair',106,35000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2122,'Three Way Lines',105,30000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2120,'Rico Enterprises',102,50000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2106,'Fred Lewis Corp.',102,65000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2119,'Solomon Inc.',109,25000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2118,'Midwest Systems',108,60000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2113,'Ian & Schmidt',104,20000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2109,'Chen Associates',103,25000.00);
INSERT INTO CUSTOMER (cust_num, company, cust_consultant, credit_limit) VALUES(2105,'AAA Investments',101,45000.00);
commit;

---
---  "order"
---
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112961,'2007-12-17',2117,106,'REI','2A44L',7,31500.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113012,'2008-01-11',2111,105,'ACI','41003',35,3745.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112989,'2008-01-03',2101,106,'FEA','114',6,1458.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113051,'2008-02-10',2118,108,'QSA','XK47',4,1420.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112968,'2007-10-12',2102,101,'ACI','41004',34,3978.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113036,'2008-01-30',2107,110,'ACI','4100Z',9,22500.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113045,'2008-02-02',2112,108,'REI','2A44R',10,45000.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112963,'2007-12-17',2103,105,'ACI','41004',28,3276.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113013,'2008-01-14',2118,108,'BIC','41003',1,652.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113058,'2008-02-23',2108,109,'FEA','112',10,1480.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112997,'2008-01-08',2124,107,'BIC','41003',1,652.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112983,'2007-12-27',2103,105,'ACI','41004',6,702.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113024,'2008-01-20',2114,108,'QSA','XK47',20,7100.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113062,'2008-02-24',2124,107,'FEA','114',10,2430.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112979,'2007-10-12',2114,102,'ACI','4100Z',6,15000.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113027,'2008-01-22',2103,105,'ACI','41002',54,4104.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113007,'2008-01-08',2112,108,'IMM','773C',3,2925.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113069,'2008-03-02',2109,107,'IMM','775C',22,31350.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113034,'2008-01-29',2107,110,'REI','2A45C',8,632.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112992,'2007-11-04',2118,108,'ACI','41002',10,760.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112975,'2007-10-12',2111,103,'REI','2A44G',6,2100.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113055,'2008-02-15',2108,101,'ACI','4100X',6,150.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113048,'2008-02-10',2120,102,'IMM','779C',2,3750.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112993,'2007-01-04',2106,102,'REI','2A45C',24,1896.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113065,'2008-02-27',2106,102,'QSA','XK47',6,2130.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113003,'2008-01-25',2108,109,'IMM','779C',3,5625.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113049,'2008-02-10',2118,108,'QSA','XK47',2,776.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (112987,'2007-12-31',2103,105,'ACI','4100Y',11,27500.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113057,'2008-02-18',2111,103,'ACI','4100X',24,600.00);
INSERT INTO "order" (order_num, order_date, cust, consultant, mfr, product, qty, amount) VALUES (113042,'2008-02-20',2113,101,'REI','2A44R',5,22500.00);
commit;
