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
    <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span class="alignright">
                <span class="white">
                    ユーザ名さん
                </span>
                <a href="??" class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <br>
        <h1 align="center">ユーザ情報更新</h1>
        <br>
        <br>

		<form action="UserInfoUpdateServlet" method="post">
		<input type="hidden" class="marginall" name="id" value="${employeeInfo.id}">
		<input type="hidden" class="marginall" name="login_id" value="${employeeInfo.login_id}">
        <table class="aligncenter">
            <tbody>
                <tr>
                    <td>ログインID</td>
                    <td>${employeeInfo.login_id}</td>
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
            <a href="???????">戻る</a>
        </div>


    </body>
</html>

