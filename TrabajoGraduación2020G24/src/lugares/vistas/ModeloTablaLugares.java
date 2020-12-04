/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.vistas;

import interfaces.IGestorLugares;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaLugares extends AbstractTableModel{
    private List<Lugar> ListaLugares=new ArrayList<>();
    private ArrayList<String> ListaNombres=new ArrayList<>();

    public ModeloTablaLugares() {
        ListaNombres.add("Nombre");
        
    }
    
    @Override
    public int getRowCount() {
        return ListaLugares.size();
    }

    @Override
    public int getColumnCount() {
        return ListaNombres.size();
        }
    @Override
    public String getColumnName(int columna) {
        return this.ListaNombres.get(columna);
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        Lugar l = this.ListaLugares.get(fila);
        return l.getNombre();
    }
    public void actualizar()
        {
        IGestorLugares GL = GestorLugares.crear();
        this.ListaLugares = GL.verLugares();
        this.fireTableDataChanged();
}
     public Lugar verLugar(int fila){
        return this.ListaLugares.get(fila);
    }

    public void setListaLugares(List<Lugar> ListaLugares) {
        this.ListaLugares = ListaLugares;
    }

    public List<Lugar> getListaLugares() {
        return ListaLugares;
    }
      public void actualizarBusqueda(List<Lugar> profesor_buscar){
        this.ListaLugares = profesor_buscar;
        this.fireTableDataChanged();
    }
}
