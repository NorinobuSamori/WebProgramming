<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ユーザ削除確認</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark justify-content-end">
            <span align="right">
                <span class="white">
                    ユーザ名さん
                </span>
                <a href="??" span class="u-red" >
                    ログアウト
                </a>

            </span>
        </nav>
        <br>
        <h1 align="center">
            ユーザ削除確認
        </h1>
        <div class="aligncenter">
        ログインID：id0001
        <br>を本当に削除してもよろしいでしょうか。
        <br>
        <br>
        <br>
            <form action="UserInfoDeleteServlet" method="post">
                <button type="submit" class="marginall"><span class="margin2">キャンセル</span></button>
                <button type="submit" class="marginall"><span class="margin2">ＯＫ</span></button>
            </form>
        </div>
    </body>
</html>
