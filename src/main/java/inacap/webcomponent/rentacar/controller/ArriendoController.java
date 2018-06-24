/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.ArriendoModel;
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
@RequestMapping("/arriendos")
public class ArriendoController {
    
   @GetMapping()
    public List<ArriendoModel> list() {
        return ArriendoModel.arriendos;
    }
    
    
    @GetMapping("/{id}")
    public ArriendoModel get(@PathVariable String id) {
        ArriendoModel arriendo = new ArriendoModel();
        return arriendo.buscarArriendo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
        ArriendoModel arriendo = new ArriendoModel();
        arriendo.editarArriendo(Integer.parseInt(id), arriendoEditar);
        return new ResponseEntity<>(arriendo.editarArriendo(Integer.parseInt(id), arriendoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ArriendoModel nuevoArriendo) {
        ArriendoModel arriendo = new ArriendoModel();
        if (arriendo.nuevoArriendo(nuevoArriendo)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ArriendoModel arriendo = new ArriendoModel();
        if (arriendo.eliminarArriendo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
