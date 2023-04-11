let emailImage = document.querySelector(".lb-middle .l-box-middle .content .email")
let pdfImage = document.querySelector(".lb-middle .l-box-middle .content .pdf")

emailImage.onclick = function(){
    alert("메일이 보내집니다.");
}

pdfImage.onclick = function(){
    alert("다운로드가 시작됩니다.");
}
