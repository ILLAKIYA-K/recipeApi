// Write your code here
package com.example.recipe;

import java.util.*;

public interface RecipeRepository {
    ArrayList<Recipe> getRecipe();

    Recipe addRecipe(Recipe rec);

    Recipe getRecipebyId(int recipeId);

    Recipe putRecipe(int recipeId, Recipe re);

    void delRecipe(int recipeId);
}