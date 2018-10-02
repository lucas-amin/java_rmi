package com.company.HelloWorld;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author a1717510
 */

interface InterfaceServ extends Remote {
    public void chamar(final String nome, final Remote interface_cli_reference) throws RemoteException;

}



class ServImpl extends UnicastRemoteObject implements InterfaceServ {

    ServImpl(final int port) throws RemoteException {
        super(port);
    }

    public void chamar(final String nome, final Remote interface_cli_reference) {
    }
}


public class Servidor_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        // TODO code application logic here
        int port = 1234;

        final Registry registry = LocateRegistry.createRegistry(port);

        final ServImpl servImpl = new ServImpl(port);

        registry.bind("servImpl", servImpl);

    }
}
