/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.model;

/**
 *
 * @author Aluno
 */
public class VeiculoBean {
    private int idVeiculo;
    private String placa;
    private String modelo;

    public VeiculoBean() {
    }

    public VeiculoBean(int idVeiculo, String placa, String modelo) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
