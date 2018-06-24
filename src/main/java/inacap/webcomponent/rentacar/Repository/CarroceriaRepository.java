/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.Repository;

import inacap.webcomponent.rentacar.model.CarroceriaModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marcos
 */
public interface CarroceriaRepository extends CrudRepository<CarroceriaModel, Integer>{
    
}
