package controller;

/////モデルはSignUpServlet.java

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
@WebServlet("/UserInfoDetailServlet")
public class UserInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Employee em = (Employee)session.getAttribute("employeeAccount");
		if(em == null){
				System.out.println("リダイレクト");
				response.sendRedirect("LoginServlet");
				return;
		}


		String id = request.getParameter("id");


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employeeDetail = employeeDao.findByDetailInfo(id);


		session.setAttribute("employeeInfo", employeeDetail);


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoDetail.jsp");
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

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employeeDetail = employeeDao.findByDetailInfo(id);

////Employee employee = employeeDao.findByLoginInfo(login_id, password);
////EmployeeDao.findByLoginInfo(loginId, password);のEmployeeDaoはエラーになるので要注意。正しくはemployeeDaoである。


		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserInfoDetailServlet");

	}

}