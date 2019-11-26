package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Wine extends BaseEntity implements Comparable<Wine> {

    public Wine() {}

    public Wine(String name) {
        super();
        this.name = name;
    }

    public Wine(String name, Integer vintage, Float alcohol, Float size,
                Float acid, Float pH, Integer bottleAging, String description, String weblink,
                Producer producer, Closure closure, Shape shape) {
        this.name = name;
        this.vintage = vintage;
        this.alcohol = alcohol;
        this.size = size;
        this.acid = acid;
        this.pH = pH;
        this.bottleAging = bottleAging;
        this.description = description;
        this.weblink = weblink;
        this.producer = producer;
        this.closure = closure;
        this.shape = shape;
    }

    @NotNull
    @NotEmpty
    @Column(name = "name")
    public String name;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    @Column(name = "vintage")
    public Integer vintage;

    @Column(name = "alcohol")
    public Float alcohol;

    @NotNull
    @Column(name = "size")
    public Float size;

    @Column(name = "acid")
    public Float acid;

    @Column(name = "ph")
    public Float pH;

    @Column(name = "bottle_aging")
    public Integer bottleAging;

    @Column(name = "description", length = 8192)
    public String description;

    @Column(name = "weblink")
    public String weblink;

    @Column(name = "subarea")
    public String subarea;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    public Producer producer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine", cascade = CascadeType.REMOVE)
    public List<GrapeComponent> grapes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    public List<Bottle> bottles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    public List<GenericTastingNotes> genericTastingNotes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    public List<Tasted> tasted;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    public List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    public List<Wishlist> wishlists;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closure_id", referencedColumnName = "id")
    public Closure closure;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shape_id", referencedColumnName = "id")
    public Shape shape;

    @Override
    public int compareTo(Wine w) {
        return name.compareTo(w.name);
    }

    @Override
    public String toString() {
        return "Wine(" + id + ")";
    }

}
