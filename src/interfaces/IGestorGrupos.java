/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import grupos.modelos.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public interface IGestorGrupos {
    
     public static final String GRUPO_ACEPTADO = "GRUPO GUARDADO";
    public static final String GRUPO_REPETIDO = "ERROR. EL GRUPO YA SE ENCUENTRA CARGADO";
    public static final String GRUPO_ERROR = "NO SE HA PODIDO GUARDAR EL GRUPO, DATOS INVALIDOS";
    public static final String GRUPO_MODIFICADO = "GRUPO MODIFICADO CORRECTAMENTE";
    public static final String GRUPO_NO_ENCONTRADO = "GRUPO NO ENCONTRADO";
    public static final String BORRAR_CORRECTO = "GRUPO BORRADO CORRECTAMENTE";
    public static final String BORRAR_ERRONEO = "NO SE PUDO BORRAR ESTE GRUPO PORQUE UN AUTOR PERTENECE A EL";
    
    
    
    public String nuevoGrupo(String nombre, String descripcion);
    public String modificarGrupo(Grupo grupo, String descripcion);
//    public ArrayList<Grupo> verGrupos();
//    public Grupo verGrupo(String nombre);
    public boolean existeEsteGrupo(Grupo grupo);
    public String borrarGrupo(Grupo grupo);
    public List<Grupo> buscarGrupos(String nombre);
    public List<Grupo> verGrupos();
//    public boolean existeEsteGrupo(Grupo grupo);
    
}
