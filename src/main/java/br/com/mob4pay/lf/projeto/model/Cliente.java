package br.com.mob4pay.lf.projeto.model;

import br.com.mob4pay.lf.projeto.base.Model;
import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.mapper.ClienteMapper;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Cliente extends Model<ClienteDto> implements Serializable
{
    @Id
    private String id;
    private String nome;
    private int idade;
    private String cpf;

    private Endereco endereco;


    @Override
    public ClienteDto modelToDto()
    {
        return ClienteMapper.INSTANCE.modelToDto(this);
    }

}
