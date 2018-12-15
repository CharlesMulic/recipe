package net.cilution.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER) // default behavior, showing intent / how to do this
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit, Recipe recipe) {
        this.setDescription(description);
        this.setAmount(amount);
        this.setUom(unit);
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit) {
        this.setDescription(description);
        this.setAmount(amount);
        this.setUom(unit);
        this.setRecipe(recipe);
    }

}
