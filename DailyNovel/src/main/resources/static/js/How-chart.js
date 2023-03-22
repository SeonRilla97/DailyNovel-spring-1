let ctx = document.getElementById('myChart').getContext('2d');
;let myChart = new Chart(ctx, {
    type: 'bar',
    data: {

        

        labels: ['자유롭게', '간편일기', '영화', '여행'],

        datasets: [{
            data: [5, 4, 3, 2],
            backgroundColor: [
                '#49b8a5', //행복
                '#f2c1c1', //들뜸
                '#99e6ff', //감동
                '#c1ff83' //화남
            ],

        }]
    },
    options: {
        maintainAspectRatio :false,
      responsive : true,
        plugins: {
            legend: {
                display: false,
                position: 'bottom'
            }
        }
      }
});