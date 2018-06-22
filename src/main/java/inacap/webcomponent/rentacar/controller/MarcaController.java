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

import inacap.webcomponent.rentacar.model.MarcaModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/marcas")
public class MarcaController {
    
    @GetMapping()
    public List<MarcaModel> list() {
        return MarcaModel.marcas;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        MarcaModel marca = new MarcaModel();
        return marca.buscarMarca(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
       MarcaModel marca = new MarcaModel();
       return new ResponseEntity<>(marca.editarMarca(Integer.parseInt(id), marcaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MarcaModel nuevaMarca) {
        MarcaModel marca = new MarcaModel();
        if(marca.nuevaMarca(nuevaMarca))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MarcaModel marca = new MarcaModel();
        
        if(marca.eliminarMarca(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
