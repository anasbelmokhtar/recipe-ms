package com.algonquin.recipebook.controllers;
import com.algonquin.recipebook.model.Ingredient;
import com.algonquin.recipebook.model.Recipe;
import com.algonquin.recipebook.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecipeBookController {

    @Autowired
    RecipeService recipeService;

    public RecipeBookController(){

    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/recipe-book/recipes")
    public List<Recipe> getRecipes(@RequestParam String username){
        System.out.println("Username is "+username);
        return recipeService.getRecipes(username);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/recipe-book/insert-recipe")
    public int insertRecipe(@RequestBody Recipe recipe){
        return recipeService.insertRecipe(recipe);
    }

   // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/recipe-book/insert-ingredient")
    public int insertIngredient(@RequestBody Ingredient ingredient) {
        return recipeService.insertIngredient(ingredient);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/recipe-book/insert-recipes")
    public int insertRecipes(@RequestBody List<Recipe> recipes){
        System.out.println("At the recipe controller: " + recipes.toString());
        return recipeService.insertRecipes(recipes);
    }

}
