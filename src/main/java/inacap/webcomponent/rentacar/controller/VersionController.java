/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VersionModel;
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
 * @author Marcos
 */
@RestController
@RequestMapping("/veriones")
public class VersionController {
    
    @GetMapping()
    public List<VersionModel> list() {
        return VersionModel.versiones;
    }
    
    @GetMapping("/{id}")
    public VersionModel get(@PathVariable String id) {
        VersionModel version = new VersionModel();
        return version.buscarVersion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        VersionModel version = new VersionModel();
        version.editarVersion(Integer.parseInt(id), versionEditar);
        return new ResponseEntity<>(version.editarVersion(Integer.parseInt(id), version), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VersionModel nuevaVersion) {
                VersionModel version = new VersionModel();
        if (version.nuevaVersion(nuevaVersion)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VersionModel version = new VersionModel();
        if (version.eliminarVersion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
