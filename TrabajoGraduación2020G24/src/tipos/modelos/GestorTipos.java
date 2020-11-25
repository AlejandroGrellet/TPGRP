/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;

/**
 *
 * @author mbmnu
 */
public class GestorTipos implements IGestorTipos{
    ArrayList<Tipo> ListaTipos=new ArrayList<>();
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
        
            if(!this.ListaTipos.contains(tipo)) {
                ListaTipos.add(tipo);
                return nombre;
            }
        } return null;
    }
    @Override
    public ArrayList<Tipo> verTipos(){
        return ListaTipos;  
    }

    @Override
    public Tipo verTipo(String nombre) {
        return tipo;
    }
    


   
}
