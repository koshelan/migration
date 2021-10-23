create table CUSTOMERS
(
    id           bigint auto_increment,
    name         varchar(50),
    surname      varchar(50),
    age          int,
    phone_number varchar(15),
    PRIMARY KEY (id)
);

insert into CUSTOMERS (name, surname, age, phone_number)
VALUES ('Ivan','Ivanov',25,'123456');
insert into CUSTOMERS (name, surname, age, phone_number)
VALUES ('Petr','Petrov',13,'654321');
insert into CUSTOMERS (name, surname, age, phone_number)
VALUES ('aLexey','Ivanov',27,'223456');
insert into CUSTOMERS (name, surname, age, phone_number)
VALUES ('Alexey','Aksyonov',70,'78964');

create table ORDERS
(
    id           bigint auto_increment,
    dat         DATETIME   NOT NULL     DEFAULT now(),
    customer_id  bigint,
    product_name varchar(255),
    amount       int,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);

insert into ORDERS (customer_id, product_name, amount)
VALUES (4,'bread',2);
insert into ORDERS (customer_id, product_name, amount)
VALUES (4,'milk',1);
insert into ORDERS (customer_id, product_name, amount)
VALUES (3,'milk',2);
insert into ORDERS (customer_id, product_name, amount)
VALUES (1,'orange',20);