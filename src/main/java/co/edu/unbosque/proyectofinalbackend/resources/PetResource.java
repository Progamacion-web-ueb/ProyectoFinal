package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;
import co.edu.unbosque.proyectofinalbackend.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/pets")
public class PetResource {

// se crea pet pero el id queda en null

    @POST
    @Path("/{owner_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetPOJO pet , @PathParam("owner_id") String owner_id) {

        System.out.println(pet.toString());
        pet.setOwner_id(owner_id);
        pet= new PetService().createPet(pet.getPet_id(),pet.getMicrochip(),pet.getName(),
                pet.getSpecies(),pet.getRace(),pet.getSize(),pet.getSex(),pet.getPicture(), pet.getOwner_id());

        System.out.println("ejecuacion");

        if (!pet.equals(null)) {
            return Response.status(Response.Status.CREATED)
                    .entity(pet)
                    .build();
        } else {
            return Response.serverError()
                    .entity("Pet could not be created")
                    .build();
        }
    }

    @GET
    @Path("/{owner_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listId(@PathParam("owner_id") String owner_id) {


        List<PetPOJO> pets ;
        pets = new PetService().listPetsId(owner_id);

        return Response.ok()
                .entity(pets)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<PetPOJO> pets ;
        pets = new PetService().listPets();

        return Response.ok()
                .entity(pets)
                .build();
    }

}
