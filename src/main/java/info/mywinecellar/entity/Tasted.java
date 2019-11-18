package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tasted extends PanacheEntity implements Comparable<Tasted> {

    public Tasted(User user, Wine wine) {
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    private Wine wine;

    @Override
    public int compareTo(Tasted t) {
        return wine.getName().compareTo(t.wine.getName());
    }

    @Override
    public String toString() {
        return "Tasted(" + id + ")";
    }

    public Wine getWine() {
        return wine;
    }

}
