package info.mywinecellar.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Shape extends BaseEntity implements Comparable<Shape> {

    public Shape() {
        super();
    }

    public Shape(String name, String description, String weblink) {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shape")
    public List<Wine> wines;

    @Override
    public int compareTo(Shape s) {
        return name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return "Shape(" + id + ")";
    }
}
