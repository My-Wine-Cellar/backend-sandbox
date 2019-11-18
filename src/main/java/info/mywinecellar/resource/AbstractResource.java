package info.mywinecellar.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

class AbstractResource {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    static final String APPLICATION_JSON = "application/json";

    // should these return ResponseEntity???
    // and moved to service layer if we add
    void checkObjectNull(Object o) {
        if (o == null) {
            log.info("==== This object is null ====");
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
    }

    void checkObjectListNull(List<?> list) {
        if (list.isEmpty()) {
            log.info("==== This list of objects is null ====");
            throw new WebApplicationException(Response.Status.NO_CONTENT);
        }
    }
}
