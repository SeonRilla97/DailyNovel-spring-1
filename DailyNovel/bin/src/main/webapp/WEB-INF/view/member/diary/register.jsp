<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../../res/css/reset.css">
  <link rel="stylesheet" href="../../../res/css/style.css">
  <link rel="stylesheet" href="../../../res/css/layout.css">
  <link rel="stylesheet" href="../../../res/css/icon.css">
  <link rel="stylesheet" href="../../../res/css/button.css">
  <link rel="stylesheet" href="../../../res/css/box.css">
  <link rel="stylesheet" href="../../../res/css/component-mobile.css">
  <link rel="stylesheet" href="../../../res/css/util.css">
  <!-- <script src="../../../res/js/" type="text/javascript"></script> -->
  <script>

// function addURL(url_, flag){
//   let url = url_;
//   url + "?" + "..va";
//   return url;
// }

  </script>
  <title>일기 작성</title>
</head>
<body>

  <div class="container-2" >

    <div class="header reg-header">
      <div class="lc-center">
        <div class="icon question-mark">?</div>
      </div>
      <div class="lc-center">
        <div class="box-short ">2023년 01월 27일</div>
      </div>
      <div class="lc-center">
        <a href="../../member/main.html"><div class="icon close-btn"></div></a>
      </div>      
    </div>

    <div class="main reg-main mgt-2">
      <div class="flex-spacebtw pdl-3 pdr-3">
        <div class="l-box-mini">
          <div class="name lc-center color-white-1">HOW</div>
          <div class="value"></div>
        </div>
        <div class="l-box-mini">
          <div class="name lc-center color-white-1">기분</div>
          <div class="value"></div>
        </div>
        <div class="l-box-mini">
          <div class="name lc-center color-white-1">날씨</div>
          <div class="value"></div>
        </div>
      </div>

      <div class="mgt-3">
        <div>
          <div>제목</div>
          <input type="text" class="editor-title pdt-3 pdl-3 pdr-3">
        </div>
        <textarea class="editor-base mgt-2 pdt-3 pdl-3 pdr-3" placeholder="여기에서 일기를 작성하세요."></textarea>

      </div>
    
    </div>

    <div class="footer lc-center">
      <div class="btn3 color-bg-green-2">저장하기</div>
    </div>
  </div>
</body>
</html>