package info.mywinecellar.service;

import info.mywinecellar.entity.Producer;

import java.util.List;

public interface ProducerService {

    List<Producer> findAll();

    void save(Producer producer);
}
