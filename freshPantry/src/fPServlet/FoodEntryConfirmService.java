package fPServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fPBean.FoodBean;
import fPBean.FoodNutrientBean;

/**
 * @author aka
 * @version 1.0
 *
 * 食材入力処理を実行し、内容確認画面を表示する
 *
 */
@WebServlet("/FoodEntryConfirmService")
public class FoodEntryConfirmService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 遷移
	static final String ON_CANCEL = "001";
	static final String ON_ADD = "002";
	static final String ON_BACK = "003";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodEntryConfirmService() {
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
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";
		// TODO jsp name と相談
		String buttonOnValue = request.getParameter("buttonOn");

		try {

			int i = 1;
			boolean endFlg = false;
			// 食材入力１件のデータ
			FoodBean foodBeanData = new FoodBean();
			ArrayList<FoodNutrientBean> nutrientList = new ArrayList<FoodNutrientBean>();

			switch (buttonOnValue){

			case ON_CANCEL:
				// 何もわたさず新規登録・変更へ
				url = "/Entry.jsp";
				break;

			case ON_ADD:
				// 登録実施
				foodBeanData.setFoodName(request.getParameter("food_name"));
				foodBeanData.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				foodBeanData.setUnit(request.getParameter("unit"));
				foodBeanData.setPurchaseDate(request.getParameter("purchase_date"));
				foodBeanData.setExpirationDate(request.getParameter("expiration_date"));
				foodBeanData.setCategoryId(request.getParameter("category_id"));
				// 栄養素


				while(!endFlg){
					String nutrientName = request.getParameter("nutrient"+i);

					if(nutrientName == null){
						// 枠がなくなったら、処理をやめる
						endFlg = true;

					} else {

						if(!nutrientName.isEmpty()){
							// 登録時には、空の栄養素は登録しない
							FoodNutrientBean nutrientData = new FoodNutrientBean();
							nutrientData.setNutrient(nutrientName);

							nutrientList.add(nutrientData);
						}

					}
					i++; // 次の栄養素の判定へ
				}
				foodBeanData.setNutrientList(nutrientList);
				// 登録呼び出し
				FoodBean.addFoodData(foodBeanData);

				// 新規登録・変更へ
				url = "/Entry.jsp";
				break;

			case ON_BACK:
				// 渡す値を設定して前の食材入力へ
				foodBeanData.setFoodName(request.getParameter("food_name"));
				foodBeanData.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				foodBeanData.setUnit(request.getParameter("unit"));
				foodBeanData.setPurchaseDate(request.getParameter("purchase_date"));
				foodBeanData.setExpirationDate(request.getParameter("expiration_date"));
				foodBeanData.setCategoryId(request.getParameter("category_id"));

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

				url = "/FoodEntry.jsp";
				break;

			default:
				url = "/Main.jsp";
				break;
			}
			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
