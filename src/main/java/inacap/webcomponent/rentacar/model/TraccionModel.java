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
public class TraccionModel {
    private int idTraccion;
    private String nombreTraccion;
    private String detalle;
    
    public static ArrayList<TraccionModel> tracciones = new ArrayList<>();

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String detalle) {
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

    public TraccionModel(int idTraccion, String nombreTraccion, String detalle) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }
    
     public boolean nuevaTraccion(TraccionModel nuevaTraccion){
        int id = 0;
        
        if(!tracciones.isEmpty()){
            for(TraccionModel traccion : tracciones){
                if(traccion.getIdTraccion() > id){
                    id = traccion.getIdTraccion();
                }
            }
        }
        id++;
        tracciones.add(new TraccionModel(id, nuevaTraccion.getNombreTraccion(), nuevaTraccion.getDetalle()));
        
        return true;
    }
    
    public TraccionModel buscarTraccion(int id){
        TraccionModel traccionEncontrada = null;
        
        if(!tracciones.isEmpty()){
            for(TraccionModel traccion : tracciones){
                if(traccion.getIdTraccion() == id){
                    traccionEncontrada = traccion;
                }
            }
        }
        return traccionEncontrada;
    }
    
    public TraccionModel editarTraccion(int id, TraccionModel traccionEditar){
         TraccionModel traccionEditada = null;
        
        if(!tracciones.isEmpty()){
            for(TraccionModel traccion : tracciones){
                if(traccion.getIdTraccion() == id){
                    traccion.setNombreTraccion(traccionEditar.getNombreTraccion());
                    traccion.setDetalle(traccionEditar.getDetalle());
                    traccionEditada = traccion;
                }
            }
        }
        return traccionEditada;
    }
    
    public boolean eliminarTraccion(int id){
        TraccionModel traccionEliminada = null;
        
        if(!tracciones.isEmpty()){
            for(TraccionModel traccion : tracciones){
                if(traccion.getIdTraccion() == id){
                   traccionEliminada = traccion;
                }
            }
        }
        tracciones.remove(traccionEliminada);
        return true;
    }
}
