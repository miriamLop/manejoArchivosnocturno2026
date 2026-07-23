/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosTexto;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author meli
 */
public class GestionArchivos {
     //defincion de lista
    List<String> listaContactos;
    //objeto de lectura
    Scanner leer=new Scanner(System.in);
     
   
    //constructor

    public GestionArchivos() {
        listaContactos = new ArrayList<>();
    }
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
    public void mostrarContenido() {
        Path path = Paths.get("D:\\programacion\\misContactos.txt");
        try {
            if (Files.exists(path)) {
                listaContactos = Files.readAllLines(path);
                if (!listaContactos.isEmpty()) {
                    for (String linea : listaContactos) {
                        System.out.println(linea);
                    }
                }else{
                    System.out.println("el archivo esta vacio");
                }
            } else {
                System.out.println("no existe el archivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void buscarContacto(){
        String nomContacto;
        int sw=0;
        String vector[];
         Path path = Paths.get("D:\\programacion\\misContactos.txt");
         try {
            if(Files.exists(path)){
                listaContactos=Files.readAllLines(path);
                if(!listaContactos.isEmpty()){
                    System.out.println("digite nombre de contacto a buscar");
                    nomContacto=leer.nextLine();
                    for(String linea:listaContactos){
                        vector=linea.split("-");
                        if(nomContacto.equalsIgnoreCase(vector[0])){
                            sw=1;
                            System.out.println("---- CONTACTO ENCONTRADO ----");
                            System.out.println("Nombre: "+vector[0]);
                            System.out.println("direccion: "+vector[1]);
                            System.out.println("Nro. celular: "+vector[2]);
                            System.out.println("--------------------------------");
                        }
                    }
                    if(sw==0){
                        System.out.println("El contacto buscado, no esta registrado");
                    }
                }else{
                    System.out.println("el archivo esta vacio");
                }
            }else{
                System.out.println("el archivo no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
