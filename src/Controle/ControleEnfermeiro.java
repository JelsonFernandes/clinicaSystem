/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloEnfermeiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleEnfermeiro {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloEnfermeiro mod = new ModeloEnfermeiro();

    public void Salvar(ModeloEnfermeiro mod) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "insert into enfermeiros(nome_enfermeiro, nascimento, morada, bi_enfermeiro, carteira_enfermeiro, fone_enfermeiro)values(?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getTxt_nome());
            pst.setString(2, mod.getNascimento());
            pst.setString(3, mod.getTxt_morada());
            pst.setString(4, mod.getTxt_bi());
            pst.setString(5, mod.getTxt_carteira());
            pst.setString(6, mod.getTxt_fone());
            pst.execute();
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmação");
            alert1.setHeaderText("ATENÇÃO!!!");
            alert1.setContentText("Dados adicionados com sucesso");
            alert1.show();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }
    }

    public void Alterar(ModeloEnfermeiro mod) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "update enfermeiros set nome_enfermeiro=?, nascimento=?, morada=?, bi_enfermeiro=?, carteira_enfermeiro=?, fone_enfermeiro=? where  id_enfermeiro=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getTxt_nome());
            pst.setString(2, mod.getNascimento());
            pst.setString(3, mod.getTxt_morada());
            pst.setString(4, mod.getTxt_bi());
            pst.setString(5, mod.getTxt_carteira());
            pst.setString(6, mod.getTxt_fone());
            pst.setString(7, mod.getTxtid());
            pst.execute();
            Alert alert1= new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmação");
            alert1.setHeaderText("ATENÇÃO!!!");
            alert1.setContentText( "Dados alterados Com sucesso!");
            alert1.show();
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }
    }
}
