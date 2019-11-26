package info.mywinecellar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Review extends BaseEntity implements Comparable<Review> {

    public Review() {
        super();
    }

    public Review(Float stars, String comment, Date date, User user, Wine wine) {
        super();
        this.stars = stars;
        this.comment = comment;
        this.date = date;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "stars")
    public Float stars;

    @Column(name = "comment", length = 512)
    public String comment;

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
    public int compareTo(Review r) {
        int result;

        if (id.equals(r.id))
            return 0;

        result = stars.compareTo(r.stars);
        if (result != 0)
            return -result;

        return wine.name.compareTo(r.wine.name);
    }

    @Override
    public String toString() {
        return "Review(" + id + ")";
    }

}
