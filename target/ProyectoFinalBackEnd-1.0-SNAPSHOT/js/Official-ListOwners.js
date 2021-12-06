document.querySelector("#clear").addEventListener("click", clearTable);
document.querySelector("#filter-localidad").addEventListener("click", filterByLocalida);
document.querySelector("#show").addEventListener("click", showTable);

var   keyData=0;
var neigborhood;

function clearTable() {

    document.location.reload();
}

function showTable() {

    fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/owners")
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data) => {
                //console.log("data"+data);
                keyData++;
            })
            for (let i = 0; i < keyData; i++) {
                console.log(data[i]);

                let owner = document.createElement("tr");

                let tdOwnerId = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdOwnerId);
                tdOwnerId.innerHTML = data[i].personId;

                let tdEmail = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdEmail);
                tdEmail.innerHTML = data[i].email;

                let tdUsername = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdUsername);
                tdUsername.innerHTML = data[i].username;

                let tdName = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdName);
                tdName.innerHTML = data[i].name;

                let tdAdress = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdAdress);
                tdAdress.innerHTML = data[i].address;

                let tdLocal = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdLocal);
                tdLocal.innerHTML = data[i].neighborhood;
            }
        });
}

function filterByLocalida() {
    neigborhood = document.getElementById("filter").value;
    fetch("http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/owners/"+neigborhood)
        .then(response => response.json())
        .then(data => {
            Object.keys(data).map((data) => {
                //console.log("data"+data);
                keyData++;
            })
            for (let i = 0; i < keyData; i++) {
                console.log(data[i]);

                let owner = document.createElement("tr");

                let tdOwnerId = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdOwnerId);
                tdOwnerId.innerHTML = data[i].personId;

                let tdEmail = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdEmail);
                tdEmail.innerHTML = data[i].email;

                let tdUsername = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdUsername);
                tdUsername.innerHTML = data[i].username;

                let tdName = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdName);
                tdName.innerHTML = data[i].name;

                let tdAdress = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdAdress);
                tdAdress.innerHTML = data[i].address;

                let tdLocal = document.createElement("td");
                document.getElementById("table-owners").appendChild(owner);
                owner.appendChild(tdLocal);
                tdLocal.innerHTML = data[i].neighborhood;
            }
        });
}
