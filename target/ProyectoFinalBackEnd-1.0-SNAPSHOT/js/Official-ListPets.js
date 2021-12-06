document.querySelector("#clear").addEventListener("click", clearTable);
document.querySelector("#show").addEventListener("click", showtable);
document.querySelector("#filter-Esterilizacion").addEventListener("click", filterBySterile);
document.querySelector("#filter-Microchip").addEventListener("click", filterBychip);
document.querySelector("#filter-Especie").addEventListener("click", filterBySpecie);

var   keyData=0;
var pet_id;
const listPetId = [];
const steril = [];
const microchip = [];
const listPets = [];

function clearTable() {
    document.location.reload();
}

function showtable() {
    debugger;
    fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/pets")
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data) => {
                //console.log("data"+data);
                keyData++;
            })
            for (let i = 0; i < keyData; i++) {
                console.log(data[i]);
                listPets[i]=data[i];
            }

            console.log(listPets);
            verifiSterile()
        });
}
function verifiSterile() {
    keyData=0;
    for(let k = 0; k < listPets.length; k++){
        petid=listPets[k].pet_id
        fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/visits/vet/"+petid)
            .then(response => response.json())
            .then(data => {
                Object.keys(data).map((data) => {
                    //console.log("data"+data);
                    keyData++;
                })
                if(keyData==0){
                    steril[k]="Sin visitas";
                }
                for (let i = 0; i < keyData; i++) {
                    if(data[i].type==="Esterilizacion"){
                        steril[k]="Esterilizado";
                    }
                    else{
                        steril[k]="No Esterilizado";
                    }
                    if(data[i].type==="Implantacion de microchip"){
                        microchip[k]="Microchip implantado";
                    }else{
                        microchip[k]="Microchip no implantado";
                    }
                }
                console.log(steril)

            });
    }

}



/*
function showtable() {
    let pet = document.createElement("tr");
    fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/pets")
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data) => {
                //console.log("data"+data);
                keyData++;
            })

            for (let i = 0; i < keyData; i++) {
                console.log(data[i]);

                let OwnerMap = data[i]["owner"];
                var ownerId = OwnerMap.username;
                pet_id=data[i].pet_id;


                let pet = document.createElement("tr");

                let tdPetId = document.createElement("td");
                document.getElementById("table-pets").appendChild(pet);
                pet.appendChild(tdPetId);
                tdPetId.innerHTML= data[i].pet_id;
                listPetId[i]=data[i].pet_id;


                let tdChip = document.createElement("td");
                document.getElementById("table-pets").appendChild(pet);
                pet.appendChild(tdChip);
                tdChip.innerHTML= data[i].microchip;

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


                let tdOwnerId = document.createElement("td");
                document.getElementById("table-pets").appendChild(pet);
                pet.appendChild(tdOwnerId);
                tdOwnerId.innerHTML= ownerId;

                let tdImagen = document.createElement("td");
                document.getElementById("table-pets").appendChild(pet);
                pet.appendChild(tdImagen);
                var url = "http://placekitten.com/803/20"+i;
                tdImagen.innerHTML= "<img id=\"imgDB\" src=\""+url+"\"/>";
            }
        });


}
*/

function filterBySterile() {
    alert("filterBySterile")
    verifySterile();

}
function filterBychip() {
    alert("filterBychip")

}
function filterBySpecie() {
    alert("filterBySpecie")

}

function verifySterile(){
    debugger;
    console.log(listPetId)
    for (let i = 0; i < listPetId.length; i++) {
        if(pet_id==undefined){
            return"Sin visitas";
        }else{
            fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/visits/"+pet_id)
                .then(response => response.json())
                .then(data => {
                    Object.keys(data).map((data) => {
                        //console.log("data"+data);
                        keyData++;
                    })
                        var aux1=0;
                    var aux2=0;
                    for (let i = 0; i < keyData; i++) {
                        console.log(data[i]);
                        if((data[i].type)===("Esterilizacion")){
                            esteril[aux1]=data[i];
                            aux1=aux1+1

                        }else{
                            Noesteril[aux1]=data[i];
                            aux1=aux1+1

                        }

                    }
                    console.log(esteril)
                    console.log(Noesteril)
                });
        }
    }


}