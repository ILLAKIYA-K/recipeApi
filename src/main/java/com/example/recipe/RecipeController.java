/*
 * 
 * You can use the following import statements
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.recipe;

import com.example.recipe.RecipeService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RecipeController {

    RecipeService service = new RecipeService();

    @PutMapping("/recipes/{recipeId}")
    public Recipe putRecipe(@PathVariable("recipeId") int recipeId, @RequestBody Recipe re) {
        return service.putRecipe(recipeId, re);
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe rec) {
        return service.addRecipe(rec);
    }

    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipe() {
        return service.getRecipe();
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipebyId(@PathVariable("recipeId") int recipeId) {
        return service.getRecipebyId(recipeId);
    }

    @DeleteMapping("recipes/{recipeId}")

    public void delRecipe(@PathVariable("recipeId") int recipeId) {
        service.delRecipe(recipeId);
    }
}