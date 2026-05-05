/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.controller;

import com.frota.manutencao.model.ManutencaoBean;
import com.frota.manutencao.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {
    @Autowired
    private ManutencaoService service;

    @PostMapping
    public String criarServico(@RequestBody ManutencaoBean equipamento) {
    service.criarServico(equipamento);
    return "Serviço Cadastrado com sucesso!";
    }
}
