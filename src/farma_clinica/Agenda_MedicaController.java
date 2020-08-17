/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleAgenda;
import Modelos.ModeloAgenda;
import Modelos.ModeloConexao;
import Modelos.ModeloTabelaAgenda;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class Agenda_MedicaController implements Initializable {

    @FXML
    public JFXTextField txtPaciente;
    @FXML
    public TextField txtId;
    @FXML
    public ComboBox<String> cboEnfermeiro;
    @FXML
    public ComboBox<String> cboServico;
    @FXML
    public TextField txtValor;
    @FXML
    public ComboBox<String> cboTurno;
    @FXML
    public TableView<ModeloTabelaAgenda> TableViewAgenda;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> ID;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> NOME;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> DATA;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> DATACONSULTA;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> MEDICO;
    @FXML
    public TableColumn<ModeloTabelaAgenda, String> TURNO;
    @FXML
    public TextField txtDataAtual;
    @FXML
    public Button btnSalvar;
    @FXML
    public Button btnPesquisar;
    @FXML
    public Button btnAlterar;
    @FXML
    public Button btnRemover;
    @FXML
    public ComboBox<String> txtStatu;
    @FXML
    public ComboBox<String> cboMedico;
    @FXML
    public DatePicker txtDataConsulta;
    @FXML
    public TextField txtPesquisar;
    @FXML
    public Button btnBuscar;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloAgenda mod = new ModeloAgenda();
    ControleAgenda control = new ControleAgenda();
    ObservableList<ModeloTabelaAgenda> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        conexao = ModeloConexao.conector();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        txtDataAtual.setText(dateFormat.format(cal.getTime()));
        ObservableList medico = FXCollections.observableArrayList();
        ObservableList enfermeiro = FXCollections.observableArrayList();
        ObservableList serv = FXCollections.observableArrayList();
        try {
            String sql1 = "select*from pacientes";
            pst = conexao.prepareStatement(sql1);
            rs = pst.executeQuery();
//            while(rs.next()){
            rs.last();
            txtPaciente.setText(rs.getString("nome_paciente"));
///////////////////////////////////////////////////////////////////////////////////////
            String sql = "select*from medicos";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                medico.add(rs.getString("nome_medico"));
                cboMedico.setItems(medico);
            }
            String buscar = "select*from enfermeiros";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            while (rs.next()) {
                enfermeiro.add(rs.getString("nome_enfermeiro"));
                cboEnfermeiro.setItems(enfermeiro);
            }
            String servico = "select*from servicos";
            pst = conexao.prepareStatement(servico);
            rs = pst.executeQuery();
            while (rs.next()) {
                serv.add(rs.getString("tipo_serv"));
                cboServico.setItems(serv);
//                txtValor.setText(rs.getString("valor"));

            }
            String servico1 = "select*from servicos where tipo_serv='" + cboServico.getSelectionModel().getSelectedItem() + "'";
            pst = conexao.prepareStatement(servico1);
            rs = pst.executeQuery();
            while (rs.next()) {

                txtValor.setText(rs.getString("valor"));

            }
            ObservableList provincia = FXCollections.observableArrayList();
            provincia.addAll("Manhã",
                    "Tarde",
                    "Noite");
            cboTurno.setItems(provincia);
            ObservableList statu = FXCollections.observableArrayList();
            statu.addAll("Atendido",
                    "A ser aTendido",
                    "Remarcado",
                    "Não atendido");
            txtStatu.setItems(statu);
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }

    @FXML
    public void Select(javafx.event.ActionEvent event) {
        try {
            String servico1 = "select*from servicos where tipo_serv='" + cboServico.getSelectionModel().getSelectedItem() + "'";
            pst = conexao.prepareStatement(servico1);
            rs = pst.executeQuery();
            while (rs.next()) {

                txtValor.setText(rs.getString("valor"));

            }
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();
        }
    }

    public void handelerSalvarDados(javafx.event.ActionEvent event) {

        mod.setTxtPaciente(txtPaciente.getText());
        mod.setCboServico(cboServico.getSelectionModel().getSelectedItem());
        mod.setCboEnfermeiro(cboEnfermeiro.getSelectionModel().getSelectedItem());
        mod.setCboTurno(cboTurno.getSelectionModel().getSelectedItem());
        mod.setTxtValor(txtValor.getText());
        mod.setCboMedico(cboMedico.getSelectionModel().getSelectedItem());
        mod.setTxtDataAtual(txtDataAtual.getText());
        mod.setTxtDataConsulta(txtDataConsulta.getEditor().getText());
        mod.setTxtStatu(txtStatu.getSelectionModel().getSelectedItem());
        control.SalvarDados(mod);

        txtPaciente.setText(null);
        cboServico.getSelectionModel().select(null);
        cboEnfermeiro.getSelectionModel().select(null);
        cboTurno.getSelectionModel().select(null);
        txtValor.setText(null);
        cboMedico.getSelectionModel().select(null);
        txtDataAtual.setText(null);
        txtDataConsulta.getEditor().setText(null);
        txtStatu.getSelectionModel().select(null);
        txtId.setText(null);

    }

    public void handelerAlterarDados(javafx.event.ActionEvent event) {

        mod.setTxtPaciente(txtPaciente.getText());
        mod.setCboServico(cboServico.getSelectionModel().getSelectedItem());
        mod.setCboEnfermeiro(cboEnfermeiro.getSelectionModel().getSelectedItem());
        mod.setCboTurno(cboTurno.getSelectionModel().getSelectedItem());
        mod.setTxtValor(txtValor.getText());
        mod.setCboMedico(cboMedico.getSelectionModel().getSelectedItem());
        mod.setTxtDataAtual(txtDataAtual.getText());
        mod.setTxtDataConsulta(txtDataConsulta.getEditor().getText());
        mod.setTxtStatu(txtStatu.getSelectionModel().getSelectedItem());
        mod.setTxtId(txtId.getText());
        control.AlterarDados(mod);
        txtPaciente.setText(null);
        cboServico.getSelectionModel().select(null);
        cboEnfermeiro.getSelectionModel().select(null);
        cboTurno.getSelectionModel().select(null);
        txtValor.setText(null);
        cboMedico.getSelectionModel().select(null);
        txtDataAtual.setText(null);
        txtDataConsulta.getEditor().setText(null);
        txtStatu.getSelectionModel().select(null);
        txtId.setText(null);

    }

    public void PegarDados(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from agenda_medica where idagenda=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                cboEnfermeiro.getSelectionModel().select(rs.getString("enfermeiro"));
                cboMedico.getSelectionModel().select(rs.getString("medico"));
                txtDataAtual.setText(rs.getString("dataagenda"));
                txtId.setText(rs.getString("idagenda"));
                txtPaciente.setText(rs.getString("nomepaciente"));
                txtValor.setText(rs.getString("valor"));
                cboMedico.getSelectionModel().select(rs.getString("medico"));
                txtDataAtual.setText(rs.getString("dataagenda"));
                txtDataConsulta.getEditor().setText(rs.getString("dataatendi"));
                txtStatu.getSelectionModel().select(rs.getString("statu"));
                cboTurno.getSelectionModel().select(rs.getString("turno"));
                cboServico.getSelectionModel().select(rs.getString("servico"));

            } else {
                
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("ERRO");
                alert2.setHeaderText("ATENÇÃO!!!");
                alert2.setContentText("Agendamento não encontrado");
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

    @FXML
    public void preencherTabela(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        String sql = ("select*from agenda_medica  where nomepaciente like'%" + txtPesquisar.getText() + "%'");
//        where nome_medico ='"+txtPesquisar.getText()+"%'");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//
//            do {
//                           
                oblist.add(new ModeloTabelaAgenda(rs.getString("idagenda"), rs.getString("nomepaciente"), rs.getString("dataagenda"), rs.getString("dataatendi"), rs.getString("medico"), rs.getString("turno")));
            }
//            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList!|nERRO:" + ex);
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("txtId"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("txtPaciente"));
        DATA.setCellValueFactory(new PropertyValueFactory<>("txtDataAtual"));
        DATACONSULTA.setCellValueFactory(new PropertyValueFactory<>("txtDataConsulta"));
        MEDICO.setCellValueFactory(new PropertyValueFactory<>("cboMedico"));
        TURNO.setCellValueFactory(new PropertyValueFactory<>("cboTurno"));
        TableViewAgenda.setItems(oblist);

    }

    public void RevoverAgendamento(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
        ale.setTitle("Alerta");
        ale.setHeaderText("Atenção!!!");
        ale.setContentText("Dezeja mesmo remover este agendamento");
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não",ButtonData.CANCEL_CLOSE);
        ale.getButtonTypes().addAll(sim, nao);
        Optional<ButtonType> result = ale.showAndWait();
        if (result.get() == sim) {
            try {
                String sql = "delete from agenda_medica where idagenda=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                pst.execute();
                ale.setContentText("Dados removidos com sucesso!");
                ale.show();
                txtPaciente.setText(null);
                cboServico.getSelectionModel().select(null);
                cboEnfermeiro.getSelectionModel().select(null);
                cboTurno.getSelectionModel().select(null);
                txtValor.setText(null);
                cboMedico.getSelectionModel().select(null);
                txtDataAtual.setText(null);
                txtDataConsulta.getEditor().setText(null);
                txtStatu.getSelectionModel().select(null);
                txtId.setText(null);
            } catch (SQLException ex) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("ERRO");
                alert2.setHeaderText("ATENÇÃO!!!");
                alert2.setContentText("Erro" + ex);
                alert2.show();
            }

        }
    }
}
