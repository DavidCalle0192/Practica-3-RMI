/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author David Calle
 */
public class PacienteCllbckImpl extends UnicastRemoteObject implements PacienteCllbckInt
{
    private String nombres;
    private String apellidos;
    private String tipo_id;
    private int id;
    private String direccion;
    
    public PacienteCllbckImpl() throws RemoteException{
        super();
    }
    public PacienteCllbckImpl(String nombres, String apellido, String tipo_id, int id, String direccion) throws RemoteException{
        super();
    }
    
    @Override
    public void notificar(int id, float ToC) throws RemoteException{}
}
