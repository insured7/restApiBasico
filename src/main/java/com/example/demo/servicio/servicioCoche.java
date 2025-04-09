package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.coche;
import com.example.demo.repositorio.cocheRepositorio;

@Service
public class servicioCoche {
	
	@Autowired
	private cocheRepositorio cocheRepo;
	
	// Operaciones CRUD
    public List<coche> getAllCoches() {
        return cocheRepo.findAll();
    }
    
    public Optional<coche> getCocheById(Long id) {
        return cocheRepo.findById(id);
    }
    
    public coche createCoche(coche coche) {
        return cocheRepo.save(coche);
    }
    
    public coche updateCoche(Long id, coche cocheActualizado) {

    	coche c = new coche();
    	
    	c.setMarca(cocheActualizado.getMarca());
    	c.setAnio(cocheActualizado.getMarca());
    	c.setCuentakm(cocheActualizado.getAnio());
    	
    	return c;
    }
    
    public void deleteCoche(Long id) {
        cocheRepo.deleteById(id);
}
    
}
