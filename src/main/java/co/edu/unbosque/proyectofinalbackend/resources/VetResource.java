package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.VetPOJO;
import co.edu.unbosque.proyectofinalbackend.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/vets")
public class VetResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<VetPOJO> vets ;
        vets = new VetService().listVets();

        return Response.ok()
                .entity(vets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VetPOJO vet) {

        Optional<VetPOJO> persistedVet = new VetService().createVet(vet);

        if (persistedVet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVet.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }

    }

/*
    //@Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"vet".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
*/
}
