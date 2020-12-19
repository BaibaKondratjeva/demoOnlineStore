create table products_categories (
    id bigint not null auto_increment,
    product_id bigint,
    category_id bigint,
    primary key (id),
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);