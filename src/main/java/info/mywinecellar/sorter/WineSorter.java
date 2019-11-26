package info.mywinecellar.sorter;

import info.mywinecellar.entity.Area;
import info.mywinecellar.entity.Country;
import info.mywinecellar.entity.Region;
import info.mywinecellar.entity.Wine;

import java.util.Comparator;

/**
 * Sorter for Wine entities
 */
public class WineSorter implements Comparator<Wine> {
    private boolean country;

    public WineSorter() {
        this(false);
    }

    public WineSorter(boolean country) {
        this.country = country;
    }

    public int compare(Wine w1, Wine w2) {
        int result;

        if (w1.id.equals(w2.id))
            return 0;

        if (country) {
            Area a1 = w1.producer.areas.get(0);
            Region r1 = a1.regions.get(0);
            Country c1 = r1.country;

            Area a2 = w2.producer.areas.get(0);
            Region r2 = a2.regions.get(0);
            Country c2 = r2.country;

            result = c1.compareTo(c2);
            if (result != 0)
                return result;

            result = r1.compareTo(r2);
            if (result != 0)
                return result;

            result = a1.compareTo(a2);
            if (result != 0)
                return result;
        }

        result = w1.producer.compareTo(w2.producer);
        if (result != 0)
            return result;

        result = w1.name.compareTo(w2.name);
        if (result != 0)
            return result;

        result = w1.vintage.compareTo(w2.vintage);
        if (result != 0)
            return result;

        result = w1.size.compareTo(w2.size);
        if (result != 0)
            return result;

        return 0;
    }
}

