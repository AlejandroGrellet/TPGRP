/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import Publicaciones.modelos.GestorPublicaciones;
import interfaces.IGestorIdiomas;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorIdiomas implements IGestorIdiomas{
    ArrayList<Idioma> ListaIdiomas=new ArrayList<>();
    private static GestorIdiomas InstanceChek;
    private Idioma idioma;
    
    public static GestorIdiomas crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorIdiomas();
        return InstanceChek;
    }

    private GestorIdiomas() {
    }
    
    @Override
    public String nuevoIdioma(String nombre) {
         if ((nombre != null) && (!nombre.isBlank())){ 
            this.idioma = new Idioma(nombre);
        
            if(!this.ListaIdiomas.contains(idioma)) {
                ListaIdiomas.add(idioma);
                return nombre;
            }
        } return null;
    }

    @Override
    public List<Idioma> verIdiomas() {
        Comparator<Idioma> ci = (i1, i2) -> i1.getNombre().compareTo(i2.getNombre());
        this.ListaIdiomas.sort(ci);
        return this.ListaIdiomas;
       
    }

    @Override
    public Idioma verIdioma(String nombre) {
        return idioma;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        IGestorPublicaciones gestorp= GestorPublicaciones.crear();
        if(!gestorp.hayPublicacionesConEsteIdioma(idioma))
        {
            ListaIdiomas.remove(idioma);
            return BORRAR_CORRECTO ;
        }
        else
        {
            return BORRAR_ERRONEO;
        }
            }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        List<Idioma> idiomaBuscado = new ArrayList<> ();
      for(Idioma idioma: ListaIdiomas)
      {
          if(idioma.getNombre().contains(nombre))
          {
              idiomaBuscado.add(idioma);
          }
      }
      Comparator<Idioma> ci = (i1, i2) -> i1.getNombre().compareTo(i2.getNombre());
      idiomaBuscado.sort(ci);
      return idiomaBuscado;    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
    return this.ListaIdiomas.contains(idioma);    
    }
    
    
    
    
}
