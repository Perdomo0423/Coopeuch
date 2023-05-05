package com.coopeuch.logicaPersistencia.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@ApiModel(description = "VO con campos seleccionados de tareas")
public class DetallesTareasVO {

    @ApiModelProperty(value = "Identificador \u00fanico de la tarea generado autom\u00e1ticamente por el sistema.")
    private Integer identificador;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(value = "Descripcion de la tarea.")
    private String descripcion;

    @NotNull
    @ApiModelProperty(value = "Fecha de creacion de la tarea")
    private Date fechaCreacion;

    @NotNull
    @ApiModelProperty(value = "Estado de la tarea")
    private Boolean vigente;
}
