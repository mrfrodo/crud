create table cr_product(
  id INTEGER IDENTITY PRIMARY KEY,
  productName varchar(50),
  unitPrice numeric,
  category varchar(50),
  imageLink varchar(120),
  numberSold  numeric,
  unitCost numeric
);

create table cr_car(
  id INTEGER IDENTITY PRIMARY KEY,
  carName varchar(50)
);