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
@Table(name="Region")
public class RegionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegion;
    
    private String nombreRegion;
    
    private String detalle;
    


    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
     public RegionModel() {
    }

    public RegionModel(String nombreRegion, String detalle) {
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }

    public RegionModel(int idRegion, String nombreRegion, String detalle) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }
    
    @Override
    public String toString() {
        return "AlumnoModel{" + "idRegion=" + idRegion + ", nombreRegion=" + nombreRegion + ", detalle=" + detalle + '}';
    }
}
