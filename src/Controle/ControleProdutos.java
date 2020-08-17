/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloProdutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleProdutos {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloProdutos mod = new ModeloProdutos();

    public void AdicionatrProdutos(ModeloProdutos mod) throws SQLException {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into produtos(nome_produto,Medida,Preco_venda, Preco_compra, quantidade, id_fornecedor, fabricante, data_fabrico, data_expiracao)values(?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeProduto());
            pst.setString(2, mod.getMedida());
            pst.setString(3, mod.getPrecoVenda());
            pst.setString(4, mod.getPrecoCompra());
            pst.setString(5, mod.getQuatidadeProduto());
            pst.setString(6, mod.getNomeFornecedor());
            pst.setString(7, mod.getNomeFabricante());
            pst.setString(8, mod.getDataFabrico());
            pst.setString(9, mod.getDataExpiracao());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmção");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Dados Salvos com sucesso");
            alert.show();
        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
//        rs.close();
    }

    public void AlterarProdutos(ModeloProdutos mod) throws SQLException {
        try {

            conexao = ModeloConexao.conector();
            String sql = "update produtos set nome_produto=?,Medida=?, Preco_venda=?, Preco_compra=?, quantidade=?, id_fornecedor=?, fabricante=?, data_fabrico=?, data_expiracao=? where Id_produto=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeProduto());
            pst.setString(2, mod.getMedida());
            pst.setString(3, mod.getPrecoVenda());
            pst.setString(4, mod.getPrecoCompra());
            pst.setString(5, mod.getQuatidadeProduto());
            pst.setString(6, mod.getNomeFornecedor());
            pst.setString(7, mod.getNomeFabricante());
            pst.setString(8, mod.getDataFabrico());
            pst.setString(9, mod.getDataExpiracao());
            pst.setString(10,mod.getCodProduto());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmção");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Dados Alterados com sucesso");
            alert.show();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
//        rs.close();
    }

}
