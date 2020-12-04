/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.controladores;

import interfaces.IControladorLugar;
import interfaces.IControladorLugares;
import interfaces.IGestorLugares;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import lugares.vistas.ModeloTablaLugares;
import lugares.vistas.VentanaLugares;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author mbmnu
 */
public class ControladorLugares implements IControladorLugares{
    private VentanaLugares ventana;
    IGestorLugares GL=GestorLugares.crear();
    
    public ControladorLugares(VentanaPrincipal VP) {
        this.ventana=new VentanaLugares(this, VP, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaLugares().setModel(new ModeloTablaLugares());
        ModeloTablaLugares mtl = (ModeloTablaLugares)this.ventana.getTablaLugares().getModel();
        mtl.actualizar();
        this.ventana.getTxtNombre().setText(null);
        ventana.setVisible(true);
    }
    

    @Override
    public void btnNuevaClic(ActionEvent evt) {
        IControladorLugar contLug = new ControladorLugar();
        ModeloTablaLugares mtl = (ModeloTablaLugares)this.ventana.getTablaLugares().getModel();
        mtl.actualizar();
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if(this.ventana.getTablaLugares().getSelectedRow()!= -1){    
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
            if(opcion == JOptionPane.YES_OPTION){
                Lugar lugar = ((ModeloTablaLugares)this.ventana.getTablaLugares().getModel()).verLugar(this.ventana.getTablaLugares().getSelectedRow());
                GL.borrarLugar(lugar);
                ModeloTablaLugares mtl = (ModeloTablaLugares)this.ventana.getTablaLugares().getModel();
                mtl.actualizar();
            }
        }
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.setVisible(false);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaLugares mtl = (ModeloTablaLugares)this.ventana.getTablaLugares().getModel();
        String nombre = this.ventana.getTxtNombre().getText().toLowerCase();
        GL.buscarLugares(nombre);
         mtl.actualizarBusqueda(GL.buscarLugares(nombre));

    }
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ModeloTablaLugares mtl = (ModeloTablaLugares)this.ventana.getTablaLugares().getModel();
        mtl.actualizar();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if((!Character.isLetter(c))){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnBuscarClic(null);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }
    
}
