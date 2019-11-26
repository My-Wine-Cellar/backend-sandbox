package info.mywinecellar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Fermentation extends BaseEntity implements Comparable<Fermentation> {

    public Fermentation() {
        super();
    }

    @NotNull
    @Column(name = "days")
    public Byte days;

    @Column(name = "temperature")
    public Float temperature;

    @OneToMany(mappedBy = "fermentation")
    public List<GrapeComponent> grapes;

    @Override
    public int compareTo(Fermentation m) {
        int result = days.compareTo(m.days);

        if (result == 0)
            return temperature.compareTo(m.temperature);

        return result;
    }

    @Override
    public String toString() {
        return "Fermentation(" + id + ")";
    }

}
