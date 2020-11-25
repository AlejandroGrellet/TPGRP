/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;

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
    public ArrayList<PalabraClave> verPalabrasClaves() {
        return ListaPalabraClave;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        return palabraClave;
    }
    
}
