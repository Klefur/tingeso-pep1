package com.main.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_colegio")
public class TipoColegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter private String nombre;
    @Setter @Getter private int max_cuotas;
    @Setter @Getter private int dcto;

    @OneToMany(mappedBy = "tipo_colegio")
    @Setter @Getter private List<Usuario> usuarios;

}
