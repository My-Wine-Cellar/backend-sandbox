package info.mywinecellar.service;

import info.mywinecellar.entity.Country;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CountryService extends AbstractService {

    /**
     * Every single Country
     *
     * @return countries
     */
    public List<Country> listAll() {
        List<Country> countries = Country.listAll();
        checkObjectListNull(countries);
        log.info("==== Show me all countries ===");
        return countries;
    }

    /**
     * Country with wine producing regions
     *
     * @return countries
     */
    public List<Country> listWithRegions() {
        List<Country> countries = Country.list("SELECT DISTINCT country FROM Country AS country " +
                "JOIN country.regions AS region", Sort.by("country.name"));
        checkObjectListNull(countries);
        log.info("==== Wine producing countries -> " + countries);
        return countries;
    }

    /**
     * Update a Country entity
     *
     * @param countryUpdate Country entity to be updated
     * @param country       Country entity
     */
    public void update(Country countryUpdate, Country country) {
        checkObjectNull(countryUpdate);
        countryUpdate.description = country.description;
        countryUpdate.weblink = country.weblink;
        log.info("==== Updating country -> " + countryUpdate.name);

        // Reference: https://quarkus.io/guides/hibernate-orm-panache
        // note that once persisted, you don't need to explicitly save your entity: all
        // modifications are automatically persisted on transaction commit.

        //countryUpdate.persist();
    }

    /**
     * @param id id
     * @return country
     */
    public Country findById(Long id) {
        Country country = Country.findById(id);
        checkObjectNull(country);
        log.info("==== Country Id -> " + country.id);
        return country;
    }

}
