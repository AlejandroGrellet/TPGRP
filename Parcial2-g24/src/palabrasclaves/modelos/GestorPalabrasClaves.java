/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import Publicaciones.modelos.GestorPublicaciones;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mbmnu
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves{
    ArrayList<PalabraClave> ListaPalabraClave=new ArrayList<>();
    private static GestorPalabrasClaves InstanceChek;
    private PalabraClave palabraClave;
    
    public static GestorPalabrasClaves crear(){
        if(InstanceChek==null)
          InstanceChek = new GestorPalabrasClaves();
        return InstanceChek;
    }
    
     private GestorPalabrasClaves() {
    }

    @Override
    public String nuevaPalabraClave(String nombre) {
        if ((nombre != null) && (!nombre.isBlank())){ 
            this.palabraClave = new PalabraClave(nombre);
        
            if(!this.ListaPalabraClave.contains(palabraClave)) {
                ListaPalabraClave.add(palabraClave);
                return nombre;
            }
        } return null;
    }

    @Override
    public List<PalabraClave> verPalabrasClaves() {
               Comparator<PalabraClave> cpc = (pc1, pc2) -> pc1.verNombre().compareTo(pc2.verNombre());
                this.ListaPalabraClave.sort(cpc);
        
        return this.ListaPalabraClave;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
       for(PalabraClave palabraClave: ListaPalabraClave)
        {
            if(palabraClave.verNombre()==nombre)
            {
                return palabraClave;
            }
        }
        return null;
    }

    @Override
    public String borrarPalabraClave(PalabraClave palabraClave) {
        IGestorPublicaciones gestorp = GestorPublicaciones.crear();
       if(!gestorp.hayPublicacionesConEstaPalabraClave(palabraClave))
       {
           ListaPalabraClave.remove(palabraClave);
           return BORRAR_CORRECTO;
       }
       else
       {
           return BORRAR_ERRONEO;
       }    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        List<PalabraClave> palabrasBuscar = new ArrayList<> ();
      for(PalabraClave palabraClave: ListaPalabraClave)
      {
          if(palabraClave.verNombre().contains(nombre))
          {
              palabrasBuscar.add(palabraClave);
          }
      }
      Comparator<PalabraClave> cpc = (pc1, pc2) -> pc1.verNombre().compareTo(pc2.verNombre());
      palabrasBuscar.sort(cpc);
      return palabrasBuscar;    }

    @Override
    public boolean existeEstaPalabraClave(PalabraClave palabraClave) {
return this.ListaPalabraClave.contains(palabraClave);    
    }
    
    
    
    
}
