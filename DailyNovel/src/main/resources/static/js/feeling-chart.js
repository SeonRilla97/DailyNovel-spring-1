var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/analysis1/feeling-chart?name=화남&frequency=1", requestOptions)
  .then(response => response.json())
  .then(data => {
    const extractedData = data.map(emotion => {
      return { name: emotion.name, frequency: emotion.frequency };
    });

    let ctx = document.getElementById('myChart').getContext('2d');
    let myChart = new Chart(ctx, {
      type: 'doughnut',
      data: {
        labels: extractedData.map(emotion => emotion.name),
        datasets: [{
          data: extractedData.map(emotion => emotion.frequency),
         
         backgroundColor: [
            '#B19CD9',
            '#C8A2DD', 
            '#D9B3FF', 
            '#E2B5FF', 
            '#F2C6FF', 
            '#FFD9F5', 
            '#ADD8E6',
            '#B0E0E6', 
            '#87CEFA'

 

          ],
          borderColor: [
            '#B19CD9',
            '#C8A2DD', 
            '#D9B3FF', 
            '#E2B5FF', 
            '#F2C6FF', 
            '#FFD9F5', 
            '#ADD8E6',
            '#B0E0E6', 
            '#87CEFA'


 
          ],

          borderWidth: 1,
        }]
      },
      options: {
        maintainAspectRatio: false,
        responsive: true,
        plugins: {
          legend: {
            position: 'bottom',
            labels: {
              padding: 20
            }
          }
        }
      }
    });
  })
  .catch(error => console.log('error', error));
