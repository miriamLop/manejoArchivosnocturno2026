/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosObjetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lab IV Incos La Paz
 */
public class OperacionesTarjeta {

    List<Cliente> listaClientes;
    //objeto de lectura
    Scanner leer = new Scanner(System.in);
    //constructor

    public OperacionesTarjeta() {
        listaClientes = new ArrayList<>();
    }

    //metodos
    public void registrarNuevoCliente() {
        Cliente cli = new Cliente();
        //solicitando datos del cliente
        //limpiando el buffer
        leer.nextLine();
        System.out.println("digite nombre completo");
        cli.setNombreCompleto(leer.nextLine());
        System.out.println("Digite nro. de cedula");
        cli.setNroCedula(leer.nextLine());
        //llenado los datos de la tarjeta de debito y cuenta
        TarjetaDebito tarjeta = new TarjetaDebito();
        System.out.println("Digite nro. cuenta bancaria");
        tarjeta.setNroCuenta(leer.nextInt());
        System.out.println("Digite nro. de tarjeta");
        tarjeta.setNumeroTarjeta(leer.nextInt());
        System.out.println("Digite monto a depositar");
        tarjeta.setSaldo(leer.nextDouble());
        tarjeta.setEstado("ACTIVO");
        //relacionar el cliente con su tarjeta de debito
        cli.setTarjeta(tarjeta);
        //adicionar a la lista
        listaClientes.add(cli);
        System.out.println("- DATOS REGISTRADOS CORRECTAMENTE -");
    }

    public void mostrarClientes() {
        if (!listaClientes.isEmpty()) {
            System.out.println(" - LISTA DE CLIENTES -");
            for (Cliente cli : listaClientes) {
                cli.mostrarCliente();
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("no se tiene clientes registrados");
        }
    }

    //guardando la lista de objetos al archivo
    public void guardarObjetos() {
        String ruta = "D:\\programacion\\clientes.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaClientes);
            oos.close();
            archivo.close();
            System.out.println("Registros guardados");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            // Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//cargando los objetos de los clientes
    public void leerClientes() {
        String ruta = "D:\\programacion\\clientes.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                //casteando de una clase Object a List<Cliente>
                listaClientes = (List<Cliente>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            // Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            // Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            // Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deposito() {
        int sw = 0;
        String ci;
        double monto;
        if (!listaClientes.isEmpty()) {
            System.out.println("Digite su numero de cedula");
            ci = leer.nextLine();
            for (Cliente c : listaClientes) {
                if (c.getNroCedula().equalsIgnoreCase(ci)) {
                    sw = 1;
                    if (c.getTarjeta().getEstado().equalsIgnoreCase("ACTIVO")) {
                        do {
                            System.out.println("Digite monto a depositar");
                            monto = leer.nextDouble();
                        } while (monto <= 0);
                        //actualizar su saldo
                        c.getTarjeta().setSaldo(c.getTarjeta().getSaldo() + monto);
                        System.out.println("Deposito realizado");
                        System.out.println("Saldo actual: " + c.getTarjeta().getSaldo());
                    }else{
                        System.out.println("La tarjeta esta INACTIVA, comuniquese con el Banco");
                    }
                }
            }
            if (sw == 0) {
                System.out.println("no se encontro al cliente");
            }
        } else {
            System.out.println("No se tiene clientes registrados");
        }

    }
    public void bloquearTarjeta(){
        String ci,res;
        int sw=0;
        if(!listaClientes.isEmpty()){
            System.out.println("digite el numero de cedula del cliente");
            ci=leer.nextLine();
            for(Cliente c:listaClientes){
                if(c.getNroCedula().equalsIgnoreCase(ci)){
                    sw=1;
                    if(c.getTarjeta().getEstado().equalsIgnoreCase("ACTIVO")){
                        System.out.println("Dsea bloquear su tarjeta de debito s/n");
                        res=leer.nextLine();
                        if(res.equalsIgnoreCase("S")){
                            c.getTarjeta().setEstado("INACTIVO");
                            System.out.println("Tarjeta: "+c.getTarjeta().getNumeroTarjeta()+ "BLOQUEADO");
                        }else{
                            System.out.println("¡Operacion cancelada!");
                        }
                    }else{
                        System.out.println("La tarjeta ya esta BLOQUEADA");
                    }
                }
            }
            if(sw==0){
                System.out.println("no se tiene registrado al cliente");
            }
        }else{
            System.out.println("no se tiene clientes registrados");
        }
    }

}
