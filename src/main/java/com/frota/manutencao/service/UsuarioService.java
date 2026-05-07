/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.service;

import com.frota.manutencao.model.AuthBean;
import com.frota.manutencao.model.UsuarioBean;
import com.frota.manutencao.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
    
    public void cadastrar(UsuarioBean usuario){
        repository.cadastrar(usuario);
    }
    
    public AuthBean logar(String email, String senha){
        return repository.logar(email, senha);
    }
}
