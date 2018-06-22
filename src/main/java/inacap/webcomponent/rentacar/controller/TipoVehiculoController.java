/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import inacap.webcomponent.rentacar.model.TipoVehiculoModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/tipovehiculos")
public class TipoVehiculoController {
    
    @GetMapping()
    public List<TipoVehiculoModel> list() {
        return TipoVehiculoModel.tipovehiculos;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
         TipoVehiculoModel tipovehiculo = new TipoVehiculoModel();
        return tipovehiculo.buscarTipoVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVehiculoEditar) {
        TipoVehiculoModel tipovehiculo = new TipoVehiculoModel();
       return new ResponseEntity<>(tipovehiculo.editarTipoVehiculo(Integer.parseInt(id), tipoVehiculoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
        TipoVehiculoModel tipovehiculo = new TipoVehiculoModel();
        if(tipovehiculo.nuevoTipoVehiculo(nuevoTipoVehiculo))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TipoVehiculoModel tipovehiculo = new TipoVehiculoModel();
        
        if(tipovehiculo.eliminarTipoVehiculo(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
