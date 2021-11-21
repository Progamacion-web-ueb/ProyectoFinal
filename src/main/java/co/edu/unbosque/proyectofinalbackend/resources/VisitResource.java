package co.edu.unbosque.proyectofinalbackend.resources;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;
import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.VisitPOJO;
import co.edu.unbosque.proyectofinalbackend.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/visits")
public class VisitResource {
    // se crea pet pero el pet_id  y vet_idqueda en null

    @POST
    @Path("/{vet_id}/{pet_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPOJO visit, @PathParam("vet_id") String vet_id, @PathParam("pet_id") String pet_id) {

        Vet vet = new VisitService().findVet_id(vet_id);
        visit.setVet_id(vet);
/*
        Pet pet = new VisitService().findPet_id(pet_id);
        visit.setPet_id(pet);
*/
        Optional<VisitPOJO> persistedVisit = new VisitService().createVisit(visit);

        if (persistedVisit.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVisit.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("PetCase could not be created")
                    .build();
        }
    }
}
