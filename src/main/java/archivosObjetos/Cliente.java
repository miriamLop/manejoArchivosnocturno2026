/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosObjetos;

import java.io.Serializable;

/**
 *
 * @author Lab IV Incos La Paz
 */
public class Cliente implements Serializable{
    //atributos
    private String nombreCompleto;
    private String nroCedula;
    //por la relacion de agregacion de multiplicidad 1 a 1
    private TarjetaDebito tarjeta;
    //constructor

    
    
    //metodos
    public void mostrarCliente(){
        System.out.println("nombre completo: "+this.nombreCompleto);
        System.out.println("Nro. cedula: "+this.nroCedula);
        if(tarjeta!=null){
            System.out.println("-- DATOS TARJETA DE DEBITO --");
            tarjeta.mostrarTarjeta();
        }
    }
    //getter y setter

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(String nroCedula) {
        this.nroCedula = nroCedula;
    }

    public TarjetaDebito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDebito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
}
