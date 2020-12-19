create table orders (
    id bigint not null auto_increment,
    order_time datetime default CURRENT_TIMESTAMP,
    customer_id bigint,
    primary key (id),
    foreign key (customer_id) references customers (id)
);
