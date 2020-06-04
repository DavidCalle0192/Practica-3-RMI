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
    public void notificar(int id, float ToC) throws RemoteException{
        System.out.println("El paciente "+nombres+" "+apellidos
                +" identificado "+tipo_id+" "+id+" presenta una T oC de "+ToC+" la cual está fuera del rango normal");
    }

    
    
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}



