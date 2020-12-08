/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import palabrasclaves.modelos.PalabraClave;

/**
 *
 * @author mbmnu
 */
public interface IGestorPalabrasClaves {
    
     public static final String PALABRACLAVE_ACEPTADO = "PALABRA CLAVE GUARDADA CON EXITO";
    public static final String PALABRACLAVE_REPETIDA = " LA PALABRA CLAVE YA SE ENCUENTRA CARGADA ANTERIORMENTE";
    public static final String PALABRACLAVE_ERROR = "NO SE HA PODIDO GUARDAR LA PALABRA CLAVE, DATOS INVALIDOS";
    public static final String BORRAR_CORRECTO = "PALABRA BORRADA CORRECTAMENTE";
    public static final String BORRAR_ERRONEO = "NO SE PUDO BORRAR ESTA PALABRA PORQUE UNA PUBLICACION LA UTILIZA";
    
    public String nuevaPalabraClave(String nombre);
//    public ArrayList<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
    public String borrarPalabraClave(PalabraClave palabraClave);
    public List<PalabraClave> buscarPalabrasClaves(String nombre);
    public List<PalabraClave> verPalabrasClaves();
    public boolean existeEstaPalabraClave(PalabraClave palabraClave);
}
