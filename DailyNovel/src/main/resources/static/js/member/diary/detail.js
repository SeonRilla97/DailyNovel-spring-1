window.onload = function() {

    const deleteYesBtn = document.querySelector('#delete-yes-btn');

    const queryString = this.window.location.search;
	const params = new URLSearchParams(queryString);
	const diaryId = params.get('diaryId');

    console.log(diaryId);


    deleteYesBtn.addEventListener('click', ()=>{


    var requestOptions = {
        method: 'DELETE',
        redirect: 'follow'
      };
      
      fetch(`http://localhost:8080/diarys/${diaryId}`, requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    

    })


}