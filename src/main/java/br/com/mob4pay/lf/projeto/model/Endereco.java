package br.com.mob4pay.lf.projeto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Endereco
{
    @Id
    private String id;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
}
