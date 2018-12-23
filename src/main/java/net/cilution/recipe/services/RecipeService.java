package net.cilution.recipe.services;

import net.cilution.recipe.commands.RecipeCommand;
import net.cilution.recipe.domain.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    @Transactional
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
