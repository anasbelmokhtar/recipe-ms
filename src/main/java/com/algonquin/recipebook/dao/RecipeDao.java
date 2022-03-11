package com.algonquin.recipebook.dao;

import com.algonquin.recipebook.model.Ingredient;
import com.algonquin.recipebook.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("recipe")
public class RecipeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipeDao(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    public int insertRecipe(Recipe recipe) {
        String sql = "insert into RecipeBook.Recipes (RecipeName, RecipeDescription) values (?,?)";
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{recipe.getRecipeName(),recipe.getRecipeDesc()});
        return rowsAffected;
    }

    public int insertIngredient(Ingredient ingredient) {
        String sql = "insert into RecipeBook.Ingredients (IngredientName, IngredientDescription) values (?,?)";
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{ingredient.getIngredientName(),ingredient.getIngredientDesc()});
        return rowsAffected;
    }

    private static class RecipeRowMapper implements RowMapper<Recipe> {

        @Override
        public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Recipe recipe = new Recipe();
            recipe.setRecipeName(rs.getString("RecipeName"));
            recipe.setRecipeDesc(rs.getString("RecipeDescription"));

            return recipe;
        }
    }
    public List<Recipe> getRecipes() {
        String sql = "SELECT * FROM RecipeBook.Recipes";
        List<Recipe> recipes = jdbcTemplate.query(sql,new RecipeRowMapper());
        return recipes;

    }
}
