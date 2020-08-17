/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelos.ModeloConexao;
import Modelos.ModeloMedicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;

/**
 *
 * @author Jelson Fernandes
 */
public class ControleMedicos {

    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloMedicos mod = new ModeloMedicos();

    public void inserirMedico(ModeloMedicos mod) {
        conexao = ModeloConexao.conector();

        try {
            String sql = ("insert into medicos ( nome_medico, nascimento, morada, bi_medico,carteira_medico,fone_medico,especial_medico)values(?,?,?,?,?,?,?)");
            pst = conexao.prepareStatement(sql);
            pst = conexao.prepareStatement(sql);

            // ResultSet rs = pst.executeQuery(sql);
            pst.setString(1, mod.getNomeMedico());
            pst.setString(2, mod.getNasciMedico());
            pst.setString(3, mod.getMoraMedico());
            pst.setString(4, mod.getBiMedico());
            pst.setString(5, mod.getCartMedico());
            pst.setString(6, mod.getFoneMedico());
            pst.setString(7, mod.getTxtEspecialidade());

            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Médico Cadastrado Com Sucesso");
            alert.show();
//            JOptionPane.showMessageDialog(null, );

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + e);
            alert.show();
        }

    }

    public void alterarMedico(ModeloMedicos mod) {
        conexao = ModeloConexao.conector();
//while(conexao!=null){
//    
//}
        try {
            String sql = ("Update Medicos set nome_medico=?, nascimento=?, morada=?, bi_medico=?,carteira_medico=?,fone_medico=?,especial_medico=? where id_medico=?");
            pst = conexao.prepareStatement(sql);
            pst = conexao.prepareStatement(sql);

            pst.setString(1, mod.getNomeMedico());
            pst.setString(2, mod.getNasciMedico());
            pst.setString(3, mod.getMoraMedico());
            pst.setString(4, mod.getBiMedico());
            pst.setString(5, mod.getCartMedico());
            pst.setString(6, mod.getFoneMedico());
            pst.setString(7, mod.getTxtEspecialidade());
            pst.setInt(8, mod.getCodMedico());

            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Médico Alterado Com Sucesso");
            alert.show();

//            JOptionPane.showMessageDialog(null, "Médico Alterado Com Sucesso");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + e);
            alert.show();
        }

    }

}
