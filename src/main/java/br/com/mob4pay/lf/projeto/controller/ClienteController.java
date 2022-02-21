package br.com.mob4pay.lf.projeto.controller;

import br.com.mob4pay.lf.projeto.dto.ClienteDto;
import br.com.mob4pay.lf.projeto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/clientes")
public class ClienteController
{
    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service)
    {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/lista")
    public Collection<ClienteDto> listar()
    {
        return service.obterTodos();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public ClienteDto findById(@PathVariable String id)
    {
        return service.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ClienteDto novo(@RequestBody ClienteDto dto)
    {
        return service.novo(dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public ClienteDto alterar(@PathVariable String id, @RequestBody ClienteDto dto)
    {
        return service.alterar(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id)
    {
        service.deletar(id);
    }
}
