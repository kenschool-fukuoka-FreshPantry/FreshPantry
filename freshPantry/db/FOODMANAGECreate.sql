CREATE TABLE fp_foodmanage (
  category_id CHAR(3) NOT NULL ,
  food_no INTEGER(10) NOT NULL AUTO_INCREMENT ,
  food_name VARCHAR(50) NOT NULL ,
  expiration_date DATE NOT NULL ,
  purchase_date DATE ,
  quantity INTEGER NOT NULL ,
  unit CHAR(3) NOT NULL ,
  registration_time TIMESTAMP NOT NULL ,
  update_time TIMESTAMP NOT NULL ,
  PRIMARY KEY(food_no , expiration_date ) ,
  FOREIGN KEY(category_id) REFERENCES fp_category(category_id)
);