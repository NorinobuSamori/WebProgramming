<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ユーザ情報更新</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span class="alignright">
                <span class="white">
                    ${employeeInfo.name}
                </span>
                <a href="LogoutServlet" class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <br>
        <h1 align="center">ユーザ情報更新</h1>
        <c:if test="${errMsg != null}" >
	    	<div class="alert alert-danger" role="alert">
		  		${errMsg}
			</div>
		</c:if>
        <br>
        <br>

		<form action="UserInfoUpdateServlet" method="post">
		<input type="hidden" class="marginall" name="id" value="${employeeInfo.id}">
		<input type="hidden" class="marginall" name="login_id" value="${employeeInfo.login_id}">
		<div class="nav justify-content-center">
	        <table>
	            <tbody>
	                <tr>
	                    <td><span  class="marginright120">ログインID</span></td>
	                    <td>${employeeInfo.login_id}</td>
	                </tr>

	                <tr>
	                    <td>パスワード</td>
	                    <td>
	                        <input type="password" class="form-control" id="exampleInputPassword1" name="password1" >
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
	                    <td><input type="text" class="form-control" name="name" value="${employeeInfo.name}"></td>
	                </tr>

	                <tr>
	                    <td>生年月日</td>
	                    <td><input type="date" class="form-control" name="birth_date" value="${employeeInfo.birth_date}"></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
        <br>
        <br>
            <div class="text-center">
                <button type="submit">
                    <span class="margin2">更新</span>
                </button>
        </div>
        </form>
        <br>
        <br>
        <br>
        <div class="margin2">
            <a href="EmployeeListServlet">戻る</a>
        </div>


    </body>
</html>

