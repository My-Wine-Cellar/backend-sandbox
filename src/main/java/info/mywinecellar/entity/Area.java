package info.mywinecellar.entity;

import info.mywinecellar.sorter.ProducerSorter;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

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
public class Area extends PanacheEntity implements Comparable<Area> {

    public Area(String name, String description, String weblink) {
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 8192)
    private String description;

    @Column(name = "weblink")
    private String weblink;

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
    private List<Producer> producers;

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

    public String getName() {
        return name;
    }

    public List<Region> getRegions() {
        return regions;
    }
}
