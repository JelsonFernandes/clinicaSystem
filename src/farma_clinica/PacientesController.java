/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControlePacientes;
import Modelos.ModeloConexao;
import Modelos.ModeloPacientes;
import Modelos.ModeloTabelaPaciente;
import com.jfoenix.controls.JFXButton;
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
import java.util.Optional;
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class PacientesController implements Initializable {

    @FXML
    public RadioButton Masculino;
    @FXML
    public RadioButton Femenino;
    public TitledPane TitlePaciente;
    @FXML
    public TextField idPaciente;
    @FXML
    public TextField NomePaciente;
    @FXML
    public Label dataPaciente;
    ToggleGroup gupo = new ToggleGroup();
    @FXML
    public TextField idadepaciente;
    @FXML
    public ComboBox<String> provPaciente;
    public TextField muniPaciente;
    @FXML
    public TextField bairroPaciente;
    @FXML
    public TextField codPstPaciente;
    @FXML
    public TextField casaPaciente;
    @FXML
    public TextField ruaPaciente;
    @FXML
    public TextField FonePaciente;
    @FXML
    public TextField emailPaciente;
    public DatePicker nascipaciente;
    @FXML
    public TextField numDocPaciente;
    @FXML
    public ComboBox<String> tipoDocPaciente;
    @FXML
    public TableView<ModeloTabelaPaciente> TablePaciente;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> ID;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> NOME;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> NASCIMENTO;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> TELEFONE;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> EMAIL;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> MUNICIPIO;
    @FXML
    public TableColumn<ModeloTabelaPaciente, String> CASA;
    @FXML
    public Button btSalvar;
    @FXML
    public Button btPesquisar;
    @FXML
    public Button btAlterar;
    public Button btAlterr;
//    @FXML
    public JFXButton buscaIdade;
    @FXML
    public TextField pesquiPaciente;
    Stage dialogStage = new Stage();
    String sexo;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ControlePacientes control = new ControlePacientes();
    ModeloPacientes mod = new ModeloPacientes();
    ObservableList<ModeloTabelaPaciente> oblist = FXCollections.observableArrayList();
    @FXML
    private BorderPane borderGroup;
    @FXML
    private JFXButton btRemover;
    @FXML
    private JFXButton btnBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        dataPaciente.setText(dateFormat.format(cal.getTime()));
        ObservableList provincia = FXCollections.observableArrayList();
        provincia.addAll("Benguela",
                "Bengo",
                "Luanda",
                "Kuanza Norte");
        provPaciente.setItems(provincia);
        ObservableList tipoDocumento = FXCollections.observableArrayList();
        tipoDocumento.addAll("BI",
                "Carta de Condução",
                "PassaPort");
        tipoDocPaciente.setItems(tipoDocumento);
        Masculino.setSelected(true);
        Masculino.setToggleGroup(gupo);
        Femenino.setToggleGroup(gupo);
//        btnIdade.setButtonType(JFXButton.ButtonType.FLAT);

    }

    public void HandelerSalvar(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        if (Masculino.isSelected()) {
            sexo = "Masculino";
        } else if (Femenino.isSelected()) {
            sexo = "Femenino";
        }
        mod.setNomePaciente(NomePaciente.getText());
        mod.setFonePaciente(FonePaciente.getText());
        mod.setTipoDocPaciente((String) tipoDocPaciente.getSelectionModel().getSelectedItem());
        mod.setDataPaciente(dataPaciente.getText());
        mod.setNascipaciente(nascipaciente.getEditor().getText());
        mod.setIdadepaciente(idadepaciente.getText());
        mod.setEmailPaciente(emailPaciente.getText());
        mod.setNumDocPaciente(numDocPaciente.getText());
        mod.setProvPaciente((String) provPaciente.getSelectionModel().getSelectedItem());
        mod.setMuniPaciente(muniPaciente.getText());
        mod.setBairroPaciente(bairroPaciente.getText());
        mod.setCasaPaciente(casaPaciente.getText());
        mod.setRuaPaciente(ruaPaciente.getText());
        mod.setCodPstPaciente(codPstPaciente.getText());
        mod.setSexo(sexo);
        control.Salvardados(mod);
        int idade = Integer.parseInt(idadepaciente.getText());
        if (idade <= 12) {
            try {
                String sql = "update pacientes set faixa_etaria where id_paciente=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, "Criança");
                pst.setString(2, codPstPaciente.getText());
                pst.execute();
            } catch (SQLException ex) {
                Alert ale = new Alert(Alert.AlertType.WARNING);
                ale.setTitle("Erro");
                ale.setHeaderText("Atenção!!!");
                ale.setContentText("Erro:" + ex);
                ale.show();
            }

        }
        NomePaciente.setText(null);
        FonePaciente.setText(null);
        tipoDocPaciente.getSelectionModel().select(null);
//        dataPaciente.setText(null);
        nascipaciente.getEditor().setText(null);
        idadepaciente.setText(null);
        emailPaciente.setText(null);
        numDocPaciente.setText(null);
        provPaciente.getSelectionModel().select(null);
        muniPaciente.setText(null);
        bairroPaciente.setText(null);
        casaPaciente.setText(null);
        ruaPaciente.setText(null);
        codPstPaciente.setText(null);

        Alert ale = new Alert(Alert.AlertType.WARNING);
        ale.setTitle("Alerta");
        ale.setHeaderText("Atenção!!!");
        ale.setContentText("Dezeja Marcar uma consulta Para este Paciente? ");

        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        ale.getButtonTypes().addAll(button1, button2);
        Optional<ButtonType> result = ale.showAndWait();
        if (result.get() == button1) {
            try {
                Parent agenda = FXMLLoader.load(getClass().getResource("Agenda_Medica.fxml"));

                Scene scene = new Scene(agenda);

//dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("Agenda_Medica.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
                dialogStage.setResizable(false);
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Erro:" + ex);
                alert.show();
            }

        }

    }

    public void HandelerAlterar(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        if (Masculino.isSelected()) {
            sexo = "Masculino";
        } else if (Femenino.isSelected()) {
            sexo = "Femenino";
        }
        mod.setNomePaciente(NomePaciente.getText());
        mod.setFonePaciente(FonePaciente.getText());
        mod.setTipoDocPaciente((String) tipoDocPaciente.getSelectionModel().getSelectedItem());
        mod.setDataPaciente(dataPaciente.getText());
        mod.setNascipaciente(nascipaciente.getEditor().getText());
        mod.setIdadepaciente(idadepaciente.getText());
        mod.setEmailPaciente(emailPaciente.getText());
        mod.setNumDocPaciente(numDocPaciente.getText());
        mod.setProvPaciente((String) provPaciente.getSelectionModel().getSelectedItem());
        mod.setMuniPaciente(muniPaciente.getText());
        mod.setBairroPaciente(bairroPaciente.getText());
        mod.setCasaPaciente(casaPaciente.getText());
        mod.setRuaPaciente(ruaPaciente.getText());
        mod.setCodPstPaciente(codPstPaciente.getText());
        mod.setSexo(sexo);
        mod.setCodPaciente(idPaciente.getText());
        control.Alterardados(mod);
        int idade = Integer.parseInt(idadepaciente.getText());
        if (idade <= 12) {
            try {
                String sql = "update pacientes set faixa_etaria=? where id_paciente=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, "Criança");
                pst.setString(2, idPaciente.getText());
                pst.execute();
            } catch (SQLException ex) {
                Alert ale = new Alert(Alert.AlertType.WARNING);
                ale.setTitle("Erro");
                ale.setHeaderText("Atenção!!!");
                ale.setContentText("Erro:" + ex);
                ale.show();
            }

        } else if (idade > 12 & idade < 18) {
            try {
                String sql = "update pacientes set faixa_etaria=? where id_paciente=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, "Adolescente");
                pst.setString(2, idPaciente.getText());
                pst.execute();
            } catch (SQLException ex) {
                Alert ale = new Alert(Alert.AlertType.WARNING);
                ale.setTitle("Erro\n" + ex);
                ale.show();
            }
        } else if (idade > 17 & idade < 60) {
            try {
                String sql = "update pacientes set faixa_etaria=? where id_paciente=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, "Adulto");
                pst.setString(2, idPaciente.getText());
                pst.execute();
            } catch (SQLException ex) {
                Alert ale = new Alert(Alert.AlertType.WARNING);
                ale.setTitle("Erro\n" + ex);
                ale.show();
            }
        } else if (idade >= 60) {
            try {
                String sql = "update pacientes set faixa_etaria=? where id_paciente=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, "Idoso");
                pst.setString(2, idPaciente.getText());
                pst.execute();
            } catch (SQLException ex) {
                Alert ale = new Alert(Alert.AlertType.WARNING);
                ale.setTitle("Erro");
                ale.setHeaderText("Atenção!!!");
                ale.setContentText("Erro:" + ex);
                ale.show();
            }
        }
        NomePaciente.setText(null);
        FonePaciente.setText(null);
        tipoDocPaciente.getSelectionModel().select(null);
//        dataPaciente.setText(null);
        nascipaciente.getEditor().setText(null);
        idadepaciente.setText(null);
        emailPaciente.setText(null);
        numDocPaciente.setText(null);
        provPaciente.getSelectionModel().select(null);
        muniPaciente.setText(null);
        bairroPaciente.setText(null);
        casaPaciente.setText(null);
        ruaPaciente.setText(null);
        codPstPaciente.setText(null);
        idPaciente.setText(null);

    }

    public void handleButtonSelecionar(javafx.event.ActionEvent event) throws ParseException {
        System.out.println("Love forever");
        conexao = ModeloConexao.conector();
        try {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("DIALOG INPUT");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("Insira o ID do Paciente");
            dialog.showAndWait();
            String sql = "select*from pacientes where id_paciente=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                NomePaciente.setText(rs.getString("nome_paciente"));
                FonePaciente.setText(rs.getString("tel_paciente"));
                tipoDocPaciente.getSelectionModel().select(rs.getString("tipodoc_paciente"));
                dataPaciente.setText(rs.getString("dataact_paciente"));
                nascipaciente.getEditor().setText(rs.getString("Nascipaciente"));
                idadepaciente.setText(rs.getString("idade"));
                emailPaciente.setText(rs.getString("email_paciente"));
                numDocPaciente.setText(rs.getString("numdoc_paciente"));
                provPaciente.getSelectionModel().select(rs.getString("provi_paciente"));
                muniPaciente.setText(rs.getString("mun_paciente"));
                bairroPaciente.setText(rs.getString("bairro_paciente"));
                casaPaciente.setText(rs.getString("casan_paciente"));
                ruaPaciente.setText(rs.getString("rua_paciente"));
                codPstPaciente.setText(rs.getString("codpos_paciente"));
                idPaciente.setText(rs.getString("id_paciente"));
                sexo = rs.getString("sexo");
                if (sexo.equals("Masculino")) {
                    Masculino.setSelected(true);
                } else if (sexo.equals("Femenino")) {
                    Femenino.setSelected(true);
                } else {

                    Alert ale = new Alert(Alert.AlertType.WARNING);
                    ale.setTitle("Erro");
                    ale.setHeaderText("Atenção!!!");
                    ale.setContentText("Paciente Não Encontrado");
                    ale.show();
                }

            }
            Date birthDay = new SimpleDateFormat("dd-MM-yyy").parse(nascipaciente.getEditor().getText());
            LocalDate now = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            idadepaciente.setText(String.valueOf(Period.between(now, LocalDate.now()).getYears()));
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    @FXML
    public void preencherTabela(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        String sql = ("select*from pacientes");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            do {
//                           
                oblist.add(new ModeloTabelaPaciente(rs.getString("id_paciente"), rs.getString("nome_paciente"), rs.getString("Nascipaciente"), rs.getString("tel_paciente"), rs.getString("email_paciente"), rs.getString("mun_paciente"), rs.getString("casan_paciente")));
//               
            } while (rs.next());

        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("codPaciente"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("NomePaciente"));
        NASCIMENTO.setCellValueFactory(new PropertyValueFactory<>("nascipaciente"));
        TELEFONE.setCellValueFactory(new PropertyValueFactory<>("FonePaciente"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("emailPaciente"));
        MUNICIPIO.setCellValueFactory(new PropertyValueFactory<>("muniPaciente"));
        CASA.setCellValueFactory(new PropertyValueFactory<>("casaPaciente"));
        TablePaciente.setItems(oblist);

    }

    public void handelerremover(javafx.event.ActionEvent event) {
        // a estrutura abaixo confirma a remoção do aluno

        Alert ale = new Alert(Alert.AlertType.WARNING);
        ale.setTitle("Alerta");
        ale.setHeaderText("Atenção!!!");
        ale.setContentText("Tem certeza que deseja remover este Paciente?");
        ButtonType sim = new ButtonType("Sim");
        ButtonType nao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        ale.getButtonTypes().addAll(sim, nao);
        Optional<ButtonType> result = ale.showAndWait();
        if (result.get() == sim) {
            String sql = "delete from pacientes where id_paciente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, idPaciente.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                   
                    ale.setTitle("Alerta");
                    ale.setHeaderText("Atenção!!!");
                    ale.setContentText(" Paciente removido com sucesso");
                    NomePaciente.setText(null);
                    FonePaciente.setText(null);
                    tipoDocPaciente.getSelectionModel().select(null);
//                    dataPaciente.setText(null);
                    nascipaciente.getEditor().setText(null);
                    idadepaciente.setText(null);
                    emailPaciente.setText(null);
                    numDocPaciente.setText(null);
                    provPaciente.getSelectionModel().select(null);
                    muniPaciente.setText(null);
                    bairroPaciente.setText(null);
                    casaPaciente.setText(null);
                    ruaPaciente.setText(null);
                    codPstPaciente.setText(null);
                    idPaciente.setText(null);

                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Erro:" + ex);
                alert.show();

            }
        }
    }

    public void PegarIdade(javafx.event.ActionEvent event) {
//        nascipaciente.

//nascipaciente.seto
        try {
            Date birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(nascipaciente.getEditor().getText());
            LocalDate now = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            idadepaciente.setText(String.valueOf(Period.between(now, LocalDate.now()).getYears()));
            System.out.println(Period.between(now, LocalDate.now()).getYears());
        } catch (ParseException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
    }

    public void PegarIdade(KeyEvent event) {
        if (event.isConsumed()) {
            try {
                Date birthDay = new SimpleDateFormat("dd-MM-yyy").parse(nascipaciente.getEditor().getText());
                LocalDate now = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                idadepaciente.setText(String.valueOf(Period.between(now, LocalDate.now()).getYears()));
            } catch (ParseException ex) {
                Alert dg = new Alert(Alert.AlertType.WARNING);
                dg.setTitle("Erro " + ex);
                dg.show();
                System.out.println("Erro \n" + ex);
            }
        }

    }

    @FXML
    private void PegarIdade(MouseDragEvent event) {
    }

    @FXML
    private void PegarIdade(MouseEvent event) {
    }

}
