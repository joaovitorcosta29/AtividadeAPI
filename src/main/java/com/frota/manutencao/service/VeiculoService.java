/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.service;

import com.frota.manutencao.model.VeiculoBean;
import com.frota.manutencao.repository.VeiculoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoDAO repository;
    
    public List<VeiculoBean> listarVeiculos(){
      return repository.listarVeiculos();
    }
    
    public double somarGastos(int id) {
        return repository.somarGastos(id);
    }
}
