package info.mywinecellar.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tasted extends BaseEntity implements Comparable<Tasted> {

    public Tasted() {
        super();
    }

    public Tasted(User user, Wine wine) {
        super();
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    public Wine wine;

    @Override
    public int compareTo(Tasted t) {
        return wine.name.compareTo(t.wine.name);
    }

    @Override
    public String toString() {
        return "Tasted(" + id + ")";
    }

}
