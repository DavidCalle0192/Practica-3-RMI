package servidorAlertas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */


import cliente.utilidades.UtilidadesConsola;import java.rmi.RemoteException;
import servidorAlertas.sop_rmi.ClsGestionAsintomaticos;
import servidorAlertas.utilidades.UtilidadesRegistroS;
;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        ClsGestionAsintomaticos objRemoto = new ClsGestionAsintomaticos();
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoGestionAsintomaticos");            
           
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
