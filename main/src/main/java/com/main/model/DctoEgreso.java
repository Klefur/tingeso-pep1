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
@Table(name = "dcto_egreso")
public class DctoEgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter @Getter private int dcto;
    @Setter @Getter private int tiempo_egreso;
}
