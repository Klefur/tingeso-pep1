package com.main.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "precio")
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter private String nombre;
    @Setter @Getter private int precio;
}
