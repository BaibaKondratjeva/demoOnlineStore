ALTER TABLE products_categories
DROP constraint products_categories_ibfk_1;
ALTER TABLE products_categories
ADD foreign key (product_id) references products (id) ON DELETE CASCADE;