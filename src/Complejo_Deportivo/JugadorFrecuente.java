/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class JugadorFrecuente extends Jugador
{

    public JugadorFrecuente(int DNI, int telefono, String nombre, String apellido, String correo) {
        super(DNI, telefono, nombre, apellido, correo);
    }
    
    @Override
    public double CalcularDescuento(double monto)
    {
        return monto * 0.10;
    }

    @Override
    public String getTipo()
    {
        return "Frecuente";
    }
    
    @Override
    public String VerInfo() {
        return super.VerInfo() +"\nTipo:" + this.getTipo(); 
    }
}
