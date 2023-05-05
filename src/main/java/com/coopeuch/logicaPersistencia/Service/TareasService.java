package com.coopeuch.logicaPersistencia.Service;

import com.coopeuch.core.entity.TareasEntity;
import com.coopeuch.logicaPersistencia.utils.DetallesTareasVO;

import javax.persistence.PersistenceException;
import java.util.List;

public interface TareasService {

    List<TareasEntity> listarTareasService() throws PersistenceException;

    TareasEntity guardarTareas(TareasEntity entity) throws PersistenceException;

    TareasEntity actualizarTareas(TareasEntity entity, Integer id) throws PersistenceException;

    boolean eliminarTareas(Integer xTareas) throws PersistenceException;


}
