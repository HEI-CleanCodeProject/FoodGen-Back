package com.genfood.foodgenback.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "\"recipe_ingredients\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class RecipeIngredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @ManyToOne
  @JoinColumn(name = "ingredient_id")
  private Ingredients ingredient;
}
