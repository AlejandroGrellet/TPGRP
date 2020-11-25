/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import java.util.ArrayList;

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
        if ((nombre != null) && (!nombre.isBlank())){ 
            this.lugar = new Lugar(nombre);
        
            if(!this.ListaLugares.contains(lugar)) {
                ListaLugares.add(lugar);
                return nombre;
            }
        } return null;
    }
    @Override
    public ArrayList<Lugar> verLugares(){
        return ListaLugares;  
    }

    @Override
    public Lugar verLugar(String nombre) {
        return lugar;
    }
    
}
