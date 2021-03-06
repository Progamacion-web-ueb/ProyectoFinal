package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetCasePOJO;
import co.edu.unbosque.proyectofinalbackend.services.PetCaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/petCases")
public class PetCaseResource {
// se crea pet pero el idpet queda en null

    @POST
    @Path("/{pet_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petCase, @PathParam("pet_id") String pet_id) {

        petCase.setPet_id(pet_id);
        petCase = new PetCaseService().createPetCase(petCase.getCase_id(), petCase.getCreated_at(), petCase.getType(), petCase.getDescription(), petCase.getPet_id());

        if (!petCase.equals(null)) {
            return Response.status(Response.Status.CREATED)
                    .entity(petCase)
                    .build();
        } else {
            return Response.serverError()
                    .entity("Pet could not be created")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<PetCasePOJO> petcases ;
        petcases = new PetCaseService().listPetCases();

        return Response.ok()
                .entity(petcases)
                .build();
    }


}
