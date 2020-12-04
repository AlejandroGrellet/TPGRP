/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import Publicaciones.modelos.GestorPublicaciones;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorTipos implements IGestorTipos{
    public List<Tipo> ListaTipos=new ArrayList<>();
    private static GestorTipos InstanceChek;
    private Tipo tipo;
    
    public static GestorTipos crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorTipos();
        return InstanceChek;
    }
    
     private GestorTipos() {
    }
    
     @Override
    public String nuevoTipo(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){ 
            this.tipo = new Tipo(nombre);
        
          if(!this.ListaTipos.contains(tipo))
            {
                this.ListaTipos.add(tipo);
                return TIPO_ACEPTADO;
            }else
            {
                return TIPO_REPETIDO;
            }
        }else
        {
            return TIPO_ERROR;
        }
    }
    @Override
    public List<Tipo> verTipos(){
         Comparator<Tipo> ct = (t1, t2) -> t1.getNombre().compareTo(t2.getNombre());
        this.ListaTipos.sort(ct);
        return this.ListaTipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
           for(Tipo tipo: ListaTipos)
        {
            if(tipo.getNombre()== nombre)
            {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
    IGestorPublicaciones gestorp= GestorPublicaciones.crear();
        if(!gestorp.hayPublicacionesConEsteTipo(tipo))
        {
            ListaTipos.remove(tipo);
            return BORRAR_CORRECTO;
        }
        else
        {
            return BORRAR_ERRONEO;
        }    
    }

    @Override
    public List<Tipo> buscarTipos(String nombre) {
    List<Tipo> tiposBuscar = new ArrayList<> ();
      for(Tipo tipo: ListaTipos)
      {
          if(tipo.getNombre().contains(nombre))
          {
              tiposBuscar.add(tipo);
          }
      }
      Comparator<Tipo> ct = (t1, t2) -> t1.getNombre().compareTo(t2.getNombre());
      tiposBuscar.sort(ct);
      return tiposBuscar;   
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) 
    {
        return this.ListaTipos.contains(tipo);   
    }
    
    


   
}
