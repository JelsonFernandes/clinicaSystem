/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloAgenda;
import Modelos.ModeloConexao;
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
public class ControleAgenda {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloAgenda mod = new ModeloAgenda();

    public void SalvarDados(ModeloAgenda mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into agenda_medica(nomepaciente, servico, enfermeiro, turno, valor, medico, dataagenda, dataatendi, statu)values(?,?,?,?,?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getTxtPaciente());
            pst.setString(2, mod.getCboServico());
            pst.setString(3, mod.getCboEnfermeiro());
            pst.setString(4, mod.getCboTurno());
            pst.setString(5, mod.getTxtValor());
            pst.setString(6, mod.getCboMedico());
            pst.setString(7, mod.getTxtDataAtual());
            pst.setString(8, mod.getTxtDataConsulta());
            pst.setString(9, mod.getTxtStatu());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Agenda Marcada com sucesso");
            alert.show();
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }

    public void AlterarDados(ModeloAgenda mod) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update agenda_medica set nomepaciente=?, servico=?, enfermeiro=?, turno=?, valor=?, medico=?, dataagenda=?, dataatendi=?, statu=? where idagenda=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, mod.getTxtPaciente());
            pst.setString(2, mod.getCboServico());
            pst.setString(3, mod.getCboEnfermeiro());
            pst.setString(4, mod.getCboTurno());
            pst.setString(5, mod.getTxtValor());
            pst.setString(6, mod.getCboMedico());
            pst.setString(7, mod.getTxtDataAtual());
            pst.setString(8, mod.getTxtDataConsulta());
            pst.setString(9, mod.getTxtStatu());
            pst.setString(10, mod.getTxtId());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Agenda Alterada com sucesso");
            alert.show();
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }
}
