/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ConsultorioController implements Initializable {

    @FXML
    public TextField codConsulta;
    @FXML
    public TextField DataAtual;
    @FXML
    public TextField Nome;
    @FXML
    public TextField idAgenda;
    @FXML
    public TextField Medico;
    @FXML
    public TextField DataAbertura;
    @FXML
    public TextField Nascimento;
    @FXML
    public TextField Idade;
    @FXML
    public TextField UltimaConsulta;
    public DatePicker ProximaConsulta;
    public RadioButton Masculino;
    @FXML
    public RadioButton Femenino;
    @FXML
    public TextField Diagnostico;
    @FXML
    public Button Analises;
    @FXML
    public Button Receitas;
    @FXML
    public Button Relatorio;
    @FXML
    public TextArea QueixaPrincipal;
    @FXML
    public TextArea habitosVida;
    @FXML
    public TextArea Historico;
    @FXML
    public TextArea SituacaoAtual;
    @FXML
    public TextArea progresso;
    @FXML
    public TextArea Recomendacoes;
    @FXML
    public ComboBox<String> Estado;
    @FXML
    public Button Buscar;
    @FXML
    public Button Atualizar;
    @FXML
    public Button Pesquisar;
    ToggleGroup gupo = new ToggleGroup();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Stage primaryStage;
    Stage dialogStage = new Stage();
    String sexo;
    @FXML
    private BorderPane SexoGroup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            conexao = ModeloConexao.conector();
            ObservableList estadio = FXCollections.observableArrayList();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar cal = Calendar.getInstance();
            DataAtual.setText(dateFormat.format(cal.getTime()));
            estadio.addAll("Em Recuperação",
                    "Recuperado",
                    "Estado Grave",
                    "Estado Grave",
                    "Transferido",
                    "Falecido");
            Estado.setItems(estadio);
            String sql = "select*from consultorio";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.last();
            codConsulta.setText(rs.getString("idconsulta"));
            Nome.setText(rs.getString("paciente"));
            Medico.setText(rs.getString("medico"));
            idAgenda.setText(rs.getString("idagenda"));
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
        Masculino.setSelected(true);
        Masculino.setToggleGroup(gupo);
        Femenino.setToggleGroup(gupo);
    }

    public void buscarDados(javafx.event.ActionEvent event) throws ParseException {

        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente where pacientes.nome_paciente='" + Nome.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            rs.first();

            Nascimento.setText(rs.getString("Nascipaciente"));
            Idade.setText(rs.getString("idade"));

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
        Date birthDay = new SimpleDateFormat("dd-MM-yyy").parse(Nascimento.getText());
        LocalDate now = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Idade.setText(String.valueOf(Period.between(now, LocalDate.now()).getYears()));
        Atualizar.setDisable(false);
        BuscaAdicional();
    }

    public void BuscaAdicional() {

        try {
            conexao = ModeloConexao.conector();
            System.out.println("Veja como está a vida!");
            String sql = "select*from consultorio where idagenda='" + idAgenda.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {

                DataAbertura.setText(rs.getString("pri_consulta"));
                UltimaConsulta.setText(rs.getString("ulticonsulta"));
                ProximaConsulta.getEditor().setText(rs.getString("daprox"));
                Diagnostico.setText(rs.getString("diagpri"));
                QueixaPrincipal.setText(rs.getString("queixa"));
                habitosVida.setText(rs.getString("habitos"));
                SituacaoAtual.setText(rs.getString("situacao"));
                Historico.setText(rs.getString("historico"));
                progresso.setText(rs.getString("progresso"));
                Recomendacoes.setText(rs.getString("recomendacoes"));
                Estado.getSelectionModel().select(rs.getString("estado"));
                sexo = rs.getString("sexo");
                if (sexo.equals("Masculino")) {
                    Masculino.setSelected(true);
                } else if (sexo.equals("Femenino")) {
                    Femenino.setSelected(true);
                }

            } else {
               
                Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Ainda não se encontram dados adicionais-\n disponiveis para este Paciente!");
            alert2.show();
            }

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }

    }

    public void buscarDado() throws ParseException {

        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from pacientes inner join agenda_medica on pacientes.nome_paciente=agenda_medica.nomepaciente where pacientes.nome_paciente='" + Nome.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
//            if
            rs.first();
//            {
//                sexo = rs.getString("sexo");

            Nascimento.setText(rs.getString("Nascipaciente"));
            Idade.setText(rs.getString("idade"));
            sexo = rs.getString("sexo");
            if (sexo.equals("Masculino")) {
                Masculino.setSelected(true);
            } else if (sexo.equals("Femenino")) {
                Femenino.setSelected(true);
            }

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
        Date birthDay = new SimpleDateFormat("dd-MM-yyy").parse(Nascimento.getText());
        LocalDate now = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Idade.setText(String.valueOf(Period.between(now, LocalDate.now()).getYears()));

    }

    public void BuscarOutroPaciente(javafx.event.ActionEvent event) throws ParseException {

        try {
            conexao = ModeloConexao.conector();
            String idagenda = JOptionPane.showInputDialog(null, "INSIRA O ID DA ANGEDA");
            String sql = "select*from consultorio where idagenda='" + idagenda + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                codConsulta.setText(rs.getString("idconsulta"));
                Nome.setText(rs.getString("paciente"));
                Medico.setText(rs.getString("medico"));
                idAgenda.setText(rs.getString("idagenda"));
                DataAbertura.setText(rs.getString("pri_consulta"));
                UltimaConsulta.setText(rs.getString("ulticonsulta"));
                ProximaConsulta.getEditor().setText(rs.getString("daprox"));
                Diagnostico.setText(rs.getString("diagpri"));
                QueixaPrincipal.setText(rs.getString("queixa"));
                habitosVida.setText(rs.getString("habitos"));
                SituacaoAtual.setText(rs.getString("situacao"));
                Historico.setText(rs.getString("historico"));
                progresso.setText(rs.getString("progresso"));
                Recomendacoes.setText(rs.getString("recomendacoes"));
                Estado.getSelectionModel().select(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
        Atualizar.setDisable(false);
        buscarDado();

    }

    public void ActualizaDados(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            if (Masculino.isSelected()) {
                sexo = "Masculino";
            } else if (Femenino.isSelected()) {
                sexo = "Femenino";
            }
            String sql = "update consultorio set paciente=?, medico=?, sexo=?, pri_consulta=?, ulticonsulta=?, daprox=?, diagpri=?, queixa=?, habitos=?, situacao=?, historico=?, progresso=?, recomendacoes=?, idagenda=?, estado=? where idconsulta=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Nome.getText());
            pst.setString(2, Medico.getText());
            pst.setString(3, sexo);
            pst.setString(4, DataAbertura.getText());
            pst.setString(5, DataAtual.getText());
            pst.setString(6, ProximaConsulta.getEditor().getText());
            pst.setString(7, Diagnostico.getText());
            pst.setString(8, QueixaPrincipal.getText());
            pst.setString(9, habitosVida.getText());
            pst.setString(10, SituacaoAtual.getText());
            pst.setString(11, Historico.getText());
            pst.setString(12, progresso.getText());
            pst.setString(13, Recomendacoes.getText());
            pst.setString(14, idAgenda.getText());
            pst.setString(15, Estado.getSelectionModel().getSelectedItem());
            pst.setString(16, codConsulta.getText());
            pst.execute();
            String sql1 = "update agenda_medica set dataatendi=? where idagenda=?";
            pst = conexao.prepareStatement(sql1);
            pst.setString(1, ProximaConsulta.getEditor().getText());
            pst.setString(2, idAgenda.getText());
            pst.execute();

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Os dados  foram actualizados com sucesso");
            alert2.show();
            if (Estado.getSelectionModel().getSelectedItem().equals("Falecido")) {
                try {
//                    conexao = ModeloConexao.conector();
                    String sql2 = "insert into mortalidade(nome_paciente,medico,id_agenda,id_consulta,pri_consulta,queixa,diagnostico,med_recomed)values(?,?,?,?,?,?,?,?)";
                    pst = conexao.prepareStatement(sql2);
                    pst.setString(1, Nome.getText());
                    pst.setString(2, Medico.getText());
                    pst.setString(3, idAgenda.getText());
                    pst.setString(4, codConsulta.getText());
                    pst.setString(5, DataAbertura.getText());
                    pst.setString(6, QueixaPrincipal.getText());
                    pst.setString(7, Diagnostico.getText());
                    pst.setString(8, Recomendacoes.getText());
                    pst.execute();
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro:\n" + ex);
                    alert.show();
                }

                try {
                    Parent morte = FXMLLoader.load(getClass().getResource("controlemorte.fxml"));

                    Scene scene = new Scene(morte);

//dialogStage.close();
                    scene = new Scene(FXMLLoader.load(getClass().getResource("controlemorte.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.show();
                    dialogStage.setResizable(false);
                } catch (IOException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText("ATENÇÃO!!!");
                    alert.setContentText("Erro" + ex);
                    alert.show();
                }
            }
            codConsulta.setText(null);
            Nome.setText(null);
            Medico.setText(null);
            idAgenda.setText(null);
            DataAbertura.setText(null);
            UltimaConsulta.setText(null);
            ProximaConsulta.getEditor().setText(null);
            Diagnostico.setText(null);
            QueixaPrincipal.setText(null);
            habitosVida.setText(null);
            SituacaoAtual.setText(null);
            Historico.setText(null);
            progresso.setText(null);
            Recomendacoes.setText(null);
            Estado.getSelectionModel().select(null);

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }

    public void PrecreverReceita(javafx.event.ActionEvent event) {
        try {
            FXMLLoader receita = new FXMLLoader(getClass().getResource("receitas.fxml"));

            Parent root = (Parent) receita.load();

//dialogStage.close();
//                    scene = new Scene(FXMLLoader.load(getClass().getResource("receitas.fxml")));
            ReceitasController receitaController = receita.getController();
            receitaController.initialize(Nome.getText());
            dialogStage.setScene(new Scene(root));
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }
}
