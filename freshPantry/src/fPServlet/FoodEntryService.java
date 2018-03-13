package fPServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fPBean.CategoryBean;
import fPBean.FoodBean;
import fPBean.FoodNutrientBean;
import fPBean.UnitBean;

/**
 * @author aka
 * @version 1.0
 *
 * 新たに購入した食材の入力を行う
 *
 */
@WebServlet("/FoodEntryService")
public class FoodEntryService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodEntryService() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = null;
		String url = "";
		try {
			// 食材入力１件のデータ
			FoodBean foodBeanData = new FoodBean();

			foodBeanData.setFoodName(request.getParameter("food_name"));
			foodBeanData.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			foodBeanData.setUnit(request.getParameter("unit"));
			// unit名の取得・設定
			foodBeanData.setUnitName(getUnitName(request.getParameter("unit")));
			foodBeanData.setPurchaseDate(request.getParameter("purchase_date"));
			foodBeanData.setExpirationDate(request.getParameter("expiration_date"));
			foodBeanData.setCategoryId(request.getParameter("category_id"));
			// category名称の取得・設定
			foodBeanData.setCategoryId(getCategoryName(request.getParameter("category_id")));

			// 栄養素
			ArrayList<FoodNutrientBean> nutrientList = new ArrayList<FoodNutrientBean>();

			int i = 1;
			boolean endFlg = false;
			while(!endFlg){
				String nutrientName = request.getParameter("nutrient"+i);

				if(nutrientName == null){
					// 枠がなくなったら、処理をやめる
					endFlg = true;

				} else {
					FoodNutrientBean nutrientData = new FoodNutrientBean();
					nutrientData.setNutrient(nutrientName);

					nutrientList.add(nutrientData);
				}
				i++; // 次の栄養素の判定へ
			}
			foodBeanData.setNutrientList(nutrientList);
			request.setAttribute("foodB", foodBeanData);
			url = "/FoodConfirm.jsp";
			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 単位に合致する単位名称を返す
	 */
	private String getUnitName(String parameter) throws SQLException {

		String unitName = "";
		ArrayList<UnitBean> unitList = UnitBean.getUnitIdList();

		for (UnitBean ub :unitList){
			if(ub.getUnit().equals(parameter)){
				unitName = ub.getUnitName();
				break;
			}
		}
		return unitName;
	}

	/*
	 * カテゴリーに合致するカテゴリー名称を返す
	 */
	private String getCategoryName(String parameter) throws SQLException {

		String categoryName = "";
		ArrayList<CategoryBean> categoryList = CategoryBean.getCategoryIdList();

		for (CategoryBean cb :categoryList){
			if(cb.getCategoryId().equals(parameter)){
				categoryName = cb.getCategoryName();
				break;
			}
		}
		return categoryName;
	}
}
