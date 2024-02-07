package com.genfood.foodgenback.integration;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.MealController;
import com.genfood.foodgenback.endpoint.controller.UserController;
import com.genfood.foodgenback.endpoint.rest.mapper.MealMapper;
import com.genfood.foodgenback.endpoint.rest.mapper.RecipeIngredientMapper;
import com.genfood.foodgenback.endpoint.rest.mapper.UserMapper;
import com.genfood.foodgenback.endpoint.rest.model.Meal;
import com.genfood.foodgenback.repository.AllergyRepository;
import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.repository.validator.MailValidator;
import com.genfood.foodgenback.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.genfood.foodgenback.utils.MealUtils.*;
import static com.genfood.foodgenback.utils.UserUtils.signUp4;

@Testcontainers
@Slf4j
public class MealIT extends FacadeIT {
  public static final int PAGE = 0;
  public static final int PAGE_SIZE = 5;
  MealController mealController;
  UserController userController;
  MealService mealService;
  RecipeIngredientService recipeIngredientService;
  AuthService authService;
  AllergyService allergyService;
  UserService userService;
  UserDetailsServiceImpl userDetailsService;

  MockHttpServletRequest request;

  @Autowired MealMapper mealMapper;
  @Autowired
  AllergyRepository allergyRepository;
  @Autowired
  UserMapper userMapper;
  @Autowired MealRepository mealRepository;
  @Autowired RecipeIngredientMapper recipeIngredientMapper;
  @Autowired
  UserRepository userRepository;
  @Autowired
  MailValidator mailValidator;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired JWTService jwtService;

  @BeforeEach
  void setUp() {
    allergyService = new AllergyService(allergyRepository,userRepository);
    userService = new UserService(userRepository, mailValidator);
    userDetailsService = new UserDetailsServiceImpl(userService);
    authService = new AuthService(userService, userDetailsService, jwtService, passwordEncoder);
    userController = new UserController(userMapper, userService, authService);
    mealService = new MealService(mealRepository, recipeIngredientService, authService, allergyService, recipeIngredientMapper);
    mealController = new MealController(mealService, mealMapper);
  }

  @Test
  void read_meals() {
    String token = userController.signUp(signUp4());
    request = new MockHttpServletRequest();
    request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+token);
    List<Meal> actual = mealController.getMeals(request);
    Assertions.assertEquals(3, actual.size());
  }
  @Test
  void read_meal_by_id() {
    Meal actual = mealController.getMealById(MEAL1_ID);
    Assertions.assertEquals(meal1(), actual);
  }

  @Test
  void read_meal_ordered() {
    List<Meal> actual = mealController.getMealsOrdered(PAGE,PAGE_SIZE);
    Assertions.assertEquals(5, actual.size());
    Assertions.assertEquals(actual.get(0), meal1());
    Assertions.assertEquals(actual.get(1), meal9());
    Assertions.assertEquals(actual.get(2), meal8());

  }

}
