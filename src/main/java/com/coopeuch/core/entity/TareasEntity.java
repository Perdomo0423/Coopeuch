package com.coopeuch.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tareas")
@Entity
public class TareasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xIdentificador")
    private Integer identificador;

    @NotBlank
    @NotNull
    @Column(name = "dDescripcion", length = 250, nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    @NotNull
    @Column(name = "estadoVigente", nullable = false)
    private Boolean vigente;
}
