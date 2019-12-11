package info.mywinecellar.resource;

import info.mywinecellar.entity.Grape;
import info.mywinecellar.service.GrapeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/grape")
public class GrapeResource {

    @Inject
    GrapeService grapeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Grape> grapeAllGet() {
        return grapeService.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/red")
    public List<Grape> grapeRedGet() {
        return grapeService.listRedGrapes();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/white")
    public List<Grape> grapeWhiteGet() {
        return grapeService.listWhiteGrapes();
    }

    @Transactional
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{grapeId}/edit")
    public void grapePut(@Valid Grape grape, @PathParam("grapeId") Long grapeId) {
        Grape grapeUpdate = Grape.findById(grapeId);
        grapeService.update(grapeUpdate, grape);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{grapeId}")
    public Grape grapeIdGet(@PathParam("grapeId") Long grapeId) {
        return grapeService.findById(grapeId);
    }

}
