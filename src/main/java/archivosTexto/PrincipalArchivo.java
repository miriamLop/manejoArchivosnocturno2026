/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosTexto;

import java.util.Scanner;

/**
 *
 * @author meli
 */
public class PrincipalArchivo {
    public static void main(String[] args) {
        GestionArchivos obj=new GestionArchivos();
        Scanner leer=new Scanner(System.in);
        boolean continuar=true;
        int opc;
        do{
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear archivo");
            System.out.println("2. Adicionar contenido");
            System.out.println("3. Salir");
            System.out.println("digite una opcion");
            opc=leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.adicionarContacto();
                    break;
                default:
                    continuar=false;
                    break;
            }
        }while(continuar);
    }
    
}
