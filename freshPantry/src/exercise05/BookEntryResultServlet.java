package exercise05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 佐藤裕章
 * @version 2.0
 *
 * 中級演習問題5　問題4
 * 書籍情報を登録するサーブレット
 *
 */
@WebServlet("/BookEntryResultServlet")
public class BookEntryResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEntryResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * 書籍情報を登録します。
	 *
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		// 画面から新規追加情報取得
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));

		// 取得情報の設定
		BookBean bookBean = new BookBean();
		bookBean.setId(id);
		bookBean.setTitle(title);
		bookBean.setPrice(price);

		// 書籍情報の登録
		BookDAO bookDAO = new BookDAO();
		int count = bookDAO.insert(bookBean);
		System.out.println("count = " + count);

		request.getRequestDispatcher("BookEntryResult.jsp")
			.forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
