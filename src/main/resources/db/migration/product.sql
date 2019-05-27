create table product(
  id INTEGER IDENTITY PRIMARY KEY,
  product_name varchar(50),
  unit_price numeric,
  category varchar(50),
  image_link varchar(120),
  number_sold  numeric,
  unit_cost numeric
);

insert into product( product_name, unit_price, category, image_link, number_sold, unit_cost)values
('Eplekake',100,'Kake','http://eplekake.com/',100,50),
('Banankake',150,'Kake','http://banankake.com/',100,95),
('Ananaskake',100,'Kake','http://ananas.com/',1000,25),
('Gulrotkake',100,'Kake','http://gulrotkake.com/',5000,75),
('Ostekake',50,'Kake','http://ostekake.com/',1000,50),
('Kneipbrød',30,'Brød','http://kneipbrød.com/',1000,50);