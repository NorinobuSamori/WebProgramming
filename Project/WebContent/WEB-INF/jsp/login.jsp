<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ログイン画面</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/css11.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../js/bootstrap.js"></script>
    </head>

    <body>
    <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

        <br>
        <br>
        <h1 align="center">ログイン画面</h1>
        <br>
        <br>
        <form action="LoginServlet" method="post">
        <table align="center">
            <tbody>
                <tr>
                    <td>ログインID</td>
                    <td>
                        <div class="form-group">
                            <label for="exampleInputEmail1"></label>
                            <input type="login_id" class="form-control" id="exampleInputLoginId" aria-describedby="LoginIdHelp"  placeholder="Enter ID" required name="login_id">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>パスワード</td>
                    <td> <div class="form-group">
                        <label for="exampleInputPassword1"></label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required name="password">
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
        <br>
        <div class="text-center">
            <button type="submit">
                <span class="margin2">ログイン</span>
            </button>
        </div>
        </form>
    </body>
</html>
