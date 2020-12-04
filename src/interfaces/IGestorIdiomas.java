/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import idiomas.modelos.Idioma;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public interface IGestorIdiomas {
    
     public static final String IDIOMA_ACEPTADO = "IDIOMA GUARDADO CON EXITO";
    public static final String IDIOMA_REPETIDO = "EL IDIOMA YA SE ENCUENTRA CARGADO CON ANTERIORIDAD";
    public static final String IDIOMA_ERROR = "NO SE HA PODIDO GUARDAR EL IDIOMA, DATOS INCORRECTOS";
    public static final String BORRAR_CORRECTO = "IDIOMA BORRADO CORRECTAMENTE";
    public static final String BORRAR_ERRONEO = "NO SE PUDO BORRAR ESTE IDIOMA PORQUE UNA PUBLICACION LO UTILIZA";
    
    public String nuevoIdioma(String nombre);
//    public ArrayList<Idioma> verIdiomas();
    public Idioma verIdioma(String nombre);
    public String borrarIdioma(Idioma idioma);
    public List<Idioma> buscarIdiomas(String nombre);
    public List<Idioma> verIdiomas();
    public boolean existeEsteIdioma(Idioma idioma);
    
}
