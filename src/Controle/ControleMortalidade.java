/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloMortalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleMortalidade {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloMortalidade mod = new ModeloMortalidade();

   
    public void ActualizaMorte(ModeloMortalidade mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update mortalidade set nome_paciente=?, medico=?,id_agenda=?,id_consulta=?,data_morte=?,hora_morte=?,pri_consulta=?,queixa=?,diagnostico=?,med_recomed=?,quando_piorou=?,tenta_anima=? where id_morte=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getMedico());
            pst.setString(2, mod.getNomePaciente());
            pst.setString(3, mod.getIdAgenda());
            pst.setString(4, mod.getIdConsulta());
            pst.setString(5, mod.getDataMorte());
            pst.setString(6, mod.getHoraMorte());
            pst.setString(7, mod.getPrimeraConsulta());
            pst.setString(8, mod.getQueixa());
            pst.setString(9, mod.getDiagnostico());
            pst.setString(10, mod.getMedicacaoRecomendada());
            pst.setString(11, mod.getQuandoPiorou());
            pst.setString(12, mod.getTentativaReanimacao());
            pst.setString(13, mod.getIdMorte());
            pst.execute();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.setResizable(true);
            alert.show();
        }
    }

}
