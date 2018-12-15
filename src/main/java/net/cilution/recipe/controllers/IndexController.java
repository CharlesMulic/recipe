package net.cilution.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import net.cilution.recipe.domain.Recipe;
import net.cilution.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        Set<Recipe> recipes = recipeService.getRecipes();
        System.out.println(recipes.size());
        model.addAttribute("recipes", recipes);

        return "index";
    }
}
