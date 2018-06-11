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
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		Employee em = (Employee)session.getAttribute("employeeAccount");
		System.out.println("(SignUpServlet1のem)=" + em);
		if(em == null){
				System.out.println("リダイレクト");
				response.sendRedirect("LoginServlet");
				return;
		}

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String login_id = request.getParameter("login_id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		if(login_id.equals("") || password1.equals("") || password2.equals("") || name.equals("") || birth_date.equals("")){////nullではない
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}


		if(!password1.equals(password2)) {////	!=ではないので要注意
			request.setAttribute("errMsg", "パスワードと確認用パスワードが一致しておりません");

			// signup.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		EmployeeDao employeeDao = new EmployeeDao();
		boolean result = employeeDao.SignUpInfo(login_id, password1, name, birth_date);
////		Employee employee = employeeDao.findByLoginInfo(login_id, password);
////EmployeeDao.findByLoginInfo(loginId, password);のEmployeeDaoはエラーになるので要注意。正しくはemployeeDaoである。

		if(result == false) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		/** エラーが起きなかった場合 **/
		// セッションにユーザの情報をセット
		System.out.println();

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("EmployeeListServlet");

	}

}