package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Maceration extends PanacheEntity implements Comparable<Maceration> {

    public Maceration(Byte days, Float temperature) {
        this.days = days;
        this.temperature = temperature;
    }

    @NotNull
    @Column(name = "days")
    private Byte days;

    @Column(name = "temperature")
    private Float temperature;

    @OneToMany(mappedBy = "maceration")
    private List<GrapeComponent> grapes;

    @Override
    public int compareTo(Maceration m) {
        int result = days.compareTo(m.days);

        if (result == 0)
            return temperature.compareTo(m.temperature);

        return result;
    }

    @Override
    public String toString() {
        return "Maceration(" + id + ")";
    }
}
