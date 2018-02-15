alter table PRODUCT drop constraint FK66rtd2on6u46jc2lj0as98lxk;
drop table if exists PRODUCT cascade;
drop table if exists PRODUCT_CATEGORY cascade;
drop sequence PRODUCT_CATEGORY_ID_SEQ;
