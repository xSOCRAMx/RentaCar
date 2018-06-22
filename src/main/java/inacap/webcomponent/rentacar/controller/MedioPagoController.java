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

import inacap.webcomponent.rentacar.model.MedioPagoModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/mediospago")
public class MedioPagoController {
    
    @GetMapping()
    public List<MedioPagoModel> list() {
        return MedioPagoModel.mediospago;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        MedioPagoModel mediopago = new MedioPagoModel();
        return mediopago.buscarMedioPago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody MedioPagoModel medioPagoEditar) {
       MedioPagoModel mediopago = new MedioPagoModel();
       return new ResponseEntity<>(mediopago.editarMedioPago(Integer.parseInt(id), medioPagoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoMedioPago) {
        MedioPagoModel mediopago = new MedioPagoModel();
        if(mediopago.nuevoMedioPago(nuevoMedioPago))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MedioPagoModel mediopago = new MedioPagoModel();
        
        if(mediopago.eliminarMedioPago(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
