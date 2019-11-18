package info.mywinecellar.resource;

import info.mywinecellar.entity.Producer;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/producer")
public class ProducerResource extends AbstractResource {

    @GET
    @Produces(value = APPLICATION_JSON)
    @Path("/all")
    public List<Producer> producersGet() {
        List<Producer> producers = Producer.listAll();
        checkObjectListNull(producers);
        log.info("==== Show me Producers ====");
        return producers;
    }

    @Transactional
    @PUT
    @Consumes(value = APPLICATION_JSON)
    @Path("/new")
    public void producerUpdatePut(Producer producer) {
        checkObjectNull(producer);
        log.info("==== Adding a new Producer --> " + producer.getName());
        producer.persist();
    }
}
