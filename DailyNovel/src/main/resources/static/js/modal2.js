window.addEventListener('load',()=>{
  let container = document.querySelector(".container-2");
  // 모달 관련
  const modalCloseBtn = document.querySelector("#modal-close-btn");

  //버튼관련
  const editDelBtn = document.querySelector("#edit-Del");
  const modalDeleteBtn = document.querySelector("#modal-delete-btn");
  const deleteNoBtn = document.querySelector('#delete-no-btn');
  
  //처음 옵션 눌렀을 때 
  const diaryEditModal = document.querySelector("#diary-edit-modal");
  const deleteCheckModal = document.querySelector("#delete-check-modal");


  // const modaleditdelete = document.querySelectorAll("#editDel");

  //수정삭제 버튼을 누르면
  editDelBtn.addEventListener('click', ()=>{
    modalOpen(diaryEditModal,container);
  })
  // X버튼
  modalCloseBtn.addEventListener('click', ()=>{
    modalClose(diaryEditModal,container);
  })

  //삭제하기
  modalDeleteBtn.addEventListener('click', ()=>{
    modalClose(diaryEditModal,container);
    modalOpen(deleteCheckModal,container);
  })

  //삭제 취소
  deleteNoBtn.addEventListener('click',() =>{
    modalClose(deleteCheckModal, container);
  })





  // for(let e of modalCloseBtn){
  //   e.addEventListener('click', ()=> {
  //     let activeModal = document.querySelector(".reg-select-modal.active");
      
  //     modalClose(activeModal,container);
  //     // modalClose(regmodal,container);  
  //   })
  // }  

  function modalOpen(modal, container){
    modal.classList.add('active');        
    container.classList.toggle('position-fixed');
  }

  function modalClose(modal, container){
    modal.classList.remove('active');      
    container.classList.toggle('position-fixed');
  }

})      