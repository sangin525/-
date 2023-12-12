<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>아이디 찾기</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        body {
            padding-top: 200px;
            padding-bottom: 40px;
            font-family: "Nanum Gothic", arial, helvetica, sans-serif;
            background-repeat: no-repeat;
        }

        .card {
            margin: 0 auto;
            float: none;
            margin-bottom: 10px;
        }

        #btn-Yes {
            background-color: #e4932b;
            border: none;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .card-title {
            margin-left: 30px;
            color: #f58b34;
        }

        a {
            color: #f58b34;
            text-decoration: none;
        }

        .links {
            text-align: center;
            margin-bottom: 10px;
        }

        .checks {
            color: red;
        }
    </style>
</head>

<body>

    <div class="card align-middle" style="width:25rem;">
        <div class="card-title" style="margin-top:30px;">
            <h2 class="card-title"><img src="/resources/img/rabbit_logo.png" alt="logo"></h2>
        </div>

        <div class="card-body">
            <form action="findPw" class="form-signin" method="POST">
                <input type="text" name="member_id" id="member_id" class="form-control" placeholder="아이디" required><br>
                <input type="text" name="name" id="name" class="form-control" placeholder="이름" required><BR>
                <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required><br>
                <p class="checks" id="checks"></p><br />
                <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 찾기</button>
            </form>
        </div>
        <div class="links">
            <a href="memberId">아이디 찾기</a> | <a href="memberLogin">로그인</a> | <a href="memberRegist">회원가입</a>
        </div>
    </div>

    <!-- Bootstrap JS 및 추가 JS 파일 포함 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var idRegex = /^[a-z0-9]{5,20}$/;

            $("#member_id").focusout(function () {
                if ($('#member_id').val() == "") {
                    $('#checks').text('아이디를 입력해주세요.');
                    $('#checks').css('color', 'red');
                }
            });

            $("#member_id").focusout(function () {
                if (!idRegex.test($(this).val())) {
                    $('#checks').text('5~20자의 영문 소문자, 숫자만 사용가능합니다');
                    $('#checks').css('color', 'red');
                }
            });

            $("#name").focusout(function () {
                if ($('#name').val() == "") {
                    $('#checks').text('이름을 입력해주세요.');
                    $('#checks').css('color', 'red');
                }
            });

            $("#email").focusout(function () {
                if ($('#email').val() == "") {
                    $('#checks').text('이메일을 입력해주세요');
                    $('#checks').css('color', 'red');
                }
            });
        });
    </script>
</body>

</html>
