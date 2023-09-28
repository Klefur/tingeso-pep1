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
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter private int nota;
    @Setter @Getter private Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @Setter @Getter private Usuario usuario;
}
