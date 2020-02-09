package info.mywinecellar.service;

import info.mywinecellar.entity.Area;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AreaService extends AbstractService {

    /**
     * Find Area by Id
     *
     * @param id id
     * @return area
     */
    public Area findById(Long id) {
        Area area = Area.findById(id);
        checkObjectNull(area);
        log.info("==== Area Id -> " + area.id);
        return area;
    }

    /**
     * Update Area entity
     *
     * @param area   area
     * @param areaId areaId
     */
    public void update(Area area, Long areaId) {
        Area areaUpdate = findById(areaId);
        checkObjectNull(areaUpdate);
        areaUpdate.description = area.description;
        areaUpdate.weblink = area.weblink;
        log.info("==== Updating area -> " + areaUpdate.name);
    }
}
