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
            <table align="center">
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
        <table align="center" class="table">>
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>id0001</td>
                    <td>田中太郎</td>
                    <td>1989年04月26日</td>
                    <td><button type="button" class="btn btn-primary">詳細</button>
                        <button type="button" class="btn btn-success">更新</button>
                        <button type="button" class="btn btn-danger">削除</button>
                    </td>
                </tr>
                <tr>
                    <td>id0002</td>
                    <td>佐藤二郎</td>
                    <td>2001年11月12日</td>
                    <td>
                        <button type="button" class="btn btn-primary">詳細</button>
                        <button type="button" class="btn btn-success">更新</button>
                        <button type="button" class="btn btn-danger">削除</button>
                    </td>
                </tr>
                <tr>
                    <td>id0003</td>
                    <td>佐川真司</td>
                    <td>2000年01月01日</td>
                    <td><button type="button" class="btn btn-primary">詳細</button>
                        <button type="button" class="btn btn-success">更新</button>
                        <button type="button" class="btn btn-danger">削除</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
