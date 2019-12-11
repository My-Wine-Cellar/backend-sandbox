package info.mywinecellar.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Barrel extends BaseEntity implements Comparable<Barrel> {

    public Barrel() {
        super();
    }

    public Barrel(String name, String description, String weblink) {
        super();
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    public String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", length = 8192)
    public String description;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "weblink")
    public String weblink;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barrel")
    public List<BarrelComponent> barrelComponents;

    @Override
    public int compareTo(Barrel b) {
        return name.compareTo(b.name);
    }

    @Override
    public String toString() {
        return "Barrel(" + id + ")";
    }

}
