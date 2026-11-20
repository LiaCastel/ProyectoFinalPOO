/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class CanchaFutbol5 extends Cancha
{

    public CanchaFutbol5(String nombre, String estado, int capacidadMaxima, double tarifaBase) {
        super(nombre, estado, capacidadMaxima, tarifaBase);
    }

    @Override
    public double CalcularTarifa(int hora) {
        if (hora >= 18) 
        {
            return tarifaBase * 1.10;
        } 
        else 
        {
            return tarifaBase;
        }
        
    }

    @Override
    public String getTipo() {
        return "Fútbol 5";  
    }

    @Override
    public String VerInfo() {
        return super.VerInfo() + "\nTarifa:"+tarifaBase+"\nTipo:" + this.getTipo(); 
    }
    
    
    
}
