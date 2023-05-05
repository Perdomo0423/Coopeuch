package com.coopeuch.logicaPersistencia.ServiceImpl;

import com.coopeuch.core.entity.TareasEntity;
import com.coopeuch.core.repository.TareasRepository;
import com.coopeuch.logicaPersistencia.Service.TareasService;
import com.coopeuch.logicaPersistencia.utils.DetallesTareasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class TareasServiceImpl implements TareasService {

    @Autowired
    private TareasRepository tareasRepository;

    @Override
    public List<TareasEntity> listarTareasService() throws PersistenceException {
        try{
            return tareasRepository.findAll();
        }catch (Exception e){
            throw new PersistenceException("Error de Implementacion de logica");
        }

    }

    @Override
    public TareasEntity guardarTareas(TareasEntity entity) throws PersistenceException{
        try{
            return tareasRepository.save(entity);
        }catch (Exception e){
            throw new PersistenceException("Error al crear en el servicio de impl");
        }

    }

    @Override
    public TareasEntity actualizarTareas(TareasEntity entity, Integer id) throws PersistenceException {
        try{
            TareasEntity tareas = tareasRepository.findById(id).get();

            tareas.setDescripcion(entity.getDescripcion());
            tareas.setFechaCreacion(entity.getFechaCreacion());
            tareas.setVigente(entity.getVigente());

            return tareas;
        }catch (Exception e){
            throw new PersistenceException("Error de logica");

        }

    }

    @Override
    public boolean eliminarTareas(Integer xTareas) throws PersistenceException {
        try{
            tareasRepository.deleteById(xTareas);
            return true;
        }catch (Exception e){
            throw new PersistenceException("Error de logica");
        }

    }
}
