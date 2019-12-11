package info.mywinecellar.resource;

import info.mywinecellar.entity.Producer;
import info.mywinecellar.service.ProducerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/producer")
public class ProducerResource {

    @Inject
    ProducerService producerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Producer> producerAllGet() {
        return producerService.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public void producerPost(Producer producer) {
        producerService.persist(producer);
    }
}
