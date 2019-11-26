package info.mywinecellar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Bottle extends BaseEntity implements Comparable<Bottle> {

    public Bottle() {
        super();
    }

    public Bottle(Integer number, String location, Boolean show, User user, Wine wine) {
        super();
        this.number = number;
        this.location = location;
        this.show = show;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "number")
    public Integer number;

    @Column(name = "location", length = 512)
    public String location;

    @Column(name = "show")
    public Boolean show;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    public Wine wine;

    @Override
    public int compareTo(Bottle b) {
        return wine.name.compareTo(b.wine.name);
    }

    @Override
    public String toString() {
        return "Bottle(" + id + ")";
    }

}
