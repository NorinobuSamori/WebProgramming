<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ユーザ情報詳細参照</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span class="alignright">
                <span class="white">
                    ${employeeAccount.name}
                </span>
                <a href="LogoutServlet" class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <br>
        <h1 align="center">ユーザ情報詳細参照</h1>
        <br>
        <br>
		<div class="nav justify-content-center">
	        <table>
	            <tbody>
	                <tr>
	                    <td><span  class="marginright120">ログインID：</span></td>
	                    <td><c:out value="${employeeInfo.login_id}"/></td>
	                </tr>

	<!-- <p>名前：<c:out value="${param.name}" /></p>
	<p>性別：<c:out value="${param.gender}" /></p>
	<%--このc:out value=""/>がXSS防止カスタムタグ --%>>  -->
	                <tr>
	                    <td>ユーザ名：</td>
	                    <td>${employeeInfo.name}</td>
	                </tr>

	                <tr>
	                    <td>生年月日：</td>
	                    <td>${employeeInfo.birth_date}</td>
	                </tr>

	                <tr>
	                    <td>登録日時：</td>
	                    <td>${employeeInfo.create_date}</td>
	                </tr>

	                <tr>
	                    <td>更新日時：</td>
	                    <td>${employeeInfo.update_date}</td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
        <br>
        <br>

        <br>
        <br>
        <div class="margin2">
            <a href="EmployeeListServlet">戻る</a>
        </div>


    </body>
</html>


