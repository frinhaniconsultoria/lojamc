package br.com.lojamc.services;

import br.com.lojamc.domain.Cliente;
import br.com.lojamc.repositories.ClienteRepository;
import br.com.lojamc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " - Tipo: " + Cliente.class.getName()));
    }
}
