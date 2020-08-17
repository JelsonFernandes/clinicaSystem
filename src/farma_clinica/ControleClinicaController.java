/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ControleClinicaController implements Initializable {

    @FXML
    private JFXTextArea criAtendidas;
    @FXML
    private JFXTextArea joAtendidos;
    @FXML
    private JFXTextArea aduAtendidos;
    @FXML
    private JFXTextArea idoAtendidos;
    @FXML
    private JFXTextArea criRecuperadas;
    @FXML
    private JFXTextArea joRecuperados;
    @FXML
    private JFXTextArea aduRecuperados;
    @FXML
    private JFXTextArea idoRecuperados;
    @FXML
    private JFXTextArea criFalecidas;
    @FXML
    private JFXTextArea joFalecidos;

    @FXML
    private JFXTextArea aduFalecidos;
    @FXML
    private JFXTextArea idoFalecidos;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    public PieChart graficoPacientes;
    ObservableList<PieChart.Data> dados = FXCollections.observableArrayList();
    public Double criancasAtend = 0.0;
    public Double adolecestesAtend = 0.0;
    public Double adultosAtend = 0.0;
    public Double idososAtend = 0.0;
    /////////////////////////////////
    public Double criancasAtendMes = 0.0;
    public Double adolecestesAtendMes = 0.0;
    public Double adultosAtendMes = 0.0;
    public Double idososAtendMes = 0.0;
    @FXML
    private PieChart graficoPacientesRecuperados;
    ObservableList<PieChart.Data> dadosRecup = FXCollections.observableArrayList();
    public Double criancasRecup = 0.0;
    public Double adolecestesRecup = 0.0;
    public Double adultosRecup = 0.0;
    public Double idososRecup = 0.0;
    //////////////////////////////////////
    public Double criancasRecupMes = 0.0;
    public Double adolecestesRecupMes = 0.0;
    public Double adultosRecupMes = 0.0;
    public Double idososRecupMes = 0.0;
    @FXML
    private PieChart graficoPacientesFalecidos;
    ObservableList<PieChart.Data> dadosFalecidos = FXCollections.observableArrayList();
    public Double criancasFalecidos = 0.0;
    public Double adolecestesFalecidos = 0.0;
    public Double adultosFalecidos = 0.0;
    public Double idososFalecidos = 0.0;
    @FXML
    private Label dataLabel;
    ObservableList<PieChart.Data> dadosBarAteind = FXCollections.observableArrayList();
    @FXML
    private BarChart<?, ?> Atendidos;
    public Double criancasFalecidosMes = 0.0;
    public Double adolecestesFalecidosMes = 0.0;
    public Double adultosFalecidosMes = 0.0;
    public Double idososFalecidosMes = 0.0;
    @FXML
    private NumberAxis x;
    @FXML
    private CategoryAxis y;
    @FXML
    private BarChart<?, ?> Recuperados;
    @FXML
    private NumberAxis xr;
    @FXML
    private CategoryAxis yr;
    @FXML
    private BarChart<String, Integer> Falecidos;
    @FXML
    private NumberAxis xf;
    @FXML
    private CategoryAxis yf;
    @FXML
    private JFXComboBox<String> MesSelect;
    @FXML
    private JFXTextField atendAdole;
    @FXML
    private JFXTextField atendCriancas;
    @FXML
    private JFXTextField atendIdoso;
    @FXML
    private JFXTextField atendAdult;
    @FXML
    private JFXTextField recapAdolc;
    @FXML
    private JFXTextField recapCrianc;
    @FXML
    private JFXTextField recapIdoso;
    @FXML
    private JFXTextField recapAdult;
    @FXML
    private JFXTextField falcAdole;
    @FXML
    private JFXTextField falcCrianca;
    @FXML
    private JFXTextField falecIdoso;
    @FXML
    private JFXTextField falecAdult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MesSelect.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        dataLabel.setText(dateFormat.format(cal.getTime()));
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Criança'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            criAtendidas.setText(rs.getString("totaciacasatedidas") + " Crianças");
            criancasAtend = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Adulto'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            aduAtendidos.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosAtend = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Adolescente'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            joAtendidos.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesAtend = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Idoso'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            idoAtendidos.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososAtend = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }

        //Chamar o gráfico de Pacientes atendidos
        dados.addAll(new PieChart.Data("Crianças  " + criancasAtend, criancasAtend),
                new PieChart.Data("Adolescentes  " + adolecestesAtend, adolecestesAtend),
                new PieChart.Data("Adultos  " + adultosAtend, adultosAtend),
                new PieChart.Data("Idosos  " + idososAtend, idososAtend));
        graficoPacientes.setData(dados);
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Idoso'and estado='Recuperado'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            idoRecuperados.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososRecup = rs.getDouble("totaciacasatedidas");

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Criança'and estado='Recuperado'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            criRecuperadas.setText(rs.getString("totaciacasatedidas") + " Crianças");
            criancasRecup = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro),count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adolescente'and estado='Recuperado'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            joRecuperados.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesRecup = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adulto'and estado='Recuperado'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            aduRecuperados.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosRecup = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        //Gráfico Para Recuperados
        dadosRecup.addAll(new PieChart.Data("Crianças  " + criancasRecup, criancasRecup),
                new PieChart.Data("Adolescentes  " + adolecestesRecup, adolecestesRecup),
                new PieChart.Data("Adultos  " + adultosRecup, adultosRecup),
                new PieChart.Data("Idosos  " + idososRecup, idososRecup));
        graficoPacientesRecuperados.setData(dadosRecup);

        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adulto'and estado='Falecido'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            aduFalecidos.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosFalecidos = rs.getDouble("totaciacasatedidas");

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adolescente'and estado='Falecido'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            joFalecidos.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesFalecidos = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Criança'and estado='Falecido'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            criFalecidas.setText(rs.getString("totaciacasatedidas") + " Crianças");
            criancasFalecidos = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        try {
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Idoso'and estado='Falecido'and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            idoFalecidos.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososFalecidos = rs.getDouble("totaciacasatedidas");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        dadosFalecidos.addAll(new PieChart.Data("Crianças  " + criancasFalecidos, criancasFalecidos),
                new PieChart.Data("Adolescentes  " + adolecestesRecup, adolecestesRecup),
                new PieChart.Data("Adultos  " + adultosFalecidos, adultosFalecidos),
                new PieChart.Data("Idosos  " + idososFalecidos, idososFalecidos));
        graficoPacientesFalecidos.setData(dadosFalecidos);
