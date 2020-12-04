/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

//import Publicaciones.modelos.Publicacion;
//import autores.controladores.ControladorAutores;
//import autores.modelos.Alumno;
//import autores.modelos.GestorAutores;
//import interfaces.IControladorAutores;
//import interfaces.IControladorPrincipal;
//import interfaces.IGestorAutores;
import interfaces.IControladorLugares;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import lugares.controladores.ControladorLugares;
import principal.vistas.VentanaPrincipal;
//import lugares.modelos.Lugar;
//import lugares.vistas.VentanaALugar;
//import palabrasclaves.modelos.PalabraClave;
//import palabrasclaves.vistas.VentanaAPalabraClave;
//import tipos.modelos.Tipo;
//import tipos.vistas.VentanaATipo;

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
//        IControladorAutores ventanaAutor = new ControladorAutores(this.ventana); 
        
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
}



        
    



 
        
        
        
 
    