/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.DAPP04Practica04.DAPP04Practica04;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Usuario
 */
@RestController
@RequestMapping("api/v1/empleado")
public class EmpleadosController {
    
    @Autowired
    private EmpleadoRepository repositoryEmpleado;
    
    @GetMapping("")
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }
    
    @GetMapping("/{id}")
    public Empleado get(@PathVariable long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if(optEmpleado.isPresent()) {
            return optEmpleado.get();
        } else {
            return null;
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Empleado empleado) {
         Optional<Empleado> empleadoOptional = repositoryEmpleado.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado existingEmpleado = empleadoOptional.get();
            existingEmpleado.setNombre(empleado.getNombre());
            existingEmpleado.setDireccion(empleado.getDireccion());
            existingEmpleado.setTelefono(empleado.getTelefono());
            Empleado updatedEmpleado = repositoryEmpleado.save(existingEmpleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        Empleado createdEmpleado = repositoryEmpleado.save(empleado);
        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Empleado> empleadoOptional = repositoryEmpleado.findById(id);
        if (empleadoOptional.isPresent()) {
            repositoryEmpleado.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
