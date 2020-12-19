create table customers (
    id bigint not null auto_increment,
    name varchar (50),
    surname varchar (50),
    e_mail varchar (50),
    address varchar (50),
    phone varchar (12),
    primary key (id)
);