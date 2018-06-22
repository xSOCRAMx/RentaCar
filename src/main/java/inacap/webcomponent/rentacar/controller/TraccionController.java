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

import inacap.webcomponent.rentacar.model.TraccionModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/tracciones")
public class TraccionController {
    
    @GetMapping()
    public List<TraccionModel> list() {
        return TraccionModel.tracciones;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        TraccionModel traccion = new TraccionModel();
        return traccion.buscarTraccion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
       TraccionModel traccion = new TraccionModel();
       return new ResponseEntity<>(traccion.editarTraccion(Integer.parseInt(id), traccionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TraccionModel nuevaTraccion) {
       TraccionModel traccion = new TraccionModel();
        if(traccion.nuevaTraccion(nuevaTraccion))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TraccionModel traccion = new TraccionModel();
        
        if(traccion.eliminarTraccion(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
