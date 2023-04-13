window.addEventListener('load',()=>{
  const tmpSelectBox = document.querySelector(".tmp-select-box");   
  const simpleTmp = document.querySelector("#simple-tmp");
  
  let container = document.querySelector(".container-2");

  const tmpBox = document.querySelector("#tmp-value");
  const feelBox = document.querySelector("#feel-value");
  const weatherBox = document.querySelector("#weather-value");
  const regCancelBtn = document.querySelector("#reg-cancel-btn");
  const regSumbitBtn = document.querySelector("#reg-submit-btn");

  const simpleTmpBox = document.querySelectorAll(".tmp-select-box > *");

  // 모달 관련
  const regTmpModal = document.querySelector("#reg-tmp-modal");
  const regFeelModal = document.querySelector("#reg-feel-modal");
  const regWeatherModal = document.querySelector("#reg-weather-modal");
  const modalCloseBtn = document.querySelectorAll("#modal-close-btn");
  const regmodal = document.querySelector(".reg-select-modal");
  const regCancelModal = document.querySelector("#reg-cancel-modal");
  const regHonestyModal = document.querySelector("#reg-honesty-modal");
  const regResetWarnModal = document.querySelector("#reg-reset-warning-modal");

  regSumbitBtn.addEventListener('click', ()=>{
    modalOpen(regHonestyModal,container);
  })

  regCancelBtn.addEventListener('click', ()=>{
    modalOpen(regCancelModal,container);
  })

  tmpBox.addEventListener('click', ()=> {
    modalOpen(regTmpModal,container);
  })   

  feelBox.addEventListener('click', ()=>{
    modalOpen(regFeelModal,container);
  })

  weatherBox.addEventListener('click', ()=>{
    modalOpen(regWeatherModal,container);
  })

  regTmpModal.addEventListener('click', (e)=> {
      if(e.target.tagName != "LI")
        return;      
      modalClose(regTmpModal,container);
      modalOpen(regResetWarnModal,container);
  })

  regFeelModal.addEventListener('click',(e)=>{
      if(e.target.tagName != "LI")
        return;      
      modalClose(regFeelModal,container);      
  })

  // 날씨 부분 수정
  let wtbox = document.querySelector(".weather-box > *");  
  let wtboxes = document.querySelectorAll(".weather-box > * ");
  for(let e of wtboxes){
    e.addEventListener('click',(e)=>{
      modalClose(regWeatherModal,container);      
    })  
  }
  // wtboxes.addEventListener('click',(e)=>{
  //   modalClose(regWeatherModal,container);      
  // })

  regWeatherModal.addEventListener('click',(e)=>{
      // wtbox.addEventListener('click',(e)=>{

      // })
      // // if(e.target.tagName != "LI")
      // //   return;      
      if(e.target != wtbox)
        return;
      modalClose(regWeatherModal,container);      
  })
  
  

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

  // 추후에 드랍다운 js 만들면서 빠져야할 부분.
  simpleTmp.addEventListener('click', ()=>{
    // tmpSelectBox.classList.toggle("d-none");
    tmpSelectBox.classList.toggle("active");
    for(let e of simpleTmpBox){
      e.classList.toggle("active");
    }
    // simpleTmpBox.classList.toggle("active");
    simpleTmp.classList.toggle("color-bg-green-2");
    
  })
  

  
})      