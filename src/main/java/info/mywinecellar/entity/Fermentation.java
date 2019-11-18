package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Fermentation extends PanacheEntity implements Comparable<Fermentation> {

    @NotNull
    @Column(name = "days")
    private Byte days;

    @Column(name = "temperature")
    private Float temperature;

    @OneToMany(mappedBy = "fermentation")
    private List<GrapeComponent> grapes;

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
