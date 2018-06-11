package forsample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dao.DBManager;
import model.Employee;

public class ForSample {
	public List<Employee> findAll(){
		
		
		
		
		return null;
		
	}

	public Employee findByDetailInfo(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
//非推奨            String sql = "SELECT id, name, age FROM employee WHERE id = " + targetId;
            String sql = "SELECT * FROM user WHERE id = ?";



             // SELECTを実行し、結果表を取得
//非推奨        Statement stmt = conn.createStatement();
//非推奨        ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
////findByDetailInfo(){}の中身の変数宣言をしないと、pStmtsetString(数字, xxxxxx)等の部分でエラーが起きるので、混乱しないように注意。
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {////1行であるはずなのに2行あったらよくないからnext()
                return null;
            }


            int id2 = rs.getInt("id");
            String login_id = rs.getString("login_id");
            String name = rs.getString("name");
            Date birth_date = rs.getDate("birth_date");
            String password = rs.getString("password");
            String create_date = rs.getString("create_date");
            String update_date = rs.getString("update_date");
            Employee employee = new Employee(id2, login_id, name, birth_date, password, create_date, update_date);////値を渡しているのではなく、引っ張っているらしい。

            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException e    e.printStackTrace();  3333");

        } finally {
            // データベース切断
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQLException e    e.printStackTrace(); 4444");

                }
            }

        }
        return null;
    }

}
