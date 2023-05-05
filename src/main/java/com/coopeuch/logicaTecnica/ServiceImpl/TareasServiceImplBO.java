package com.coopeuch.logicaTecnica.ServiceImpl;

import com.coopeuch.core.entity.TareasEntity;
import com.coopeuch.logicaPersistencia.Service.TareasService;
import com.coopeuch.logicaPersistencia.utils.DetallesTareasVO;
import com.coopeuch.logicaTecnica.Service.TareasServiceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Component
@Service
public class TareasServiceImplBO implements TareasServiceBO {

    @Autowired
    private TareasService tareasService;

    @Override
    public DetallesTareasVO guardarBO(DetallesTareasVO detallesTareasVO) {

            TareasEntity tareasEntity = new TareasEntity();

            tareasEntity.setDescripcion(detallesTareasVO.getDescripcion());
            tareasEntity.setFechaCreacion(detallesTareasVO.getFechaCreacion());
            tareasEntity.setVigente(detallesTareasVO.getVigente());

            TareasEntity newEntity = tareasService.guardarTareas(tareasEntity);

            detallesTareasVO.setIdentificador(newEntity.getIdentificador());

            return detallesTareasVO;
        }


}

