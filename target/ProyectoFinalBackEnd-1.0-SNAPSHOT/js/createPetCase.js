document.querySelector("#save-case").addEventListener("click", createPetCase);
var fechaPg;
var descriptionPg;
var typePg;
var petId;
var caseId;

function createPetCase(){

    fechaPg= document.getElementById("created-at").value;
    descriptionPg= document.getElementById("description").value;
    typePg= document.getElementById("type").value;
    petId= document.getElementById("pet-id").value;

    console.log(fechaPg);
    console.log(descriptionPg);
    console.log(typePg);
    console.log(petId);

    function getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min)) + min;
    }

    caseId = "caso"+getRandomInt(100,10000)+petId;
    console.log(caseId);

    const update = {
        case_id: caseId,
        created_at: fechaPg,
        type: typePg,
        description: descriptionPg,
    };

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(update),
    };

    fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/petCases/'+petId, options)
        .then(data => {
            if (!data.ok) {
                throw Error(data.status);
            }
            return data.json();
        }).then(update => {
        console.log(update);
        alert("petCase creado correctamente")
    }).catch(e => {
        console.log(e);
    });


}





