package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Barrel extends PanacheEntity implements Comparable<Barrel> {

    public Barrel(String name, String description, String weblink) {
        super();
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", length = 8192)
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "weblink")
    private String weblink;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barrel")
    private List<BarrelComponent> barrelComponents;

    @Override
    public int compareTo(Barrel b) {
        return name.compareTo(b.name);
    }

    @Override
    public String toString() {
        return "Barrel(" + id + ")";
    }

    public String getName() {
        return name;
    }
}
