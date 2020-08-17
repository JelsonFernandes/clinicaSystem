/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleVenda {
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloVenda mod = new ModeloVenda();
    public void InserirItem(ModeloVenda mod) throws SQLException{
        try {
            conexao=ModeloConexao.conector();
            String sql="insert into venda_produtos (id_produto, medida, id_venda, venda_pro_valor, venda_pro_quanti)values(?,?,?,?,?)";
            pst=conexao.prepareStatement(sql);
            pst.setString(1, mod.getProduto());
            pst.setString(2, mod.getMedida());
            pst.setString(3, mod.getCodVenda());
            pst.setString(4, mod.getValor());
            pst.setString(5, mod.getQuantidade());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de Inserção\n"+ ex);
        }
    }
    public void SalvarVenda(ModeloVenda mod) throws SQLException{
        try {
            conexao=ModeloConexao.conector();
            String sql="update vendas set tipo_venda=?, total=?, desconto_venda=?,valor_entregue=?, troco=?,valor_final=? where id_venda=?";
            pst=conexao.prepareStatement(sql);
            pst.setString(1, mod.getTipoPagamento());
            pst.setString(2, mod.getTotal());
            pst.setString(3, mod.getDesconto());
            pst.setString(4, mod.getValorRecebido());
            pst.setString(5, mod.getTroco());
            pst.setString(6, mod.getValorFinal());
            pst.setString(7, mod.getCodVenda());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Venda Salva Com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro de Inserção\n"+ ex);
        }
//        rs.close();
        
    }
}
