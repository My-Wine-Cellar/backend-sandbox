/*
 * My-Wine-Cellar, copyright 2019
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.sorter;

import info.mywinecellar.entity.Tasted;

import java.util.Comparator;

/**
 * Sorter for Tasted entities
 */
public class TastedSorter implements Comparator<Tasted> {
    private WineSorter wineSorter;

    public TastedSorter() {
        this(false);
    }

    public TastedSorter(boolean country) {
        wineSorter = new WineSorter(country);
    }

    public int compare(Tasted t1, Tasted t2) {
        if (t1.id.equals(t2.id))
            return 0;

        return wineSorter.compare(t1.wine, t2.wine);
    }
}

