package com.genfood.foodgenback.integration;

import static com.genfood.foodgenback.utils.RecipeUtils.RECIPE1_ID;
import static com.genfood.foodgenback.utils.RecipeUtils.recipe1;
import static com.genfood.foodgenback.utils.RecipeUtils.recipe2;
import static com.genfood.foodgenback.utils.RecipeUtils.recipeIngredients1;
import static com.genfood.foodgenback.utils.RecipeUtils.updatedRecipe3;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.RecipeController;
import com.genfood.foodgenback.endpoint.rest.mapper.RecipeIngredientMapper;
import com.genfood.foodgenback.endpoint.rest.mapper.RecipeMapper;
import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import com.genfood.foodgenback.endpoint.rest.model.RecipeIngredients;
import com.genfood.foodgenback.repository.RecipeIngredientRepository;
import com.genfood.foodgenback.repository.RecipeRepository;
import com.genfood.foodgenback.repository.validator.RecipeValidator;
import com.genfood.foodgenback.service.RecipeIngredientService;
import com.genfood.foodgenback.service.RecipeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@Slf4j
public class RecipeIT extends FacadeIT {

  public static final int PAGE = 0;
  public static final int PAGE_SIZE = 10;

  RecipeController recipeController;
  RecipeService recipeService;
  RecipeIngredientService recipeIngredientService;

  @Autowired RecipeMapper recipeMapper;
  @Autowired RecipeIngredientMapper recipeIngredientMapper;

  @Autowired RecipeValidator recipeValidator;

  @Autowired RecipeRepository recipeRepository;
  @Autowired RecipeIngredientRepository recipeIngredientRepository;

  @BeforeEach
  void setUp() {
    recipeService =
        new RecipeService(recipeRepository, recipeValidator, recipeIngredientRepository);
    recipeIngredientService = new RecipeIngredientService(recipeIngredientRepository);
    recipeController =
        new RecipeController(
            recipeService, recipeMapper, recipeIngredientMapper, recipeIngredientService);
  }

  @Test
  void read_recipes() {
    List<Recipe> actual = recipeController.getRecipes(PAGE, PAGE_SIZE);
    Assertions.assertTrue(actual.contains(recipe1()));
    Assertions.assertTrue(actual.contains(recipe2()));
    Assertions.assertEquals(9, actual.size());
  }

  @Test
  void read_recipe_by_id() {
    RecipeIngredients actual = recipeController.getRecipeById(RECIPE1_ID);
    Assertions.assertEquals(recipeIngredients1(), actual);
  }

  @Test
  void crupdate_recipes() {
    recipeController.crupdateRecipes(List.of(updatedRecipe3()));
    List<Recipe> actual = recipeController.getRecipes(PAGE, PAGE_SIZE);
    Assertions.assertTrue(actual.contains(updatedRecipe3()));
  }
}
