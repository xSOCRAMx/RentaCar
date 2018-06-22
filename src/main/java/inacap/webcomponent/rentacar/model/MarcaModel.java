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
public class MarcaModel {
    private int idMarca;
    private String nombreMarca;
    private String detalle;
    
    public static ArrayList<MarcaModel> marcas = new ArrayList<>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    public MarcaModel(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }
    
     public boolean nuevaMarca(MarcaModel nuevaMarca){
        int id = 0;
        
        if(!marcas.isEmpty()){
            for(MarcaModel marca : marcas){
                if(marca.getIdMarca() > id){
                    id = marca.getIdMarca();
                }
            }
        }
        id++;
        marcas.add(new MarcaModel(id, nuevaMarca.getNombreMarca(), nuevaMarca.getDetalle()));
        
        return true;
    }
    
    public MarcaModel buscarMarca(int id){
        MarcaModel marcaEncontrada = null;
        
        if(!marcas.isEmpty()){
            for(MarcaModel marca : marcas){
                if(marca.getIdMarca() == id){
                    marcaEncontrada = marca;
                }
            }
        }
        return marcaEncontrada;
    }
    
    public MarcaModel editarMarca(int id, MarcaModel marcaEditar){
         MarcaModel marcaEditada = null;
        
        if(!marcas.isEmpty()){
            for(MarcaModel marca : marcas){
                if(marca.getIdMarca() == id){
                    marca.setNombreMarca(marcaEditar.getNombreMarca());
                    marca.setDetalle(marcaEditar.getDetalle());
                    marcaEditada = marca;
                }
            }
        }
        return marcaEditada;
    }
    
    public boolean eliminarMarca(int id){
        MarcaModel marcaEliminada = null;
        //#TODO
        //revisar si la marca esta siendo usada antes de eliminarla (cascada en la BD)
                
        if(!marcas.isEmpty()){
            for(MarcaModel marca : marcas){
                if(marca.getIdMarca() == id){
                   marcaEliminada = marca;
                }
            }
        }
        marcas.remove(marcaEliminada);
        return true;
    }
}
