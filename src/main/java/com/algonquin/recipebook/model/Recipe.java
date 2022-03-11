package com.algonquin.recipebook.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String recipeDesc;
    private List<Ingredient> ingredients = new ArrayList<>();

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDesc() {
        return recipeDesc;
    }

    public void setRecipeDesc(String recipeDesc) {
        this.recipeDesc = recipeDesc;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient i){
        this.ingredients.add(i);
    }

    public void removeIngredient(Ingredient i){
        this.ingredients.remove(i);
    }
}
