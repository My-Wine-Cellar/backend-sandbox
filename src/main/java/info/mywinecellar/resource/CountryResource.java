package info.mywinecellar.resource;

import info.mywinecellar.entity.Country;
import info.mywinecellar.service.CountryService;

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

@Path("/country")
public class CountryResource {

    @Inject
    CountryService countryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Country> countryAllGet() {
        return countryService.listAll();
    }

    @Transactional
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{countryId}/edit")
    public void countryPut(@Valid Country country, @PathParam("countryId") Long countryId) {
        Country countryUpdate = Country.findById(countryId);
        countryService.update(countryUpdate, country);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{countryId}")
    public Country countryIdGet(@PathParam("countryId") Long countryId) {
        return countryService.findById(countryId);
    }

}
