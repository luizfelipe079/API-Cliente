package br.com.mob4pay.lf.projeto.mapper;

import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.model.Cliente;
import br.com.mob4pay.lf.projeto.model.Endereco;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteMapperTest
{
    ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

    Cliente cliente;
    ClienteDto dto;

    @BeforeAll
    void init()
    {
        cliente = new Cliente();
        cliente.setId("6213f773098e02462dd73ea9");
        cliente.setNome("Luiz Felipe");
        cliente.setCpf("12345678910");

        Endereco endereco = new Endereco();
        endereco.setId("6213f773098e02462dd73ea9");

        cliente.setEndereco(endereco);

        dto = new ClienteDto();
        dto.setId("6213f773098e02462dd73ea9");
        dto.setNome("Luiz Felipe");
        dto.setCpf("12345678910");

    }

    @Test
    @Order(1)
    void modelToDto()
    {
        ClienteDto clienteDto = clienteMapper.modelToDto(cliente);

        assertEquals("6213f773098e02462dd73ea9", clienteDto.getId());
    }

    @Test
    @Order(2)
    void dtoToModel()
    {
        Cliente model = clienteMapper.dtoToModel(dto);

        assertEquals("6213f773098e02462dd73ea9", cliente.getId());
    }

    @Test
    @Order(3)
    void nullIdTest()
    {
        dto.setId(null);
        Cliente model = clienteMapper.dtoToModel(dto);

        assertEquals(null, model.getId());

    }

}