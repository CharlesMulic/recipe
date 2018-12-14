package net.cilution.recipe.services;

import net.cilution.recipe.domain.Recipe;
import java.util.List;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
