document.querySelector("#save-pet").addEventListener("click", addPet);

var pet_idPg ;
var microchipPg;
var namePg;
var speciesPg;
var racePg;
var sizePg;
var sexPg;
var picturePg;
var owner_idPg;

function addPet() {

    alert("function add Pet")
    debugger;

     microchipPg= document.getElementById("microchip").value;
     namePg= document.getElementById("name").value;
     speciesPg= document.getElementById("species").value;
     racePg= document.getElementById("reace").value;
     sizePg= document.getElementById("size").value;
     sexPg= document.getElementById("sex").value;
     picturePg= document.getElementById("picture").value;

    var id1 = namePg.match(/.{1,2}/g);
    var id2 = speciesPg.match(/.{1,2}/g);
    var id3 = racePg.match(/.{1,2}/g);
    var id4 = sexPg.match(/.{1,2}/g);

    pet_idPg= (id1[0]+"-"+id2[0]+"-"+id3[0]+"-"+id4[0]);
    var cookie= getCookie("login");
    const myArray = cookie.split(",");

    if(myArray[0]==="owner"){
        owner_idPg=myArray[1];
    }
     console.log(pet_idPg)
     console.log(microchipPg)
     console.log(namePg)
     console.log(speciesPg)
     console.log(racePg)
     console.log(sizePg)
     console.log(sexPg)
     console.log(picturePg)
     console.log(owner_idPg)

    debugger;
    const update = {
        pet_id: pet_idPg,
        microchip: microchipPg,
        name: namePg,
        species: speciesPg,
        race: racePg,
        size: sizePg,
        sex: sexPg,
        picture: picturePg
    };

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(update),
    };

    fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/pets/'+owner_idPg, options)
        .then(data => {
            if (!data.ok) {
                throw Error(data.status);
            }
            return data.json();
        }).then(update => {
        console.log(update);
        alert("Usuario creado correctamente")
    }).catch(e => {
        console.log(e);
    });

}

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