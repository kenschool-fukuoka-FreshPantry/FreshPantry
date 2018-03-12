CREATE TABLE recip (
  recip_no INTEGER(10) NOT NULL ,
  food_no INTEGER(2) NOT NULL ,
  food_name VARCHAR(50) ,
  quantity INTEGER(5) ,
  unit CHAR(2) ,
  registration_time TIMESTAMP NOT NULL ,
  update_time TIMESTAMP NOT NULL ,
  PRIMARY KEY(food_no) ,
  FOREIGN KEY(recip_no) REFERENCES recipmanage(recip_no)
);