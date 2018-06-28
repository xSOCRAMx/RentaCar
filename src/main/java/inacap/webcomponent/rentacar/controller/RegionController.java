/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.RegionRepository;
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

import inacap.webcomponent.rentacar.model.RegionModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/regiones")
public class RegionController {
    
    @Autowired
    private RegionRepository  regionRespository;
    
    
    @GetMapping()
    public Iterable<RegionModel> listarTodos() {
        
        return regionRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> muestraUnaRegion(@PathVariable String id) {
        
        Optional<RegionModel> aOptional = regionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> editaRegion(@PathVariable String id, @RequestBody RegionModel regionEditar) {
        
        Optional<RegionModel> aOptional = regionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            RegionModel aEncontrado = aOptional.get();
            
            regionRespository.setIdRegion(aEncontrado.getIdRegion());
            
            regionRespository.save(regionRespository);
            
            return new ResponseEntity<>(regionEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarRegion(@RequestBody RegionModel nuevaRegion) {
      
        nuevaRegion = regionRespository.save(nuevaRegion);
        
        Optional<RegionModel> aOptional = regionRespository.findById(nuevaRegion.getIdRegion());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<RegionModel> aOptional = regionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            regionRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    } 
}
