/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class Indece_Natal_MorteController implements Initializable {

    @FXML
    private PieChart Natalidade_Mortalidade;
//     private PieChart graficoPacientesFalecidos;
    ObservableList<PieChart.Data> dadosFalecidos = FXCollections.observableArrayList();
    public Double Natalidade = 0.0;
    public Double Mortalidade = 0.0;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private Label Data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Data.setText(dateFormat.format(cal.getTime()));
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy");
        Calendar cal2 = Calendar.getInstance();
        String data = dateFormat2.format(cal2.getTime());
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(data), count(nome_paciente)as totalnascidos from natalidade where  year(data)='" + Data.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();

            Natalidade = rs.getDouble("totalnascidos");

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(data_registro), count(nome_paciente)as totalfalecidos from mortalidade where  year(data_registro)='" + Data.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();

//            Natalidade = rs.getDouble("totaciacasatedidas");
            Mortalidade = rs.getDouble("totalfalecidos");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }

        //Chamar o gráfico de Pacientes atendidos
        dadosFalecidos.addAll(new PieChart.Data("ÍNDICE DE NATALIDADE EM: " + data + "----> " + Natalidade, Natalidade),
                new PieChart.Data("ÍNDICE DE MORTALIDADE EM: " + data + "----> " + Mortalidade, Mortalidade));

        Natalidade_Mortalidade.setData(dadosFalecidos);
    }

}
