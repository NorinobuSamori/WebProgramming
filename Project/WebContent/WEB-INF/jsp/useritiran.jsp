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
            <span align="right">
                <span class="white">
                    ユーザ名さん
                </span>
                <a href="??" class="u-red">
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <h1 align="center">
            ユーザ一覧
        </h1>
        <form >
            <span class="nav justify-content-end margin2">
                <a href="???????">新規登録</a>
            </span>
            <table class="aligncenter">
                <tbody>
                    <tr>
                        <td>ログインID</td>
                        <td>
                            <div class="form-group">
                                <label for="exampleInputEmail1"></label>
                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter ID">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>パスワード</td>
                        <td> <div class="form-group">
                            <label for="exampleInputPassword1"></label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            </div>
                        </td>
                    </tr>
                    <td>生年月日</td>
                    <td> <div class="form-group">
                        <input type="date" name="calendar" max="9999-12-31">
                        ～
                        <input type="date" name="calendar" max="9999-12-31">
                        </div>
                    </td>
                </tbody>
            </table>
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
        <table class="aligncenter" class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">login_id</th>
                    <th scope="col">name</th>
                    <th scope="col">birth_date</th>
                    <th scope="col">リンクボタン</th>
                </tr>
            </thead>
               <tbody>
                 <c:forEach var="employee" items="${employeeList}" ><!-- //// useritiranではないということに注意  -->
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
               </tbody>
        </table>
    </body>
</html>
