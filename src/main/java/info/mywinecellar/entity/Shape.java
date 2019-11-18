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
public class Shape extends PanacheEntity implements Comparable<Shape> {

    public Shape(String name, String description, String weblink) {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shape")
    private List<Wine> wines;

    @Override
    public int compareTo(Shape s) {
        return name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return "Shape(" + id + ")";
    }
}
