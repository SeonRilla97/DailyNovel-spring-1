let ctx = document.getElementById('myChart').getContext('2d');
let myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {

        

        labels: ['행복', '들뜸', '감동', '화남', '불안', '실망', '슬픔', '평온', '난감'],

        datasets: [{
            data: [10, 10, 10, 10, 10, 10, 10, 10, 10],
            backgroundColor: [
                '#A593E0', //행복
                '#81C147', //들뜸
                '#f100e5', //감동
                '#E53A40', //화남
                '#f94e3f', //불안
                '#181842', //실망
                '#566270', //슬픔
                '#D7FFF1', //평온
                '#FBFFB9' //난감
            ],
            borderColor: [
                '#A593E0', //행복
                '#E0E3DA', //들뜸
                '#f100e5', //감동
                '#E53A40', // 화남
                '#f94e3f', //불안
                '#181842', //실망
                '#566270', //슬픔
                '#D7FFF1', //평온
                '#FBFFB9' //난감
            ],
            borderWidth: 1,

        }]
    },
    options: {
        maintainAspectRatio :false,
      responsive : true,
        plugins: {
            legend: {
                position: 'bottom',

                    labels: {
                        padding:20
                            
                        
                    }
                }
             }
          }
        });