//GráficoMensal();
    }

    @FXML
    public void ChamarGraficoMesal(javafx.event.ActionEvent event) {
        try {

            String mes = MesSelect.getSelectionModel().getSelectedItem();
            if (mes.equals("Janeiro")) {
                System.out.println("Més Nº: " + 1);
                mes = String.valueOf(1);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Fevereiro")) {
                System.out.println("Més Nº: " + 2);
                mes = String.valueOf(2);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Março")) {
                System.out.println("Més Nº: " + 3);
                mes = String.valueOf(3);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Abril")) {
                System.out.println("Més Nº: " + 4);
                mes = String.valueOf(4);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Maio")) {
                System.out.println("Més Nº: " + 5);
                mes = String.valueOf(5);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Junho")) {
                System.out.println("Més Nº: " + 6);
                mes = String.valueOf(6);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Julho")) {
                System.out.println("Més Nº: " + 7);
                mes = String.valueOf(7);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Agosto")) {
                System.out.println("Més Nº: " + 8);
                mes = String.valueOf(8);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Stetembro")) {
                System.out.println("Més Nº: " + 9);
                mes = String.valueOf(9);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Outubro")) {
                System.out.println("Més Nº: " + 10);
                mes = String.valueOf(10);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Novembro")) {
                System.out.println("Més Nº: " + 11);
                mes = String.valueOf(11);
                System.out.println("Més Nº: " + mes);
            } else if (mes.equals("Dezembro")) {
                System.out.println("Més Nº: " + 12);
                mes = String.valueOf(12);

            }
            conexao = ModeloConexao.conector();
            String sql = "select year(datacadastro),month(datacadastro) as mes, count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Criança'and month(datacadastro)=" + mes + " and  year(datacadastro)='" + dataLabel.getText() + "'";
//            month(datacadastro)='"+mes+"'"+"and
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            atendCriancas.setText(rs.getString("totaciacasatedidas") + "Crianças");
            criancasAtendMes = rs.getDouble("totaciacasatedidas");
            System.out.println(sql);
            conexao = ModeloConexao.conector();
            String sql1 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Adolescente'and month(datacadastro)=" + mes + " and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.first();
            atendAdole.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesAtendMes = rs.getDouble("totaciacasatedidas");
            //Adultos
            conexao = ModeloConexao.conector();
            String sql2 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Adulto'and month(datacadastro)=" + mes + " and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql2);
            rs = pst.executeQuery();
            rs.first();
            atendAdult.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosAtendMes = rs.getDouble("totaciacasatedidas");
            //Idosos
            String sql3 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes where faixa_etaria='Idoso'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql3);
            rs = pst.executeQuery();
            rs.first();
            atendIdoso.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososAtendMes = rs.getDouble("totaciacasatedidas");

            //Recuperados
            //Crianças
            String sql5 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Criança'and estado='Recuperado'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql5);
            rs = pst.executeQuery();
            rs.first();
            recapCrianc.setText(rs.getString("totaciacasatedidas") + " Crianças");
            criancasRecupMes = rs.getDouble("totaciacasatedidas");
            //Adolescentes
            String sql6 = "select year(datacadastro),count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adolescente'and estado='Recuperado'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql6);
            rs = pst.executeQuery();
            rs.first();
            recapAdolc.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesRecupMes = rs.getDouble("totaciacasatedidas");
            //Adultos
            String sql7 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adulto'and estado='Recuperado'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql7);
            rs = pst.executeQuery();
            rs.first();
            recapAdult.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosRecupMes = rs.getDouble("totaciacasatedidas");
            //Idosos
            String sql4 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Idoso'and estado='Recuperado'and month(datacadastro)=" + mes + "and and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql4);
            rs = pst.executeQuery();
            rs.first();
            recapIdoso.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososRecupMes = rs.getDouble("totaciacasatedidas");

            //Felecidos
            String sql10 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Criança'and estado='Falecido'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql10);
            rs = pst.executeQuery();
            rs.first();
            falcCrianca.setText(rs.getString("totaciacasatedidas") + " Crianças");
            criancasFalecidosMes = rs.getDouble("totaciacasatedidas");

            String sql9 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adolescente'and estado='Falecido'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql9);
            rs = pst.executeQuery();
            rs.first();
            falcAdole.setText(rs.getString("totaciacasatedidas") + " Adolescentes");
            adolecestesFalecidosMes = rs.getDouble("totaciacasatedidas");

            String sql8 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Adulto'and estado='Falecido'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql8);
            rs = pst.executeQuery();
            rs.first();
            falecAdult.setText(rs.getString("totaciacasatedidas") + " Adultos");
            adultosFalecidosMes = rs.getDouble("totaciacasatedidas");

            String sql11 = "select year(datacadastro), count(nome_paciente)as totaciacasatedidas from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente inner join consultorio on agenda_medica.idagenda=consultorio.idagenda where pacientes.faixa_etaria='Idoso'and estado='Falecido'and month(datacadastro)=" + mes + "and year(datacadastro)='" + dataLabel.getText() + "'";
            pst = conexao.prepareStatement(sql11);
            rs = pst.executeQuery();
            rs.first();
            falecIdoso.setText(rs.getString("totaciacasatedidas") + " Idosos");
            idososFalecidosMes = rs.getDouble("totaciacasatedidas");

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
        }
        //Adolescentes

        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Criaças ->" + criancasAtendMes, criancasAtendMes));
        set1.getData().add(new XYChart.Data("Adolescentes ->" + adolecestesAtendMes, adolecestesAtendMes));
        set1.getData().add(new XYChart.Data("Adultos ->" + adultosAtendMes, adultosAtendMes));
        set1.getData().add(new XYChart.Data("Idosos ->" + idososAtendMes, idososAtendMes));
        Atendidos.getData().addAll(set1);
