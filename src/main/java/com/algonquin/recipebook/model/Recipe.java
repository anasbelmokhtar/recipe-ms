package com.algonquin.recipebook.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "recipeName",
        "recipeDescription",
        "imagePath",
        "ingredients"
})
@Generated("jsonschema2pojo")
public class Recipe {

    @JsonProperty("recipeName")
    private String recipeName;
    @JsonProperty("recipeDescription")
    private String recipeDescription;
    @JsonProperty("imagePath")
    private String imagePath;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients = null;

    @JsonProperty("recipeName")
    public String getRecipeName() {
        return recipeName;
    }

    @JsonProperty("recipeName")
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @JsonProperty("recipeDescription")
    public String getRecipeDescription() {
        return recipeDescription;
    }

    @JsonProperty("recipeDescription")
    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    @JsonProperty("imagePath")
    public String getImagePath() {
        return imagePath;
    }

    @JsonProperty("imagePath")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @JsonProperty("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
