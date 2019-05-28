create table cr_product(
  id INTEGER IDENTITY PRIMARY KEY,
  product_name varchar(50),
  unit_price numeric,
  category varchar(50),
  image_link varchar(120),
  number_sold  numeric,
  unit_cost numeric
);

create table cr_car(
  id INTEGER IDENTITY PRIMARY KEY,
  carName varchar(50)
);