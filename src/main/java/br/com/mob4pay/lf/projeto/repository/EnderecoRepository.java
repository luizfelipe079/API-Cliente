package br.com.mob4pay.lf.projeto.repository;

import br.com.mob4pay.lf.projeto.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, String>
{

}
