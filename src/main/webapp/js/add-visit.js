document.querySelector("#save-visit").addEventListener("click", addVisit);

var visit_idPg ;
var created_atPg;
var typePg;
var descriptionPg;
var pet_idPg;
var vet_idPg;

function addVisit() {

     created_atPg= document.getElementById("created_at").value;
     typePg= document.getElementById("type").value;
     descriptionPg= document.getElementById("description").value;
     pet_idPg= document.getElementById("pet_id").value;

     var cookie= getCookie("login");
     const myArray = cookie.split(",");

     if(myArray[0]==="vet"){
          vet_idPg=myArray[1];
     }

     var id1 = typePg.match(/.{1,2}/g);
     var id2 = pet_idPg.match(/.{1,2}/g);
     var id3 = vet_idPg.match(/.{1,2}/g);

     visit_idPg= ("visit"+id1[0]+"-"+id2[0]+"-"+id3[0]);



     console.log(visit_idPg);
     console.log(created_atPg);
     console.log(typePg);
     console.log(descriptionPg);
     console.log(pet_idPg);
     console.log(vet_idPg);

     const update = {
          visit_id: visit_idPg,
          created_at: created_atPg,
          type: typePg,
          description: descriptionPg
     };

     const options = {
          method: 'POST',
          headers: {
               'Content-Type': 'application/json',
          },
          body: JSON.stringify(update),
     };

     fetch('http://localhost:8080/ProyectoFinalBackEnd-1.0-SNAPSHOT/api/visits/'+vet_idPg+'/'+pet_idPg, options)
         .then(data => {
              if (!data.ok) {
                   throw Error(data.status);
              }
              return data.json();
         }).then(update => {
          console.log(update);
          alert("Usuario creado correctamente")
     }).catch(e => {
          console.log(e);
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