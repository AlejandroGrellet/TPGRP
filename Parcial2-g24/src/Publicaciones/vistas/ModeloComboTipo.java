/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import interfaces.IGestorTipos;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public class ModeloComboTipo extends DefaultComboBoxModel {
    private JComboBox combo;
    IGestorTipos GT = GestorTipos.crear();

    public ModeloComboTipo() {
        for(Tipo tipo : GT.verTipos())
            this.addElement(tipo);
    }

    public Tipo obtenerGrupo(){
        return (Tipo)this.getSelectedItem();
    }
     public void seleccionarCargo(Tipo tipo)
    {
        this.setSelectedItem(tipo);       
    }
    
}
