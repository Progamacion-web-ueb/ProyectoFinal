
document.querySelector("#list-owners").addEventListener("click", changePage1);
document.querySelector("#list-pets").addEventListener("click", changePage2);
document.querySelector("#list-cases").addEventListener("click", changePage3);
document.querySelector("#list-visits").addEventListener("click", changePage4);
document.querySelector("#chat").addEventListener("click", changePage5);
document.querySelector("#update-data").addEventListener("click", changePage6);


function changePage1() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListOwners.html';
}
function changePage2() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListPets.html';
}
function changePage3() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListCases.html';
}
function changePage4() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialListVisits.html';
}
function changePage5() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialChat.html';
}
function changePage6() {
    location.href ='http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/OfficialUpdate.html';
}