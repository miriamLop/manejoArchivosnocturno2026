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
public class TarjetaDebito implements Serializable{
    //atributos
    private int numeroTarjeta;
    private int nroCuenta;
    private double saldo;
    private String estado;
    // no se debe definir el objeto de lectura
    

    
    
    //metodos
    public void mostrarTarjeta(){
        System.out.println("Nro. Tarjeta: "+this.numeroTarjeta);
        System.out.println("Nro. cuenta: "+this.nroCuenta);
        System.out.println("saldo: "+this.saldo);
        System.out.println("Esado: "+this.estado);
    }
    //getter y setter

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
