package info.mywinecellar.controller;

import info.mywinecellar.entity.Producer;
import info.mywinecellar.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/producer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/all")
    public List<Producer> producersGet() {
        logger.info("======= Show me Producers ==========");
        return producerService.findAll();
    }

    @PostMapping(value = "/new")
    public void producerSavePost(Producer producer) {
        logger.info("======= Adding a new Producer --> " + producer.getName());
        producerService.save(producer);
    }
}
