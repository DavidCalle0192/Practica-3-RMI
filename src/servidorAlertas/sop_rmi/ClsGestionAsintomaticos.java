package servidorAlertas.sop_rmi;

import cliente.sop_rmi.PacienteCllbckInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
/*/*
Clase que implementa la interface remota GestorUsuariosInt
*/

public class ClsGestionAsintomaticos extends UnicastRemoteObject implements GestionAsintomaticosInt
{  
    private Hashtable<Integer,PacienteCllbckInt> pacientes;
    
    public ClsGestionAsintomaticos() throws RemoteException
    {
        super(); //invoca al constructor de la clase base       
        this.pacientes = new Hashtable<>();
    }
 

    @Override
    public boolean registrarAsintomatico(PacienteCllbckInt objAsintomatico, int idPaciente) throws RemoteException {
    
        System.out.println("Entrando a registrar paciente");
        boolean bandera=false;
        
        if(pacientes.size() < 5)
        {
            if(pacientes.put(idPaciente, objAsintomatico)!=null)bandera=true;
        }
        
        return bandera;
    }

    @Override
    public boolean enviarIndicador(int id, float ToC) throws RemoteException {
        boolean res = false;
        System.out.println("Desde enviar indicadores...");;
        
        if(pacientes.get(id)!=null){
            if(ToC<35.2 || ToC > 37.2){
                pacientes.get(id).notificar(id, ToC);
            }else{
                System.out.println("El paciente con id "+id+" presenta una T oC de "+ToC
                        +" que esta dentro del rango normal");
            }
        }else{
            System.out.println("No se encuentra el paciente con id "+id);
            res = false;
        }
        
        return res;
    }
}
