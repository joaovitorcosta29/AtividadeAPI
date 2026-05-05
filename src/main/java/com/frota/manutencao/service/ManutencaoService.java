/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.service;

import com.frota.manutencao.model.ManutencaoBean;
import com.frota.manutencao.repository.ManutencaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class ManutencaoService {
    
    @Autowired
    private ManutencaoDAO repository;
    
    public void criarServico(ManutencaoBean manutencao){
        repository.criarServico(manutencao);
    }
}
