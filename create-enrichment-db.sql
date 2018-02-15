create sequence PRODUCT_CATEGORY_ID_SEQ start 1 increment 1;
create table PRODUCT (PRODUCT_ID int4 not null, DESCRIPTION varchar(255) not null, PRODUCT_CATEGORY_ID varchar(255) not null, primary key (PRODUCT_ID));
create table PRODUCT_CATEGORY (PRODUCT_CATEGORY_ID varchar(255) not null, DESCRIPTION varchar(255) not null, primary key (PRODUCT_CATEGORY_ID));
alter table PRODUCT add constraint FK66rtd2on6u46jc2lj0as98lxk foreign key (PRODUCT_CATEGORY_ID) references PRODUCT_CATEGORY;
