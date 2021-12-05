document.querySelector("#register").addEventListener("click", changePage);

function changePage() {

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;
    var neighborhood = document.getElementById("neighborhood").value;
    var role = document.getElementById("role").value;

    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/PublicRecord.html';
}


