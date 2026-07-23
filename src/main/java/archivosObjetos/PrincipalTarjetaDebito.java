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
            System.out.println("2. Salir");
            System.out.println("digite una opcion");
            opc=leer.nextInt();
            switch (opc) {
                case 1:
                    obj.registrarNuevoCliente();
                    obj.guardarObjetos();
                    break;               
                default:
                    continuar=false;
                    break;
            }
        }while(continuar);
    }
    
}
