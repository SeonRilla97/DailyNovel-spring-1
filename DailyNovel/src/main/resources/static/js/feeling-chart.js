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
            '#fecd50', //(Navy blue)
			'#a0d4cd', //(Medium purple)
			'#ef7d00', //(Magenta)
			'#e42313', //(Vivid red)
			'#dca8ad', //(Bright yellow)
			'#b482c2', //(Salmon)
			'#68739b', //(Light green)
			'#6495ed', //(Cornflower blue)
			'#d45087' //(Pinkish red)

 

          ],
          borderColor: [
            '#fecd50', //(Navy blue)
			'#a0d4cd', //(Medium purple)
			'#ef7d00', //(Magenta)
			'#e42313', //(Vivid red)
			'#dca8ad', //(Bright yellow)
			'#b482c2', //(Salmon)
			'#68739b', //(Light green)
			'#6495ed', //(Cornflower blue)
			'#d45087' //(Pinkish red)


 
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
