/*Create mysql table script*/
create table products
(
  ID_PRODUCT         int auto_increment
    primary key,
  NAME_PRODUCT       varchar(255) null,
  COST_PRICE_PRODUCT double       null,
  SALE_PRICE_PRODUCT double       null,
  BARCODE_PRODUCT    varchar(50)  null
);
--
/*Create postgre table script*/
create table products
(
  id_product         serial not null
    constraint products_pk
      primary key,
  name_product       varchar(255),
  cost_price_product double precision,
  sale_price_product double precision,
  barcode_product    varchar(50)
);