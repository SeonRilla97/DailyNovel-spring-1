var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/analysis1/how?how=\"\"&count=1", requestOptions)
  .then(response => response.json())
  .then(data => {
	  const extractedData = data.map(template =>{
		  return {name:template.name, count:template.count}
	  });
  
  console.log(extractedData);



let ctx = document.getElementById('myChart').getContext('2d');
;let myChart = new Chart(ctx, {
    type: 'bar',
    data: {

        

        labels: extractedData.map(template => template.name),

        datasets: [{
            data: extractedData.map(template => template.count),
            backgroundColor: [
                '#A593E0',
				'#E0E3DA',
				'#f100e5',
				'#E53A40',
				'#f94e3f',
				'#FFFF66',
				'#566270'
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
})
  .catch(error => console.log('error', error));