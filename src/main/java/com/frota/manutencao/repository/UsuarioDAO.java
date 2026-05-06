/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frota.manutencao.repository;

import com.frota.manutencao.model.UsuarioBean;
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
    public void registrar(UsuarioBean usuario) {
        try {
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)");

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.executeUpdate();

            System.out.println("Usuário registrado com sucesso!");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
}
    public UsuarioBean buscarPorEmail(String email) {
    UsuarioBean usuario = null;
    
        try {
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
             usuario = new UsuarioBean();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNomeUsuario(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
