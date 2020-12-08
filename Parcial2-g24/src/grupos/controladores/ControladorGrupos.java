/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.vistas.ModeloTablaMiembros;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorGrupos;
import interfaces.IGestorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author mbmnu
 */
public class ControladorGrupos implements IControladorGrupos{
    private VentanaGrupos ventana;
    IGestorGrupos GP = GestorGrupos.crear();
    
    public ControladorGrupos(VentanaPrincipal VP) {
        this.ventana = new VentanaGrupos(this, VP, true);
        this.ventana.setLocationRelativeTo(null);
        ModeloTablaMiembros MTG = new ModeloTablaMiembros();
        MTG.actualizar();
        this.ventana.getTablaGrupos().setModel(MTG);
        this.ventana.setVisible(true);
    }

    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
