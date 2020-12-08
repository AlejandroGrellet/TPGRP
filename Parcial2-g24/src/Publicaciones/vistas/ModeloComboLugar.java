/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import interfaces.IGestorLugares;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

/**
 *
 * @author mbmnu
 */
public class ModeloComboLugar extends DefaultComboBoxModel {
    private JComboBox combo;
    IGestorLugares GL = GestorLugares.crear();

    public ModeloComboLugar() {
        for(Lugar lugar : GL.verLugares())
            this.addElement(lugar);
    }

    public Lugar obtenerGrupo(){
        return (Lugar)this.getSelectedItem();
    }
     public void seleccionarCargo(Lugar lugar)
    {
        this.setSelectedItem(lugar);       
    }
    
}
