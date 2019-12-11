package info.mywinecellar.entity;

import info.mywinecellar.sorter.WineSorter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
public class Producer extends BaseEntity implements Comparable<Producer> {

    public Producer() {
        super();
    }

    public Producer(String name, String description, String phone, String fax, String email, String website) {
        super();
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
    }

    @NotNull
    @NotEmpty(message = "You must at least provide the name")
    @Column(name = "name")
    public String name;

    @Column(name = "description", length = 8192)
    public String description;

    @Column(name = "phone")
    public String phone;

    @Column(name = "fax")
    public String fax;

    @Column(name = "email")
    public String email;

    @Column(name = "website")
    public String website;

    @ManyToMany(mappedBy = "producers")
    public List<Area> areas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producer")
    public List<Wine> wines;

    public List<Wine> getWines() {
        Collections.sort(wines, new WineSorter());
        return wines;
    }

    @Override
    public int compareTo(Producer p) {
        return name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return "Producer(" + id + ")";
    }

}
