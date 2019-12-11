package info.mywinecellar.entity;

import info.mywinecellar.sorter.BottleSorter;
import info.mywinecellar.sorter.GenericTastingNotesSorter;
import info.mywinecellar.sorter.ReviewSorter;
import info.mywinecellar.sorter.TastedSorter;
import info.mywinecellar.sorter.WishlistSorter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    public User() {
        super();
    }

    @Column(name = "password")
    public String password;

    @Column(name = "username")
    public String username;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email")
    public String email;

    @Column(name = "last_login")
    public Date lastLogin;

    @Column(name = "enabled")
    public boolean enabled;

    @OneToMany(mappedBy = "user")
    public List<Bottle> bottles;

    @OneToMany(mappedBy = "user")
    public List<GenericTastingNotes> genericTastingNotes;

    @OneToMany(mappedBy = "user")
    public List<Review> reviews;

    @OneToMany(mappedBy = "user")
    public List<Tasted> tasted;

    @OneToMany(mappedBy = "user")
    public List<Wishlist> wishlist;

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
