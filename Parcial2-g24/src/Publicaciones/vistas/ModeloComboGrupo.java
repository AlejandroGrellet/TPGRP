/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author mbmnu
 */
public class ModeloComboGrupo extends DefaultComboBoxModel{
    private JComboBox combo;
    IGestorGrupos GP = GestorGrupos.crear();
    IGestorAutores GA = GestorAutores.crear();
    private Autor autor;

    public ModeloComboGrupo() {
        this.autor =GA.verAutores().get(0);
//        MiembroEnGrupo MG = new MiembroEnGrupo(autor, Rol.COLABORADOR, grupo);
        for(MiembroEnGrupo grupo : autor.verListaGrupo()){
        
            this.addElement(grupo);
        }
    }

    public MiembroEnGrupo obtenerGrupo(){
        MiembroEnGrupo MEG = new MiembroEnGrupo(autor, Rol.COLABORADOR,(Grupo)this.getSelectedItem());
        return MEG;
    }
     public void seleccionarCargo(Grupo grupo)
    {
        this.setSelectedItem(grupo);       
    }
    
}
