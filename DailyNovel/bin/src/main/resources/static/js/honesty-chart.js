let ctx = document.getElementById('myChart').getContext('2d');
let myChart = new Chart(ctx, {
    type: 'polarArea',
    data: {

        
        labels:  ['0 ~ 25% ', '26 ~ 50%  ','51 ~ 75%', '76 ~ 100%'],

        datasets: [{
            data: [6, 13, 8, 15],
            backgroundColor: [
                'rgb(255, 99, 132)',//0 ~ 25
                'rgb(75, 192, 192)',//26 ~ 50%
                'rgb(255, 205, 86)',//51 ~ 75%
                'rgb(54, 162, 235)',//76 ~ 100
            ],
            borderColor: [
                'rgb(255, 99, 132)',//0 ~ 25
                'rgb(75, 192, 192)',//26 ~ 50%
                'rgb(255, 205, 86)',//51 ~ 75%
                'rgb(54, 162, 235)',//76 ~ 100
            ],

        }]
    },
     options: {
        maintainAspectRatio :false,
      responsive : true,
        plugins: {
            legend: {
                position: 'bottom',
                labels: {
                    maxWidth: 200,
                    padding:15
                        
                    
                }
            }
        }
      }
});