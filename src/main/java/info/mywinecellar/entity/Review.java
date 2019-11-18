package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Review extends PanacheEntity implements Comparable<Review> {

    public Review(Float stars, String comment, Date date, User user, Wine wine) {
        this.stars = stars;
        this.comment = comment;
        this.date = date;
        this.user = user;
        this.wine = wine;
    }

    @NotNull
    @Column(name = "stars")
    private Float stars;

    @Column(name = "comment", length = 512)
    private String comment;

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
    public int compareTo(Review r) {
        int result;

        if (id.equals(r.id))
            return 0;

        result = stars.compareTo(r.stars);
        if (result != 0)
            return -result;

        return wine.getName().compareTo(r.wine.getName());
    }

    @Override
    public String toString() {
        return "Review(" + id + ")";
    }

    public User getUser() {
        return user;
    }

    public Float getStars() {
        return stars;
    }

    public Wine getWine() {
        return wine;
    }
}
