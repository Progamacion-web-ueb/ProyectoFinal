package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.OfficialPOJO;
import co.edu.unbosque.proyectofinalbackend.services.OfficialService;
//import co.edu.unbosque.proyectofinalbackend.services.;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/officials")
public class OfficialResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OfficialPOJO official) {

        Optional<OfficialPOJO> persisteOfficial = new OfficialService().createOfficial(official);

        if (persisteOfficial.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persisteOfficial.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Update( @PathParam("username") String username,String name) {

        Official official1 = new OfficialService().update(username,name);
        if (official1.getName().equals(name)) {
            return Response.status(Response.Status.CREATED)
                    .entity(official1.getUsername()+" updated")
                    .build();
        } else {
            return Response.status(Response.Status.CREATED)
                    .entity(official1.getUsername()+" updated")
                    .build();
        }
    }

    @Logged
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

}
