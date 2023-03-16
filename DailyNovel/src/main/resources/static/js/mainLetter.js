const HITEXT = ["당신의 하루를 들려주세요","내가 그린 기림은 긴 기린 그림","경찰청 강철 철창살은 긴 청찰살","짜잔 내가 돌아왔다"]

let addHello = document.querySelector("#add-hello");
// console.log(Math.floor(Math.random() * HITEXT.length))
addHello.insertAdjacentHTML('beforeend',`<div class="h2 mgt-2">${HITEXT[Math.floor(Math.random() * HITEXT.length)]}`)