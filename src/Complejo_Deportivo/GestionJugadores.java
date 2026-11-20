/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class GestionJugadores 
{
    private Jugador[] arreglo;
    private int conta;

    public GestionJugadores()
    {
        arreglo = new Jugador[300];
        conta = 0;
    }
    
    public boolean EsRecepcionista(Empleado actual)
    {
        if (actual != null)
        {
            if (actual.getRol().equals("Recepcionista"))
            {
                return true;
            }
        }
        return false;
    }
    
    //Auxiliares no requeridos por RF03. Para RF05: Buscar y ObtenerPorPos
    public Jugador Buscar(int DNI)
    {
        for (int i = 0; i < conta; i++)
        {
            if (arreglo[i].getDNI() == DNI)
            {
                return arreglo[i];
            }
        }

        return null;
    }

    public Jugador ObtenerPorPos(int pos)
    {
        if (pos >= 0 && pos < conta)
        {
            return arreglo[pos];
        }
        else
        {
            return null;
        }
    }

    
    public void ActualizarTipo(int DNI)
    {
        for (int i = 0; i < conta; i++)
        {
            if (arreglo[i].getDNI() == DNI)
            {
                if (arreglo[i].getReservasFinalizadas() >= 5 &&
                    arreglo[i] instanceof JugadorRegular)
                {
                    Jugador nuevo = new JugadorFrecuente(
                            arreglo[i].getDNI(),
                            arreglo[i].getTelefono(),
                            arreglo[i].getNombre(),
                            arreglo[i].getApellido(),
                            arreglo[i].getCorreo());

                    nuevo.setReservasFinalizadas(
                            arreglo[i].getReservasFinalizadas());

                    arreglo[i] = nuevo;

                    System.out.println("El jugador ahora es Frecuente");
                }

                break;
            }
        }
    }

    
    public void IncrementarReservas(int DNI)
    {
        int encontrado = 0;

        for (int i = 0; i < conta; i++)
        {
            if (arreglo[i].getDNI() == DNI)
            {
                encontrado = 1;

                arreglo[i].setReservasFinalizadas(
                        arreglo[i].getReservasFinalizadas() + 1);

                System.out.println("Reserva finalizada registrada");

                ActualizarTipo(DNI);

                break;
            }
        }

        if (encontrado == 0)
        {
            System.out.println("Jugador no encontrado");
        }
    }


    
    public void Registrar(Jugador ref, Empleado actual)
    {
        if (EsRecepcionista(actual))
        {
            if (ref == null)
            {
                System.out.println("Debe ingresar los datos del jugador");
            }
            else
            {
                int repetido = 0;

                for (int i = 0; i < conta; i++)
                {
                    if (arreglo[i].getDNI() == ref.getDNI())
                    {
                        repetido++;
                    }
                }

                if (repetido > 0)
                {
                    System.out.println("Ya existe un jugador con ese DNI");
                }
                else if (conta == arreglo.length)
                {
                    System.out.println("Jugadores llenos");
                }
                else if (ref.getDNI() < 10000000 ||
                         ref.getDNI() > 99999999)
                {
                    System.out.println("El DNI debe tener 8 dígitos");
                }
                else if (ref.getNombre() == null ||
                         ref.getNombre().trim().equals(""))
                {
                    System.out.println("Debe ingresar el nombre del jugador");
                }
                else if (ref.getApellido() == null ||
                         ref.getApellido().trim().equals(""))
                {
                    System.out.println("Debe ingresar el apellido del jugador");
                }
                else if (ref.getTelefono() < 100000000 ||
                        ref.getTelefono() > 999999999)
               {
                   System.out.println("El teléfono debe tener 9 dígitos");
               }
                else if (ref.getCorreo() == null)
                {
                    System.out.println("Debe ingresar el correo del jugador");
                }
                else if (!(ref instanceof JugadorRegular) ||
                         ref.getReservasFinalizadas() != 0)
                {
                    System.out.println("El jugador nuevo debe ser Regular y tener cero reservas finalizadas");
                }
                else
                {
                    arreglo[conta] = ref;
                    conta++;

                    System.out.println("Jugador registrado correctamente");
                }
            }
        }
        else
        {
            System.out.println("Solo el Recepcionista puede registrar jugadores");
        }
    }
    
    public double ObtenerDescuento(int DNI, double monto)
    {
        Jugador ref = Buscar(DNI);

        if (ref != null)
        {
            return ref.CalcularDescuento(monto);
        }
        else
        {
            System.out.println("Jugador no encontrado");
            return 0;
        }
    }
    
    
    public void Modificar(int DNI, Jugador ref, Empleado actual)
    {
        if (EsRecepcionista(actual))
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++)
            {
                if (arreglo[i].getDNI() == DNI)
                {
                    encontrado = 1;

                    if (ref == null)
                    {
                        System.out.println("Debe ingresar los datos del jugador");
                    }
                    else
                    {
                        int repetido = 0;

                        for (int j = 0; j < conta; j++)
                        {
                            if (i != j)
                            {
                                if (arreglo[j].getDNI() == ref.getDNI())
                                {
                                    repetido++;
                                }
                            }
                        }

                        if (repetido > 0)
                        {
                            System.out.println("Ya existe un jugador con ese DNI");
                        }
                        else if (ref.getDNI() < 10000000 ||
                                 ref.getDNI() > 99999999)
                        {
                            System.out.println("El DNI debe tener 8 dígitos");
                        }
                        else if (ref.getNombre() == null ||
                                 ref.getNombre().trim().equals(""))
                        {
                            System.out.println("Debe ingresar el nombre del jugador");
                        }
                        else if (ref.getApellido() == null ||
                                 ref.getApellido().trim().equals(""))
                        {
                            System.out.println("Debe ingresar el apellido del jugador");
                        }
                        else if (ref.getTelefono() <= 0)
                        {
                            System.out.println("Debe ingresar un teléfono válido");
                        }
                        else if (ref.getCorreo() == null ||
                                 ref.getCorreo().trim().equals(""))
                        {
                            System.out.println("Debe ingresar el correo del jugador");
                        }
                        else
                        {
                            arreglo[i].setDNI(ref.getDNI());
                            arreglo[i].setNombre(ref.getNombre());
                            arreglo[i].setApellido(ref.getApellido());
                            arreglo[i].setTelefono(ref.getTelefono());
                            arreglo[i].setCorreo(ref.getCorreo());

                            System.out.println("Jugador modificado correctamente");
                        }
                    }
                    break;
                }
            }

            if (encontrado == 0)
            {
                System.out.println("Jugador no encontrado");
            }
        }
        else
        {
            System.out.println("Solo el Recepcionista puede modificar jugadores");
        }
    }

    
    public void Eliminar(int DNI, Empleado actual)
    {
        if (EsRecepcionista(actual))
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++)
            {
                if (arreglo[i].getDNI() == DNI)
                {
                    encontrado = 1;

                    for (int j = i; j < conta - 1; j++)
                    {
                        arreglo[j] = arreglo[j + 1];
                    }

                    arreglo[conta - 1] = null;
                    conta--;

                    System.out.println("Jugador eliminado correctamente");
                    break;
                }
            }

            if (encontrado == 0)
            {
                System.out.println("Jugador no encontrado");
            }
        }
        else
        {
            System.out.println("Solo el Recepcionista puede eliminar jugadores");
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
    
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }


    
}
