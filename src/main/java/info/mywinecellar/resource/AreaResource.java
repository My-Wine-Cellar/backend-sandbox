package info.mywinecellar.resource;

import info.mywinecellar.entity.Area;
import info.mywinecellar.entity.Grape;
import info.mywinecellar.entity.Producer;
import info.mywinecellar.service.AreaService;

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


@Path("/area")
public class AreaResource {

    @Inject
    AreaService areaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{areaId}")
    public Area areaIdGet(@PathParam("areaId") Long areaId) {
        return areaService.findById(areaId);
    }

    @Transactional
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{areaId}/edit")
    public void areaPut(@Valid Area area, @PathParam("areaId") Long areaId) {
        areaService.update(area, areaId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{areaId}/grapes")
    public List<Grape> areaGrapesGet(@PathParam("areaId") Long areaId) {
        Area area = areaService.findById(areaId);
        return area.primaryGrapes;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{areaId}/producers")
    public List<Producer> areaProducersGet(@PathParam("areaId") Long areaId) {
        Area area = areaService.findById(areaId);
        return area.getProducers();
    }
}
