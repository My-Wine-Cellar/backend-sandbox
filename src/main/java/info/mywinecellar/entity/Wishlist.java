package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Wishlist extends PanacheEntity implements Comparable<Wishlist> {

    public Wishlist(Date date, User user, Wine wine) {
        super();
        this.date = date;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    private Wine wine;

    @Override
    public int compareTo(Wishlist w) {
        return wine.getName().compareTo(w.wine.getName());
    }

    @Override
    public String toString() {
        return "Wishlist(" + id + ")";
    }

    public Wine getWine() {
        return wine;
    }

}
