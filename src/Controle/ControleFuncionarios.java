/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloFuncionarios;
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
public class ControleFuncionarios {

    ModeloFuncionarios mod = new ModeloFuncionarios();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void SalvarDados(ModeloFuncionarios mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into funcionarios(sexo, nome, tipoocumento, numdocumento, datanasci, nacinalidade, endereco, telefone, email, funcao, salario, iniciofuncao, prazocontrato, fimContrato)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getSexo());
            pst.setString(2, mod.getNomeFunc());
            pst.setString(3, mod.getTipoDoc());
            pst.setString(4, mod.getNumDoc());
            pst.setString(5, mod.getNascimento());
            pst.setString(6, mod.getNacionalidade());
            pst.setString(7, mod.getEndereco());
            pst.setString(8, mod.getTelefone());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getFuncao());
            pst.setString(11, mod.getSalario());
            pst.setString(12, mod.getInicioContrato());
            pst.setString(13, mod.getDuracaoContrato());
            pst.setString(14, mod.getFimContrato());
            pst.execute();
             Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText( "Dados adicionados com sucesso");
                alert.show();
            
        } catch (SQLException ex) {
             Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Erro:"+ex);
                alert.show();
        }

    }

    public void EditarDados(ModeloFuncionarios mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update funcionarios set sexo=?, nome=?, tipoocumento=?, numdocumento=?, datanasci=?, nacinalidade=?, endereco=?, telefone=?, email=?, funcao=?, salario=?, iniciofuncao=?, prazocontrato=?, fimContrato=? where id_func=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getSexo());
            pst.setString(2, mod.getNomeFunc());
            pst.setString(3, mod.getTipoDoc());
            pst.setString(4, mod.getNumDoc());
            pst.setString(5, mod.getNascimento());
            pst.setString(6, mod.getNacionalidade());
            pst.setString(7, mod.getEndereco());
            pst.setString(8, mod.getTelefone());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getFuncao());
            pst.setString(11, mod.getSalario());
            pst.setString(12, mod.getInicioContrato());
            pst.setString(13, mod.getDuracaoContrato());
            pst.setString(14, mod.getFimContrato());
            pst.setString(15, mod.getIdFunc());
            pst.execute();
             Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText( "Dados alterados com sucesso");
                alert.show();
           
        } catch (SQLException ex) {
            Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Erro:"+ex);
                alert.show();
        }

    }

}
