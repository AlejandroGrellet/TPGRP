/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;


import autores.modelos.Cargo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author USUARIO
 */
public class ModeloComboCargos extends DefaultComboBoxModel{
    private JComboBox combo;
    
    public ModeloComboCargos()
    {
        for(Cargo cargo : Cargo.values())
            this.addElement(cargo);
//        combo=new JComboBox();
//        combo.addItem("A1");
//        combo.addItem("A2");
//        combo.addItem("A3");
    }
    
    
    public Cargo obtenerCargo()
    {
        return (Cargo)this.getSelectedItem();
    }
    
    public void seleccionarCargo(Cargo cargo)
    {
        this.setSelectedItem(cargo);       
    }
    
        
}
