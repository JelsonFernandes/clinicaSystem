/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloEmpresa;
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
public class ControleEmpresa {

    ModeloEmpresa mod = new ModeloEmpresa();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void SalvarEmpresa(ModeloEmpresa mod) {
//        id_empresa, nome, representante, nif, endereco, numfunciocionarios, telefone, email, website, log, logimagem, id_empresa, id
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into tbempresa ( nome, representante, nif, endereco, numfunciocionarios, telefone, email, website,caminhoImagem,logimagem)values(?,?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeEmpresa());
            pst.setString(2, mod.getRepresentanteEmpresa());
            pst.setString(3, mod.getNifEmpresa());
            pst.setString(4, mod.getEndeEmpres());
            pst.setString(5, mod.getNumFuncEmpresa());
            pst.setString(6, mod.getTelefoneEmpresa());
            pst.setString(7, mod.getEmaiEmpresa());
            pst.setString(8, mod.getWebEmpresa());
            pst.setString(9, mod.getCaminho());
            pst.setBinaryStream(10,mod.getFoto());
            
            pst.execute();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setContentText("Empresa Cadastrada com Sucesso");
            alert.show();
           
        } catch (SQLException ex) {
            Alert  alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro\n" + ex);
            
        }
    }
     public void AlterarEmpresa(ModeloEmpresa mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update tbempresa set nome=?, representante=?, nif=?, endereco=?, numfunciocionarios=?, telefone=?, email=?, website=?,caminhoImagem=?,logimagem=? where id_empresa=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomeEmpresa());
            pst.setString(2, mod.getRepresentanteEmpresa());
            pst.setString(3, mod.getNifEmpresa());
            pst.setString(4, mod.getEndeEmpres());
            pst.setString(5, mod.getNumFuncEmpresa());
            pst.setString(6, mod.getTelefoneEmpresa());
            pst.setString(7, mod.getEmaiEmpresa());
            pst.setString(8, mod.getWebEmpresa());
             pst.setString(9, mod.getCaminho());
            pst.setBinaryStream(10,mod.getFoto());
            pst.setString(11, mod.getIdEmpresa());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setContentText("Empresa Cadastrada com Sucesso");
            alert.show();
            
        } catch (SQLException ex) {
            Alert  alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro\n" + ex);
        }
    }

}
