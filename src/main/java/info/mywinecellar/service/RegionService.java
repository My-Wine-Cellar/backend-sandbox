package info.mywinecellar.service;

import info.mywinecellar.entity.Region;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegionService extends AbstractService {

    /**
     * @param region   region
     * @param regionId regionId
     */
    public void update(Region region, Long regionId) {
        Region regionUpdate = findById(regionId);
        checkObjectNull(regionUpdate);
        regionUpdate.description = region.description;
        regionUpdate.weblink = region.weblink;
        log.info("==== Updating region -> " + regionUpdate.name);
    }

    /**
     * @param id id
     * @return region
     */
    public Region findById(Long id) {
        Region region = Region.findById(id);
        checkObjectNull(region);
        log.info("==== Region Id -> " + region.id);
        return region;
    }
}
