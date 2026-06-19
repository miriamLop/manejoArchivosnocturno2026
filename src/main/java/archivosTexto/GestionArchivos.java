/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosTexto;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author meli
 */
public class GestionArchivos {
    //objeto de lectura
    Scanner leer=new Scanner(System.in);
    //metodos
    public void crearArchivo(){
        Path path=Paths.get("D:\\programacionII_Nocturno\\misContactos.txt");
        try {
            if(!Files.exists(path)){
                //no existe
                Files.createFile(path);
                System.out.println("Archivo creado");
            }else{
                System.out.println("El archivo ya existe");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adicionarContacto(){
      Path path=Paths.get("D:\\programacionII_Nocturno\\misContactos.txt");
      String nombre,direccion,telefono,res="S";
        try {
            if(Files.exists(path)){
                do{
                    System.out.println("Digite nombre del contacto a adicionar");
                    nombre=leer.nextLine();
                    System.out.println("digite direccion");
                    direccion=leer.nextLine();
                    System.out.println("Digite numero de telefono");
                    telefono=leer.nextLine();
                    nombre=nombre+"-"+direccion+"-"+telefono+"\n";
                    //guardar el contenido
                    Files.write(path, nombre.getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Contacto registrado");
                    System.out.println("Desea seguir agregando contactos S/N?");
                    res=leer.nextLine();
                }while(res.equalsIgnoreCase("S"));
            }else{
                System.out.println("Error, no existe el archivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
