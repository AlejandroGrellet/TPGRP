/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import autores.vistas.ModeloTablaAlumno;
import autores.vistas.ModeloTablaProfesores;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAMAlumno;
import interfaces.IControladorAMProfesor;
import interfaces.IControladorAutores;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author USUARIO
 */
public class ControladorAutores implements IControladorAutores {
    
//    private IControladorAMAlumno VA;
//    private IControladorAMProfesor VP;
    private VentanaAutores ventanaAutor;
    IGestorAutores GA = GestorAutores.crear();

    public ControladorAutores(VentanaPrincipal VP) {
        this.ventanaAutor=new VentanaAutores(this, VP, true);
        ventanaAutor.setLocationRelativeTo(null);
        ventanaAutor.getTablaAlumnos().setModel(new ModeloTablaAlumno());
        ventanaAutor.getTablaProfesores().setModel(new ModeloTablaProfesores());
        this.ventanaAutor.getTxtAlumnoApellido().setText(null);
        this.ventanaAutor.getTxtProfesorApellido().setText(null);  
        ventanaAutor.setVisible(true);
        
    }
    
   
    
    
    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        IControladorAMProfesor contProf = new ControladorAMProfesor();
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel();
        mtp.actualizar();
            }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
       IControladorAMAlumno controlador =new ControladorAMAlumno();
        ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
        mta.actualizar();
       
       
       
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
    List<Profesor> LISTA = GA.verProfesores();
        if(LISTA.size()==0)
        {
            JOptionPane.showMessageDialog(ventanaAutor,"No se encontraron elementos");
        }
        else if (ventanaAutor.getTablaProfesores().getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(ventanaAutor,"Elija el elemento a modificar");
        }
        
        else
        {
            int row = ventanaAutor.getTablaProfesores().getSelectedRow();
            int dni = Integer.parseInt(ventanaAutor.getTablaProfesores().getValueAt(row,0).toString());
            
            Autor profeA = null;
            
            for(Profesor auxiliar: LISTA)
            {
                if(auxiliar.verDni()==dni)
                {
                    profeA = auxiliar;
                }
            }
            
            IControladorAMProfesor controladorProfe = new ControladorAMProfesor(profeA);
            
        }
        
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel();
        mtp.actualizar();
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        List<Alumno> LISTA = GA.verAlumnos();
        
        
        if(LISTA.size()==0){
            JOptionPane.showMessageDialog(ventanaAutor,"No se encontraron elementos");}
        else if (ventanaAutor.getTablaAlumnos().getSelectedRow()==-1){
            JOptionPane.showMessageDialog(ventanaAutor,"Elija el elemento a modificar");}
        
        else
        {
            int row = ventanaAutor.getTablaAlumnos().getSelectedRow();
            int dni = Integer.parseInt(ventanaAutor.getTablaAlumnos().getValueAt(row,0).toString());
            
            Autor alumnoA = null;
            
            for(Alumno auxiliar: LISTA)
            {
                if(auxiliar.verDni()==dni)
                {
                    alumnoA = auxiliar;
                }
            }
            
            IControladorAMAlumno controladorA = new ControladorAMAlumno(alumnoA);
            
        }
        
        ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
        mta.actualizar();
        
        
        
    }    

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
            if(this.ventanaAutor.getTablaProfesores().getSelectedRow()!= -1){    
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION_PROFESOR, "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");
            if(opcion == JOptionPane.YES_OPTION){
                Autor Profesor = ((ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel()).verProfesor(this.ventanaAutor.getTablaProfesores().getSelectedRow());
                GestorAutores.BorrarProfesor(Profesor);
                ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel();
                mtp.actualizar();
                this.btnActivarDesactivar();
            }
        }    
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
                if(this.ventanaAutor.getTablaAlumnos().getSelectedRow()!= -1){ 
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION_ALUMNO, "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Confirmar","Cancelar"}, "Cancelar");    
            if(opcion == JOptionPane.YES_OPTION){
                Autor Alumno = ((ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel()).verAlumno(this.ventanaAutor.getTablaAlumnos().getSelectedRow());
                GestorAutores.BorrarAlumno(Alumno);
                ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
                mta.actualizar();
                this.btnActivarDesactivar();
            }
        }        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaAutor.setVisible(false);    
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel();
        String apellidos = this.ventanaAutor.getTxtProfesorApellido().getText().toLowerCase();
        ArrayList<Profesor> profesor_buscar = new ArrayList<>();
        IGestorAutores ga = GestorAutores.crear();
        mtp.setProfesores(ga.verProfesores());
        if((apellidos!=null)&&(!apellidos.isBlank())){
            for(Profesor prof : mtp.getProfesores()){
                if(prof.verApellidos().toLowerCase().contains(apellidos)){
                    profesor_buscar.add(prof);
                }
            }
             mtp.actualizarBusqueda(profesor_buscar);
        }
        else{
            mtp.actualizar();
        }    
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
        String apellidos = this.ventanaAutor.getTxtAlumnoApellido().getText().toLowerCase();
        ArrayList<Alumno> alumnos_buscados = new ArrayList<>();
        IGestorAutores ga = GestorAutores.crear();
        mta.setAlumnos(ga.verAlumnos());
        if((apellidos!=null)&&(!apellidos.isBlank())){
            for(Alumno p : mta.getAlumnos()){
                if(p.verApellidos().toLowerCase().contains(apellidos)){
                    alumnos_buscados.add(p);
                }
            }
             mta.actualizarBusqueda(alumnos_buscados);
        }
        else{
            mta.actualizar();
        }    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
        mta.actualizar();
        ModeloTablaProfesores mtp = (ModeloTablaProfesores)this.ventanaAutor.getTablaProfesores().getModel();
        mtp.actualizar();
        this.btnActivarDesactivar();
        
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
   char c = evt.getKeyChar();
        if((!Character.isLetter(c))){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnBuscarProfesorClic(null);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
   char c = evt.getKeyChar();
        if((!Character.isLetter(c))){
            switch(c){
                case KeyEvent.VK_ENTER:
                    this.btnBuscarAlumnoClic(null);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }    }
    
    
    public void btnActivarDesactivar(){
        IGestorAutores ga = GestorAutores.crear();
        if(ga.verAlumnos().isEmpty()){
            this.ventanaAutor.getBtnModificarAlumno().setEnabled(false);
            this.ventanaAutor.getBtnBorrarAlumno().setEnabled(false);
        }
        if(ga.verProfesores().isEmpty()){
            this.ventanaAutor.getBtnBorrarProfesor().setEnabled(false);
            this.ventanaAutor.getBtnModificarProfesor().setEnabled(false);
        }
        if(!(ga.verAlumnos().isEmpty())){
            this.ventanaAutor.getBtnBorrarAlumno().setEnabled(true);
            this.ventanaAutor.getBtnModificarAlumno().setEnabled(true);
        }
        if(!(ga.verProfesores().isEmpty())){
            this.ventanaAutor.getBtnBorrarProfesor().setEnabled(true);
            this.ventanaAutor.getBtnModificarProfesor().setEnabled(true);
        }
    }
    
    
//    public void actualizar(){
//         ModeloTablaAlumno mta = (ModeloTablaAlumno)this.ventanaAutor.getTablaAlumnos().getModel();
//         
//    }
//    
    
}
