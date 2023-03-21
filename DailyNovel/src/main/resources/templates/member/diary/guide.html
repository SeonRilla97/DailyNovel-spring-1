<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>일기 쓰기 전</title>
  <link rel="stylesheet" href="../../../res/css/reset.css">
  <link rel="stylesheet" href="../../../res/css/style.css">
  <link rel="stylesheet" href="../../../res/css/layout.css">
  <link rel="stylesheet" href="../../../res/css/icon.css">
  <link rel="stylesheet" href="../../../res/css/button.css">
  <link rel="stylesheet" href="../../../res/css/box.css">
  <link rel="stylesheet" href="../../../res/css/component-mobile.css">
  <link rel="stylesheet" href="../../../res/css/util.css">


</head>

<body>

  <div class="container-1" style="overflow: hidden;">

    <div class="header lc-center" >
      
      <div class="icon close-btn"></div>    
      

    <div></div>

    </div>
    <div class="main guide-main">
      <div class="lc-center">
        <div id="swiper" class="swiper-bullets">
          <div class="swiper-bullet active">1</div>
          <div class="swiper-bullet">2</div>
          <div class="swiper-bullet">3</div>
          <div class="swiper-bullet">4</div>
          <div class="swiper-bullet">5</div>
        </div>
      </div>      
      <div id="guide-index"></div>
      <div id="guide-content" class="guide-content">
        <div class="ty6">
          오늘은 어떤 하루였는지 떠올려볼까요?
          <!-- <p class="text-center h1"></p>  -->
        </div>
        <div class="ty6">
          <p class="text-center h1">1.오늘은 어떤 하루였는지<br>떠올려볼까요?</p> 
        </div>
        <div class="ty6">
          <p class="text-center h1">2.오늘은 어떤 하루였는지<br>떠올려볼까요?</p> 
        </div>
        <div class="ty6">
          <p class="text-center h1">3.오늘은 어떤 하루였는지<br>떠올려볼까요?</p> 
        </div>
      </div>      


    </div>
    <div class="footer lc-center">
      <a href="../diary/select-tmp.html" style="text-align: center;">바로 작성을 하고 싶으신가요?<br>여기를 클릭하세요.</a>
    </div>

  </div>  
  <script>
    let mousedownX = 0;
    let mouseupX = 0;
    let touchstartX = 0;
    let touchendX = 0;
    const main = document.querySelector('.guide-main');
    const swiper = document.getElementById("swiper");
    
    main.addEventListener('mousedown', (e)=>{  
      mousedownX = e.offsetX;    
      console.log("마우스를 눌렀을 때 좌표 :" + e.offsetX);
    });

    main.addEventListener('mousemove', (e)=>{
      mouseupX = e.offsetX;
      console.log("x 움직이는 중~  :" + e.offsetX);
    });

    main.addEventListener('mouseup', (e)=>{      
      let curactivebullet = document.querySelector('.swiper-bullets > .active');
      let nextactivebullet = document.querySelector('.swiper-bullets > .active + .swiper-bullet');

      // curactivebullet.classList.remove('active');
      // nextactivebullet.classList.add('active');
      mouseupX = e.offsetX;
      console.log(`땟을때 좌표 : ${e.offsetX}`);

      if((mousedownX > mouseupX) && (mousedownX-mouseupX)>100 ){
        curactivebullet.classList.remove('active');
        nextactivebullet.classList.add('active');
      } 

      mousedownX = 0;
      mouseupX = 0;
    })    

    
    main.addEventListener("touchstart",  (e) => {
      // Iterate through the touch points and log each screenX/Y coordinate.
      // The unit of each coordinate is CSS pixels.
      for (let i = 0; i < e.touches.length; i++) {
        touchstartX = e.touches[i].pageX; 
      }
    },
    false
  );

  
  
  const conta = document.querySelector(".container-1");
  let width = conta.clientWidth;
  let left2 = conta.clientLeft;


    main.addEventListener("touchend", (e)=>{
      const guideText = document.querySelector(".guide-content");
      const texts = document.querySelectorAll(".guide-content > div");
      let gwidth = guideText.clientWidth;
      let left = guideText.offsetLeft;

      let curactivebullet = document.querySelector('.swiper-bullets > .active');
      let nextactivebullet = document.querySelector('.swiper-bullets > .active + .swiper-bullet');

      for (let i = 0; i < e.touches.length; i++) {
        touchendX = e.touches[i].pageX;
      }

      if((touchstartX > touchendX) && (touchstartX-touchendX)>100 ){
        // 다음 속성 없으면 유지.
        if(nextactivebullet == null){
          return;
        }
        curactivebullet.classList.remove('active');
        nextactivebullet.classList.add('active');
        // left = left - gwidth;
        texts.forEach((i) => {          
          i.setAttribute("style", `left: ${-gwidth}px`);
        });
        
        // texts.setAttribute("style",`left: ${-gwidth}px`);
      } 
    })
    
  </script>
</body>
</html>

<!-- <div>
        <div>
          <p class="text-center h1">Q1.</p>
        </div>
        <div>
          <p class="text-center h1">오늘은 어떤 하루였는지<br>떠올려볼까요?</p> 
        </div>
      </div>
      <div class="d-none">
        <div>
          <p class="h2">Q1.</p>
        </div>
        <div>
          <p class="text-center h1">오늘은 어떤 하루였는지<br>떠올려볼까요?</p> 
        </div>
      </div> -->