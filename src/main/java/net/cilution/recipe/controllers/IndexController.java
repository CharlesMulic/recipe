package net.cilution.recipe.controllers;

import net.cilution.recipe.domain.Category;
import net.cilution.recipe.domain.UnitOfMeasure;
import net.cilution.recipe.repositories.CategoryRepository;
import net.cilution.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> category = categoryRepository.findByDescription("Fast Food");
        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println(category.get().getId());
        System.out.println(unit.get().getId());

        return "index";
    }
}
