package br.com.mob4pay.lf.projeto.service;

import br.com.mob4pay.lf.projeto.model.Cliente;
import br.com.mob4pay.lf.projeto.repository.ClienteRepository;
import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService extends br.com.mob4pay.lf.projeto.service.Service<Cliente, ClienteDto>
{
    private final ClienteRepository repository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteService(ClienteRepository repository,
                          EnderecoRepository enderecoRepository)
    {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }

    // Retorna todos os clientes e seus endereços
    public Collection<ClienteDto> obterTodos()
    {
        return super.getAll();
    }

    // Retorna um cliente em específico de acordo com o id passado
    public ClienteDto findById(String id)
    {
        return super.getById(id);
    }

    // Salva um novo cliente e um novo endereço
    public ClienteDto novo(ClienteDto dto)
    {
        enderecoRepository.save(dto.getEndereco());

        return super.create(dto);
    }

    // Altera um cliente e seu endereço
    public ClienteDto alterar(String id, ClienteDto dto)
    {
        enderecoRepository.save(dto.getEndereco());

        dto.setId(id);

        return super.update(dto);
    }

    // Apaga da base de dados o cliente referente ao id passado
    public void deletar(String id)
    {
        super.delete(id);
    }

    @Override
    protected MongoRepository<Cliente, String> getRepository()
    {
        return repository;
    }

}
