create table books (bookId INTEGER(10) NOT NULL AUTO_INCREMENT ,title varchar2(20),author varchar2(30),price number(7),
user_id INTEGER(10),
constraint user_pk PRIMARY KEY(bookId));