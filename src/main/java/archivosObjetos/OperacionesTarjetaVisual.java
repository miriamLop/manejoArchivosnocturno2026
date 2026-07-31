/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosObjetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC29
 */
public class OperacionesTarjetaVisual {
    List<Cliente> listaClientes;
    //constructor

    public OperacionesTarjetaVisual() {
        listaClientes=new ArrayList<>();
    }
    //metodos
    public void registrarCliente(String nombre,String cedula,int nCuenta,int nTarjeta, double saldo){
        Cliente cli=new Cliente(nombre, cedula);
        TarjetaDebito tar=new TarjetaDebito(nTarjeta, nCuenta, saldo);
        //adicionando la agregacion entre cliente y TarjetaDebito
        cli.setTarjeta(tar);
        //adicionar a la lista
        listaClientes.add(cli);
        System.out.println("Cliente registrado");
                
    }
    
    
}
