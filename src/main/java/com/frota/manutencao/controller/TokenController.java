/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.controller;

import com.frota.manutencao.model.AuthBean;
import com.frota.manutencao.service.TokenService;
import com.frota.manutencao.service.UsuarioService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class TokenController {
    
    // Injeta automaticamente a instância do TokenService
    // O Spring gerencia o ciclo de vida desta dependência
    @Autowired
    private TokenService service;
    
    @Autowired
    private UsuarioService usuarioservice;
    
    /**
     * Endpoint para gerar um novo token JWT
     * 
     * Método: GET
     * URL: http://localhost:8080/teste
     * 
     * Resposta: Um token JWT válido por 5 minutos
     * 
     * Exemplo:
     * eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpYWdvLnRlc3RlQHRlc3RlLmNvbSIsImlhdCI6MTY4OTEyMzQ1MCwiZXhwIjoxNjg5MTIzNzUwfQ.signature
     * 
     * @return String - token JWT gerado
     */
    @GetMapping("/teste")
    public String testeToken() {
        // Chama o serviço para gerar um novo token JWT
        return service.gerarToken();
    }
    
    @PostMapping("/cadastrar")
    public void Cadastrar(@RequestBody AuthBean usuario){
        usuarioservice.cadastrar(usuario);
    }
    
    @PostMapping("/logar")
    public void Logar(@RequestBody AuthBean usuario){
        usuarioservice.logar(usuario.getEmail(), usuario.getNome());
    }
    
    /**
     * Endpoint para validar um token JWT
     * 
     * Método: POST
     * URL: http://localhost:8080/validar-token?token=SEU_TOKEN_AQUI
     * 
     * Parâmetro de Requisição:
     * - token (obrigatório): O token JWT a ser validado
     * 
     * Respostas:
     * - Se válido: "Token válido! Subject: ... , Emitido em: ... , Expira em: ..."
     * - Se inválido/expirado: "Token inválido ou expirado!"
     * 
     * Exemplo de uso:
     * POST /validar-token?token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpYWdvLnRlc3RlQHRlc3RlLmNvbSIsImlhdCI6MTY4OTEyMzQ1MCwiZXhwIjoxNjg5MTIzNzUwfQ.signature
     * 
     * @param token String - token JWT recebido na requisição
     * @return String - resultado da validação com detalhes do token
     */
    
    @PostMapping("/validar-token")
    public String validarToken(@RequestParam String token) {
        // Valida o token usando o serviço
        if (service.validarToken(token)) {
            // Se válido, extrai e exibe os claims (informações) do token
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + 
                   ", Emitido em: " + claims.getIssuedAt() + 
                   ", Expira em: " + claims.getExpiration();
        } else {
            // Se inválido ou expirado, retorna mensagem de erro
            return "Token inválido ou expirado!";
        }
    }
}
