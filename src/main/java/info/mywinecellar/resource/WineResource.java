package info.mywinecellar.resource;

import info.mywinecellar.entity.Wine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/wine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WineResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GET
    @Path("/all")
    public List<Wine> wineListAll() {
        logger.info("======== Show me Wines =========");
        return Wine.listAll();
    }

    @Transactional
    @POST
    @Path("/new")
    public void wineNewPost(Wine wine) {
        logger.info("======= Adding a new Wine --> " + wine.getName());
        wine.persist();
    }
}
