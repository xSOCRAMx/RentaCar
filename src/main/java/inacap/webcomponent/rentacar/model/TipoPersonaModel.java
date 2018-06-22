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
public class TipoPersonaModel {
    private int idPersona;
    private String nombreTipoPersona;
    private String detalle; 
    
    public static ArrayList<TipoPersonaModel> tipopersonas = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    public TipoPersonaModel(int idPersona, String nombreTipoPersona, String detalle) {
        this.idPersona = idPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }
    
      public boolean nuevoTipoPersona(TipoPersonaModel nuevoTipoPersona){
        int id = 0;
        
        if(!tipopersonas.isEmpty()){
            for(TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona() > id){
                    id = tipopersona.getIdPersona();
                }
            }
        }
        id++;
        tipopersonas.add(new TipoPersonaModel(id, nuevoTipoPersona.getNombreTipoPersona(), nuevoTipoPersona.getDetalle()));
        
        return true;
    }
    
    public TipoPersonaModel buscaTipoPersona(int id){
        TipoPersonaModel tipoPersonaEncontrada = null;
        
        if(!tipopersonas.isEmpty()){
            for(TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona() == id){
                    tipoPersonaEncontrada = tipopersona;
                }
            }
        }
        return tipoPersonaEncontrada;
    }
    
    public TipoPersonaModel editarTipoPersona(int id, TipoPersonaModel tipoPersonaEditar){
         TipoPersonaModel tipoPersonaEditada = null;
        
        if(!tipopersonas.isEmpty()){
            for(TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona() == id){
                    tipopersona.setNombreTipoPersona(tipoPersonaEditar.getNombreTipoPersona());
                    tipopersona.setDetalle(tipoPersonaEditar.getDetalle());
                    tipoPersonaEditada = tipopersona;
                }
            }
        }
        return tipoPersonaEditada;
    }
    
    public boolean eliminarTipoPersona(int id){
        TipoPersonaModel tipoPersonaEliminada = null;
        
        if(!tipopersonas.isEmpty()){
            for(TipoPersonaModel tipopersona : tipopersonas){
                if(tipopersona.getIdPersona() == id){
                   tipoPersonaEliminada = tipopersona;
                }
            }
        }
        tipopersonas.remove(tipoPersonaEliminada);
        return true;
    }
}