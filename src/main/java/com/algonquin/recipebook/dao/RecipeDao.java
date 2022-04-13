package com.algonquin.recipebook.dao;

import com.algonquin.recipebook.model.Ingredient;
import com.algonquin.recipebook.model.Recipe;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{recipe.getRecipeName(),recipe.getRecipeDescription()});
        return rowsAffected;
    }

    public int insertIngredient(Ingredient ingredient) {
        String sql = "insert into RecipeBook.Ingredients (IngredientName, IngredientDescription) values (?,?)";
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{ingredient.getName(),ingredient.getAmount()});
        return rowsAffected;
    }

    public int insertRecipes(List<Recipe> recipes) {
        System.out.println("At the recipe DAO: " + recipes.toString());
        saveBatch(recipes);
        int rowsAffected = 1;
        return rowsAffected;
    }

    private static class RecipeRowMapper implements RowMapper<Recipe> {

        @Override
        public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Recipe recipe = new Recipe();
            recipe.setRecipeName(rs.getString("RecipeName"));
            recipe.setRecipeDescription(rs.getString("RecipeDescription"));
            recipe.setImagePath(rs.getString("imagePath"));

            return recipe;
        }
    }
    public List<Recipe> getRecipes() {
        String sql = "SELECT * FROM RecipeBook.Recipes";
        List<Recipe> recipes = jdbcTemplate.query(sql,new RecipeRowMapper());
        System.out.println(recipes.get(0).toString());
        return recipes;

    }

    public void saveBatch(final List<Recipe> recipes) {
        final int batchSize = 500;
        List<List<Recipe>> batchLists = Lists.partition(recipes, batchSize);

        for(List<Recipe> batch : batchLists) {
            this.jdbcTemplate.batchUpdate("insert into RecipeBook.Recipes (RecipeName, RecipeDescription,imagePath) values (?,?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i)
                        throws SQLException {
                    Recipe recipe = batch.get(i);
                    ps.setString(1, recipe.getRecipeName());
                    ps.setString(2, recipe.getRecipeDescription());
                    ps.setString(3, recipe.getImagePath());
                }
                @Override
                public int getBatchSize() {
                    return batch.size();
                }
            });
        }
    }
}
