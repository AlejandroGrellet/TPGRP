/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import Publicaciones.controladores.ControladorPublicaciones;
import autores.controladores.ControladorAutores;
import grupos.controladores.ControladorGrupos;
import interfaces.IControladorAutores;
import interfaces.IControladorGrupos;
import interfaces.IControladorLugares;
import interfaces.IControladorPrincipal;
import interfaces.IControladorPublicaciones;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import lugares.controladores.ControladorLugares;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author mbmnu
 */
public class ControladorPrincipal implements IControladorPrincipal {
    
    private VentanaPrincipal ventana;
    
//    public static void main(String[] args) {
//        
//        IGestorAutores GA=GestorAutores.crear();
//        System.out.println(GA.nuevoAutor(1, "ASD", "ASD", "ASD", "ASD", "ASD"));
//        System.out.println(GA.nuevoAutor(2, "DFG", "DFG", "DFG", "DFG", "DFG"));
//                
//        for(Alumno i:GA.verAlumnos()){
//        System.out.println(i);
//    }
//    }

    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnAutoresClic(ActionEvent evt) {
        IControladorAutores ventanaAutor = new ControladorAutores(this.ventana); 
        
           }
    @Override
    public  void btnLugaresClic(ActionEvent evt){
        IControladorLugares ventanaLugares=new ControladorLugares(this.ventana);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        
        int opcion = JOptionPane.showOptionDialog(null, "¿Desea terminar?","SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] {"Si", "No"}, this);
             if(opcion == JOptionPane.YES_OPTION)
             {
                ventana.dispose();
                 System.exit(0);
                 
             }
             else
                 this.ventana.requestFocus();
        
    }

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void btnGruposClic(ActionEvent evt) {
        IControladorGrupos ventanaGrupos = new ControladorGrupos(this.ventana);    
    }

    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        IControladorPublicaciones ventanaPublicaciones = new ControladorPublicaciones(this.ventana);
    }
    
}



        
    



 
        
        
        
 
    