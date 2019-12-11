package info.mywinecellar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Wishlist extends BaseEntity implements Comparable<Wishlist> {

    public Wishlist() {
        super();
    }

    public Wishlist(Date date, User user, Wine wine) {
        super();
        this.date = date;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "date")
    public Date date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    public Wine wine;

    @Override
    public int compareTo(Wishlist w) {
        return wine.name.compareTo(w.wine.name);
    }

    @Override
    public String toString() {
        return "Wishlist(" + id + ")";
    }

}
