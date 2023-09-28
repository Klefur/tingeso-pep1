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
@Table(name = "dcto_cuota")
public class DctoCuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter private int dcto;
    @Setter @Getter private int puntaje_prom;
}
