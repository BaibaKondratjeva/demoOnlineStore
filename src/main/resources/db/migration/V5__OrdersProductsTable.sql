create table orders_products (
    id bigint not null auto_increment,
    order_id bigint,
    product_id bigint,
    quantity int,
    primary key (id),
    foreign key (order_id) references orders (id),
    foreign key (product_id) references products (id)
);