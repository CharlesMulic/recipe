package net.cilution.recipe.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // no cascading here, if we delete note don't delete recipe, but cascades from recipe to notes
    private Recipe recipe;

    @Lob // allows JPA to store >255 characters, which is default for String
    private String recipeNotes;

}
