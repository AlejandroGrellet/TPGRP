/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaProfesores extends AbstractTableModel{
    private ArrayList<String> nombreColumnas=new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
//    GestorAutores gestor= GestorAutores.crear();
    
    
        public ModeloTablaProfesores() {
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("Cargo");
        
        GestorAutores gp = GestorAutores.crear();
         this.profesores = gp.verProfesores();
    }

    @Override
    public int getRowCount() {
        return this.profesores.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    

    @Override
    public Object getValueAt(int fila, int columna) {
       Profesor prof = this.profesores.get(fila);
        switch(columna)
        {
            case 0: return prof.verDni();
            case 1: return prof.verApellidos();
            case 2 : return prof.verNombres();
            default : return prof.verCargo();
        }
    }

    
    public Profesor verProfesor(int fila){
        return this.profesores.get(fila);
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

  

    
    
    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }

public void actualizar()
        {
        GestorAutores ge = GestorAutores.crear();
        this.profesores = ge.verProfesores();
        this.fireTableDataChanged();
}



  public void actualizarBusqueda(ArrayList<Profesor> profesor_buscar){
        this.profesores = profesor_buscar;
        this.fireTableDataChanged();
    }

}
