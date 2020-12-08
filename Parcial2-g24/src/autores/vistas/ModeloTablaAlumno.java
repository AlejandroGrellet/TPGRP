/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.Alumno;
import autores.modelos.GestorAutores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mbmnu
 */
public class ModeloTablaAlumno extends AbstractTableModel{
    private ArrayList<String> nombreColumnas=new ArrayList<>();
        private List<Alumno> alumnos = new ArrayList<>();

        

    public ModeloTablaAlumno() {
        
        nombreColumnas.add("DNI");
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("CX");
        
         GestorAutores ga = GestorAutores.crear();
         this.alumnos = ga.verAlumnos();
    }

    @Override
    public int getRowCount() {
    return this.alumnos.size();  
    }

    @Override
    public int getColumnCount() {
    return this.nombreColumnas.size();
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    

    
    @Override
    public String getColumnName(int columna) {
        return this.nombreColumnas.get(columna);
    }

      public Alumno verAlumno(int fila){
        return this.alumnos.get(fila);
    }
    
    
    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        Alumno e = this.alumnos.get(fila);
        switch(columna)
        {
            case 0: e.verDni();
            break;
            case 1: e.verApellidos();
            break;
            case 2: e.verNombres();
            break;
            default : e.verCx();
            break;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Alumno alum = this.alumnos.get(fila);
        switch(columna)
        {
            case 0: return alum.verDni();
            case 1: return alum.verApellidos();
            case 2 : return alum.verNombres();
            default : return alum.verCx();
        }    
    }

//    @Override
//    public Class<?> getColumnClass(int columna) {
//        switch(columna)
//{
//            case 0: return String.class;
//            case 1: return Integer.class;
//            default: return String.class;
//                    
//}
//    } 
    public void actualizar()
        {
        GestorAutores ge = GestorAutores.crear();
        this.alumnos = ge.verAlumnos();
        this.fireTableDataChanged();
}
      public void actualizarBusqueda(ArrayList<Alumno> alumno_buscar){
        this.alumnos = alumno_buscar;
        this.fireTableDataChanged();
    }
    
    
}