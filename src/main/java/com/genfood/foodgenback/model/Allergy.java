package com.genfood.foodgenback.model;

import jakarta.persistence.*;

@Entity
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Ingredients ingredient;
}