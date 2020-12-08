/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import autores.vistas.ModeloComboCargos;
import autores.vistas.ModeloTablaGrupos;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ControladorAMProfesor implements IControladorAMProfesor {
    private VentanaAMProfesor ventana;
    private static boolean activacion = true ;
    private Profesor autor_modificar;
    IGestorAutores gestorA = GestorAutores.crear();
    public static final String ErrorMsj="ERROR";
    
    public ControladorAMProfesor() {
        activacion=true;
        this.ventana=new VentanaAMProfesor(this,null,true);
        
        JComboBox combo = new JComboBox();
        combo.setModel(new ModeloComboCargos());
        this.ventana.getComboCargo().setModel(new ModeloComboCargos());
        this.ventana.getTablaGrupos().setModel(new ModeloTablaGrupos(null));
        ventana.setLocationRelativeTo(null);
        this.ventana.getTablaGrupos().setVisible(false);
        this.ventana.getLabelGrupos().setVisible(false);
        this.ventana.setVisible(true);
        this.ventana.requestFocus();
    }
    
    
    public ControladorAMProfesor(Autor autor) {
        autor_modificar= (Profesor)autor;
        activacion = false;
        this.ventana=new VentanaAMProfesor(this,null,true);
        ventana.setLocationRelativeTo(null);
        JComboBox combo = new JComboBox();
        combo.setModel(new ModeloComboCargos());
        this.ventana.getTablaGrupos().setModel(new ModeloTablaGrupos(autor));
        this.ventana.getComboCargo().setModel(new ModeloComboCargos());
        this.ventana.getTxtDocumento().enable(false);
        this.ventana.getTxtDocumento().setText(this.autor_modificar.verDni()+"");
        this.ventana.getTxtNombres().setText(this.autor_modificar.verNombres());
        this.ventana.getTxtApellidos().setText(this.autor_modificar.verApellidos());
        this.ventana.getComboCargo().setSelectedItem(this.autor_modificar.verCargo());
        this.ventana.getPassClave().setText(this.autor_modificar.verClave());
        this.ventana.getPassRepetirClave().setText(this.autor_modificar.verClave());
        this.ventana.setVisible(true);
        this.ventana.requestFocus();
    }
    
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        Cargo cargo;
    if(activacion){
        int dni=0;
        String nombre = this.ventana.getTxtNombres().getText();
        String apellido =this.ventana.getTxtApellidos().getText();
        cargo=(Cargo)this.ventana.getComboCargo().getSelectedItem();
        String clave=this.ventana.getPassClave().getText();
        String repclave=this.ventana.getPassClave().getText();
        dni = Integer.parseInt(this.ventana.getTxtDocumento().getText());
        if(!gestorA.nuevoAutor(dni, apellido, nombre, cargo, clave, clave).equals(ErrorMsj)){
            gestorA.nuevoAutor(dni, apellido, nombre, cargo, clave, repclave);
            this.ventana.dispose();
            }
          else
              JOptionPane.showMessageDialog(null,ErrorMsj,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        else{
            String nombre = this.ventana.getTxtNombres().getText();
            String apellido =this.ventana.getTxtApellidos().getText();
            cargo =(Cargo)this.ventana.getComboCargo().getSelectedItem();;
            String clave=this.ventana.getPassClave().getText();
            String repclave=this.ventana.getPassClave().getText();
             JOptionPane.showMessageDialog(ventana,gestorA.modificarAutor(autor_modificar, apellido, nombre, cargo, clave, repclave));
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
