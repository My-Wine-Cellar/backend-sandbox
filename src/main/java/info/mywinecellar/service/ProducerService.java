package info.mywinecellar.service;

import info.mywinecellar.entity.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProducerService extends AbstractService {

    public void persist(Producer producer) {
        checkObjectNull(producer);
        log.info("==== Adding a new Producer --> " + producer.name);
        producer.persist();
    }

    public List<Producer> listAll() {
        List<Producer> producers = Producer.listAll();
        checkObjectListNull(producers);
        log.info("==== Show me Producers ====");
        return producers;
    }

    public Producer findById(Long id) {
        Producer producer = Producer.findById(id);
        checkObjectNull(producer);
        log.info("==== Producer Id -> " + producer.id);
        return producer;
    }
}
