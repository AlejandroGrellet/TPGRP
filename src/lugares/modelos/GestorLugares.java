/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import Publicaciones.modelos.GestorPublicaciones;
import interfaces.IGestorLugares;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorLugares implements IGestorLugares{
    ArrayList<Lugar> ListaLugares=new ArrayList<>();
    private static GestorLugares InstanceChek;
    private Lugar lugar;
    
    public static GestorLugares crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorLugares();
        return InstanceChek;
    }
    
     private GestorLugares() {
    }
    
     @Override
    public String nuevoLugar(String nombre) {
    if(nombre!= null && nombre!="")
        {
            Lugar lugar = new Lugar (nombre);
            if(!this.ListaLugares.contains(lugar))
            {
                this.ListaLugares.add(lugar);
                return LUGAR_ACEPTADO;
            }else
            {
                return LUGAR_REPETIDO;
            }
        }else
        {
            return LUGAR_ERROR;
        }
    
       
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        IGestorPublicaciones gestorp= GestorPublicaciones.crear();
        if(!gestorp.hayPublicacionesConEsteLugar(lugar))
        {
            ListaLugares.remove(lugar);
            return BORRAR_CORRECTO;
        }
        else
        {
            return BORRAR_ERRONEO;
        }    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
    List<Lugar> lugaresBuscar = new ArrayList<> ();
      for(Lugar lugar: ListaLugares)
      {
          if(lugar.getNombre().contains(nombre))
          {
              lugaresBuscar.add(lugar);
          }
      }
      Comparator<Lugar> cl = (l1, l2) -> l1.getNombre().compareTo(l2.getNombre());
      lugaresBuscar.sort(cl);
      return lugaresBuscar;    
    }

    
    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    @Override
    public List<Lugar> verLugares(){
        Comparator<Lugar> cl = (l1, l2) -> l1.getNombre().compareTo(l2.getNombre());
        this.ListaLugares.sort(cl);
        return this.ListaLugares;  
    }

    @Override
    public Lugar verLugar(String nombre) {
        for(Lugar lugar: ListaLugares)
        {
            if(lugar.getNombre()==nombre)
            {
                return lugar;
            }
        }
       return null;
    }
    
}
