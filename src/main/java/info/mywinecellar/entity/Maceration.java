package info.mywinecellar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Maceration extends BaseEntity implements Comparable<Maceration> {

    public Maceration() {
        super();
    }

    public Maceration(Byte days, Float temperature) {
        super();
        this.days = days;
        this.temperature = temperature;
    }

    @NotNull
    @Column(name = "days")
    public Byte days;

    @Column(name = "temperature")
    public Float temperature;

    @OneToMany(mappedBy = "maceration")
    public List<GrapeComponent> grapes;

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
