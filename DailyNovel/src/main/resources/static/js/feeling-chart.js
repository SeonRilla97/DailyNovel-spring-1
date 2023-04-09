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
            '#A593E0', 
            '#81C147', 
            '#f100e5', 
            '#E53A40', 
            '#f94e3f', 
            '#FFFF66', 
            '#566270', 
            '#D7FFF1', 
            '#FBFFB9' 

          ],
          borderColor: [
            '#A593E0', 
            '#E0E3DA', 
            '#f100e5', 
            '#E53A40', 
            '#f94e3f', 
            '#FFFF66', 
            '#566270', 
            '#D7FFF1', 
            '#FBFFB9' 

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
