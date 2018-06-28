/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.TipoVehiculoRepository;
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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/tipovehiculos")
public class TipoVehiculoController {
    
    @Autowired
    private TipoVehiculoRepository  tipovehiculoRespository;
    
    
    @GetMapping()
    public Iterable<TipoVehiculoModel> listarTodos() {
        
        return tipovehiculoRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> muestraUnTipoVehiculo(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> aOptional = tipovehiculoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> editaTipoVehiculo(@PathVariable String id, @RequestBody TipoVehiculoModel tipovehiculoEditar) {
        
        Optional<TipoVehiculoModel> aOptional = tipovehiculoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            TipoVehiculoModel aEncontrado = aOptional.get();
            
            tipovehiculoEditar.setIdTipoVehiculo(aEncontrado.getIdTipoVehiculo());
            
            tipovehiculoRespository.save(tipovehiculoEditar);
            
            return new ResponseEntity<>(tipovehiculoEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTipoVehiculo(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
      
        nuevoTipoVehiculo = tipovehiculoRespository.save(nuevoTipoVehiculo);
        
        Optional<TipoVehiculoModel> aOptional = tipovehiculoRespository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> aOptional = tipovehiculoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            tipovehiculoRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}
