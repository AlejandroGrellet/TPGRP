/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;

/**
 *
 * @author mbmnu
 */
public class GestorGrupos implements IGestorGrupos{

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        if((!nombre.isBlank())&&(nombre!=null)&& (!descripcion.isBlank())&&(descripcion!=null))
           return null;
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Grupo> verGrupos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grupo verGrupo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
