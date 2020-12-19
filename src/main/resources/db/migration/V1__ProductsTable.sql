create table products (
    id bigint not null auto_increment,
    name varchar (250),
    description varchar (1000),
    price decimal not null,
    quantity int,
    imageUri varchar (1000),
    primary key (id)
);