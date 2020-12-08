/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import Publicaciones.modelos.GestorPublicaciones;
import Publicaciones.modelos.Publicacion;
import autores.modelos.Profesor;
import interfaces.IGestorPublicaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaPublicaciones extends AbstractTableModel{
    private List<Publicacion> ListaPublicaciones=new ArrayList<>();
    private ArrayList<String> ListaNombres =new ArrayList<>();
    
    public ModeloTablaPublicaciones() {
        this.ListaNombres.add("Título");
        this.ListaNombres.add("Autor");
        this.ListaNombres.add("Año");
        IGestorPublicaciones GP = GestorPublicaciones.crear();
         this.ListaPublicaciones = GP.verPublicaciones();
    }

    
    @Override
    public int getRowCount() {
        return this.ListaPublicaciones.size();
    }

    @Override
    public int getColumnCount() {
        return this.ListaNombres.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
    Publicacion publicacion = this.ListaPublicaciones.get(fila);
        switch(columna)
        {
            case 0: return publicacion.getTitulo();
            case 1: return publicacion.getMgrupo().verAutor();
            default : return publicacion.getFechaDePublicacion();
        }    
    }

    @Override
    public String getColumnName(int column) {
        return this.ListaNombres.get(column);
    }

    public List<Publicacion> getListaPublicaciones() {
        return ListaPublicaciones;
    }
    
    
    public void actualizar()
        {
        IGestorPublicaciones GP = GestorPublicaciones.crear();
        this.ListaPublicaciones = GP.verPublicaciones();
        this.fireTableDataChanged();
}

    public Publicacion verPublicacion(int fila){
        return this.ListaPublicaciones.get(fila);
    }

  public void actualizarBusqueda(List<Publicacion> publicacion_buscar){
        this.ListaPublicaciones = publicacion_buscar;
        this.fireTableDataChanged();
    }

    public void setListaPublicaciones(List<Publicacion> ListaPublicaciones) {
        this.ListaPublicaciones = ListaPublicaciones;
    }
  
}
