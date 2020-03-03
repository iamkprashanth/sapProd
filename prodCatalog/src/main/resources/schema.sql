DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS seller;
DROP TABLE IF EXISTS variants;
DROP TABLE IF EXISTS variant_value;
DROP TABLE IF EXISTS product_variants;
DROP TABLE IF EXISTS product_details;

CREATE TABLE category (
  category_id int(11) NOT NULL AUTO_INCREMENT,
  category_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (category_id)
);

CREATE TABLE brands (
  brand_id int(11) NOT NULL AUTO_INCREMENT,
  brand_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (brand_id)
);

CREATE TABLE products (
  product_id int(11) NOT NULL AUTO_INCREMENT,
  product_name varchar(45) DEFAULT NULL,
  brand_id int(11) DEFAULT NULL,
  category_id int(11) DEFAULT NULL,
  PRIMARY KEY (product_id)
) ;

CREATE TABLE seller (
  seller_id int(11) NOT NULL AUTO_INCREMENT,
  seller_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (seller_id)
);

CREATE TABLE `variants` (
  `variant_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`variant_id`)
) ;

CREATE TABLE `variant_value` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_id` int(11) DEFAULT NULL,
  `value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`value_id`),
  CONSTRAINT `variant_id` FOREIGN KEY (`variant_id`) REFERENCES `variants` (`variant_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `product_variants` (
  `product_variants_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `product_variant_name` varchar(255) DEFAULT NULL,
  `sku` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`product_variants_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seller_id` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `product_details` (
  `product_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_variants_id` int(11) DEFAULT NULL,
  `value_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_detail_id`),
  CONSTRAINT `product_variants_id` FOREIGN KEY (`product_variants_id`) REFERENCES `product_variants` (`product_variants_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `value_id` FOREIGN KEY (`value_id`) REFERENCES `variant_value` (`value_id`) ON DELETE CASCADE ON UPDATE CASCADE
);


