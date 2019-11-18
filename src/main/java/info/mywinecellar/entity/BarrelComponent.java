package info.mywinecellar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "barrel_component")
public class BarrelComponent extends PanacheEntity implements Comparable<BarrelComponent> {

    private static final String NOT_NULL_MESSAGE = "This field is required";

    public BarrelComponent(Byte percentage, Integer size, Integer aging,
                           GrapeComponent grapeComponent, Barrel barrel) {
        this.percentage = percentage;
        this.size = size;
        this.aging = aging;
        this.grapeComponent = grapeComponent;
        this.barrel = barrel;
    }

    @NotNull(message = NOT_NULL_MESSAGE)
    @Column(name = "percentage")
    private Byte percentage;

    @NotNull(message = NOT_NULL_MESSAGE)
    @Column(name = "size")
    private Integer size;

    @NotNull(message = NOT_NULL_MESSAGE)
    @Column(name = "aging")
    private Integer aging;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "grape_component_id", referencedColumnName = "id")
    private GrapeComponent grapeComponent;

    @NotNull(message = "You need to select a barrel")
    @ManyToOne
    @JoinColumn(name = "barrel_id", referencedColumnName = "id")
    private Barrel barrel;

    @Override
    public int compareTo(BarrelComponent bc) {
        int result = percentage.compareTo(bc.percentage);

        if (result == 0)
            return barrel.getName().compareTo(bc.barrel.getName());

        return result;
    }

    @Override
    public String toString() {
        return "BarrelComponent(" + id + ")";
    }

}
