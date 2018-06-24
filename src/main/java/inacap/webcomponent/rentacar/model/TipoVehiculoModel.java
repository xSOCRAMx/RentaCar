/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name="TipoVehiculo")
public class TipoVehiculoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoVehiculo;
    
    private String nombreTipoVehiculo;
    
    private String detalle;
    


    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    public TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }
    
    @Override
    public String toString() {
        return "TipoVehiculo{" + "idTipoVehiculo=" + idTipoVehiculo + ", nombreTipoVehiculo=" + nombreTipoVehiculo + ", detalle=" + detalle + '}';
    }
}
