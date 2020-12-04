/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public interface IGestorTipos {
    
     public static final String TIPO_ACEPTADO = "TIPO GUARDADO";
    public static final String TIPO_REPETIDO = "ERROR. EL TIPO YA SE ENCUENTRA CARGADO";
    public static final String TIPO_ERROR = "NO SE HA PODIDO GUARDAR EL TIPO, DATOS INVALIDOS";
    public static final String BORRAR_CORRECTO = "TIPO BORRADO CORRECTAMENTE";
    public static final String BORRAR_ERRONEO = "NO SE PUDO BORRAR ESTE TIPO PORQUE UNA PUBLICACION LO UTILIZA";
    
    public String nuevoTipo(String nombre);
//    public ArrayList<Tipo> verTipos();
    public Tipo verTipo(String nombre);
    public String borrarTipo(Tipo tipo);
    public List<Tipo> buscarTipos(String nombre);
    public List<Tipo> verTipos();
    public boolean existeEsteTipo(Tipo tipo);
    
}
