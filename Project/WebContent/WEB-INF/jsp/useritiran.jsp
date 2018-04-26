<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ユーザ一覧</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../js/bootstrap.js"></script>
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span class="alignright">
                <span class="white">
                    ${employeeAccount.name}
<%-- 前に確認しているものを変えてみたのですが、 ${employeeList.name}の場合、どうしてエラーが発生するのでしょうか java.lang.NumberFormatException: For input string: "name" --%>
                </span>
                <a href="LogoutServlet" class="u-red">
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <h1 align="center">
            ユーザ一覧
        </h1>
        <form action="EmployeeListServlet" method="post">
            <span class="nav justify-content-end margin2">
                <a href="SignUpServlet">新規登録</a>
            </span>
            <div class="nav justify-content-center">
	            <table>
	                <tbody>
	                    <tr>
	                        <td><span  class="marginright120">ログインID</span></td>
	                        <td>
	                            <div class="form-group">
	                                <label for="exampleInputEmail1"></label>
	                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter ID" name="login_id">
	                            </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><span  class="marginright120">ユーザ名</span></td>
	                        <td>
	                            <div class="form-group">
	                                <label for="exampleInputEmail1"></label>
	                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter NAME" name="name">
	                            </div>
	                        </td>
	                    </tr>
	                    <tr>
		                    <td>生年月日</td>
		                    <td>
		                    	<span class="form-group">
			                        <input type="date" name="calendar1" max="9999-12-31" >
			                        ～
			                        <input type="date" name="calendar2" max="9999-12-31">
		                        </span>
		                    </td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
            <br>
            <br>
            <div class="text-right margin2">
            <button type="submit" >
                <span class="margin2">検索</span>
            </button>
            </div>
        </form>
        <hr>
        <!-- ------------------------------------------------------------------------  -->
        <div class="container"><!-- spanにするとエラーが発生した  -->
	        <table class="table table-striped ">
	            <thead class="thead-dark">
	                <tr>
	                    <th scope="col">login_id</th>
	                    <th scope="col">name</th>
	                    <th scope="col">birth_date</th>
	                    <th scope="col">リンクボタン</th>
	                </tr>
	            </thead>
	               <tbody>
	               	 <c:if test="${employeeAccount.login_id == 'admin'}">
		                 <c:forEach var="employee" items="${employeeList}" begin="0" >
		                   <tr>
		                     <td>${employee.login_id}</td>
		                     <td>${employee.name}</td>
		                     <td>${employee.birth_date}</td>
		                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
		                     <td>
		                       <a class="btn btn-primary" href="UserInfoDetailServlet?id=${employee.id}">詳細</a>
		                       <a class="btn btn-success" href="UserInfoUpdateServlet?id=${employee.id}">更新</a>
		                       <a class="btn btn-danger" href ="UserInfoDeleteServlet?id=${employee.id}">削除</a>
		                     </td>
		                   </tr>
		                 </c:forEach>
		             </c:if>

		             <c:if test="${employeeAccount.login_id != 'admin'}">
		                 <c:forEach var="employee" items="${employeeList}"  begin="0">
		                   <tr>
		                     <td>${employee.login_id}</td>
		                     <td>${employee.name}</td>
		                     <td>${employee.birth_date}</td>
		                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
		                     <td>
		                       <a class="btn btn-primary" href="UserInfoDetailServlet?id=${employee.id}">詳細</a>
		                       		<c:if test="${employee.login_id == employeeAccount.login_id}">
		                       			<a class="btn btn-success" href="UserInfoUpdateServlet?id=${employee.id}">更新</a>
		                       		</c:if>
		                     </td>
		                   </tr>
		                 </c:forEach>
		             </c:if>
	               </tbody>
	        </table>
	    </div>
    </body>
</html>
