package br.com.mob4pay.lf.projeto.service;

import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.model.Cliente;
import br.com.mob4pay.lf.projeto.model.Endereco;
import br.com.mob4pay.lf.projeto.repository.ClienteRepository;
import br.com.mob4pay.lf.projeto.repository.EnderecoRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteServiceTest
{
    Cliente cliente;
    ClienteDto dto;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private ClienteService service;

    @BeforeAll()
    void mockObjects()
    {
        Collection<Cliente> clientes = new ArrayList<>();

        cliente = new Cliente();
        cliente.setId("6213f773098e02462dd73ea9");
        cliente.setNome("Luiz Felipe");
        cliente.setCpf("12345678910");
        cliente.setIdade(23);

        Endereco endereco = new Endereco();
        endereco.setId("6213f773098e02462dd73ea9");

        cliente.setEndereco(endereco);

        clientes.add(cliente);

        dto = new ClienteDto();

        dto.setId("6213f773098e02462dd73ea9");
        dto.setNome("Luiz Felipe");
        dto.setCpf("12345678910");
        dto.setIdade(23);

        dto.setEndereco(endereco);

        when(clienteRepository.findAll()).thenReturn((List<Cliente>) clientes);
        when(clienteRepository.findById(Mockito.anyString())).thenReturn(Optional.of(cliente));
        when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
    }

    @Test
    @Order(1)
    void verificarSeAListaRetornadaNaoEstaVazia()
    {
        Collection<ClienteDto> listAll = service.obterTodos();

        assertFalse(listAll.isEmpty());
    }

    @Test
    @Order(2)
    void verificaSeOsDadosRecebidosEstaoCorretos()
    {
        ClienteDto clienteDto = service.findById("6213f773098e02462dd73ea9");

        assertEquals("6213f773098e02462dd73ea9", clienteDto.getId());
        assertEquals("Luiz Felipe", clienteDto.getNome());
        assertEquals("12345678910", clienteDto.getCpf());
        assertEquals(23, clienteDto.getIdade());

    }

    @Test
    @Order(3)
    void verificaSeOcorremErrosNaHoraDaInsercao()
    {
        service.novo(dto);

        assertDoesNotThrow(() -> new Exception());
    }

    @Test
    @Order(4)
    void verificaSeOcorremErrosNaHoraDeAlterar()
    {
        service.alterar("6213f773098e02462dd73ea9", dto);

        assertDoesNotThrow(() -> new Exception());
    }

    @Test
    @Order(5)
    void verificaSeOcorremErrosNaHoraDeDeletar()
    {
        service.deletar("6213f773098e02462dd73ea9");

        assertDoesNotThrow(() -> new Exception());
    }

}