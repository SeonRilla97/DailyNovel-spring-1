const outBox = document.querySelectorAll(".outBox");
//여기에 유효성검사 까지 들어간다면 어떻게 되는거지???
//이거 쓸 경우, outbox 내부에는 input이 하나만 있어야 합니다.
outBox.forEach(e => {
    e.addEventListener("keyup", ()=>{
        let value = e.querySelector("input").value

        if(!value== ''){
            //빈 값이 아닌 경우
            e.classList.add('existence');   
        }else{
            //빈 값인 경우
            e.classList.remove('existence');   
        }
    });
});

