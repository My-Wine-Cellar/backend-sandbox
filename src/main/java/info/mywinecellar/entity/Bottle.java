package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Bottle extends PanacheEntity implements Comparable<Bottle> {

    public Bottle(Integer number, String location, Boolean show, User user, Wine wine) {
        this.number = number;
        this.location = location;
        this.show = show;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "number")
    private Integer number;

    @Column(name = "location", length = 512)
    private String location;

    @Column(name = "show")
    private Boolean show;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    private Wine wine;

    @Override
    public int compareTo(Bottle b) {
        return wine.getName().compareTo(b.wine.getName());
    }

    @Override
    public String toString() {
        return "Bottle(" + id + ")";
    }

    public Wine getWine() {
        return wine;
    }

}
