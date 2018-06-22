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
public class CiudadModel {
    private int idCiudad;
    private String nombreCiudad;
    private String Detalle;
    private RegionModel region;
    
    
    public static ArrayList<CiudadModel> ciudades = new ArrayList<>();

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String Detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.Detalle = Detalle;
        this.region = region;
    }

    public CiudadModel(int idCiudad, String nombreCiudad, String Detalle, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.Detalle = Detalle;
        this.region = region;
    }

    public boolean nuevaCiudad(CiudadModel nuevaCiudad){
        int id = 0;
        
        if(!ciudades.isEmpty()){
            for(CiudadModel ciudad : ciudades){
                if(ciudad.getIdCiudad() > id){
                    id = ciudad.getIdCiudad();
                }
            }
        }
        id++;
        ciudades.add(new CiudadModel(id, nuevaCiudad.getNombreCiudad(), nuevaCiudad.getDetalle(), nuevaCiudad.getRegion()));
        
        return true;
    }
    
    public CiudadModel buscarCiudad(int id){
        CiudadModel ciudadEncontrada = null;
        
        if(!ciudades.isEmpty()){
            for(CiudadModel ciudad : ciudades){
                if(ciudad.getIdCiudad() == id){
                    ciudadEncontrada = ciudad;
                }
            }
        }
        return ciudadEncontrada;
    }
    
    public CiudadModel editarCiudad(int id, CiudadModel ciudadEditar){
         CiudadModel ciudadEditada = null;
        
        if(!ciudades.isEmpty()){
            for(CiudadModel ciudad : ciudades){
                if(ciudad.getIdCiudad() == id){
                    ciudad.setNombreCiudad(ciudadEditar.getNombreCiudad());
                    ciudad.setDetalle(ciudadEditar.getDetalle());
                    ciudad.setRegion(ciudadEditar.getRegion());
                    ciudadEditada = ciudad;
                }
            }
        }
        return ciudadEditada;
    }
    
    public boolean eliminarCiudad(int id){
        CiudadModel ciudadEliminada = null;

        if(!ciudades.isEmpty()){
            for(CiudadModel ciudad : ciudades){
                if(ciudad.getIdCiudad() == id){
                   ciudadEliminada = ciudad;
                }
            }
        }
        ciudades.remove(ciudadEliminada);
        return true;
    }
}
