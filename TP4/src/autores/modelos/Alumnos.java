/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

/**
 *
 * @author mbmnu
 */
public class Alumnos {
    private int DNI;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cx;

    public Alumnos(int DNI, String apellidos, String nombres, String clave, String cx) {
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cx = cx;
    }
    
    
    public void mostrar()
    {
        System.out.println(apellidos);
        System.out.println(nombres);
        System.out.println(DNI);
        System.out.println(clave);
        System.out.println(cx);
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }
}
