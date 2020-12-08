/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.controladores;

import Publicaciones.modelos.GestorPublicaciones;
import Publicaciones.modelos.Publicacion;
import Publicaciones.vistas.ModeloTablaPublicaciones;
import Publicaciones.vistas.VentanaPublicaciones;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPublicaciones;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author mbmnu
 */
public class ControladorPublicaciones implements IControladorPublicaciones{
    private VentanaPublicaciones ventana;
    IGestorPublicaciones GP = GestorPublicaciones.crear();

    public ControladorPublicaciones(VentanaPrincipal VP) {
        this.ventana= new VentanaPublicaciones(this,VP, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaPublicaciones().setModel(new ModeloTablaPublicaciones());
        this.ventana.setVisible(true);
        this.ventana.requestFocus();
    }
    
    @Override
    public void btnNuevaClic(ActionEvent evt) {
        IControladorAMPublicacion VentanaAMPublicacion =new ControladorAMPublicacion();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        ModeloTablaPublicaciones MTP=new ModeloTablaPublicaciones();
         if (this.ventana.getTablaPublicaciones().getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(ventana,"Elija el elemento a modificar");
        }
        
        else
        {
            int row = this.ventana.getTablaPublicaciones().getSelectedRow();
            Publicacion publicacion = MTP.verPublicacion(row);
            IControladorAMPublicacion VentanaMod =new ControladorAMPublicacion(publicacion);
            }

    }
    

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if(this.ventana.getTablaPublicaciones().getSelectedRow()!= -1){    
            int opcion = JOptionPane.showOptionDialog(null, PUBLICACION_MODIFICAR, "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
            if(opcion == JOptionPane.YES_OPTION){
                Publicacion publicacion = ((ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel()).verPublicacion(this.ventana.getTablaPublicaciones().getSelectedRow());
                GP.borrarPublicacion(publicacion);
                ModeloTablaPublicaciones mtp = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
                mtp.actualizar();
//                this.btnActivarDesactivar();
            }
        }    
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.setVisible(false);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaPublicaciones MTP= (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        String titulo =this.ventana.getTxtNombre().getText();
        List<Publicacion> lista = new ArrayList<>();
        IGestorPublicaciones GP = GestorPublicaciones.crear();
        MTP.setListaPublicaciones(GP.verPublicaciones());
        if((titulo!=null)&&(!titulo.isBlank())){
            for(Publicacion publicacion : MTP.getListaPublicaciones()){
                if(publicacion.getTitulo().toLowerCase().contains(titulo)){
                    lista.add(publicacion);
                }
            }
             MTP.actualizarBusqueda(lista);
        }
        else{
            MTP.actualizar();
        }  
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ModeloTablaPublicaciones MTP = (ModeloTablaPublicaciones)this.ventana.getTablaPublicaciones().getModel();
        MTP.actualizar();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
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
