/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.repository;

import com.frota.manutencao.model.AuthBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioDAO {
    public void cadastrar(AuthBean usuario) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO usuario (nome_usuario, email, senha) VALUES (?, ?, ?)");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    public AuthBean logar(String email, String senha) {
        AuthBean auth = new AuthBean();
    
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");

            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                auth.setNome(rs.getString("nome"));
                auth.setEmail(rs.getString("email"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return auth;
    }
}
