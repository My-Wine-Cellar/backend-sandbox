package info.mywinecellar.entity;

import info.mywinecellar.sorter.WineSorter;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

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
public class Producer extends PanacheEntity implements Comparable<Producer> {

    public Producer() {}

    public Producer(String name, String description, String phone, String fax, String email, String website) {
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
    private String name;

    @Column(name = "description", length = 8192)
    private String description;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @ManyToMany(mappedBy = "producers")
    private List<Area> areas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producer")
    private List<Wine> wines;

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

    public String getName() {
        return name;
    }

    public List<Area> getAreas() {
        return areas;
    }
}
