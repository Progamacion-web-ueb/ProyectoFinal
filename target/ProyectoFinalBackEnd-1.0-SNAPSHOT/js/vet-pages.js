document.querySelector("#list-visits").addEventListener("click", changePage1);
document.querySelector("#add-visits").addEventListener("click", changePage2);
document.querySelector("#update-visits").addEventListener("click", changePage3);

function changePage1() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/VetListVisits.html';
}
function changePage2() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/VetAddVisit.html';
}
function changePage3() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/VetUpdate.html';
}