//        GraficoMensal();
        System.out.println("Més Nº: " + criancasAtendMes);
        //Recuperados
        XYChart.Series set2 = new XYChart.Series<>();
        set2.getData().add(new XYChart.Data("Criaças ->" + criancasRecupMes, criancasRecupMes));
        set2.getData().add(new XYChart.Data("Adolescentes ->" + adolecestesRecupMes, adolecestesRecupMes));
        set2.getData().add(new XYChart.Data("Adultos ->" + adultosRecupMes, adultosRecupMes));
        set2.getData().add(new XYChart.Data("Idosos ->" + idososRecupMes, idososRecupMes));
        Recuperados.getData().addAll(set2);
        //Falecidos
        XYChart.Series set3 = new XYChart.Series<>();
        set3.getData().add(new XYChart.Data("Criaças ->" + criancasFalecidosMes, criancasFalecidosMes));
        set3.getData().add(new XYChart.Data("Adolescentes ->" + adolecestesFalecidosMes, adolecestesFalecidosMes));
        set3.getData().add(new XYChart.Data("Adultos ->" + adultosFalecidosMes, adultosFalecidosMes));
        set3.getData().add(new XYChart.Data("Idosos ->" + idososFalecidosMes, idososFalecidosMes));
        Falecidos.getData().addAll(set3);

    }

    private void GraficoMensal() {

    }

}
