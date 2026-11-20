/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class JugadorRegular extends Jugador
{

    public JugadorRegular(int DNI, int telefono, String nombre, String apellido, String correo) {
        super(DNI, telefono, nombre, apellido, correo);
    }

    @Override
    public double CalcularDescuento(double monto) {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Regular";
    }
    
    @Override
    public String VerInfo() {
        return super.VerInfo() +"\nTipo:" + this.getTipo(); 
    }
    
    
}
