package info.mywinecellar.service;

import info.mywinecellar.entity.Wine;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class WineService extends AbstractService implements PanacheRepository<Wine> {

    /**
     * Check for null and then save Wine
     * @param wine Wine entity
     */
    public void persist(Wine wine) {
        checkObjectNull(wine);
        log.info("==== Adding a new Wine --> " + wine.name);
        wine.persist();
    }

    /**
     * Check for null and then list Wine's
     * @return all Wine's
     */
    public List<Wine> listAll() {
        List<Wine> wines = Wine.listAll();
        checkObjectListNull(wines);
        log.info("==== Show me Wines ====");
        return wines;
    }

}
