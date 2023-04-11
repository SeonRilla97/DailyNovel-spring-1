window.addEventListener('load', ()=>{

  // 담는 박스
  const box = document.querySelector(".tmp-select-box");

  // 담겨 있는 애들(자식들 다 크기 줄이면서 사라져야 해서)
  const simpleTmpBox = document.querySelectorAll(".tmp-select-box > *");  

  // 간편일기 탭 
  const simpleTmp = document.querySelector("#simple-tmp");  

  simpleTmp.addEventListener('click', ()=>{

    box.classList.toggle("active");

    for(let e of simpleTmpBox){
      e.classList.toggle("active");
    }

    simpleTmp.classList.toggle("color-bg-green-2");  
  })




})