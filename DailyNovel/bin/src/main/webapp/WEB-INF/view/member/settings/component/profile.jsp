<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필</title>
    <link rel="stylesheet" href="../../../../res/css/reset.css">
    <link rel="stylesheet" href="../../../../res/css/layout.css">
    <link rel="stylesheet" href="../../../../res/css/navigation.css">
    <link rel="stylesheet" href="../../../../res/css/box.css">
    <link rel="stylesheet" href="../../../../res/css/button.css">
    <link rel="stylesheet" href="../../../../res/css/style.css">
    <link rel="stylesheet" href="../../../../res/css/icon.css">
    <link rel="stylesheet" href="../../../../res/css/component-mobile.css">
    <link rel="stylesheet" href="../../../../res/css/util.css">

    <!-- js -->
    <script src="../../../../res/js/setting.js"></script>
</head>
<body>
    <section class="container-1">
        <header class="header lc-center top-sticky">
            <div class="box-large color-bg-green-2 h1 mgt-3">프로필</div>
        </header>

        <section class="main flex-column">
            <form action="">
                <div class="lc-center mgt-5">
                    <input type="file" accept="image/*" onchange="updateImg()" class="upload-btn C d-none" style="display: none;">
                    <div class="pro-img finger"></div>
                </div>
                
                <div class="mgt-5 lc-center">
                    <div class="l-box-short">
                        <div class="name">닉네임</div>
                        <div class="content">송지산</div>
                    </div>
                </div>
                <div class="mgt-5 lc-center">
                    <div class="l-box-short color-bg-gray-1">
                        <div class="name">생년월일</div>
                        <div class="content color-bg-gray-1">20.**.**.**.</div>
                    </div>
                </div>   
                <div class="mgt-5 lc-center">
                    <div class="l-box-middle">
                        <div class="name">상태 메시지</div>
                        <div class="content">이슬람 마카체프 vs 악렉산더 볼카노프스키</div>
                    </div>
                </div>   
                <div class="mgt-5 lc-center">
                    <input class="btn3" type="submit" value="적용">
                    <input class="btn3 font-s-box mgl-6-f" type="reset" value="초기화">
                </div> 
            </form>

        </section>



        <div class="footer mgt-5 bottom-sticky" style="background-color: white;">
            <div class="container-nav color-white-1">
                
                <div class="nav-1 lc-center">
                    <a href="../index.html" class="lc-vertical-alignment">
                    <div class="nav-icon bookmark-btn"></div>
                    <div class="h6 mgt-2">모아보기</div>
                </a>
                </div>
                
                <div class="nav-2 lc-center">
                    <a href="../index.html" class="lc-vertical-alignment">
                        <div class=" nav-icon speech-bubble-btn"></div>
                        <div class="h6 mgt-2">커뮤니티</div>
                    </a>
                </div>

                <div class="nav-main lc-center">
                    <a href="../../main.html" class="lc-vertical-alignment">
                        <div class="nav-icon book-btn"></div>
                        <div class="h6 mgt-2">메인화면</div>
                    </a>
                </div>
    
                <div class="nav-4 lc-center">
                    <a href="" class="lc-vertical-alignment" >
                        <div class="nav-icon  hourglass-btn"></div>
                        <div class="h6 mgt-2">돌아보기</div>
                    </a>
                </div>
                <div class="nav-5 lc-center">
                    <a href="../main.html" class="lc-vertical-alignment">
                        <div class="nav-icon gear-btn"></div>
                        <div class="h6 mgt-2">설정하기</div>
                    </a>
                </div>
            </div>
        </div>
    </section>
</body>
</html>