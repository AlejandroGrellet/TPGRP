/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IGestorIdiomas;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author mbmnu
 */
public class ModeloComboIdioma extends DefaultComboBoxModel{
    private JComboBox combo;
    IGestorIdiomas GI = GestorIdiomas.crear();

    public ModeloComboIdioma() {
        for(Idioma idioma : GI.verIdiomas())
            this.addElement(idioma);
    }

    public Idioma obtenerIdioma(){
        return (Idioma)this.getSelectedItem();
    }
     public void seleccionarCargo(Idioma idioma)
    {
        this.setSelectedItem(idioma);       
    }
}
