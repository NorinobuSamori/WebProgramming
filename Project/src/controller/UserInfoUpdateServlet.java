package controller;

//モデルはSignUpServlet.java

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
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO 未実装：ログインセッションがある場合、ユーザ一覧画面にリダイレクトさせる


		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String login_id = request.getParameter("login_id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		if(!password1.equals(password2)) {////	!=ではないので要注意
			request.setAttribute("errMsg", "パスワードと確認用パスワードが一致しておりません");

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employeeDetail = employeeDao.findByDetailInfo(id);

		HttpSession session = request.getSession();
		session.setAttribute("employeeInfo", employeeDetail);


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao2 = new EmployeeDao();
		employeeDao2.byUpdateInfo(login_id, password1, name, birth_date);
////		Employee employee = employeeDao.findByLoginInfo(login_id, password);
////EmployeeDao.findByLoginInfo(loginId, password);のEmployeeDaoはエラーになるので要注意。正しくはemployeeDaoである。


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String login_id = request.getParameter("login_id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		if(!password1.equals(password2)) {////	!=ではないので要注意
			request.setAttribute("errMsg", "パスワードと確認用パスワードが一致しておりません");

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employeeDetail = employeeDao.findByDetailInfo(id);

		HttpSession session = request.getSession();
		session.setAttribute("employeeInfo", employeeDetail);


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao2 = new EmployeeDao();
		employeeDao2.byUpdateInfo(login_id, password1, name, birth_date);
////		Employee employee = employeeDao.findByLoginInfo(login_id, password);
////EmployeeDao.findByLoginInfo(loginId, password);のEmployeeDaoはエラーになるので要注意。正しくはemployeeDaoである。



		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("EmployeeListServlet");

	}

}