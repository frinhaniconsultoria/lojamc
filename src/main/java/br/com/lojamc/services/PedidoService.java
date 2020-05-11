package br.com.lojamc.services;

import br.com.lojamc.domain.Pedido;
import br.com.lojamc.repositories.PedidoRepository;
import br.com.lojamc.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " - Tipo: " + Pedido.class.getName()));
    }
}
