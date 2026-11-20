/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public abstract class Jugador 
{
    protected int DNI, telefono;
    protected String nombre, apellido, correo;
    protected int reservasFinalizadas;

    public Jugador(int DNI, int telefono, String nombre, String apellido, String correo) {
        this.DNI = DNI;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.reservasFinalizadas=0;
    }

    
    public abstract double CalcularDescuento(double monto);

    public abstract String getTipo();

  
    public String VerInfo() {
        return "DNI:" + DNI + 
                "\nTelefono:" + telefono + 
                "\nnombre=" + nombre + 
                "\napellido=" + apellido + 
                "\ncorreo=" + correo + 
                "\nreservasFinalizadas=" + reservasFinalizadas;
    }

    
    
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getReservasFinalizadas() {
        return reservasFinalizadas;
    }

    public void setReservasFinalizadas(int reservasFinalizadas) {
        this.reservasFinalizadas = reservasFinalizadas;
    }
    
    
    
}
