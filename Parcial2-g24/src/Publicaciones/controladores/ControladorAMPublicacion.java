/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.controladores;

import Publicaciones.modelos.GestorPublicaciones;
import Publicaciones.modelos.Publicacion;
import Publicaciones.vistas.ModeloComboGrupo;
import Publicaciones.vistas.ModeloComboIdioma;
import Publicaciones.vistas.ModeloComboLugar;
import Publicaciones.vistas.ModeloComboTipo;
import Publicaciones.vistas.ModeloTablaPalabrasClave;
import Publicaciones.vistas.VentanaAMPublicaciones;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author mbmnu
 */
public class ControladorAMPublicacion  implements IControladorAMPublicacion{
    private Publicacion publicacion_modificar;
    private VentanaAMPublicaciones ventana;
    private boolean activacion;
    IGestorPublicaciones GP= GestorPublicaciones.crear();
    
    public ControladorAMPublicacion() {
        activacion =true;
        this.ventana=new VentanaAMPublicaciones(this,null, true);
        ventana.setLocationRelativeTo(null);
        ModeloTablaPalabrasClave MTPC = new ModeloTablaPalabrasClave();
        MTPC.actualizar();
        this.ventana.getTablaPalabrasClave().setModel(MTPC);
        this.ventana.getTablaPalabrasClave().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.ventana.getComboGrupo().setModel(new ModeloComboGrupo());
        this.ventana.getComboIdioma().setModel(new ModeloComboIdioma());
        this.ventana.getComboLugar().setModel(new ModeloComboLugar());
        this.ventana.getComboTipo().setModel(new ModeloComboTipo());
        this.ventana.getComboGrupo().setSelectedIndex(-1);
        this.ventana.getComboIdioma().setSelectedIndex(-1);
        this.ventana.getComboLugar().setSelectedIndex(-1);
        this.ventana.getComboTipo().setSelectedIndex(-1);
        ventana.setVisible(true);
        this.ventana.requestFocus();
    }
   
    public ControladorAMPublicacion(Publicacion publicacion){
        activacion = false;
        publicacion_modificar = publicacion;
        this.ventana=new VentanaAMPublicaciones(this,null, true);
        ventana.setLocationRelativeTo(null);
        ModeloTablaPalabrasClave MTPC = new ModeloTablaPalabrasClave();
        MTPC.actualizar();
        this.ventana.getTablaPalabrasClave().setModel(MTPC);
        this.ventana.getTablaPalabrasClave().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClave().getSelectionModel();
        for(PalabraClave palabraClave : this.publicacion_modificar.getPalabrasclaves()) {
            for(int fila = 0; fila < MTPC.getRowCount(); fila++) {
            PalabraClave pc = MTPC.getListaPC(fila);
            if (palabraClave.equals(pc)) {
                modeloSeleccion.addSelectionInterval(fila, fila);
                break;
                }
            }
        }
        this.ventana.getComboGrupo().setModel(new ModeloComboGrupo());
        this.ventana.getComboIdioma().setModel(new ModeloComboIdioma());
        this.ventana.getComboLugar().setModel(new ModeloComboLugar());
        this.ventana.getComboTipo().setModel(new ModeloComboTipo());
        this.ventana.getTxTitulo().enable(false);
        this.ventana.getTxTitulo().setText(this.publicacion_modificar.getTitulo());
        this.ventana.getTxtEnlace().setText(this.publicacion_modificar.getEnlace());
        this.ventana.getTxtResumen().setText(this.publicacion_modificar.getResumen());
        this.ventana.getComboIdioma().setSelectedItem(this.publicacion_modificar.getIdioma());
        this.ventana.getComboLugar().setSelectedItem(this.publicacion_modificar.getIdioma());
        this.ventana.getComboTipo().setSelectedItem(this.publicacion_modificar.getTipo());
        ventana.setVisible(true);
        
        
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String Titulo = this.ventana.getTxTitulo().getText();
        String enlace =this.ventana.getTxtEnlace().getText();
        String resumen = this.ventana.getTxtResumen().getText();
//        LocalDate fecha = ((LocalDate)Integer.parseInt(this.ventana.getTxtFecha().getText())).toDate();
        MiembroEnGrupo MEG =(MiembroEnGrupo)this.ventana.getComboGrupo().getSelectedItem();
        Idioma idioma =(Idioma)this.ventana.getComboIdioma().getSelectedItem();
        Tipo tipo =(Tipo)this.ventana.getComboTipo().getSelectedItem();
        Lugar lugar =(Lugar)this.ventana.getComboLugar().getSelectedItem();
        List<PalabraClave> palabrasClaves=new ArrayList<>();
        ModeloTablaPalabrasClave MTPC = new ModeloTablaPalabrasClave();
        for(int fila :this.ventana.getTablaPalabrasClave().getSelectedRows())
            palabrasClaves.add(MTPC.getListaPC(fila));
        if(activacion==true){
            GP.nuevaPublicacion(Titulo, MEG, LocalDate.EPOCH, tipo, idioma, lugar, palabrasClaves, enlace, resumen);  
            JOptionPane.showMessageDialog(null,GP.nuevaPublicacion(Titulo, MEG, LocalDate.EPOCH, tipo, idioma, lugar, palabrasClaves, enlace, resumen));
        }
        else{
            GP.modificarPublicacion(publicacion_modificar, MEG, LocalDate.EPOCH, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
            JOptionPane.showMessageDialog(null,GP.modificarPublicacion(publicacion_modificar, MEG, LocalDate.EPOCH, tipo, idioma, lugar, palabrasClaves, enlace, resumen));
        }
        this.ventana.setVisible(false);
    }
        

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.setVisible(false);
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
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
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        ModeloTablaPalabrasClave MTPC = (ModeloTablaPalabrasClave)this.ventana.getTablaPalabrasClave().getModel();
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClave().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, MTPC.getRowCount() - 1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = this.ventana.getTablaPalabrasClave().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.getTxtEnlace().setText(selectedFile.getAbsolutePath());
        }           
    }
    
    
}
