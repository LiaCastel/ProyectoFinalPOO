/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complejo_Deportivo;

/**
 *
 * @author Usuario
 */
public class GestionCanchas 
{
    private Cancha[] arreglo;
    private int conta;

    public GestionCanchas() {
        arreglo = new Cancha[50];
        conta = 0;
    }
    
    //Buscar no se necesita para el RF02 pero en otros requerimiento si, asi que ahi se los dejo para que usen.
    public Cancha Buscar(int codigo)
    {
        for (int i = 0; i < conta; i++)
        {
            if (arreglo[i].getCodigo() == codigo)
            {
                return arreglo[i];
            }
        }

        return null;
    }
    
    public Cancha ObtenerPorPos(int pos)
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
    
    
    public void Registrar(Cancha ref, Empleado actual)
        {
            if (EsAdministrador(actual))
            {
                if (ref == null)
                {
                    System.out.println("Debe ingresar los datos de la cancha");
                }
                else
                {
                    int repetido = 0;

                    for (int i = 0; i < conta; i++)
                    {
                        if (arreglo[i].getCodigo() == ref.getCodigo())
                        {
                            repetido++;
                        }
                    }

                    if (repetido > 0)
                    {
                        System.out.println("Ya existe una cancha con ese código");
                    }
                    else if (conta == arreglo.length)
                    {
                        System.out.println("Canchas llenas");
                    }
                    else if (ref.getCodigo() <= 0)
                    {
                        System.out.println("El código debe ser mayor a cero");
                    }
                    else if (ref.getNombre() == null ||
                             ref.getNombre().trim().equals(""))
                    {
                        System.out.println("Debe ingresar el nombre de la cancha");
                    }
                    else if (ref.getCapacidadMaxima() <= 0)
                    {
                        System.out.println("La capacidad máxima debe ser mayor a cero");
                    }
                    else if (ref.getTarifaBase() <= 0)
                    {
                        System.out.println("La tarifa base debe ser mayor a cero");
                    }
                    else if (ref.getEstado() == null)
                    {
                        System.out.println("Debe ingresar el estado de la cancha");
                    }
                    else if (!ref.getEstado().equals("Disponible") &&
                             !ref.getEstado().equals("Ocupada") &&
                             !ref.getEstado().equals("En Mantenimiento"))
                    {
                        System.out.println("El estado de la cancha no es válido");
                    }
                    else
                    {
                        arreglo[conta] = ref;
                        conta++;

                        System.out.println("Cancha registrada correctamente");
                    }
                }
            }
            else
            {
                System.out.println("Solo el Administrador puede registrar canchas");
            }
        }




    
    public void Modificar(int codigo, Cancha ref, Empleado actual)
    {
        if (EsAdministrador(actual))
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++)
            {
                if (arreglo[i].getCodigo() == codigo)
                {
                    encontrado = 1;

                    if (ref == null)
                    {
                        System.out.println("Debe ingresar los datos de la cancha");
                    }
                    else
                    {
                        int repetido = 0;

                        for (int j = 0; j < conta; j++)
                        {
                            if (i != j)
                            {
                                if (arreglo[j].getCodigo() == ref.getCodigo())
                                {
                                    repetido++;
                                }
                            }
                        }

                        if (repetido > 0)
                        {
                            System.out.println("Ya existe una cancha con ese código");
                        }
                        else if (ref.getCodigo() <= 0)
                        {
                            System.out.println("El código debe ser mayor a cero");
                        }
                        else if (ref.getNombre() == null ||
                                 ref.getNombre().trim().equals(""))
                        {
                            System.out.println("Debe ingresar el nombre de la cancha");
                        }
                        else if (ref.getCapacidadMaxima() <= 0)
                        {
                            System.out.println("La capacidad máxima debe ser mayor a cero");
                        }
                        else if (ref.getTarifaBase() <= 0)
                        {
                            System.out.println("La tarifa base debe ser mayor a cero");
                        }
                        else if (ref.getEstado() == null)
                        {
                            System.out.println("Debe ingresar el estado de la cancha");
                        }
                        else if (!ref.getEstado().equals("Disponible") &&
                                 !ref.getEstado().equals("Ocupada") &&
                                 !ref.getEstado().equals("En Mantenimiento"))
                        {
                            System.out.println("El estado de la cancha no es válido");
                        }
                        else
                        {
                            arreglo[i] = ref;

                            System.out.println("Cancha modificada correctamente");
                        }
                    }
                    break;
                }
            }

            if (encontrado == 0)
            {
                System.out.println("Cancha no encontrada");
            }
        }
        else
        {
            System.out.println("Solo el Administrador puede modificar canchas");
        }
    }

    
    
    public void Eliminar(int codigo, Empleado actual) 
    {
        if (EsAdministrador(actual)) 
        {
            int encontrado = 0;

            for (int i = 0; i < conta; i++) 
            {
                if (arreglo[i].getCodigo() == codigo) 
                {
                    encontrado = 1;

                    for (int j = i; j < conta - 1; j++) 
                    {
                        arreglo[j] = arreglo[j + 1];
                    }

                    arreglo[conta - 1] = null;
                    conta--;

                    System.out.println("Cancha eliminada correctamente");
                    break;
                }
            }

            if (encontrado == 0) 
            {
                System.out.println("Cancha no encontrada");
            }
        }
        else 
        {
            System.out.println("Solo el Administrador puede eliminar canchas");
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