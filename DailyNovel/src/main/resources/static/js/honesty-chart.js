var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/analysis1/honesty?honestyRange=10&count=5", requestOptions)
  .then(response => response.json())
  .then(data => {
    const extractedData = data.map(honesty => {
      return {honestyRange: honesty.honestyRange, count: honesty.count};
    });
    
    console.log(extractedData);

    const ctx = document.getElementById('myChart').getContext('2d');
    const myChart = new Chart(ctx, {
      type: 'polarArea',
      data: {
        labels: extractedData.map(honesty => honesty.honestyRange),
        datasets: [{
          data: extractedData.map(honesty => honesty.count),
          backgroundColor: [
            'rgb(255, 99, 132)', // 0 ~ 20
            'rgb(75, 192, 192)', // 20 ~ 40%
            'rgb(255, 205, 86)', // 40 ~ 60%
            'rgb(159, 162, 235)', // 60 ~ 80
            'rgb(54, 162, 235)' // 80 ~ 100
          ],
          borderColor: [
            'rgb(255, 99, 132)', // 0 ~ 20
            'rgb(75, 192, 192)', // 20 ~ 40%
            'rgb(255, 205, 86)', // 40 ~ 60%
            'rgb(159, 162, 235)', // 60 ~ 80
            'rgb(54, 162, 235)' // 80 ~ 100
          ]
        }]
      },
      options: {
        maintainAspectRatio: false,
        responsive: true,
        plugins: {
          legend: {
            position: 'bottom',
            labels: {
              maxWidth: 200,
              padding: 15
            }
          }
        }
      }
    });
  })
  .catch(error => console.log('error', error));