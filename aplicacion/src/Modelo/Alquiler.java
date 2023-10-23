/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 * Crea una nueva clase de tipo Alquiler que tendrá unos atributos específicos.
 * @author grupo2
 */
public class Alquiler {
    private int idalquiler;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Trabajador trabajador;
    private Extras extra;
    private String tipoTarifa;
    private Date fechaAlquiler;
    private Date fechaRecogida;
    private Date fechaDevolucion;
    private double costoAlquiler;
    private String estado;

    public Alquiler() {
    }

    public Alquiler(int idalquiler, Vehiculo vehiculo, Cliente cliente, Trabajador trabajador, Extras extra, String tipoTarifa,Date fechaAlquiler, Date fechaRecogida, Date fechaDevolucion, double costoAlquiler, String estado) {
        this.idalquiler = idalquiler;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.trabajador = trabajador;
        this.extra = extra;
        this.tipoTarifa = tipoTarifa;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaRecogida = fechaRecogida;
        this.fechaDevolucion = fechaDevolucion;
        this.costoAlquiler = costoAlquiler;
        this.estado = estado;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public int getIdAlquiler() {
        return idalquiler;
    }

    public void setidalquiler(int idalquiler) {
        this.idalquiler = idalquiler;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public String getEstado() {
        return estado;
    }

    public Extras getExtra() {
        return extra;
    }

    public void setExtra(Extras extra) {
        this.extra = extra;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
       
}
