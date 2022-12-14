DROP TABLE IF EXISTS goods;

CREATE TABLE goods (
  id INTEGER unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  costPrice INTEGER NOT NULL,
  shippingMethod INTEGER NOT NULL,
  sellingPrice INTEGER NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO goods (id, name,costPrice,shippingMethod,sellingPrice) VALUES (1,"iPad",74800,450,90000);
INSERT INTO goods (id, name,costPrice,shippingMethod,sellingPrice) VALUES (2,"ポケモン",6500,450,5000);
