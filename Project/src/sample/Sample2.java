package sample;

import java.util.List;

import model.Employee;

public class Sample2 {
	public List<Employee> findAll(){




		return null;

	}

	public int int1(){

		int a = 10;

		String s4 = String1(a);
		int a2 = Integer.parseInt(s4);
		return a2;

	}

	public String String1(int i){

////		String b = 10;はエラー発生
		String s5 = "10";////これはOK
		String s = String.valueOf(i);////これで変換可
		int i2 = Integer.parseInt(s);
		String s2 = "abc";
		String a = "1";
		a = "2";
		System.out.println(a);

		return s;

//		return s2;returnが２つあると到達不能コードになる。

	}

//	public Date Date1(String s3){
//
//
//	return s;

//	return s2;returnが２つあると到達不能コードになる。

//}

//	Date Date11(String day1){
//		 simpledateインスタンス
//		day1 = Date;
//
//
//		}
//		Date Date22(String day2){
//		day2 = Date;
//		}






}
