package br.com.mob4pay.lf.projeto.mapper;

import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ClienteMapper
{
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public ClienteDto modelToDto(Cliente model);

    public Cliente dtoToModel(ClienteDto dto);
}
