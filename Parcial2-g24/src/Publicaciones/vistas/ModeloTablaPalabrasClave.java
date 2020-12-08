/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicaciones.vistas;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaPalabrasClave extends AbstractTableModel{
    private List<PalabraClave> ListaPC = new ArrayList<>();
    private ArrayList<String> ListaNombres =new ArrayList<>();

    public ModeloTablaPalabrasClave() {
        ListaNombres.add("Palabras Claves");
        IGestorPalabrasClaves GPC = GestorPalabrasClaves.crear();
         this.ListaPC = GPC.verPalabrasClaves();
//        this.actualizar();
    }
    
    @Override
    public int getRowCount() {
        return this.ListaPC.size();
    }

    @Override
    public int getColumnCount() {
        return this.ListaNombres.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave PC = this.ListaPC.get(fila);
        return PC.verNombre();
    }
    public void actualizar()
    {
        IGestorPalabrasClaves GPC = GestorPalabrasClaves.crear();
        this.ListaPC = GPC.verPalabrasClaves();
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return ListaNombres.get(column);
    }

    public PalabraClave getListaPC(int Fila) {
        return ListaPC.get(Fila);
    }
    
}
    
    

