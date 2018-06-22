/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VehiculoModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    
    @GetMapping()
    public List<VehiculoModel> list() {
        return VehiculoModel.vehiculos;
    }
    
     @GetMapping("/{id}")
    public VehiculoModel get(@PathVariable String id) {
        VehiculoModel vehiculo = new VehiculoModel();
        return vehiculo.buscarVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VehiculoModel VehiculoEditar) {
        VehiculoModel vehiculo = new VehiculoModel();
        vehiculo.editarVehiculo(Integer.parseInt(id), VehiculoEditar);
        return new ResponseEntity<>(vehiculo.editarVehiculo(Integer.parseInt(id), vehiculo), HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VehiculoModel nuevoVehiculo) {
                VehiculoModel vehiculo = new VehiculoModel();
        if (vehiculo.nuevoVehiculo(nuevoVehiculo)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VehiculoModel vehiculo = new VehiculoModel();
        if (vehiculo.eliminarVehiculo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
