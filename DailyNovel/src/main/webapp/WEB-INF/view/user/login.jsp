<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Niconne&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="/css/button.css" />
    <link rel="stylesheet" type="text/css" href="/css/box.css" />
    <link rel="stylesheet" type="text/css" href="/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="/css/util.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/css/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/css/component-mobile.css" />

    <title>login</title> 
</head>
<body>
    <div class="container-1" >
        <header  class="header lc-center mgt-5">
            <p style="font-family:Niconne; font-size: 5rem;" >DailyNovel</p>
        </header>

        <main class="main lc-vertical-alignment mgt-6">
            <div>당신의 하루를 보다 쉽게 정리하세요. </div>
            <form id ="form" class="lc-vertical-alignment mgt-4" action="../member/main.html">
                <div id="idmiss"class=" blind mgt-3 color-red-1" >계정이 올바르지 않습니다.</div>

                <div class="outBox-id box-large  mgt-3">
                    <div class="inputBox">
                        <input id="id" class="sample-id" type="text"/>
                        <label for="id">이메일 또는 별명</label>
                    </div>
                </div>

                <div id="passwordmiss" class="blind mgt-3 color-red-1" >비밀번호가 올바르지 않습니다.</div>
                <div class="outBox-pass box-large  mgt-3">
                    <div class="inputBox">
                        <input id="passwd" class="sample-pass" type="password"/>
                        <label for="passwd">비밀번호</label>
                    </div>
                </div>
                <div class="lc-center mgt-5">
                    <div>
                        <a href="../user/account-recovery/id.html">아이디 찾기</a>
                    </div>
                    <div class="mgl-5">
                        <a href="../user/account-recovery/password.html">비밀번호 찾기</a>
                    </div>
                </div>
                <input id="loginbtn" type="submit" class="btn3 mgt-5 input-boder-none color-bg-green-2 color-white-2 " value="로그인"/>
            </form>
            <div class="mgt-5">
                <div class="lc-center">
                <div><a href="../user/sign-up.html">처음이신가요? &nbsp;회원가입</a></div>
                </div>
            </div>
        </main>
        
        <script type="text/javascript" src="/js/validation.js"></script>
</body>
</html>