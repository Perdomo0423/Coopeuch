package com.coopeuch.Rest;

import com.coopeuch.core.entity.TareasEntity;
import com.coopeuch.logicaPersistencia.Service.TareasService;
import com.coopeuch.logicaPersistencia.utils.DetallesTareasVO;
import com.coopeuch.logicaTecnica.Service.TareasServiceBO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = PathRest.TAREAS.ROOT)
public class TareasResource {

    @Autowired
    private TareasService tareasService;

    @Autowired
    private TareasServiceBO tareasServiceBO;

    /**
     * <h1>LISTAR LAS TAREAS</h1>
     *
     * @return ServiceLogica Tareas
     * @throws Exception
     */

    @GetMapping(PathRest.TAREAS.LISTAR)
    public List<TareasEntity> listarController() throws Exception{
        try{
             return tareasService.listarTareasService();
        }catch (Exception e){
            throw new Exception("Error de controlador, datos no suministrados");
        }

    }

    @ApiOperation(value = "Crear una tarea")
    @PostMapping(PathRest.TAREAS.CREAR)
    public ResponseEntity<DetallesTareasVO> guardarTareasResouce(
            @RequestBody(required = true) @Valid DetallesTareasVO detallesTareasVO) throws Exception {
        try{
            return new ResponseEntity<>(tareasServiceBO.guardarBO(detallesTareasVO),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<DetallesTareasVO>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(PathRest.TAREAS.ACTUALIZAR)
    public TareasEntity updateById(@RequestBody TareasEntity tareasEntity, @PathVariable Integer id){
        return this.tareasService.actualizarTareas(tareasEntity, id);
    }

    @DeleteMapping(PathRest.TAREAS.ELIMINAR)
    public void eliminarTarea(@PathVariable(name = "id") @ApiParam(value = "Eliminar tarea") Integer id)throws Exception {
        try{
            tareasService.eliminarTareas(id);
        }catch (Exception e){
            throw new Exception("Error de controlador, datos no suministrados");
        }
    }

}
