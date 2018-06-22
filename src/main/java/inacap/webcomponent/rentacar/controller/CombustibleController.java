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

import inacap.webcomponent.rentacar.model.CombustibleModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/combustibles")
public class CombustibleController {
    
    @GetMapping()
    public List<CombustibleModel> list() {
        return CombustibleModel.combustibles;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        CombustibleModel combustible = new CombustibleModel();
        return combustible.buscarCombustible(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {
        CombustibleModel combustible = new CombustibleModel();
       return new ResponseEntity<>(combustible.editarCombustible(Integer.parseInt(id), combustibleEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CombustibleModel nuevoCombustible) {
        CombustibleModel combustible = new CombustibleModel();
        if(combustible.nuevoCombustible(nuevoCombustible))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         CombustibleModel combustible = new CombustibleModel();
        
        if(combustible.eliminarCombustible(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
