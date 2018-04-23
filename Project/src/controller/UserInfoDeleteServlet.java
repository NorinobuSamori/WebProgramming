package controller;

////モデルはSignUpServlet.java

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
@WebServlet("/UserInfoDeleteServlet")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoDeleteServlet() {
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
		if(em == null){
				System.out.println("リダイレクト");
				response.sendRedirect("LoginServlet");
				return;
		}


		String id = request.getParameter("id");

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employeeDetail = employeeDao.findByDetailInfo(id);

		session.setAttribute("employeeInfo", employeeDetail);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoDelete.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行

		String id = request.getParameter("id");


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.findByDeleteInfo(id);


		response.sendRedirect("EmployeeListServlet");


	}

}