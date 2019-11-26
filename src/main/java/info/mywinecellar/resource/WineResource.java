package info.mywinecellar.resource;

import info.mywinecellar.entity.Wine;
import info.mywinecellar.service.WineService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/wine")
public class WineResource {

    @Inject
    WineService wineService;

    /**
     * Retrieve the list of Wine's
     *
     * @return List<Wine>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Wine> wineAllGet() {
        return wineService.listAll();
    }

    /**
     * Add a new Wine
     *
     * @param wine Wine entity
     */
    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public void winePost(Wine wine) {
        wineService.persist(wine);
    }

}
