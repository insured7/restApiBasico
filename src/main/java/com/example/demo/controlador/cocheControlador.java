package com.example.demo.controlador;

import com.example.demo.model.coche;
import com.example.demo.servicio.servicioCoche;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coches")
public class cocheControlador {

	@Autowired
	private servicioCoche cocheServicio;
	
	@GetMapping
    public ResponseEntity<List<coche>> getAllCoches() {
        return new ResponseEntity<>(cocheServicio.getAllCoches(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<coche> getCocheById(@PathVariable Long id) {
        return cocheServicio.getCocheById(id)
                .map(coche -> new ResponseEntity<>(coche, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<coche> createCoche(@RequestBody coche coche) {
        return new ResponseEntity<>(cocheServicio.createCoche(coche), HttpStatus.CREATED);
    }
    
    
    //no funciona correctamente
    @PutMapping("/{id}")
    public ResponseEntity<coche> updateCoche(@PathVariable Long id, @RequestBody coche coche) {
        try {
            return new ResponseEntity<>(cocheServicio.updateCoche(id, coche), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoche(@PathVariable Long id) {
    	cocheServicio.deleteCoche(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
}
