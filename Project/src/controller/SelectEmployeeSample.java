package controller;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;

public class SelectEmployeeSample {
    public static void main(String[] args) {
        // employeeテーブルの全レコードを取得
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.findAll();


//        Employee emp = empDao.findById("'' OR '' = ''");////大文字変換コピーミス注意
//        System.out.println("ID:" + emp.getId());
//        System.out.println("名前:" + emp.getName());
//        System.out.println("年齢:" + emp.getAge());


        // 取得したレコードの内容を出力
        for (Employee emp1 : employeeList) {
            System.out.println("ID:" + emp1.getId());
            System.out.println("ログインID:" + emp1.getLogin_id());
            System.out.println("名前:" + emp1.getName());
            System.out.println("誕生日:" + emp1.getBirth_date());
            System.out.println("パスワード:" + emp1.getPassword());
            System.out.println("登録日:" + emp1.getCreate_date());
            System.out.println("更新日:" + emp1.getUpdate_date() + "\n");
        }
    }
}
