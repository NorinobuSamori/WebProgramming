<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ユーザ新規登録</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span class="alignright">
                <span class="white">
                    ${employeeAccount.name}<%-- employeeListと型が違っていたりするので注意 --%>
                </span>
                <a href="LogoutServlet" class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <br>
        <h1 align="center">ユーザ新規登録</h1>
        <c:if test="${errMsg != null}" >
		    <div class="alert alert-danger" role="alert">
			  ${errMsg}
			</div>
		</c:if>
        <br>
        <br>
		<form action="SignUpServlet" method="post">
		<div class="nav justify-content-center">
	        <table>   <!-- <table class="aligncenter">の場合、テーブル要素内がaligncenterになったが、エラーも起きる（今回はなぜか起きていない）  -->
	            <tbody>
	                <tr>
	                    <td><span  class="marginright120">ログインID</span></td>
	                    <td><input type="text" class="form-control" name="login_id"></td>
	                </tr>

	                <tr>
	                    <td>パスワード</td>
	                    <td>
	                        <input type="password" class="form-control" id="exampleInputPassword1" name="password1">
	                    </td>
	                </tr>

	                <tr>
	                    <td>パスワード(確認)</td>
	                    <td>
	                        <input type="password" class="form-control" id="exampleInputPassword2" name="password2">
	                    </td>
	                </tr>

	                <tr>
	                    <td>ユーザ名</td>
	                    <td><input type="text" class="form-control" name="name"></td>
	                </tr>

	                <tr>
	                    <td>生年月日</td>
	                    <td><input type="date" class="form-control" name="birth_date"></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
        <br>
        <br>
        <div class="text-center">
            <button type="submit">
                <span class="margin2">登録</span>
            </button>
        </div>
        </form>
        <br>
        <br>
        <br>
        <div class="margin2">
            <a href="EmployeeListServlet">戻る</a>
        </div>
		<br>
		<br>
		<br>

    </body>
</html>
