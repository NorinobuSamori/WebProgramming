package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる

		// ユーザ一覧情報を取得
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employeeList = employeeDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("employeeList", employeeList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/useritiran.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO  未実装：検索処理全般
	}

}