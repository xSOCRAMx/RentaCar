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
public class CarroceriaModel {
    private int idCarroceria;
    private String nombreCarroceria;
    private String detalle;
    
    public static ArrayList<CarroceriaModel> carrocerias = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    public CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }
    
     public boolean nuevaCarroceria(CarroceriaModel nuevaCarroceria){
        int id = 0;
        
        if(!carrocerias.isEmpty()){
            for(CarroceriaModel carroceria : carrocerias){
                if(carroceria.getIdCarroceria() > id){
                    id = carroceria.getIdCarroceria();
                }
            }
        }
        id++;
        carrocerias.add(new CarroceriaModel(id, nuevaCarroceria.getNombreCarroceria(), nuevaCarroceria.getDetalle()));
        
        return true;
    }
    
    public CarroceriaModel buscarCarroceria(int id){
        CarroceriaModel carroceriaEncontrada = null;
        
        if(!carrocerias.isEmpty()){
            for(CarroceriaModel carroceria : carrocerias){
                if(carroceria.getIdCarroceria() == id){
                    carroceriaEncontrada = carroceria;
                }
            }
        }
        return carroceriaEncontrada;
    }
    
    public CarroceriaModel editarCarroceria(int id, CarroceriaModel carroceriaEditar){
         CarroceriaModel carroceriaEditada = null;
        
        if(!carrocerias.isEmpty()){
            for(CarroceriaModel carroceria : carrocerias){
                if(carroceria.getIdCarroceria() == id){
                    carroceria.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                    carroceria.setDetalle(carroceriaEditar.getDetalle());
                    carroceriaEditada = carroceria;
                }
            }
        }
        return carroceriaEditada;
    }
    
    public boolean eliminarCarroceria(int id){
        CarroceriaModel carroceriaEliminada = null;
        
        if(!carrocerias.isEmpty()){
            for(CarroceriaModel carroceria : carrocerias){
                if(carroceria.getIdCarroceria() == id){
                   carroceriaEliminada = carroceria;
                }
            }
        }
        carrocerias.remove(carroceriaEliminada);
        return true;
    }
}
