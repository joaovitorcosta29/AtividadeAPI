/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.controller;

import com.frota.manutencao.model.VeiculoBean;
import com.frota.manutencao.service.TokenService;
import com.frota.manutencao.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/veiculos") 
public class VeiculoController {
    
    @Autowired
    private VeiculoService service;
    
    @Autowired
    private TokenService tokenService;
    
    @GetMapping //rota do postman: http://localhost:9000/api/veiculos
    public List<VeiculoBean> listarVeiculos(@RequestHeader("Authorization") String auth) {
        
        String token = auth.replace("Bearer", "");
        if(tokenService.validarToken(auth)){
            return service.listarVeiculos();
        }else{
            return null;
        }
    }
    
    @GetMapping("/{id}/gastos") //rota do postman: http://localhost:9000/api/veiculos/1/gastos
    public Double gastos(@PathVariable int id, @RequestHeader("Authorization") String auth) {
        
        String token = auth.replace("Bearer", "");
        tokenService.validarToken(token); 
        return service.somarGastos(id);
        
    }
}
