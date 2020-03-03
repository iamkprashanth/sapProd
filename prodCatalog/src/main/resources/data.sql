INSERT INTO `category` VALUES (1,'Shirts'),(2,'Pants'),(3,'Socks'),(4,'Caps');
INSERT INTO `brands` VALUES (1,'Wrangler'),(2,'Levis'),(3,'Allen Solley'),(4,'Roadster');

INSERT INTO `products` VALUES (1,'Mens Printed Casual Shirt',1,1),(2,'Mens Solid Casual Shirt',1,1),(3,'Mens Checkered Casual Shirt',1,1),(4,'Mens Striped Casual Shirt',1,1),(5,'Mens Printed Casual Shirt',2,1),(6,'Mens Solid Casual Shirt',2,1),(7,'Mens Printed Casual Shirt',3,1),(8,'Mens Solid Casual Shirt',3,1),(9,'Mens Striped Casual Shirt',4,1);

INSERT INTO `seller` VALUES (1,'RetailNet'),(2,'LeesShop'),(3,'AddicShop'),(4,'AllenShop');

INSERT INTO `variants` VALUES (1,'color'),(2,'size');

INSERT INTO `variant_value` VALUES (1,1,'red'),(2,1,'blue'),(3,1,'green'),(4,2,'small'),(5,2,'medium'),(6,2,'large');

INSERT INTO `product_variants` VALUES (1,1,'red color','POI0987654321',1299,4,1),(2,2,'blue color','POI0987654322',999,4,1),(3,3,'green-color','POI0987654321',1299,4,1);

INSERT INTO `product_details` VALUES (1,1,1),(2,1,4),(3,1,3),(4,1,4),(5,2,1),(6,2,2),(7,2,3),(8,2,5);
