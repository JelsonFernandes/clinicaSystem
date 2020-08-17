/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleFornecedor {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloFornecedor mod = new ModeloFornecedor();

    public void SalvarFornecedor(ModeloFornecedor mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into tbfornecedores(Nome_fornecedor, email_fornecedor, fone_fornecedor, endereco_fornecedor, produto_fornecedor, website)value(?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeEmpresa());
            pst.setString(2, mod.getEmailEmpresa());
            pst.setString(3, mod.getFoneEmpresa());
            pst.setString(4, mod.getEndeEmpresa());
            pst.setString(5, mod.getProdutoEmpresa());
            pst.setString(6, mod.getWebEmpresa());
            pst.execute();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Dados salvos com sucesso");
            alert.show();

        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    public void AlterarFornecedor(ModeloFornecedor mod) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "update tbfornecedores set Nome_fornecedor=?, email_fornecedor=?, fone_fornecedor=?, endereco_fornecedor=?, produto_fornecedor=?, website=? where id_fornecedor=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeEmpresa());
            pst.setString(2, mod.getEmailEmpresa());
            pst.setString(3, mod.getFoneEmpresa());
            pst.setString(4, mod.getEndeEmpresa());
            pst.setString(5, mod.getProdutoEmpresa());
            pst.setString(6, mod.getWebEmpresa());
            pst.setString(7, mod.getCodEmpresa());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Dados alterados com sucesso");
            alert.show();
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    public void remover(ModeloFornecedor mod) {
        conexao = ModeloConexao.conector();
        // a estrutura abaixo confirma a remoção do aluno
         Alert ale = new Alert(Alert.AlertType.WARNING);
        ale.setTitle("Alerta");
        ale.setHeaderText("Atenção!!!");
        ale.setContentText("Tem certeza que deseja remover este Fornecedor?");
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        ale.getButtonTypes().addAll(sim, nao);
        Optional<ButtonType> result = ale.showAndWait();
        if (result.get() == sim) {
            String sql = "delete from tbfornecedores where id_fornecedor=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, mod.getCodEmpresa());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmação");
                    alert.setHeaderText("Atenção!!!");
                    alert.setContentText(" Fornecedor removido com sucesso");
                    alert.show();

                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Erro:" + ex);
                alert.show();

            }
        }
    }
}
