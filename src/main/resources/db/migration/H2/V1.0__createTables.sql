-- transaction definition

-- Drop table

-- DROP TABLE price;

CREATE TABLE price (
	brand_id varchar(20) NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	price_list varchar(20) NOT NULL,
	product_id varchar(20) NOT NULL,
	priority int NOT NULL,
	price float8 NOT NULL,
	curr varchar(3) NOT NULL,
	CONSTRAINT price_pk PRIMARY KEY (brand_id, price_list, product_id)
);
