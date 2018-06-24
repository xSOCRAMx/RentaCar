/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class ModeloModel {
    private int idModelo;
    private String nombreModelo;
    private String detalle;
    private MarcaModel marca;
    
    public static ArrayList<ModeloModel> modelos = new ArrayList<>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }

    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalle, MarcaModel marca) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    public ModeloModel(int idModelo, String nombreModelo, String detalle, MarcaModel marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }
    
    public boolean nuevoModelo(ModeloModel nuevoModelo){
        int id = 0;
        
        if(!modelos.isEmpty()){
            for(ModeloModel modelo : modelos){
                if(modelo.getIdModelo() > id){
                    id = modelo.getIdModelo();
                }
            }
        }
        id++;
        modelos.add(new ModeloModel(id, nuevoModelo.getNombreModelo(), nuevoModelo.getDetalle(), nuevoModelo.getMarca()));
        
        return true;
    }
    
    public ModeloModel buscarModelo(int id){
        ModeloModel modeloEncontrado = null;
        
        if(!modelos.isEmpty()){
            for(ModeloModel modelo : modelos){
                if(modelo.getIdModelo() == id){
                    modeloEncontrado = modelo;
                }
            }
        }
        return modeloEncontrado;
    }
    
    public ModeloModel editarModelo(int id, ModeloModel modeloEditar){
         ModeloModel modeloEditado = null;
        
        if(!modelos.isEmpty()){
            for(ModeloModel modelo : modelos){
                if(modelo.getIdModelo() == id){
                    modelo.setNombreModelo(modeloEditar.getNombreModelo());
                    modelo.setDetalle(modeloEditar.getDetalle());
                    modeloEditado = modelo;
                }
            }
        }
        return modeloEditado;
    }
    
    public boolean eliminarModelo(int id){
        ModeloModel modeloEliminado = null;
        
        if(!modelos.isEmpty()){
            for(ModeloModel modelo : modelos){
                if(modelo.getIdModelo() == id){
                   modeloEliminado = modelo;
                }
            }
        }
        modelos.remove(modeloEliminado);
        return true;
    }
}
