Vue
.createApp({
	data() {
		let x= 0;
		let y = 10;
		let z = 20;
		
		return {x,y,z};
	},
	
	methods : {
		calcHandler(e){
			console.log("hi Vue");
		}
	}
	
	
})
.mount("#main-container");

