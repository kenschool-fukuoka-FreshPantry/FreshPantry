CREATE TABLE fp_food (
  food_no INTEGER(10) NOT NULL ,
  nutrient_no INTEGER(2) NOT NULL ,
  nutrient VARCHAR(50) ,
  registration_time TIMESTAMP NOT NULL ,
  update_time TIMESTAMP NOT NULL,
  PRIMARY KEY(food_no,nutrient_no) ,
  FOREIGN KEY(food_no) REFERENCES fp_foodmanage(food_no)
);