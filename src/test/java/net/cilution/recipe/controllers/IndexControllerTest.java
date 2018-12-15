package net.cilution.recipe.controllers;

import net.cilution.recipe.domain.Recipe;
import net.cilution.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPageReturnsExpectedViewName() {
        String expected = "index";
        String actual = indexController.getIndexPage(model);
        assertEquals(expected, actual);
    }

    @Test
    public void recipesGetAddedToModelWhenGettingIndexPage() {
        indexController.getIndexPage(model);
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());

//        HashSet<Recipe> recipes = new HashSet<>();
//        when(recipeService.getRecipes()).thenReturn(recipes);
//        indexController.getIndexPage(model);
//        verify(model, times(1)).addAttribute("recipes", recipes);
    }

    @Test
    public void getRecipesGetsCalledOnceWhenGettingIndexPage() {
        indexController.getIndexPage(model);
        verify(recipeService, times(1)).getRecipes();
    }

    @Test
    public void testAllRecipesGetReturned() {
        // given
        HashSet<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipes.add(recipe1);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // when
        indexController.getIndexPage(model);

        // then
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());

    }
}