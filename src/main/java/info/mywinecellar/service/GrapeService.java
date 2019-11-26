package info.mywinecellar.service;

import info.mywinecellar.entity.Grape;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GrapeService extends AbstractService {

    /**
     * @return grapes
     */
    public List<Grape> listAll() {
        List<Grape> grapes = Grape.listAll();
        checkObjectListNull(grapes);
        log.info("==== Show me all grapes ====");
        return grapes;
    }

    /**
     * @return grapes
     */
    public List<Grape> listRedGrapes() {
        List<Grape> grapes = Grape.list("color = 'Red'", Sort.by("name"));
        checkObjectListNull(grapes);
        log.info("==== Show me red grapes ====");
        return grapes;
    }

    /**
     * @return grapes
     */
    public List<Grape> listWhiteGrapes() {
        List<Grape> grapes = Grape.list("color = 'White'", Sort.by("name"));
        checkObjectListNull(grapes);
        log.info("==== Show me white grapes ====");
        return grapes;
    }

    /**
     * Update a Grape entity
     *
     * @param grapeUpdate grapeUpdate
     * @param grape       grape
     */
    public void update(Grape grapeUpdate, Grape grape) {
        checkObjectNull(grapeUpdate);
        grapeUpdate.weblink = grape.weblink;
        grapeUpdate.description = grape.description;
        log.info("==== Updating grape -> " + grapeUpdate.name);
    }

    /**
     * @param id grapeId
     * @return grape
     */
    public Grape findById(Long id) {
        Grape grape = Grape.findById(id);
        checkObjectNull(grape);
        log.info("==== Grape Id -> " + grape.id);
        return grape;
    }
}
