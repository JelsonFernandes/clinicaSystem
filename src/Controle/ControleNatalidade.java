/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloNatalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleNatalidade {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloNatalidade mod = new ModeloNatalidade();

    public void salvarDados(ModeloNatalidade mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into natalidade(sexo,raca,id_paciente,nome_paciente,descricao,parteiira,nome_pai,datanascimento,hora_nascimento,estado_rnascido,estado_mae,tipo_parto,peso,nome_rnascido)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);

            pst.setString(1, mod.getSexo());
            pst.setString(2, mod.getRaca());
            pst.setString(3, mod.getIdPaciente());
            pst.setString(4, mod.getNomePaciente());
            pst.setString(5, mod.getDescricao());
            pst.setString(6, mod.getParteira());
//            pst.setString(7, mod.getData());
            pst.setString(7, mod.getNomePai());
            pst.setString(8, mod.getDataNascimento());
            pst.setString(9, mod.getHoraNascimento());
            pst.setString(10, mod.getEstadoRNascido());
            pst.setString(11, mod.getEstadoMãe());
            pst.setString(12, mod.getTipoParto());
            pst.setString(13, mod.getPeso());
            pst.setString(14, mod.getNomeRNascido());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dados Salvos com sucesso!");
            alert.show();

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n\r" + ex);
            System.out.println("Erro:\n\r" + ex);
            alert.show();
            alert.setResizable(true);

        }

    }

    public void alterarDados(ModeloNatalidade mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update natalidade set sexo=?,raca=?,id_paciente=?,nome_paciente=?,descricao=?,parteiira=?,nome_pai=?,datanascimento=?,hora_nascimento=?,estado_rnascido=?,estado_mae=?,tipo_parto=?,peso=?,nome_rnascido=?b where id_natalidade=?";
            pst = conexao.prepareStatement(sql);

            pst.setString(1, mod.getSexo());
            pst.setString(2, mod.getRaca());
            pst.setString(3, mod.getIdPaciente());
            pst.setString(4, mod.getNomePaciente());
            pst.setString(5, mod.getDescricao());
            pst.setString(6, mod.getParteira());
            pst.setString(7, mod.getNomePai());
            pst.setString(8, mod.getDataNascimento());
            pst.setString(9, mod.getHoraNascimento());
            pst.setString(10, mod.getEstadoRNascido());
            pst.setString(11, mod.getEstadoMãe());
            pst.setString(12, mod.getTipoParto());
            pst.setString(13, mod.getPeso());
            pst.setString(14, mod.getNomeRNascido());
            pst.setString(15, mod.getIdNatalidade());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dados Salvos com sucesso!");
            alert.show();

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);

        }

    }
}
