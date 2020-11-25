/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import lugares.modelos.Lugar;

/**
 *
 * @author mbmnu
 */
public interface IGestorLugares {
    public String nuevoLugar(String nombre);
//    public ArrayList<Lugar> verLugares();
    public Lugar verLugar(String nombre);
    public String borrarLugar(Lugar lugar);
    public List<Lugar> buscarLugares(String nombre);
    public List<Lugar> verLugares();
    public boolean existeEsteLugar(Lugar lugar);
    
    
}
