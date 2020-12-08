/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.controladores;

import interfaces.IGestorLugares;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import lugares.modelos.GestorLugares;
import lugares.vistas.VentanaAMLugares;
import interfaces.IControladorALugar;

/**
 *
 * @author mbmnu
 */
public class ControladorALugar implements IControladorALugar{
    private VentanaAMLugares ventana;
    IGestorLugares GL =GestorLugares.crear();
    private final String ERROR="Error al cargar los elementos, por favo verifique los datos";
    private final String MSJ_REPETIDO="Elemento repetido";
    

    public ControladorALugar() {
        this.ventana = new VentanaAMLugares(this, null, true);
        ventana.setTitle(TITULO);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        
            String nombre = this.ventana.getTxtNombre().getText();
        if ((nombre!=null)&&(!nombre.isBlank())&&(!GL.nuevoLugar(nombre).equals(MSJ_REPETIDO)))
        {  
            GL.nuevoLugar(nombre);
            JOptionPane.showMessageDialog(null,"EXITO");
            ventana.setVisible(false);
        }else
        JOptionPane.showMessageDialog(null,ERROR,"ERROR",JOptionPane.WARNING_MESSAGE);

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if((!Character.isLetter(c))){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
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
