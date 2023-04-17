let emailImage = document.querySelector(".lb-middle .l-box-middle .content .email")
let pdfImage = document.querySelector(".lb-middle .l-box-middle .content .pdf")


emailImage.onclick = function(e){
    fetch('/member/setting/export/email')
      .then(response => response.json())
      .catch(error => console.error(error));
  
    
    alert("전송이 완료됐습니다.")
}

pdfImage.onclick = function(){
    alert("다운로드가 시작됩니다.");
}
