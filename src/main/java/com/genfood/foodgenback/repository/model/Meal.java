package com.genfood.foodgenback.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "\"meal\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @OneToOne
  @JoinColumn(name = "region_id")
  private Region region;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  private Integer download;
}
