
	var key;

	document.querySelector("#refresh").addEventListener("click", reload);
	document.querySelector("#butonFilter").addEventListener("click", filter);

    console.log("create data base");
	var openRequest = indexedDB.open("pets",1);
	openRequest.onupgradeneeded = function(e) {
		var thisDB = e.target.result;
		if(!thisDB.objectStoreNames.contains("people")) {
			thisDB.createObjectStore("people", {autoIncrement:true});
		}
	}
	openRequest.onsuccess = function(e) {
		console.log("openRequest.onsuccess");
		db = e.target.result;
		//Listen for add clicks
		document.querySelector("#addDataTable").addEventListener("click", addTable);
		//Listen for add clicks
		
		
		
	}	
	openRequest.onerror = function(e) {
        alert("openRequest.onerror");
		//Do something for the error
	}

	function addTable(){

		var tx = db.transaction(["people"],"readonly");
		var store = tx.objectStore('people');
		store.openCursor().onsuccess = function(event) {
			var cursor = event.target.result;
			// cursor será truthy mientras haya elementos que procesar
			if (cursor) {
				// En cursor.value tenemos el elemento actual
				var current = cursor.value;

				let td1 = document.createElement("td");
				let td2 = document.createElement("td");
				let td3 = document.createElement("td");
				let td4 = document.createElement("td");
				let td5 = document.createElement("td");
				let td6 = document.createElement("td");
				let td7 = document.createElement("td");
				let td8 = document.createElement("td");
				let td9 = document.createElement("td");
				let td10 = document.createElement("td");
				let td11 = document.createElement("td");
				let td12 = document.createElement("td");
				let td13 = document.createElement("td");
				let td14 = document.createElement("td");
			
				let tr = document.createElement("tr");
				document.getElementById("body-table").appendChild(tr);
				key=cursor.key;

			
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tr.appendChild(td8);
				tr.appendChild(td9);
				tr.appendChild(td10);
				tr.appendChild(td11);
				tr.appendChild(td12);
				tr.appendChild(td13);
				tr.appendChild(td14);

				td1.innerHTML= current.ownerName;
				td2.innerHTML= current.petName;
				td3.innerHTML= current.microchip;
				td4.innerHTML= current.species;
				td5.innerHTML= current.sex;
				td6.innerHTML= current.size;
				td7.innerHTML= current.sterile;
				td8.innerHTML= current.dangerous;
				td9.innerHTML= current.neighborhood;
				td10.innerHTML= current.creationDate;
				td11.innerHTML= key;
				td12.innerHTML = current.modifyDate;
				td13.innerHTML = current.modifyDateSterile;
				td14.innerHTML = current.modifyDateMicroship;

				// Pasamos a procesar el siguiente resultado
				cursor.continue();
			
			}
		} 
	}

	function reload(){
		location.reload();
	}

	function filter(){
		var tx = db.transaction(["people"],"readonly");
		var store = tx.objectStore('people');
		store.openCursor().onsuccess = function(event) {
			var cursor = event.target.result;
			// cursor será truthy mientras haya elementos que procesar
			if (cursor) {
				// En cursor.value tenemos el elemento actual
				var current = cursor.value;

				let td1 = document.createElement("td");
				let td2 = document.createElement("td");
				let td3 = document.createElement("td");
				let td4 = document.createElement("td");
				let td5 = document.createElement("td");
				let td6 = document.createElement("td");
				let td7 = document.createElement("td");
				let td8 = document.createElement("td");
				let td9 = document.createElement("td");
				let td10 = document.createElement("td");
				let td11 = document.createElement("td");
				let td12 = document.createElement("td");
				let td13 = document.createElement("td");
				let td14 = document.createElement("td");
				let tr = document.createElement("tr");
				document.getElementById("body-table").appendChild(tr);
				key=cursor.key;
			
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tr.appendChild(td8);
				tr.appendChild(td9);
				tr.appendChild(td10);
				tr.appendChild(td11);
				tr.appendChild(td12);
				tr.appendChild(td13);
				tr.appendChild(td14);

				var filterSize=document.querySelector("#sizeOption").value;
				var filterDangerous=document.querySelector("#dangerousOption").value;
				var filterspices=document.querySelector("#speciesOption").value;
				var filterSex=document.querySelector("#sexOption").value;
				var filterMicrochip=document.querySelector("#microchipOption").value;
				var filterSterile=document.querySelector("#sterileOption").value;
				
				if(filterMicrochip=="Mascotas que NO tienen microchip"){
					filterMicrochip="";
				}

				if(filterSize==current.size||filterSize=="seleccione"){
					console.log("filter1")
					if(filterDangerous==current.dangerous||filterDangerous=="seleccione"){
						console.log("filter2")
						if(filterspices==current.species||filterspices=="seleccione"){
							console.log("filter3")
							if(filterSex==current.sex||filterSex=="seleccione"){
								console.log("filter4")
								if(filterSterile==current.sterile||filterSterile=="seleccione"){
									console.log("filter5")
									if (filterMicrochip == current.microchip||filterMicrochip=="seleccione"){
										console.log("filter6")
										td1.innerHTML= current.ownerName;
										td2.innerHTML= current.petName;
										td3.innerHTML= current.microchip;
										td4.innerHTML= current.species;
										td5.innerHTML= current.sex;
										td6.innerHTML= current.size;
										td7.innerHTML= current.sterile;
										td8.innerHTML= current.dangerous;
										td9.innerHTML= current.neighborhood;
										td10.innerHTML= current.creationDate;
										td11.innerHTML = key;
										td12.innerHTML = current.modifyDate;
										td13.innerHTML = current.modifyDateSterile;
										td14.innerHTML = current.modifyDateMicroship;
									} else if (filterMicrochip != "" && current.microchip != "" || filterMicrochip == "seleccione") {
										console.log("filter7")
										td1.innerHTML= current.ownerName;
										td2.innerHTML= current.petName;
										td3.innerHTML= current.microchip;
										td4.innerHTML= current.species;
										td5.innerHTML= current.sex;
										td6.innerHTML= current.size;
										td7.innerHTML= current.sterile;
										td8.innerHTML= current.dangerous;
										td9.innerHTML= current.neighborhood;
										td10.innerHTML= current.creationDate;
										td11.innerHTML= key;
										td12.innerHTML = current.modifyDate;
										td13.innerHTML = current.modifyDateSterile;
										td14.innerHTML = current.modifyDateMicroship;
									}
								}
								
							}
						}
					}
				}

				

				

				// Pasamos a procesar el siguiente resultado
				cursor.continue();
			
			}
		} 
	}
	

