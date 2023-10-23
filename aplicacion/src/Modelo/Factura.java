/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 * Crea una nueva clase de tipo Factura que tendrá unos atributos específicos.
 * @author grupo2
 */
public class Factura {
    private int numFactura;
    private Alquiler Alquiler;
    private String tipofactura;
    private double igv;
    private double totalpago;
    private Date fechaEmision;
    private Date fechapago;

    public Factura() {
    }

    public Factura(int numFactura, Alquiler Alquiler, String tipofactura, double igv, double totalpago, Date fechaEmision, Date fechapago) {
        this.numFactura = numFactura;
        this.Alquiler = Alquiler;
        this.tipofactura = tipofactura;
        this.igv = igv;
        this.totalpago = totalpago;
        this.fechaEmision = fechaEmision;
        this.fechapago = fechapago;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Alquiler getAlquiler() {
        return Alquiler;
    }

    public void setAlquiler(Alquiler Alquiler) {
        this.Alquiler = Alquiler;
    }

    public String getTipofactura() {
        return tipofactura;
    }

    public void setTipofactura(String tipofactura) {
        this.tipofactura = tipofactura;
    }

    public double getigv() {
        return igv;
    }

    public void setigv(double igv) {
        this.igv = igv;
    }

    public double getTotalpago() {
        return totalpago;
    }

    public void settotalpago(double totalpago) {
        this.totalpago = totalpago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setfechapago(Date fechapago) {
        this.fechapago = fechapago;
    }
  
}
