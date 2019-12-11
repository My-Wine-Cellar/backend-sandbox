package info.mywinecellar.entity;

import info.mywinecellar.sorter.ProducerSorter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
public class Area extends BaseEntity implements Comparable<Area> {

    public Area() {
        super();
    }

    public Area(String name, String description, String weblink) {
        super();
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    public String name;

    @Column(name = "description", length = 8192)
    public String description;

    @Column(name = "weblink")
    public String weblink;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "areas")
    public List<Region> regions;

    @ManyToMany(mappedBy = "areas")
    public List<Grape> primaryGrapes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "area_producer",
               joinColumns =
               @JoinColumn(name = "area_id", referencedColumnName = "id"),
               inverseJoinColumns =
               @JoinColumn(name = "producer_id", referencedColumnName = "id")
    )
    public List<Producer> producers;

    public List<Producer> getProducers() {
        Collections.sort(producers, new ProducerSorter());
        return producers;
    }

    @Override
    public int compareTo(Area a) {
        return name.compareTo(a.name);
    }

    @Override
    public String toString() {
        return "Area(" + id + ")";
    }

}
