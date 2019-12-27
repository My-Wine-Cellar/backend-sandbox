package info.mywinecellar.resource;

import info.mywinecellar.entity.Country;
import info.mywinecellar.service.CountryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/d")
public class RootResource {

    @Inject
    CountryService countryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Country> countryGet() {
        return countryService.listWithRegions();
    }
}
