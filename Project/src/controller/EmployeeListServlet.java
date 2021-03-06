package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/EmployeeListServlet")////hitto
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		Employee em = (Employee)session.getAttribute("employeeAccount");
		System.out.println("(EmployeeListServlet1のem)=" + em);
		if(em == null){
				System.out.println("リダイレクト");
				response.sendRedirect("LoginServlet");
				return;
		}

		// ユーザ一覧情報を取得
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employeeList = employeeDao.findAll();

		System.out.println("(EmployeeListServlet2のem)=" + em);


		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("employeeList", employeeList);

		System.out.println("(EmployeeListServlet3のem)=" + em);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/useritiran.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String calendar1 = request.getParameter("calendar1");
		String calendar2 = request.getParameter("calendar2");


	// TODO  未実装：検索処理全般

		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> searchList = employeeDao.findSearch(login_id, name, calendar1, calendar2);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("employeeList", searchList);


		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/useritiran.jsp");
		dispatcher.forward(request, response);

	}

}
