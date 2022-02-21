package br.com.mob4pay.lf.projeto.repository;

import br.com.mob4pay.lf.projeto.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>
{

}
