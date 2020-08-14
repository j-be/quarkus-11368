package org.duckdns.owly.quarkus_11368;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SomethingResource {
    @Inject
    SomethingRepo repo;

    @GET
    public List<Something> getAll() {
        return repo.listAll();
    }

    @GET
    @Path("/del/{id}")
    public Something getDel(@PathParam("id") long id) {
        return repo.getDelRevisionOf(id);
    }

    @POST
    public Something create(Something toCreate) {
        repo.persist(toCreate);
        return toCreate;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        repo.deleteById(id);
    }
}
