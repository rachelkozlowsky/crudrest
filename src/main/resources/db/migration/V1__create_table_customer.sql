CREATE TABLE customer (
  customer_id BIGINT NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   cpf VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   zip_code VARCHAR(255) NOT NULL,
   city VARCHAR(255) NOT NULL,
   street VARCHAR(255) NOT NULL,
   number VARCHAR(255) NOT NULL,
   complement VARCHAR(255) NOT NULL,
   CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

ALTER TABLE customer ADD CONSTRAINT uc_customer_cpf UNIQUE (cpf);

ALTER TABLE customer ADD CONSTRAINT uc_customer_email UNIQUE (email);