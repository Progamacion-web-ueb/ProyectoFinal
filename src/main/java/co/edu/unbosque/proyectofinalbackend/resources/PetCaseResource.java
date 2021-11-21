package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetCasePOJO;
import co.edu.unbosque.proyectofinalbackend.services.PetCaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/petCases")
public class PetCaseResource {
// se crea pet pero el idpet queda en null

    @POST
    @Path("/{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petCase, @PathParam("type") String type) {

        petCase.setType(type);
        Optional<PetCasePOJO> persistedPetCase = new PetCaseService().createPetCase(petCase);

        if (persistedPetCase.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPetCase.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("PetCase could not be created")
                    .build();
        }
    }
}
