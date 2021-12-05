package co.edu.unbosque.proyectofinalbackend.resources;

import co.edu.unbosque.proyectofinalbackend.resources.filters.Logged;

import co.edu.unbosque.proyectofinalbackend.resources.pojos.OwnerPOJO;

import co.edu.unbosque.proyectofinalbackend.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<OwnerPOJO> owners ;
        owners = new OwnerService().listOwners();
        System.out.println("conteo "+owners.size());
        return Response.ok()
                .entity(owners)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OwnerPOJO owner) {
        owner.setPersonId(conteoOwners()+1);
        Optional<OwnerPOJO> persistedOwner = new OwnerService().createOwner(owner);
        if (persistedOwner.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOwner.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }

    public Long conteoOwners(){
        Long tamaño ;
        List<OwnerPOJO> owners ;
        owners = new OwnerService().listOwners();
        System.out.println("conteo "+owners.size());
        tamaño=Long.parseLong( owners.size()+"");
        return tamaño;
    }
/*
    //@Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
*/
}