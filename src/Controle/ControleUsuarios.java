/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Modelos.ModeloConexao;
import Modelos.ModeloUsuarios;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleUsuarios {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloUsuarios mod = new ModeloUsuarios();

    public void inserirUsuario(ModeloUsuarios mod) {
        conexao = ModeloConexao.conector();

        try {
            String sql = ("insert into usuarios ( nome_user, Perfil_user, email_user, senha_user)values(?,?,?,?)");
            pst = conexao.prepareStatement(sql);
            pst = conexao.prepareStatement(sql);

            // ResultSet rs = pst.executeQuery(sql);
            pst.setString(1, mod.getNomeUsu());
            pst.setString(2, mod.getPerfilUsu());
            pst.setString(3, mod.getEmailUsu());
            pst.setString(4, mod.getSenhaUsu());

            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setContentText("Usuário Cadastrado Com Sucesso");
            alert.show();
           

        } catch (Exception e) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
             alert.setContentText("Erro ao inserir o Usuário!\nERRO: " + e);
            alert.show();
            
        }

    }

    public void alterarUsuario(ModeloUsuarios mod) {
        conexao = ModeloConexao.conector();

        try {
            String sql = ("Update usuarios set nome_user=?, Perfil_user=?, email_user=?, senha_user=? where id_user=?");
            pst = conexao.prepareStatement(sql);
            pst = conexao.prepareStatement(sql);

            // ResultSet rs = pst.executeQuery(sql);
            pst.setString(1, mod.getNomeUsu());
            pst.setString(2, mod.getPerfilUsu());
            pst.setString(3, mod.getEmailUsu());
            pst.setString(4, mod.getSenhaUsu());
            pst.setInt(5, mod.getCodUsu());

            pst.execute();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setContentText("Usuário alterado Com Sucesso");
            alert.show();
           

        } catch (Exception e) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
             alert.setContentText("Erro ao inserir o Usuário!\nERRO: " + e);
            alert.show();
            
        }

    }
}