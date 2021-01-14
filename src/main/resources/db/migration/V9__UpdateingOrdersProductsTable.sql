ALTER TABLE orders_products
DROP constraint orders_products_ibfk_1;

ALTER TABLE orders_products
ADD foreign key (order_id) references orders (id) ON DELETE CASCADE;