package info.mywinecellar.entity;

import info.mywinecellar.sorter.BottleSorter;
import info.mywinecellar.sorter.GenericTastingNotesSorter;
import info.mywinecellar.sorter.ReviewSorter;
import info.mywinecellar.sorter.TastedSorter;
import info.mywinecellar.sorter.WishlistSorter;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Bottle> bottles;

    @OneToMany(mappedBy = "user")
    private List<GenericTastingNotes> genericTastingNotes;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Tasted> tasted;

    @OneToMany(mappedBy = "user")
    private List<Wishlist> wishlist;

    public List<Bottle> getBottles() {
        Collections.sort(bottles, new BottleSorter());
        return bottles;
    }

    public List<GenericTastingNotes> getGenericTastingNotes() {
        Collections.sort(genericTastingNotes, new GenericTastingNotesSorter());
        return genericTastingNotes;
    }

    public List<Review> getReviews() {
        Collections.sort(reviews, new ReviewSorter());
        return reviews;
    }

    public List<Tasted> getTasted() {
        Collections.sort(tasted, new TastedSorter());
        return tasted;
    }

    public List<Wishlist> getWishlist() {
        Collections.sort(wishlist, new WishlistSorter());
        return wishlist;
    }
}
