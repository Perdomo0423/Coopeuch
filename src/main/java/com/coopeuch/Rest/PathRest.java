package com.coopeuch.Rest;

public class PathRest {

    private static final String EXCEPTION_MESSAGE = "This is an utility class";

    private PathRest() {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    public static final class TAREAS {
        private TAREAS(){
            throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
        }
        public static final String ROOT = "/tareas";
        public static final String LISTAR = "/listarTareas";
        public static final String  CREAR = "/crearTareas";
        public static final String ACTUALIZAR = "/actualizarTareas/{id}";
        public static final String  ELIMINAR = "/eliminarTareas/{id}";
    }
}
