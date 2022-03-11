package com.algonquin.recipebook.controllers;
import com.algonquin.recipebook.model.Ingredient;
import com.algonquin.recipebook.model.Recipe;
import com.algonquin.recipebook.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class RecipeBookController {

    @Autowired
    RecipeService recipeService;

    public RecipeBookController(){

    }

    @PostMapping("/recipe-book/recipes")
    public List<Recipe> getRecipes(){
        return recipeService.getRecipes();
    }
    @PostMapping("/recipe-book/insert-recipe")
    public int insertRecipe(@RequestBody Recipe recipe){
        return recipeService.insertRecipe(recipe);
    }
    @PostMapping("/recipe-book/insert-ingredient")
    public int insertIngredient(@RequestBody Ingredient ingredient) {
        return recipeService.insertIngredient(ingredient);
    }

}
