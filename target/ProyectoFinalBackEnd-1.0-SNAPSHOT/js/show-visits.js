document.querySelector("#filter1").addEventListener("click", filterByName);
document.querySelector("#filter2").addEventListener("click", filterByName1);
document.querySelector("#clear").addEventListener("click", clearTable);

function clearTable() {
    document.location.reload();
}

var filternamePet

function filterByName() {

        var  vet_id
        var cookie= getCookie("login");
        const myArray = cookie.split(",");
        var   keyData=0;
        if(myArray[0]==="vet"){
            vet_id=myArray[1];
        }
        filternamePet =document.getElementById("filter-namePet").value;
        fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/visits/"+vet_id)
            .then(response => response.json())
            .then(data => {
                Object.keys(data).map((data) => {
                    //console.log("data"+data);
                    keyData++;
                })
                for (let i = 0; i < keyData; i++) {
                    console.log(data);
                    let vetMap = data[i]["vet"];
                    let petMap = data[i]["pet"];
                    var vettalbe = vetMap.username;
                    var pettalbe = petMap.pet_id;

                    if (filternamePet === "") {
                        let visit = document.createElement("tr");

                        let tdVisitId = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdVisitId);
                        tdVisitId.innerHTML = data[i].visit_id;

                        let tdFecha = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdFecha);
                        tdFecha.innerHTML = data[i].created_at;

                        let tdType = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdType);
                        tdType.innerHTML = data[i].type;

                        let tdDescription = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdDescription);
                        tdDescription.innerHTML = data[i].description;

                        let tdVetid = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdVetid);
                        tdVetid.innerHTML = vettalbe;

                        let tdPetid = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdPetid);
                        tdPetid.innerHTML = pettalbe;

                        let tdPetname = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdPetname);
                        tdPetname.innerHTML = petMap.name;
                    }
                    if (petMap.name === filternamePet) {

                        let visit = document.createElement("tr");

                        let tdVisitId = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdVisitId);
                        tdVisitId.innerHTML = data[i].visit_id;

                        let tdFecha = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdFecha);
                        tdFecha.innerHTML = data[i].created_at;

                        let tdType = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdType);
                        tdType.innerHTML = data[i].type;

                        let tdDescription = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdDescription);
                        tdDescription.innerHTML = data[i].description;

                        let tdVetid = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdVetid);
                        tdVetid.innerHTML = vettalbe;

                        let tdPetid = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdPetid);
                        tdPetid.innerHTML = pettalbe;

                        let tdPetname = document.createElement("td");
                        document.getElementById("table-visit").appendChild(visit);
                        visit.appendChild(tdPetname);
                        tdPetname.innerHTML = petMap.name;
                    }

                }
            });
}


function filterByName1() {

    var  vet_id
    var cookie= getCookie("login");
    const myArray = cookie.split(",");
    var   keyData=0;
    if(myArray[0]==="vet"){
        vet_id=myArray[1];
    }
    filternamePet =document.getElementById("filter-namePet").value;
    fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/visits/"+vet_id)
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data) => {
                //console.log("data"+data);
                keyData++;
            })
            for (let i = keyData-1; i>=0; i--) {
                console.log(data);
                let vetMap = data[i]["vet"];
                let petMap = data[i]["pet"];
                var vettalbe = vetMap.username;
                var pettalbe = petMap.pet_id;

                if (filternamePet === "") {
                    let visit = document.createElement("tr");

                    let tdVisitId = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdVisitId);
                    tdVisitId.innerHTML = data[i].visit_id;

                    let tdFecha = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdFecha);
                    tdFecha.innerHTML = data[i].created_at;

                    let tdType = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdType);
                    tdType.innerHTML = data[i].type;

                    let tdDescription = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdDescription);
                    tdDescription.innerHTML = data[i].description;

                    let tdVetid = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdVetid);
                    tdVetid.innerHTML = vettalbe;

                    let tdPetid = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdPetid);
                    tdPetid.innerHTML = pettalbe;

                    let tdPetname = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdPetname);
                    tdPetname.innerHTML = petMap.name;
                }
                if (petMap.name === filternamePet) {

                    let visit = document.createElement("tr");

                    let tdVisitId = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdVisitId);
                    tdVisitId.innerHTML = data[i].visit_id;

                    let tdFecha = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdFecha);
                    tdFecha.innerHTML = data[i].created_at;

                    let tdType = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdType);
                    tdType.innerHTML = data[i].type;

                    let tdDescription = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdDescription);
                    tdDescription.innerHTML = data[i].description;

                    let tdVetid = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdVetid);
                    tdVetid.innerHTML = vettalbe;

                    let tdPetid = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdPetid);
                    tdPetid.innerHTML = pettalbe;

                    let tdPetname = document.createElement("td");
                    document.getElementById("table-visit").appendChild(visit);
                    visit.appendChild(tdPetname);
                    tdPetname.innerHTML = petMap.name;
                }

            }
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
