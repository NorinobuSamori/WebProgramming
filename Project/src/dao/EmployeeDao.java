package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Employee;

/////-----------------------------------------------------------------------------------------------------------
public class EmployeeDao {
    public Employee findByLoginInfo(String login_Id, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
//非推奨            String sql = "SELECT id, name, age FROM employee WHERE id = " + targetId;
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";



             // SELECTを実行し、結果表を取得
//非推奨        Statement stmt = conn.createStatement();
//非推奨        ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login_Id);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();




             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
            String login_idData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new Employee(login_idData, nameData);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            // 以下findAllと同じ処理なので略
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }

        }
    }

//////---------------------------------------------------------------------------------------------
    public List<Employee> findAll() {
        Connection conn = null;
        List<Employee> empList = new ArrayList<Employee>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加

            while (rs.next()) {
                int id = rs.getInt("id");
                String login_id = rs.getString("login_id");
                String name = rs.getString("name");
                Date birth_date = rs.getDate("birth_date");
                String password = rs.getString("password");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                Employee employee = new Employee(id, login_id, name, birth_date, password, create_date, update_date);
                empList.add(employee);
            }
//return new Employee(id, login_id, name, birth_date, password, create_date, update_date);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException e　から　e.printStackTrace();");
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return empList;
    }

////---------------------------------------------------------------------------------------------------------------
    ////SignUpシリーズ用

    public void SignUpInfo(String login_Id, String password, String name, String birth_date ) {////Employeeがvoidになりました
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
//非推奨            String sql = "SELECT id, name, age FROM employee WHERE id = " + targetId;
            String sql = "INSERT INTO user (login_id, name, password, birth_date, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())";



            // SELECTを実行し、結果表を取得
//非推奨        Statement stmt = conn.createStatement();
//非推奨        ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login_Id);
            pStmt.setString(2, name);
            pStmt.setString(3, password);
            pStmt.setString(4, birth_date);
            pStmt.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException e    e.printStackTrace();  11111");

        } finally {
            // データベース切断
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQLException e    e.printStackTrace(); 22222");

                }
            }

        }
    }
/////-------------------------------------------------------------------------------------------------------------
////●UserInfoDetailシリーズ用
////モデルはEmployeeDao.Signup

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

/////-------------------------------------------------------------------------------------------------------------
////UserInfoUpdateシリーズ用
////モデルはEmployeeDao.SignUpシリーズ


    public void byUpdateInfo(String login_Id, String password, String name, String birth_date ) {////Employee→voidへ
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
//非推奨            String sql = "SELECT id, name, age FROM employee WHERE id = " + targetId;
            String sql = "UPDATE user SET password = ?, name= ?, birth_date= ?, update_date = now() where login_id = ? ";



             // SELECTを実行し、結果表を取得
//非推奨        Statement stmt = conn.createStatement();
//非推奨        ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login_Id);
            pStmt.setString(2, name);
            pStmt.setString(3, password);
            pStmt.setString(4, birth_date);
            pStmt.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException e    e.printStackTrace();  11111");

        } finally {
            // データベース切断
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQLException e    e.printStackTrace(); 22222");

                }
            }

        }
    }

//////---------------------------------------------------------------------------------------------
////UserInfoDeleteシリーズ用
////モデルはEmployeeDao.findByInfoUpdate

    public void findByDeleteInfo(String id){////Employeeがvoidに
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
//非推奨            String sql = "SELECT id, name, age FROM employee WHERE id = " + targetId;
            String sql = "DELETE from user where id = ?";
////update文にwhere id=Xを入れる


             // SELECTを実行し、結果表を取得
//非推奨        Statement stmt = conn.createStatement();
//非推奨        ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            pStmt.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException e    e.printStackTrace();  11111");

        } finally {
            // データベース切断
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQLException e    e.printStackTrace(); 22222");

                }
            }

        }
    }


/////-------------------------------------------------------------------------------------------------------------
}
