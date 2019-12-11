package info.mywinecellar.sorter;

import info.mywinecellar.entity.Producer;

import java.util.Comparator;

/**
 * Sorter for Producer entities
 */
public class ProducerSorter implements Comparator<Producer> {

    public ProducerSorter() {
    }

    public int compare(Producer p1, Producer p2) {

        if (p1.id.equals(p2.id))
            return 0;

        return p1.name.compareTo(p2.name);
    }
}

