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

import inacap.webcomponent.rentacar.model.TransmisionModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/transmisiones")
public class TransmisionController {
    
    @GetMapping()
    public List<TransmisionModel> list() {
        return TransmisionModel.transmisiones;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        TransmisionModel transmision = new TransmisionModel();
        return transmision.buscarTransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        TransmisionModel transmision = new TransmisionModel();
       return new ResponseEntity<>(transmision.editarTransmision(Integer.parseInt(id), transmisionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TransmisionModel nuevaTransmision) {
        TransmisionModel transmision = new TransmisionModel();
        if(transmision.nuevaTransmision(nuevaTransmision))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TransmisionModel transmision = new TransmisionModel();
        
        if(transmision.eliminarTranmision(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
