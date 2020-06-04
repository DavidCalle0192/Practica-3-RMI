/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidorAlertas.sop_rmi.GestionAsintomaticosInt;

/**
 *
 * @author usuario
 */
public class ClienteDeObjetos {

  public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        GestionAsintomaticosInt objRemoto = (GestionAsintomaticosInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoUsuarios");
        MenuPrincipal();

    }

    private static void MenuPrincipal() throws RemoteException {
       
        int aux = 0;//variable para validar la opción 2
        int aux2 = 0;//variable para controlar la cantidad de pacientes registrados
        int opcion = 0;
        //ClsAsintomaticoDTO objAsintomatico = new ClsAsintomaticoDTO();
        do {
            System.out.println("==========Menu===========");
            System.out.println("1. Registrar asintomatico");
            System.out.println("2. Enviar Indicador      ");
            System.out.println("3. Salir                 ");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    
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

  
}
