/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.repository;

import com.frota.manutencao.model.ManutencaoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ManutencaoDAO {
    public void criarServico(ManutencaoBean manutencao) {
        try {
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM veiculos WHERE id_veiculo = ?");
            stmt.setInt(1, manutencao.getIdVeiculo());

            ResultSet rs = stmt.executeQuery();
            
            if (manutencao.getCusto() <= 0) {
                System.out.println("Erro: O custo da manutenção deve ser positivo");
                return;
            }
            
            if (manutencao.getIdVeiculo() < 1) {
                System.out.println("Erro: O carro não está no sistema.");
                return;
            }

            stmt = conn.prepareStatement("INSERT INTO manutencao (servico, id_veiculo) VALUES (?, ?)");
            stmt.setString(1, manutencao.getServico());
            stmt.setInt(2, manutencao.getIdVeiculo());

            stmt.executeUpdate();

            System.out.println("Serviço cadastrado com sucesso!");

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
