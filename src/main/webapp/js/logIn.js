
document.querySelector("#loginU").addEventListener("click", loginUsersOfficial);
debugger;

if(checkCookie("login")){
    console.log("relogin on")
    reLoginCookie();
}

var user;
var password;

function loginUsersOfficial() {

    var keyData =0;
    user = document.getElementById('login-user').value;
    password = document.getElementById('login-password').value;

         fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/officials')
            .then(response => response.json())
            .then(data => {
                Object.keys(data).map((data)=>{
                    //console.log("data"+data);
                    keyData++;
                })
                for(let i=0;i<keyData;i++){
                    var userDb = data[i]["username"];
                    var passwordDb = data[i]["password"];
                    console.log(userDb);
                    console.log(passwordDb);
                    if(userDb===user && passwordDb===password){
                        var cvalue = "official,"+userDb
                        setCookie("login", cvalue, 1)
                        location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListOwners.html';
                        console.log("usuario y contraseña correctos");
                    }else {
                        if(i==(keyData-1)){
                            loginUsersVet();
                        }
                    }
                }
            });
}

function loginUsersVet() {
    keyData=0;
     fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/vets')
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data)=>{
                //console.log("data"+data);
                keyData++;
            })
            for(let i=0;i<keyData;i++){
                var userDb = data[i]["username"];
                var passwordDb = data[i]["password"];
                console.log(userDb);
                console.log(passwordDb);
                if(userDb===user && passwordDb===password){
                    var cvalue = "vet,"+userDb
                    setCookie("login", cvalue, 1)
                    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/VetListVisits.html';
                    break;
                    console.log("usuario y contraseña correctos");
                }else {
                    if(i==(keyData-1)){
                        loginUsersOvner();
                    }
                }

            }
        });
}

function loginUsersOvner() {
    keyData=0;

    fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/owners')
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data)=>{
                //console.log("data"+data);
                keyData++;
            })
            for(let i=0;i<keyData;i++){
                var userDb = data[i]["username"];
                var passwordDb = data[i]["password"];
                console.log(userDb);
                console.log(passwordDb);
                if(userDb===user && passwordDb===password){
                    var cvalue = "owner,"+userDb
                    setCookie("login", cvalue, 1)
                    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerShowPets.html';
                    break;
                    console.log("usuario y contraseña correctos");
                }else {
                    if(i==(keyData-1)){
                        loginincorrecto();
                    }
                }

            }
        });
}

function loginincorrecto(){
    alert("Usurioa o Contraseña Incorrectos");
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
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

function checkCookie(cname) {
    var resul = false;
    var username = getCookie(cname);
    if (username != "") {
        resul = true;
    }
    return resul;
}

function reLoginCookie(){
 var data =getCookie("login")
    console.log(data);
    const myArray = data.split(",");
    //console.log(myArray[1]);
    console.log(myArray[0]);
    if(myArray[0] === "official"){
        location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListOwners.html';
    }else if(myArray[0] === "vet"){
        location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/VetListVisits.html';
    }else if(myArray[0] === "owner"){
        location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerShowPets.html';
    }
}