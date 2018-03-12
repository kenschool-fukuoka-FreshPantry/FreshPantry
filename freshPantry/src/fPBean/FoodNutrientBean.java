package fPBean;

import fPBean2.FoodBean;

public class FoodNutrientBean {

	private int NutrientNo ;
	private String Nutrient ;

	public FoodNutrientBean() {
		super();
	}
	public int getNutrientNo() {
		return NutrientNo;
	}
	public void setNutrientNo(int nutrientNo) {
		NutrientNo = nutrientNo;
	}
	public String getNutrient() {
		return Nutrient;
	}
	public void setNutrient(String nutrient) {
		Nutrient = nutrient;
	}

	public static FoodBean getNutrientData(int no) {

		return new FoodBean();
	}

	public static void updateNutrientData(FoodBean foodBean){

	}
}
