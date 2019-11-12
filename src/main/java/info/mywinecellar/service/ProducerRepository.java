package info.mywinecellar.service;

import info.mywinecellar.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProducerRepository extends JpaRepository<Producer, Long> {
}
