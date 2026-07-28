/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosObjetos;

import java.util.Scanner;

/**
 *
 * @author Lab IV Incos La Paz
 */
public class PrincipalTarjetaDebito {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        OperacionesTarjeta obj=new OperacionesTarjeta();
        int opc;
        boolean continuar=true;
        do{
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Registrar cliente - Tarjeta debito");           
            System.out.println("2. mostrar todos los clientes");
            System.out.println("3. Deposito de dinero");
            System.out.println("4. salir");
            System.out.println("digite una opcion");
            opc=leer.nextInt();
            switch (opc) {
                case 1:
                    obj.registrarNuevoCliente();
                    obj.guardarObjetos();
                    break;   
                case 2:
                    obj.leerClientes();
                    obj.mostrarClientes();
                    break;
                case 3:
                    obj.leerClientes();
                    obj.deposito();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar=false;
                    break;
            }
        }while(continuar);
    }
    
}
