package info.mywinecellar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Grape extends PanacheEntity implements Comparable<Grape> {

    public Grape(String name, String color, String description, String weblink) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "color")
    private String color;

    @Column(name = "description", length = 8192)
    private String description;

    @Column(name = "weblink")
    private String weblink;

    @JsonIgnore
    @OneToMany
    private List<Grape> alternativeNames;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "grape_area",
            joinColumns =
            @JoinColumn(name = "grape_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "area_id", referencedColumnName = "id")
    )
    private List<Area> areas;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grape")
    private List<GrapeComponent> grapeComponents;

    @Override
    public int compareTo(Grape g) {
        return name.compareTo(g.name);
    }

    @Override
    public String toString() {
        return "Grape(" + id + ")";
    }

    public String getName() {
        return name;
    }
}
