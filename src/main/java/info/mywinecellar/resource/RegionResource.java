package info.mywinecellar.resource;

import info.mywinecellar.entity.Area;
import info.mywinecellar.entity.Region;
import info.mywinecellar.service.RegionService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/region")
public class RegionResource {

    @Inject
    RegionService regionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{regionId}")
    public Region regionIdGet(@PathParam("regionId") Long regionId) {
        return regionService.findById(regionId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{regionId}/areas")
    public List<Area> regionAreasGet(@PathParam("regionId") Long regionId) {
        Region region = regionService.findById(regionId);
        return region.areas;
    }

    @Transactional
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{regionId}/edit")
    public void regionPut(@Valid Region region, @PathParam("regionId") Long regionId) {
        regionService.update(region, regionId);
    }


}
