/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.sop_rmi.PacienteCllbckImpl;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import servidorAlertas.sop_rmi.GestionAsintomaticosInt;

/**
 *
 * @author usuario
 */
public class ClienteDeObjetos {
    
    private static ArrayList listadoId = new ArrayList();
    private static GestionAsintomaticosInt objRemoto;

  public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (GestionAsintomaticosInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoUsuarios");
        MenuPrincipal();

    }

    private static void MenuPrincipal() throws RemoteException {
       
        int aux = 0;//variable para validar la opción 2
        int aux2 = 0;//variable para controlar la cantidad de pacientes registrados
        int opcion = 0;
        PacienteCllbckImpl objAsintomatico = new PacienteCllbckImpl();
        do {
            System.out.println("==========Menu===========");
            System.out.println("1. Registrar asintomatico");
            System.out.println("2. Enviar Indicador      ");
            System.out.println("3. Salir                 ");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    aux = 1;
                    if (aux2 == 5) {

                        System.out.println("La cantidad de pacientes registrados es 5");
                    } else {

                        System.out.println("Validando Existencia de un paciente con el mismo ID");
                        System.out.println("Ingrese el id: ");
                        Scanner leer = new Scanner(System.in);
                        int dni = leer.nextInt();
                        if (listadoId.contains(dni)) {
                            System.out.println("Existe un paciente con ese id!");
                            System.out.println();
                            System.out.println("Existe un paciente con ese id!");
                        } else {
                            listadoId.add(dni);
                            System.out.println("No existen pacientes con ese ID, se procedera a la creación del nuevo registro.");
                            Opcion1(dni,objAsintomatico);
                        }
                    }
                    break;
                case 2:
                    
                    break;
            
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 3);
    }

    private static void Opcion1(int id,PacienteCllbckImpl objAsintomatico) throws RemoteException {

        
        System.out.println("==Registro del Paciente==");

        //SOLICITAR DATOS DEL PACIENTE
        //System.out.println("Ingrese el id del paciente");
        //int id = UtilidadesConsola.leerEntero();
        objAsintomatico.setId(id);

        System.out.println("Ingrese el tipo de id ");
        String tipo_id = UtilidadesConsola.leerCadena();
        objAsintomatico.setTipo_id(tipo_id);
        
        System.out.println("Ingrese el nombre del paciente ");
        String nombres = UtilidadesConsola.leerCadena();
        objAsintomatico.setNombres(nombres);

        System.out.println("Ingrese el apellido del paciente ");
        String apellidos = UtilidadesConsola.leerCadena();
        objAsintomatico.setApellidos(apellidos);
        
        System.out.println("Ingrese la dirección del paciente ");
        String direccion = UtilidadesConsola.leerCadena();
        objAsintomatico.setDireccion(direccion);
/*
        boolean valor = objRemoto.registrarAsintomatico(objAsintomatico);
        if (valor) {
            System.out.println("Registro realizado satisfactoriamente...");
        } else {
            System.out.println("no se pudo realizar el registro...");
        }*/
    }
  
}
