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
@Table(name="Combustible")
public class CombustibleModel {
    
    private int idCombustible;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tipoCombustible;
    
    private String detalle;
    


    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String tipoCombustible, String detalle) {
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    public CombustibleModel(int idCombustible, String tipoCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }
    @Override
    public String toString() {
        return "CombustibleModel{" + "idCombustible=" + idCombustible + ", tipoCombustible=" + tipoCombustible + ", detalle=" + detalle + '}';
    } 
   
}
