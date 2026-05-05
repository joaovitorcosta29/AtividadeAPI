/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.repository;

import com.frota.manutencao.model.VeiculoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */

@Repository
public class VeiculoDAO {
    public List<VeiculoBean> listarVeiculos(){
        List<VeiculoBean> listar = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
         
            PreparedStatement stmt = null;
            ResultSet rs = null;
         
            stmt = conn.prepareStatement("SELECT id_veiculo, placa, modelo FROM veiculos");
            rs = stmt.executeQuery();
         
            while(rs.next()){
                VeiculoBean veiculo = new VeiculoBean();
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
            
                listar.add(veiculo);
            }

        } catch (SQLException e){
             e.printStackTrace();
        }
         return listar;
         
    }
    public double somarGastos(int idVeiculo) {
        try {
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement("SELECT SUM(custo) FROM manutencao WHERE id_veiculo = ?");
            stmt.setInt(1, idVeiculo);

            ResultSet rs = stmt.executeQuery();

            double total = 0;

            if (rs.next()) {
                total = rs.getDouble(1);
            }

            rs.close();
            stmt.close();
            conn.close();

            return total;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
