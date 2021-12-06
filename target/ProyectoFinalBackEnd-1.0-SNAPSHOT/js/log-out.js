
document.querySelector("#log-out").addEventListener("click", logOut);

function logOut() {
    eliminarCookie("login");
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT';
}
function eliminarCookie(cname) {
    return document.cookie = cname + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}