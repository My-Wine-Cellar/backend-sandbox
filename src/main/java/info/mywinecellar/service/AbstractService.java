package info.mywinecellar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

abstract class AbstractService {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Checks to see if Object passed in is null
     *
     * @param o Object
     * @throws WebApplicationException Response.Status.NOT_FOUND
     */
    void checkObjectNull(Object o) throws WebApplicationException {
        if (o == null) {
            log.info("==== This object is null ====");
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    /**
     * Checks to see if List<?>Object</?> is null
     *
     * @param list Object
     * @throws WebApplicationException Response.Status.NOT_FOUND
     */
    void checkObjectListNull(List<?> list) throws WebApplicationException {
        if (list.isEmpty()) {
            log.info("==== This list of objects is null ====");
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}
