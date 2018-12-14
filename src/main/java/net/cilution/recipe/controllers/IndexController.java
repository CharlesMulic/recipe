package net.cilution.recipe.controllers;

import net.cilution.recipe.domain.Recipe;
import net.cilution.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        Set<Recipe> recipes = recipeService.getRecipes();
        System.out.println(recipes.size());
        model.addAttribute("recipes", recipes);

        return "index";
    }
}
