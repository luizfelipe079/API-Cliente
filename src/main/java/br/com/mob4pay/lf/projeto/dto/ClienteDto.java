package br.com.mob4pay.lf.projeto.dto;

import br.com.mob4pay.lf.projeto.base.ModelDto;
import br.com.mob4pay.lf.projeto.mapper.ClienteMapper;
import br.com.mob4pay.lf.projeto.model.Cliente;
import br.com.mob4pay.lf.projeto.model.Endereco;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDto extends ModelDto<Cliente> implements Serializable
{
    private String id;
    private String nome;
    private int idade;
    private String cpf;
    private Endereco endereco;

    @Override
    public Cliente dtoToModel()
    {
        return ClienteMapper.INSTANCE.dtoToModel(this);
    }

}
