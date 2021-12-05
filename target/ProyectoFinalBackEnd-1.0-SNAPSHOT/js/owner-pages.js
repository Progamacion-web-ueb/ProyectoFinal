document.querySelector("#add-pet").addEventListener("click", changePage1);
document.querySelector("#show-pets").addEventListener("click", changePage2);
document.querySelector("#update-pet").addEventListener("click", changePage3);
document.querySelector("#update-data").addEventListener("click", changePage4);
debugger;

function changePage1() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerAddPet.html';
}
function changePage2() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerShowPets.html';
}
function changePage3() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerUpdatePet.html';
}
function changePage4() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OwnerUpdate.html';
}