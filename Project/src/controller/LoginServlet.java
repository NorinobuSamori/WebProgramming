package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// TODO 未実装：ログインセッションがある場合、ユーザ一覧画面にリダイレクトさせる
		HttpSession session = request.getSession();
		Employee em = (Employee)session.getAttribute("employeeInfo");
		if(em != null){
				System.out.println("一覧リダイレクト");
				response.sendRedirect("EmployeeListServlet");
				return;
		}

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの入力項目を取得
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.findByLoginInfo(login_id, password);
////EmployeeDao.findByLoginInfo(loginId, password);のEmployeeDaoはエラーになるので要注意。正しくはemployeeDaoである。

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (employee == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		HttpSession session = request.getSession();
		session.setAttribute("employeeInfo", employee);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("EmployeeListServlet");

	}

}
