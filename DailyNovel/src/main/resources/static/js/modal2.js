window.addEventListener('load',()=>{
  let container = document.querySelector(".container-2");
  // 모달 관련
  const modalCloseBtn = document.querySelectorAll("#modal-close-btn");

  //수정삭제 버튼불러오기
  const editDelBtn = document.querySelector("#edit-Del");
  
  const diaryEditModal = document.querySelector("#diary-edit-modal");
  const modaleditdelete = document.querySelectorAll("#editDel");

  //수정삭제 버튼을 누르면
  editDelBtn.addEventListener('click', ()=>{
    modalOpen(diaryEditModal,container);
  })

  // regCancelBtn.addEventListener('click', ()=>{
  //   modalOpen(modaleditdelete,container);
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