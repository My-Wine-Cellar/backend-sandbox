package info.mywinecellar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Country extends BaseEntity implements Comparable<Country> {

    public Country() {
        super();
    }

    public Country(String name, String flag, String description, String weblink) {
        super();
        this.name = name;
        this.flag = flag;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    public String name;

    @Column(name = "flag")
    public String flag;

    @Column(name = "description", length = 8192)
    public String description;

    @Column(name = "weblink")
    public String weblink;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    public List<Region> regions;

    @Override
    public int compareTo(Country c) {
        return name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return "Country(" + id + ")";
    }

}
