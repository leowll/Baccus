create sequence shop_id_seq;
alter table shop alter shop_id set default nextval('shop_id_seq');
select setval('shop_id_seq', 100001 ); --set to the highest current value of shopID