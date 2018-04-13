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
                    ユーザ名さん
                </span>
                <a href="??" class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <br>
        <h1 align="center">ユーザ情報詳細参照</h1>
        <br>
        <br>

        <table class="aligncenter">
            <tbody>
                <tr>
                    <td>ログインID：</td>
                    <td><c:out value="${employeeList.login_id}"/></td><!-- employeeの箇所を変数調整すれば、これで合ってるっぽい。ただ、employeeはログインしている右上のユーザ名と一緒でいいとのこと -->
                </tr>

<!-- セーブしたらエラーが治った  -->

<!-- <p>名前：<c:out value="${param.name}" /></p>
<p>性別：<c:out value="${param.gender}" /></p>
<%--このc:out value=""/>がXSS防止カスタムタグ --%>>  -->
                <tr>
                    <td>ユーザ名：</td>
                    <td>${employeeList.name}</td>
                </tr>

                <tr>
                    <td>生年月日：</td>
                    <td>${employeeList.birth_date}</td>
                </tr>

                <tr>
                    <td>登録日時：</td>
                    <td>${employeeList.create_date}</td>
                </tr>

                <tr>
                    <td>更新日時：</td>
                    <td>${employeeList.update_date}</td>
                </tr>
            </tbody>
        </table>
        <br>
        <br>

        <br>
        <br>
        <div class="margin2">
            <a href="???????">戻る</a>
        </div>


    </body>
</html>


