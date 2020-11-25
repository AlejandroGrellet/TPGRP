/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import java.util.ArrayList;

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
    public ArrayList<Idioma> verIdiomas() {
        return ListaIdiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        return idioma;
    }
    
    
}
