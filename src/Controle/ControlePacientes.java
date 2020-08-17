/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloPacientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControlePacientes {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloPacientes mod = new ModeloPacientes();

    public void Salvardados(ModeloPacientes mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into pacientes(nome_paciente, tel_paciente, tipodoc_paciente, dataact_paciente, Nascipaciente, idade, email_paciente, numdoc_paciente, provi_paciente, mun_paciente, bairro_paciente, casan_paciente, rua_paciente, codpos_paciente,sexo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomePaciente());
            pst.setString(2, mod.getFonePaciente());
            pst.setString(3, mod.getTipoDocPaciente());
            pst.setString(4, mod.getDataPaciente());
            pst.setString(5, mod.getNascipaciente());
            pst.setString(6, mod.getIdadepaciente());
            pst.setString(7, mod.getEmailPaciente());
            pst.setString(8, mod.getNumDocPaciente());
            pst.setString(9, mod.getProvPaciente());
            pst.setString(10, mod.getMuniPaciente());
            pst.setString(11, mod.getBairroPaciente());
            pst.setString(12, mod.getCasaPaciente());
            pst.setString(13, mod.getRuaPaciente());
            pst.setString(14, mod.getCodPstPaciente());
            pst.setString(15, mod.getSexo());
            pst.execute();
           
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Paciente Adicionado com sucesso");
            alert.show();
        } catch (SQLException ex) {
             Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    public void Alterardados(ModeloPacientes mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update pacientes set nome_paciente=?, tel_paciente=?, tipodoc_paciente=?, dataact_paciente=?, Nascipaciente=?, idade=?, email_paciente=?, numdoc_paciente=?, provi_paciente=?, mun_paciente=?, bairro_paciente=?, casan_paciente=?, rua_paciente=?, codpos_paciente=?,sexo=? where id_paciente=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getNomePaciente());
            pst.setString(2, mod.getFonePaciente());
            pst.setString(3, mod.getTipoDocPaciente());
            pst.setString(4, mod.getDataPaciente());
            pst.setString(5, mod.getNascipaciente());
            pst.setString(6, mod.getIdadepaciente());
            pst.setString(7, mod.getEmailPaciente());
            pst.setString(8, mod.getNumDocPaciente());
            pst.setString(9, mod.getProvPaciente());
            pst.setString(10, mod.getMuniPaciente());
            pst.setString(11, mod.getBairroPaciente());
            pst.setString(12, mod.getCasaPaciente());
            pst.setString(13, mod.getRuaPaciente());
            pst.setString(14, mod.getCodPstPaciente());
            pst.setString(15, mod.getSexo());
            pst.setString(16, mod.getCodPaciente());
            pst.execute();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Paciente Alterado com sucesso");
            alert.show();

        } catch (SQLException ex) {
              Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
        

    }
  
   

}
