package com.genfood.foodgenback.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "\"recipe\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Recipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String readme;
}
