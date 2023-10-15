package br.com.sitelucasxavier.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controler é o componente entre usuário e aplicação, pode ser iniciada com @Controller(maior flexibilidade de retornar paginas)
// ou @RestController(contruindo uma api)
// Usar ctrl+p para ver mais info
@RestController
@RequestMapping("/primeiraRota")
//criar uma rota >>> http://localhost:8080/ -----, toda vez que acessar esse /primeiraRota vai entrar nessa controller
public class MinhaPrimeiraController {
    /**
     * METODOS DE ACESSO DO HTTP
     * 
     * GET - buscar uma informação
     * POST - Adicionar um dado/informação
     * PUT - alterar um dado/info(mais de uma info)
     * DELETE - Remover um dado
     * PATCH - Alterar somente uma parte da info/dado
     */
    //Método de uma classe
    @GetMapping("/primeiroMetodo")
    public String primeiraMensagem() {
        return "Funcionou";
    }
}
