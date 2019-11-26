package info.mywinecellar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
public class Region extends BaseEntity implements Comparable<Region> {

    public Region() {
        super();
    }

    public Region(String name, String description, String weblink, Country country) {
        this.name = name;
        this.description = description;
        this.weblink = weblink;
        this.country = country;
    }

    @NotNull
    @Column(name = "name")
    public String name;

    @Column(name = "description", length = 8192)
    public String description;

    @Column(name = "weblink")
    public String weblink;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country country;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "region_area",
            joinColumns =
            @JoinColumn(name = "region_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "area_id", referencedColumnName = "id")
    )
    public List<Area> areas;

    public List<Area> getAreas() {
        areas.forEach(area -> {
            if (area.name.equals(this.name)) {
                Collections.swap(areas, areas.indexOf(area), 0);
            }
        });
        return areas;
    }

    @Override
    public int compareTo(Region r) {
        return name.compareTo(r.name);
    }

    @Override
    public String toString() {
        return "Region(" + id + ")";
    }

}
