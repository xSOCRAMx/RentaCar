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
public class VehiculoModel {
    private int idVehiculo;
    private String patente;
    private int valor;
    private int año;
    private String color;
    private TipoVehiculoModel tipoVehiculo;
    private VersionModel version;

    public static ArrayList<VehiculoModel> vehiculos = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    public VehiculoModel(int idVehiculo, String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }
    
    public boolean nuevoVehiculo(VehiculoModel nuevoVehiculo) {

        int id = 0;
        if (!vehiculos.isEmpty()) {

            for (VehiculoModel vehiculo : vehiculos) {

                if (vehiculo.getIdVehiculo() > id) {
                    id = vehiculo.getIdVehiculo();
                }

            }

        }
        id++;
        vehiculos.add(new VehiculoModel(id, nuevoVehiculo.getPatente(), nuevoVehiculo.getValor(), nuevoVehiculo.getAño(), nuevoVehiculo.getColor(), nuevoVehiculo.getTipoVehiculo(), nuevoVehiculo.getVersion()));
        return true;
    }
    
    public VehiculoModel buscarVehiculo(int idBuscar) {

        VehiculoModel vehiculoEncontrado = null;

        if (!vehiculos.isEmpty()) {
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo() == idBuscar) {
                    vehiculoEncontrado = vehiculo;
                }
            }
        }
        return vehiculoEncontrado;
    }
    
    public VehiculoModel editarVehiculo(int idEditar, VehiculoModel vehiculoEditar) {

        VehiculoModel vehiculoEditado = null;

        if (!vehiculos.isEmpty()) {
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo() == idEditar) {
                    vehiculo.setPatente(vehiculoEditar.getPatente());
                    vehiculo.setValor(vehiculoEditar.getValor());
                    vehiculo.setAño(vehiculoEditar.getAño());
                    vehiculo.setColor(vehiculoEditar.getColor());
                    vehiculo.setTipoVehiculo(vehiculoEditar.getTipoVehiculo());
                    vehiculo.setVersion(vehiculoEditar.getVersion());
                    vehiculoEditado = vehiculo;
                }
            }
        }
        return vehiculoEditado;
    }
    
    public boolean eliminarVehiculo(int idEliminar) {

        VehiculoModel vehiculoEliminar = null;

        if (!vehiculos.isEmpty()) {
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo()== idEliminar) {
                    vehiculoEliminar = vehiculo;
                }
            }
        }

        vehiculos.remove(vehiculoEliminar);
        return true;
    }
}
