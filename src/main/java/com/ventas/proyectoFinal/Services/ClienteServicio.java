package com.ventas.proyectoFinal.Services;

import com.ventas.proyectoFinal.entities.Cliente;
import com.ventas.proyectoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio {

    // a la hora de iniciar se crea una instancia y se inyecta en la variable clienteRepository
    @Autowired
    private ClienteRepository clienteRepository;

    // esta funcion guarda el cliente y regresa la entidad cliente puede crear nuevo o actualizar
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    // esta funcion busca el id del cliente y devuelve el cliente
    public Optional<Cliente> buscarpPorID(Long id) {
        return clienteRepository.findById(id);
    }

    // esta funcion busca borra el Cliente de acuerdo con el ID recibido
    public void borrarCliente(long id) {
       clienteRepository.deleteById(id);
    }
}