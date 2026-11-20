/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public abstract class Cancha 
{
    protected String nombre, estado;
    protected int codigo, capacidadMaxima;
    protected double tarifaBase;

    public Cancha(String nombre, String estado, int capacidadMaxima, double tarifaBase) {
        this.nombre = nombre;
        this.estado = estado;
        this.capacidadMaxima = capacidadMaxima;
        this.tarifaBase = tarifaBase;
    }
    
    public abstract double CalcularTarifa(int hora);

    //Para el que este haciendo el RF5. Pueden usarlo como  if(cancha.PuedeReservarse==true)  etc
    public boolean PuedeReservarse()
    {
        if (estado.equals("En Mantenimiento"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public String VerInfo() {
        return "\nNombre=" + nombre + 
                "\nEstado:" + estado + 
                "\nCodigo:" + codigo + 
                "\nCapacidadMaxima:" + capacidadMaxima;
                
    }
    
    
    
    //Para mostrar el tipo en el JTable
    public abstract String getTipo();
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
    
    
    
    
}
