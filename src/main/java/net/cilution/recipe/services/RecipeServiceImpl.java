package net.cilution.recipe.services;

import lombok.extern.slf4j.Slf4j;
import net.cilution.recipe.domain.Recipe;
import net.cilution.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> getRecipes() {
        log.debug("Fetching recipes");
        Set<Recipe> list = new HashSet<>();
        recipeRepository.findAll().forEach(list::add);
        return list;
    }
}
