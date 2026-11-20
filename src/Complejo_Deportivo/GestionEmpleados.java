/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class GestionEmpleados 
{
    private Empleado[] arreglo;
    private int conta;

    public GestionEmpleados() {
        arreglo = new Empleado[200];
        conta=0;
    }
    
    public boolean EsAdministrador(Empleado actual) 
    {
        if (actual != null) 
        {
            if (actual.getRol().equals("Administrador")) 
            {
                return true;
            }
        }
        return false;
    }
    
    //Para el primer empleado unicamente
    public void RegistrarInicial(Empleado ref)
    {
        if (conta == 0)
        {
            if (ref != null &&
                ref.getRol().equals("Administrador"))
            {
                arreglo[conta] = ref;
                conta++;

                System.out.println("Administrador inicial registrado");
            }
            else
            {
                System.out.println("El usuario inicial debe ser Administrador");
            }
        }
    }
    
    public void Registrar(Empleado ref, Empleado actual) 
    {
        if (EsAdministrador(actual)) 
        {
            int dni = 0;
            int usuario = 0;

            for (int i = 0; i < conta; i++) {
                if (arreglo[i].getDNI() == ref.getDNI()) 
                {
                    dni++;
                }
                else if (arreglo[i].getUsuario().equals(ref.getUsuario()))
                {
                    usuario++;
                }
            }

            if (dni == 1) 
            {
                System.out.println("DNI ya existente");
                
            }
            else if (usuario == 1)
            {
                System.out.println("Usuario ya existente");
            }
            else if (conta >= arreglo.length)
            {
                System.out.println("Capacidad llena");
            }
            else
            {
                arreglo[conta] = ref;
                conta++;
            }
        }
        else
        {
            System.out.println("No es administrador. No puede ingresar");
        }
    }

    //Es una busqueda por DNI
    public void Modificar(int DNI, Empleado ref, Empleado actual) 
    {
        if (EsAdministrador(actual)) 
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++) 
            {
                if (arreglo[i].getDNI() == DNI) 
                {
                    encontrado = 1;
                    int repetido = 0;

                    for (int j = 0; j < conta; j++) 
                    {
                        if (i != j) 
                        {
                            if (arreglo[j].getDNI() == ref.getDNI() ||
                                arreglo[j].getUsuario().equals(ref.getUsuario())) 
                            {
                                repetido++;
                            }
                        }
                    }

                    if (repetido == 0) 
                    {
                        arreglo[i] = ref;
                        System.out.println("Empleado modificado correctamente");
                    } 
                    else 
                    {
                        System.out.println("El DNI o usuario ya existe");
                    }
                    break;
                }
            }

            if (encontrado == 0) 
            {
                System.out.println("Empleado no encontrado");
            }
        }
        else 
        {
            System.out.println("Solo el Administrador puede modificar empleados");
        }
    }

    //Tambien se elimina por DNI
    public void Eliminar(int DNI, Empleado actual) 
    {
        if (EsAdministrador(actual)) 
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++) {
                if (arreglo[i].getDNI() == DNI) {

                    encontrado = 1;

                    for (int j = i; j < conta - 1; j++) 
                    {
                        arreglo[j] = arreglo[j + 1];
                    }

                    arreglo[conta - 1] = null;
                    conta--;

                    System.out.println("Empleado eliminado correctamente");
                    break;
                }
            }

            if (encontrado == 0) {
                System.out.println("Empleado no encontrado");
            }

        } 
        else 
        {
            System.out.println("Solo el Administrador puede eliminar empleados");
        }
    }
    
    public String VerInfo()
    {
        String cad="";
        for (int i=0; i<conta;i++)
        {
            cad=cad+arreglo[i].VerInfo();
        }
        return cad;
    }

}
