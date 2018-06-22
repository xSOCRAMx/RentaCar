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
public class MedioPagoModel {
    private int idMedioPago;
    private String nombreMedioPago;
    private String detalle;
    
    public static ArrayList<MedioPagoModel> mediospago = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    public MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }
    
    public boolean nuevoMedioPago(MedioPagoModel nuevoMedioPago){
        int id = 0;
        
        if(!mediospago.isEmpty()){
            for(MedioPagoModel mediopago : mediospago){
                if(mediopago.getIdMedioPago() > id){
                    id = mediopago.getIdMedioPago();
                }
            }
        }
        id++;
        mediospago.add(new MedioPagoModel(id, nuevoMedioPago.getNombreMedioPago(), nuevoMedioPago.getDetalle()));
        
        return true;
    }
    
    public MedioPagoModel buscarMedioPago(int id){
        MedioPagoModel medioPagoEncontrado = null;
        
        if(!mediospago.isEmpty()){
            for(MedioPagoModel mediopago : mediospago){
                if(mediopago.getIdMedioPago() == id){
                    medioPagoEncontrado = mediopago;
                }
            }
        }
        return medioPagoEncontrado;
    }
    
    public MedioPagoModel editarMedioPago(int id, MedioPagoModel medioPagoEditar){
         MedioPagoModel medioPagoEditado = null;
        
        if(!mediospago.isEmpty()){
            for(MedioPagoModel mediopago : mediospago){
                if(mediopago.getIdMedioPago() == id){
                    mediopago.setNombreMedioPago(medioPagoEditar.getNombreMedioPago());
                    mediopago.setDetalle(medioPagoEditar.getDetalle());
                    medioPagoEditado = mediopago;
                }
            }
        }
        return medioPagoEditado;
    }
    
    public boolean eliminarMedioPago(int id){
        MedioPagoModel medioPagoEliminado = null;
        
        if(!mediospago.isEmpty()){
            for(MedioPagoModel mediopago : mediospago){
                if(mediopago.getIdMedioPago() == id){
                   medioPagoEliminado = mediopago;
                }
            }
        }
        mediospago.remove(medioPagoEliminado);
        return true;
    }
}
