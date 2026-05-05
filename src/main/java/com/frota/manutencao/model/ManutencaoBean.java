/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.model;

/**
 *
 * @author Aluno
 */
public class ManutencaoBean {
    private int idManutencao;
    private String servico;
    private double custo;
    private int idVeiculo;

    public ManutencaoBean() {
    }

    public ManutencaoBean(int idManutencao, String servico, double custo, int idVeiculo) {
        this.idManutencao = idManutencao;
        this.servico = servico;
        this.custo = custo;
        this.idVeiculo = idVeiculo;
    }

    public int getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(int idManutencao) {
        this.idManutencao = idManutencao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

}
