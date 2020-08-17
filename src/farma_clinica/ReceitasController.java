/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ReceitasController implements Initializable {

    @FXML
    private Label Data_Receita;
    @FXML
    private JFXTextField Id_Receita;
    @FXML
    private JFXTextField Id_Consulta;
    @FXML
    private JFXTextField Paciente;
    @FXML
    private JFXTextField Medico;
    @FXML
    private JFXTextArea Prescricao;
    @FXML
    private JFXButton Salvar;
    @FXML
    private JFXButton Buscar;
    @FXML
    private JFXButton Actualizar;
    @FXML
    private JFXButton Remover;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
//PegarDados dados= new PegarDados();

    /**
     * Initializes the controller class.
     */
//    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Data_Receita.setText(dateFormat.format(cal.getTime()));
    }

//    
//        public  void Transferirdados(javafx.event.ActionEvent event,(String pessoa)) {
//            
//            
//        }
//    
    void initialize(String text) {
        conexao = ModeloConexao.conector();
        try {
            System.out.println(text);
            Paciente.setText(text);
            String sql = "select*from consultorio where paciente='" + Paciente.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                Id_Consulta.setText(rs.getString("idconsulta"));
//                Paciente.setText(rs.getString("paciente"));
                Medico.setText(rs.getString("medico"));

            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO DE INSERÇÃO" + ex);
            alert.show();
        }

    }

    public void SalvarDados(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into receitas (paciente, medico, id_consulta, prescricao, data)values(?,?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Paciente.getText());
            pst.setString(2, Medico.getText());
            pst.setString(3, Id_Consulta.getText());
            pst.setString(4, Prescricao.getText());
            pst.setString(5, Data_Receita.getText());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dados Salvo com sucesso");
            Paciente.setText(null);
            Medico.setText(null);
            Medico.setText(null);
            Id_Consulta.setText(null);
            Prescricao.setText(null);
            Data_Receita.setText(null);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO DE INSERÇÃO" + ex);
            alert.setResizable(true);
            alert.show();
        }

    }

    public void AlterarDados(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update receitas  set paciente=?, medico=?, id_consulta=?, prescricao=?, data=? where id_receita=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Paciente.getText());
            pst.setString(2, Medico.getText());
            pst.setString(3, Id_Consulta.getText());
            pst.setString(4, Prescricao.getText());
            pst.setString(5, Data_Receita.getText());
            pst.setString(6, Id_Receita.getText());
            pst.execute();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dados Alterado com sucesso");
            Paciente.setText(null);
            Medico.setText(null);
            Medico.setText(null);
            Id_Consulta.setText(null);
            Prescricao.setText(null);
            Data_Receita.setText(null);
            Id_Receita.setText(null);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO DE INSERÇÃO" + ex);
            alert.setResizable(true);
            alert.show();
        }

    }

    public void BuscarReceita(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        try {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Pesquisar Morte");
            dialog.setHeaderText("INSIRA O ID DA MORTE");
            dialog.showAndWait();
            String sql = "select*from receitas where id_receita ="+dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
                Id_Receita.setText(rs.getString("id_receita"));
                Id_Consulta.setText(rs.getString("id_consulta"));
                Paciente.setText(rs.getString("paciente"));
                Medico.setText(rs.getString("medico"));
                Prescricao.setText(rs.getString("prescricao"));
                Data_Receita.setText(rs.getString("data"));

            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO DE INSERÇÃO" + ex);
            alert.setResizable(true);
            alert.show();
        }
    }

    public void Remover(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "delete from receitas where id_receita=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Id_Receita.getText());
            pst.execute();
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dados Removido com sucesso");
            Paciente.setText(null);
            Medico.setText(null);
            Medico.setText(null);
            Id_Consulta.setText(null);
            Prescricao.setText(null);
            Data_Receita.setText(null);
            Id_Receita.setText(null);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.setResizable(true);
            alert.show();
            alert.setResizable(true);
        }

    }
}