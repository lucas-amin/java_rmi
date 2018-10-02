/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.HelloWorld;/*
import java.rmi.*;

/**
 *
 * @author a1717510
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface InterfaceCli extends Remote {
    public void echo(String nome) throws RemoteException;

}


class CliImpl extends UnicastRemoteObject implements InterfaceCli {
    public Remote getServer_registry() {
        return server_registry;
    }

    public Remote server_registry;

    protected CliImpl(final int port, final Remote server_registry) throws RemoteException {
        this.server_registry = server_registry;
    }

    @Override
    public void echo(String nome) throws RemoteException {
        System.out.println(nome);
    }
}


public class Cliente_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        final int port = 1234;

        final Registry registry = LocateRegistry.getRegistry(port);

        final CliImpl cliImpl = new CliImpl(port, registry);

        while (true) {
            cliImpl.echo("sim");

            System.out.println(cliImpl.getServer_registry());
        }
    }

}
