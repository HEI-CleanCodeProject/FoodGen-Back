package com.genfood.foodgenback.model;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.plaf.synth.Region;

@Entity
@Getter
@Setter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Region region;
    @OneToOne
    private Recipe recipe;
    private String image;
    private int download;
}
