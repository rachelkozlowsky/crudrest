CREATE TABLE products (
  product_id BIGINT NOT NULL,
   product_name VARCHAR(255) NOT NULL,
   product_value DECIMAL NOT NULL,
   orders_id BIGINT,
   CONSTRAINT pk_products PRIMARY KEY (product_id)
);

ALTER TABLE products ADD CONSTRAINT FK_PRODUCTS_ON_ORDERS FOREIGN KEY (orders_id) REFERENCES orders (id);