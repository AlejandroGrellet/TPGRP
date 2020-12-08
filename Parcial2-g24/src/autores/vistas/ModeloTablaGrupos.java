/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import grupos.modelos.MiembroEnGrupo;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaGrupos extends AbstractTableModel{
    private ArrayList<String> ListaNombres=new ArrayList<>();
    private List<MiembroEnGrupo> miembros= new ArrayList<>(); 
    private Autor autor;

    public ModeloTablaGrupos(Autor autor) {
        if(autor!=null){
        ListaNombres.add("Grupo");
        ListaNombres.add("Rol");
        IGestorAutores GA = GestorAutores.crear();
        this.autor=autor;
        miembros=autor.verListaGrupo();
        }
    }
    
    
    @Override
    public int getRowCount() {
        return miembros.size();
    }

    @Override
    public int getColumnCount() {
        return ListaNombres.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo miemb = this.miembros.get(fila);
        switch(columna)
        {
            case 0: return miemb.verGrupo();
            default : return miemb.verRol();
        }
    }

    @Override
    public String getColumnName(int column) {
        return ListaNombres.get(column);
    }
    
}
