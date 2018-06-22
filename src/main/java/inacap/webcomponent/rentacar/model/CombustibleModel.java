/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CombustibleModel {
    private int idCombustible;
    private String tipoCombustible;
    private String detalle;
    
    public static ArrayList<CombustibleModel> combustibles = new ArrayList<>();

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
    
    public boolean nuevoCombustible(CombustibleModel nuevoCombustible){
        int id = 0;
        
        if(!combustibles.isEmpty()){
            for(CombustibleModel marca : combustibles){
                if(marca.getIdCombustible() > id){
                    id = marca.getIdCombustible();
                }
            }
        }
        id++;
        combustibles.add(new CombustibleModel(id, nuevoCombustible.getTipoCombustible(), nuevoCombustible.getDetalle()));
        
        return true;
    }
    
    public CombustibleModel buscarCombustible(int id){
        CombustibleModel combustibleEncontrado = null;
        
        if(!combustibles.isEmpty()){
            for(CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == id){
                    combustibleEncontrado = combustible;
                }
            }
        }
        return combustibleEncontrado;
    }
    
    public CombustibleModel editarCombustible(int id, CombustibleModel combustibleEditar){
         CombustibleModel combustibleEditado = null;
        
        if(!combustibles.isEmpty()){
            for(CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == id){
                    combustible.setTipoCombustible(combustibleEditar.getTipoCombustible());
                    combustible.setDetalle(combustibleEditar.getDetalle());
                    combustibleEditado = combustible;
                }
            }
        }
        return combustibleEditado;
    }
    
    public boolean eliminarCombustible(int id){
        CombustibleModel combustibleEliminado = null;
     
        if(!combustibles.isEmpty()){
            for(CombustibleModel combustible : combustibles){
                if(combustible.getIdCombustible() == id){
                   combustibleEliminado = combustible;
                }
            }
        }
        combustibles.remove(combustibleEliminado);
        return true;
    }
}
