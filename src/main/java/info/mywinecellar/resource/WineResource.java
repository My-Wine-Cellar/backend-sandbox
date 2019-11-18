package info.mywinecellar.resource;

import info.mywinecellar.entity.Wine;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/wine")
public class WineResource extends AbstractResource {

    @GET
    @Produces(value = APPLICATION_JSON)
    @Path("/all")
    public List<Wine> wineListAll() {
        checkObjectListNull(Wine.listAll());
        log.info("==== Show me Wines ====");
        return Wine.listAll();
    }

    @Transactional
    @POST
    @Consumes(value = APPLICATION_JSON)
    @Path("/new")
    public void wineNewPost(Wine wine) {
        checkObjectNull(wine);
        log.info("==== Adding a new Wine --> " + wine.getName());
        wine.persist();
    }
}
