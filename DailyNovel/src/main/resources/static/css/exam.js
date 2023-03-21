
class inputForm{
    constructor(container, input) {
        this.doc = document.querySelector(container);
        this.input  = document.querySelector(input);
        console.log( this.input.value);
        let value = this.input.value;
    this.input.addEventListener('keyup', function(){
        value = this.input.value;
        console.log(value)
        if(!value=== ''){
            //빈 값이 아닌 경우
            this.doc.classList.add('existence');   
        }else{
            //빈 값인 경우
            this.doc.classList.remove('existence');   
        }
    });
    }   
}


new inputForm(".outBox-id",".sample-id");


