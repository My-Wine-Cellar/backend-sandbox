package info.mywinecellar.sorter;

import info.mywinecellar.entity.Bottle;

import java.util.Comparator;

/**
 * Sorter for Bottle entities
 */
public class BottleSorter implements Comparator<Bottle> {

    private WineSorter wineSorter;

    public BottleSorter() {
        this(false);
    }

    public BottleSorter(boolean country) {
        wineSorter = new WineSorter(country);
    }

    public int compare(Bottle b1, Bottle b2) {
        int result;

        if (b1.id.equals(b2.id))
            return 0;

        return wineSorter.compare(b1.wine, b2.wine);
    }
}

