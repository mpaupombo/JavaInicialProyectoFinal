package com.ventas.proyectoFinal.controllers;

import com.ventas.proyectoFinal.Services.ClienteServicio;
import com.ventas.proyectoFinal.entities.Cliente;
import com.ventas.proyectoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

   @Autowired
   private ClienteServicio clienteServicio;


    //---------------------------------------------------------
    // CREAR CLIENTE CON POST
    // http://localhost:8080/cliente

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteServicio.guardar(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }


    //---------------------------------------------------------
    //READ -------------------------
////    //http://localhost:8080/cliente/{id}
    @GetMapping("/{id}")
    public Optional<Cliente> one(@PathVariable Integer id) {

        return this.clienteServicio.buscarpPorID(Long.valueOf(id));
    }
////
//    //---------------------------------------------------------
//    //DELETE -------------------------
//    //http://localhost:8080/cliente/borrar/1
    @DeleteMapping(value = "/borrar/{id}")
    public void two(@PathVariable Integer id){
        this.clienteServicio.borrarCliente(Long.valueOf(id));
    }

}
