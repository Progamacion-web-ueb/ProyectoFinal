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
        
        visit = new VisitService().createVisit(visit.getVisit_id(),visit.getCreated_at(),visit.getType(),visit.getDescription(),visit.getPet_id(),visit.getVet_id());

        if (!visit.equals(null)) {
            return Response.status(Response.Status.CREATED)
                    .entity(visit)
                    .build();
        } else {
            return Response.serverError()
                    .entity("Pet could not be created")
                    .build();
        }
    }
}
