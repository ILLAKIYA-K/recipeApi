package com.example.recipe;

import com.example.recipe.RecipeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.recipe.Recipe;

import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
        int uniqueId = 6;

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here

        @Override
        public void delRecipe(int recipeId) {
                Recipe d = recipeBook.get(recipeId);
                if (d == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }

        }

        @Override
        public Recipe putRecipe(int recipeId, Recipe re) {
                Recipe s = recipeBook.get(recipeId);
                if (s == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

                if (re.getRecipeName() != null) {
                        s.setRecipeName(re.getRecipeName());

                }

                if (re.getRecipeType() != null) {
                        s.setRecipeType(re.getRecipeType());

                }

                if (re.getIngredients() != null) {
                        s.setIngredients(re.getIngredients());

                }

                return s;
        }

        @Override

        public Recipe getRecipebyId(int recipeId) {
                Recipe s = recipeBook.get(recipeId);
                if (s == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return s;
        }

        @Override
        public Recipe addRecipe(Recipe rec) {
                rec.setRecipeId(uniqueId);
                recipeBook.put(uniqueId, rec);
                uniqueId += 1;
                return rec;
        }

        @Override
        public ArrayList<Recipe> getRecipe() {
                Collection<Recipe> recipeCollection = recipeBook.values();
                ArrayList<Recipe> arr = new ArrayList<>(recipeCollection);
                return arr;
        }
}