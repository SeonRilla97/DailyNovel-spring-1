const HITEXT = ["당신의 하루를 들려주세요","어쩌라고!","소소한 일상과 나만의 이야기","마음먹은 대로 잘 될거에요"
,"내일은 영화보러 갈까요","나만의 여행을 계획하기","나는 더 나은 미래를 위해 싸운다","두려움이 가장 큰 적이다."]

let addHello = document.querySelector("#add-hello");
// console.log(Math.floor(Math.random() * HITEXT.length))
addHello.insertAdjacentHTML('beforeend',`<div class="h2 mgt-2">${HITEXT[Math.floor(Math.random() * HITEXT.length)]}`)