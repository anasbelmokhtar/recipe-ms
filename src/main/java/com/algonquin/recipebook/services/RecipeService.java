package com.algonquin.recipebook.services;

import com.algonquin.recipebook.dao.RecipeDao;
import com.algonquin.recipebook.model.Ingredient;
import com.algonquin.recipebook.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeDao recipeDao;

    public List<Recipe> getRecipes(String username){
        return recipeDao.getRecipes(username);
    }

    public int insertRecipe(Recipe recipe) {
        return recipeDao.insertRecipe(recipe);
    }
    public int insertIngredient(Ingredient ingredient){
        return recipeDao.insertIngredient(ingredient);
    }

    public int insertRecipes(List<Recipe> recipes) {
        System.out.println("At the recipe service: " + recipes.toString());
        return recipeDao.insertRecipes(recipes);
    }
}
