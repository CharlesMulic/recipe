package net.cilution.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use underlying persistence framework to generate an id for us
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob // large object storage
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) // deleting recipe will delete notes
    private Notes notes;

    @ManyToMany
    // specify a single table for the relationship, recipe_category
    // specify that we join this object's data on recipe_id
    // specify that we join Category's data on category_id
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @Enumerated(EnumType.STRING)
    // ORDINAL is default, persisted as 1,2,3. String values can work better with enum structure changes
    private Difficulty difficulty;

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }
    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
