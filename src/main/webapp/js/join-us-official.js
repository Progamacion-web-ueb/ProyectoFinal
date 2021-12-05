document.querySelector("#register-official").addEventListener("click", registerOfficial);

var role ;
var usernamepg;
var passwordpg ;
var emailpg ;
var namepg ;

function registerOfficial() {

    role = "official";
    usernamepg = document.getElementById("username").value;
    passwordpg = document.getElementById("password").value;
    emailpg = document.getElementById("email").value;
    namepg = document.getElementById("name").value;

    console.log(role)
    console.log(usernamepg)
    console.log(passwordpg)
    console.log(emailpg)
    console.log(namepg)

    debugger;
    const update = {
        username: usernamepg,
        password: passwordpg,
        email: emailpg,
        name: namepg,
    };

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(update),
    };

    fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/officials', options)
        .then(data => {
            if (!data.ok) {
                throw Error(data.status);
            }
            return data.json();
        }).then(update => {
        console.log(update);
        alert("Official creado correctamente")

    }).catch(e => {
        console.log(e);
    });

}