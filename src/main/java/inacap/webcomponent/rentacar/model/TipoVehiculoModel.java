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
public class TipoVehiculoModel {
    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;
    
    public static ArrayList<TipoVehiculoModel> tipovehiculos = new ArrayList<>();

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
    
    public boolean nuevoTipoVehiculo(TipoVehiculoModel nuevoTipoVehiculo){
        int id = 0;
        
        if(!tipovehiculos.isEmpty()){
            for(TipoVehiculoModel tipovehiculo : tipovehiculos){
                if(tipovehiculo.getIdTipoVehiculo() > id){
                    id = tipovehiculo.getIdTipoVehiculo();
                }
            }
        }
        id++;
        tipovehiculos.add(new TipoVehiculoModel(id, nuevoTipoVehiculo.getNombreTipoVehiculo(), nuevoTipoVehiculo.getDetalle()));
        
        return true;
    }
    
    public TipoVehiculoModel buscarTipoVehiculo(int id){
        TipoVehiculoModel tipoVehiculoEncontrado = null;
        
        if(!tipovehiculos.isEmpty()){
            for(TipoVehiculoModel tipovehiculo : tipovehiculos){
                if(tipovehiculo.getIdTipoVehiculo() == id){
                    tipoVehiculoEncontrado = tipovehiculo;
                }
            }
        }
        return tipoVehiculoEncontrado;
    }
    
    public TipoVehiculoModel editarTipoVehiculo(int id, TipoVehiculoModel tipoVehiculoEditar){
         TipoVehiculoModel tipoVehiculoEditado = null;
        
        if(!tipovehiculos.isEmpty()){
            for(TipoVehiculoModel tipovehiculo : tipovehiculos){
                if(tipovehiculo.getIdTipoVehiculo() == id){
                    tipovehiculo.setNombreTipoVehiculo(tipoVehiculoEditar.getNombreTipoVehiculo());
                    tipovehiculo.setDetalle(tipoVehiculoEditar.getDetalle());
                    tipoVehiculoEditado = tipovehiculo;
                }
            }
        }
        return tipoVehiculoEditado;
    }
    
    public boolean eliminarTipoVehiculo(int id){
        TipoVehiculoModel tipoVehiculoEliminado = null;
        
        if(!tipovehiculos.isEmpty()){
            for(TipoVehiculoModel tipovehiculo : tipovehiculos){
                if(tipovehiculo.getIdTipoVehiculo() == id){
                   tipoVehiculoEliminado = tipovehiculo;
                }
            }
        }
        tipovehiculos.remove(tipoVehiculoEliminado);
        return true;
    }
}
