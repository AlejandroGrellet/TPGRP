/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.vistas.ModeloTablaGrupos;
import autores.vistas.VentanaAMAlumno;
import interfaces.IControladorAMAlumno;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ControladorAMAlumno implements IControladorAMAlumno {
    
    private VentanaAMAlumno ventana;
    private static boolean activacion= true;
    private Alumno autor_modif;
    IGestorAutores gestorA = GestorAutores.crear();
     public static final String ErrorMsj="ERROR";
    
    public ControladorAMAlumno() {
        activacion=true;
        this.ventana = new VentanaAMAlumno((IControladorAMAlumno)this, null, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaGrupos().setModel(new ModeloTablaGrupos(null));
        this.ventana.getTablaGrupos().setVisible(false);
        this.ventana.getLabelGrupos().setVisible(false);
        this.ventana.setVisible(true);
        this.ventana.requestFocus();
     
    }

    public ControladorAMAlumno(Autor autor) {
        autor_modif=(Alumno)autor;
        activacion = false;
        this.ventana = new VentanaAMAlumno((IControladorAMAlumno)this, null, true);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.getTablaGrupos().setModel(new ModeloTablaGrupos(autor));
        this.ventana.getTxtDocumento().enable(false);
        this.ventana.getTxtDocumento().setText(this.autor_modif.verDni()+"");
        this.ventana.getTxtNombres().setText(this.autor_modif.verNombres());
        this.ventana.getTxtApellidos().setText(this.autor_modif.verApellidos());
        this.ventana.getTxtCX().setText(this.autor_modif.verCx());
        this.ventana.getPassClave().setText(this.autor_modif.verClave());
        this.ventana.getPassRepetirClave().setText(this.autor_modif.verClave());
        this.ventana.setVisible(true);
        
        this.ventana.requestFocus();
        
        
    }
    
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        int dni=0;
        if(activacion){
        
        String nombre = this.ventana.getTxtNombres().getText();
        String apellido =this.ventana.getTxtApellidos().getText();
        String cx=this.ventana.getTxtCX().getText();
        String clave=this.ventana.getPassClave().getText();
        String repclave=this.ventana.getPassClave().getText();
//        if(this.ventana.getTxtDocumento().isDigit())
        dni = Integer.parseInt(this.ventana.getTxtDocumento().getText());
//        else evt.consume();
        if(!gestorA.nuevoAutor(dni, apellido, nombre, cx, clave, clave).equals(ErrorMsj)){
            gestorA.nuevoAutor(dni, apellido, nombre, cx, clave, repclave);
            this.ventana.dispose();
            }
          else
              JOptionPane.showMessageDialog(null,ErrorMsj,"ERROR",JOptionPane.WARNING_MESSAGE);

        }
        else{
            
            String nombre = this.ventana.getTxtNombres().getText();
            String apellido =this.ventana.getTxtApellidos().getText();
            String cx=this.ventana.getTxtCX().getText();
            String clave=this.ventana.getPassClave().getText();
            String repclave=this.ventana.getPassClave().getText();
            gestorA.modificarAutor(autor_modif, apellido, nombre, cx, clave, repclave);
            this.ventana.dispose();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
    this.ventana.setVisible(false);
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
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

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
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

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
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

    @Override
    public void txtCXPresionarTecla(KeyEvent evt) {
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

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
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

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
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

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


}

    
