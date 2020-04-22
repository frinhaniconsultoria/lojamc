package br.com.lojamc.services;

import br.com.lojamc.domain.Categoria;
import br.com.lojamc.repositories.CategoriaRepository;

import br.com.lojamc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " - Tipo: " + Categoria.class.getName()));
    }
}
