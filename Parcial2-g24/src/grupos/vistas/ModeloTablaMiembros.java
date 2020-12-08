/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.vistas;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaMiembros extends AbstractTableModel{
    private List<Grupo> ListaGrupos=new ArrayList<>();
    private ArrayList<String> ListaNombres=new ArrayList<>();

    public ModeloTablaMiembros() {
        this.ListaNombres.add("Nombre");
        this.ListaNombres.add("Descripcion");
        IGestorGrupos GG = GestorGrupos.crear();
        ListaGrupos = GG.verGrupos();
    }
    
    
    
    @Override
    public int getRowCount() {
        return this.ListaGrupos.size();
    }

    @Override
    public int getColumnCount() {
        return this.ListaNombres.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.ListaNombres.get(columna);
    }
    
    public void actualizar()
    {
        IGestorGrupos GG = GestorGrupos.crear();
        this.ListaGrupos = GG.verGrupos();
        this.fireTableDataChanged();
    }
    @Override
    public Object getValueAt(int fila, int columna) {
        Grupo g = this.ListaGrupos.get(fila);
        switch (columna){
            case 0:
                return g.verNombre();
            default:
                return g.verDescripcion();
        }        
    }
    
    
}
