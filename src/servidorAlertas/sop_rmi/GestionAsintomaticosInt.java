
package servidorAlertas.sop_rmi;

import cliente.sop_rmi.PacienteCllbckInt;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionAsintomaticosInt extends Remote
{
   
    public boolean registrarAsintomatico(PacienteCllbckInt objPaciente, int idPaciente) throws RemoteException;
    public boolean enviarIndicador(int id, float ToC) throws RemoteException;
}


