alter table orders
add column status_id bigint;

alter table orders add foreign key (status_id) references order_status (id);
