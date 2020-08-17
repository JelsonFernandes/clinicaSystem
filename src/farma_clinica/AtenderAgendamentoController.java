/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import Modelos.ModeloTabelaAtendimento;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class AtenderAgendamentoController implements Initializable {

    public TableView<ModeloTabelaAtendimento> TBVaTENDIMENTO;
    @FXML
    public TableColumn<ModeloTabelaAtendimento, String> ID;
    @FXML
    public TableColumn<ModeloTabelaAtendimento, String> NOME;
    @FXML
    public TableColumn<ModeloTabelaAtendimento, String> DATAAGENDAMENTO;
    @FXML
    public TableColumn<ModeloTabelaAtendimento, String> DATACONSULTA;
    @FXML
    public TableColumn<ModeloTabelaAtendimento, String> MEDICO;
    @FXML
    public Button btnAtendimento;
    @FXML
    public TextField txtData;
    public TextField IdAgenda;
    @FXML
    public ComboBox<String> cboMedico;
    @FXML
    public TextField txtPaciente;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Stage primaryStage;
    Stage dialogStage = new Stage();
    String nome = null;
    String id = null;

    ObservableList<ModeloTabelaAtendimento> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao = ModeloConexao.conector();
        try {
            ObservableList medico = FXCollections.observableArrayList();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar cal = Calendar.getInstance();
            txtData.setText(dateFormat.format(cal.getTime()));
            String sql = "select*from medicos";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                medico.add(rs.getString("nome_medico"));
                cboMedico.setItems(medico);
            }
        } catch (SQLException ex) {
             Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }

    public void preencherTabela(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        String paciente = null;

        String sql = ("select*from agenda_medica  where (dataatendi) ='" + txtData.getText() + "'" + "and (medico)='" + cboMedico.getSelectionModel().getSelectedItem() + "'");
//  ='"+ jTextFieldAno.getText()+"'"+"and  (tipo)='"+ jComboBoxTipo.getSelectedItem()+"'");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//
//            do {
//                           
                oblist.add(new ModeloTabelaAtendimento(rs.getString("idagenda"), rs.getString("nomepaciente"), rs.getString("dataagenda"), rs.getString("dataatendi"), rs.getString("medico")));
            }

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        DATAAGENDAMENTO.setCellValueFactory(new PropertyValueFactory<>("DataAgenda"));
        DATACONSULTA.setCellValueFactory(new PropertyValueFactory<>("DataConsulta"));
        MEDICO.setCellValueFactory(new PropertyValueFactory<>("Medico"));
        TBVaTENDIMENTO.setItems(oblist);

    }

    @FXML
    public void setarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {

            txtPaciente.setText(String.valueOf(TBVaTENDIMENTO.getFocusModel().getFocusedItem().getNome()));
            IdAgenda.setText(String.valueOf(TBVaTENDIMENTO.getFocusModel().getFocusedItem().getId()));
        }
    }

    @FXML
    public void SalvarEmConsultorio(javafx.event.ActionEvent event) throws IOException {

        try {
            conexao = ModeloConexao.conector();
            String sql1 = "select*from consultorio where idagenda='" + IdAgenda.getText() + "'";
            pst = conexao.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                nome = rs.getString("paciente");
                id = rs.getString("idagenda");
            }
            if (txtPaciente.getText().equals(nome) || (IdAgenda.getText().equals(id))) {
                Node node = (Node) event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                Parent consultorio = FXMLLoader.load(getClass().getResource("consultorio.fxml"));

                Scene scene = new Scene(consultorio);

                scene = new Scene(FXMLLoader.load(getClass().getResource("consultorio.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();

            } else {
                conexao = ModeloConexao.conector();
                String sql = "insert into consultorio(paciente,medico,idagenda,pri_consulta)values(?,?,?,?)";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtPaciente.getText());
                pst.setString(2, cboMedico.getSelectionModel().getSelectedItem());
                pst.setString(3, IdAgenda.getText());
                pst.setString(4, txtData.getText());
                pst.execute();
                txtPaciente.setText(null);
                cboMedico.getSelectionModel().select(null);

//        nome=txtPaciente.getText();
                Node node = (Node) event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                Parent consultorio = FXMLLoader.load(getClass().getResource("consultorio.fxml"));

                Scene scene = new Scene(consultorio);

                scene = new Scene(FXMLLoader.load(getClass().getResource("consultorio.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }

        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }

    }
}
