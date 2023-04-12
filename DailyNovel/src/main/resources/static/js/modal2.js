window.addEventListener('load',()=>{
  const tmpSelectBox = document.querySelector(".tmp-select-box");   
  const simpleTmp = document.querySelector("#simple-tmp");
  
  let container = document.querySelector(".container-2");

  const tmpBox = document.querySelector("#tmp-value");
  const feelBox = document.querySelector("#feel-value");
  const weatherBox = document.querySelector("#weather-value");
  const regCancelBtn = document.querySelector("#reg-cancel-btn");

  const simpleTmpBox = document.querySelectorAll(".tmp-select-box > *");

  // 모달 관련
  const regTmpModal = document.querySelector("#reg-tmp-modal");
  const regFeelModal = document.querySelector("#reg-feel-modal");
  const regWeatherModal = document.querySelector("#reg-weather-modal");
  const modalCloseBtn = document.querySelectorAll("#modal-close-btn");
  const regmodal = document.querySelector(".reg-select-modal");
  const regCancelModal = document.querySelector("#reg-cancel-modal");
  const regHonestyModal = document.querySelector("#reg-honesty-modal");


  // regCancelBtn.addEventListener('click', ()=>{
  //   modalOpen(regCancelModal,container);
  // })

  for(let e of modalCloseBtn){
    e.addEventListener('click', ()=> {
      let activeModal = document.querySelector(".reg-select-modal.active");
      
      modalClose(activeModal,container);
      // modalClose(regmodal,container);  
    })
  }  

  function modalOpen(modal, container){
    modal.classList.add('active');        
    container.classList.toggle('position-fixed');
  }

  function modalClose(modal, container){
    modal.classList.remove('active');      
    container.classList.toggle('position-fixed');
  }

})      