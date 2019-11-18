package info.mywinecellar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Country extends PanacheEntity implements Comparable<Country> {

    public Country(String name, String flag, String description, String weblink) {
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "flag")
    private String flag;

    @Column(name = "description", length = 8192)
    private String description;

    @Column(name = "weblink")
    private String weblink;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Region> regions;

    @Override
    public int compareTo(Country c) {
        return name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return "Country(" + id + ")";
    }

}
