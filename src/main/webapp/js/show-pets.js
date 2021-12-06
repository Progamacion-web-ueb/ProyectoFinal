debugger;
var cookie= getCookie("login");
const myArray = cookie.split(",");
var   keyData=0;
if(myArray[0]==="owner"){
    owner_id=myArray[1];
}

fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/pets/"+owner_id)
    .then(response => response.json())
    .then(data => {
        Object.keys(data).map((data)=>{
            //console.log("data"+data);
            keyData++;
        })
        for(let i=0;i<keyData;i++){
            console.log(data[i]);

            let pet = document.createElement("tr");

            let tdPetId = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdPetId);
            tdPetId.innerHTML= data[i].pet_id;

            let tdNombre = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdNombre);
            tdNombre.innerHTML= data[i].name;

            let tdEspecie = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdEspecie);
            tdEspecie.innerHTML= data[i].species;

            let tdRaza = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdRaza);
            tdRaza.innerHTML= data[i].race;

            let tdSexo = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdSexo);
            tdSexo.innerHTML= data[i].sex;

            let tdTamaño = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdTamaño);
            tdTamaño.innerHTML= data[i].size;

            let tdImagen = document.createElement("td");
            document.getElementById("table-pets").appendChild(pet);
            pet.appendChild(tdImagen);
            var url = "http://placekitten.com/803/20"+i;
             tdImagen.innerHTML= "<img id=\"imgDB\" src=\""+url+"\"/>";

            /*
            documento.getElementById("content").innerHTML = "<img src ='  " el valor de la imagen". jpg' alt=">" ;
            <img src="http://placekitten.com/803/250" />
             */

        }
    });


function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') c = c.substring(1);
        if (c.indexOf(name) === 0)
            console.log(c.substring(name.length, c.length));
        return c.substring(name.length, c.length);
    }
    return "";
}