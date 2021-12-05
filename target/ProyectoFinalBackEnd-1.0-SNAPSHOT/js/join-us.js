document.querySelector("#save-register").addEventListener("click", registerUser);

var role ;
var usernamepg;
var passwordpg ;
var emailpg ;
var namepg ;
var addresspg;
var neighborhoodpg;


function registerUser() {

     role = document.getElementById("role").value;
     usernamepg = document.getElementById("username").value;
     passwordpg = document.getElementById("password").value;
     emailpg = document.getElementById("email").value;
     namepg = document.getElementById("name").value;
     addresspg = document.getElementById("address").value;
     neighborhoodpg = document.getElementById("neighborhood").value;

    var obj = new Object();
    obj.username = usernamepg;
    obj.password  = passwordpg;
    obj.email = emailpg;
    obj.name = namepg;
    obj.address = addresspg;
    obj.neighborhood = neighborhoodpg;

    console.log( obj);
    var jsonString= JSON.stringify(obj);
    console.log( jsonString);

    debugger;

    if(role==="vet"){

        const update = {
            username: usernamepg,
            password: passwordpg,
            email: emailpg,
            name: namepg,
            address: addresspg,
            neighborhood: neighborhoodpg
        };

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(update),
        };

        fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/vets', options)
            .then(data => {
                if (!data.ok) {
                    throw Error(data.status);
                }
                return data.json();
            }).then(update => {
            console.log(update);

        }).catch(e => {
            console.log(e);
        });
    }
    if (role==="owner"){

        const update = {
            username: usernamepg,
            password: passwordpg,
            email: emailpg,
            name: namepg,
            address: addresspg,
            neighborhood: neighborhoodpg
        };

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(update),
        };

        fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/owners', options)
            .then(data => {
                if (!data.ok) {
                    throw Error(data.status);
                }
                return data.json();
            }).then(update => {
            console.log(update);

        }).catch(e => {
            console.log(e);
        });
    }

}