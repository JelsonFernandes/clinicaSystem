/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import Modelos.ModeloFacturaAnalise;
import Modelos.ModeloTabelaAnalise;
import Modelos.ModeloTabelaPaciMedico;
import Modelos.ModeloTabelaPaciMedico1;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class Laboratorio1Controller implements Initializable {

    @FXML
    public TextField codAbertura;
    @FXML
    public TextField codAnalise;
    @FXML
    public TextField Paciente;
    @FXML
    public TextField IdItem;
    @FXML
    public TextField Medico;
    @FXML
    public TextField Data;
    @FXML
    public RadioButton Positivo;
    @FXML
    public RadioButton Negativo;
    @FXML
    public TextField Analise;
    @FXML
    public TextField Observacao;
    @FXML
    public TextField txtPesquisa;

    @FXML
    public TextField Pesquisa;
    @FXML
    public Button AbrirAnalise;
    ToggleGroup grupo = new ToggleGroup();
    @FXML
    public TableView<ModeloTabelaAnalise> TableAnalise;
    @FXML
    public TableColumn<ModeloTabelaAnalise, String> ID;
    @FXML
    public TableColumn<ModeloTabelaAnalise, String> ANALISE;
    @FXML
    public TableColumn<ModeloTabelaAnalise, String> RESULTADO;
    @FXML
    public TableColumn<ModeloTabelaAnalise, String> OBSERVACAO;
    @FXML
    public TableView<ModeloTabelaPaciMedico> TableAnalise2;
    @FXML
    public TableColumn<ModeloTabelaPaciMedico, String> ID2;
    @FXML
    public TableColumn<ModeloTabelaPaciMedico, String> NOME;
    public TableView<ModeloTabelaPaciMedico1> TableAnalise3;
    @FXML
    public TableColumn<ModeloTabelaPaciMedico1, String> ID3;
    @FXML
    public TableColumn<ModeloTabelaPaciMedico1, String> NOME3;

    @FXML
    public Button Adicionar;
    @FXML
    public Button Editar;
    @FXML
    public Button Deletar;
    @FXML
    public Button Finalizar;
    @FXML
    public Button Cancelar;
    @FXML
    public Button btPesquisa;
    @FXML
    public Button BuscamMedico;
    public TextArea Visao;
    @FXML
    public Button Buscar;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int id = 1;
    String analise;
    String resultado;
    String obs;
    String ide;
    ObservableList<ModeloTabelaAnalise> oblist = FXCollections.observableArrayList();
    ObservableList<ModeloTabelaPaciMedico> oblistpm = FXCollections.observableArrayList();
    ObservableList<ModeloTabelaPaciMedico1> oblistpm1 = FXCollections.observableArrayList();
    ArrayList<ModeloFacturaAnalise> lista = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        Data.setText(dateFormat.format(cal.getTime()));
        Positivo.setSelected(true);
        Positivo.setToggleGroup(grupo);
        Negativo.setToggleGroup(grupo);
//        imprimirFactura();

    }

    public void PrencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            analise = Analise.getText();

            obs = Observacao.getText();
            if (Positivo.isSelected()) {
                resultado = "Positivo";
            } else if (Negativo.isSelected()) {
                resultado = "Negativo";
            }
//          Visao.appendText("\n"+analise+resultado+obs);
            oblist.add(new ModeloTabelaAnalise(id, analise, resultado, obs));

            id++;

            ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
            ANALISE.setCellValueFactory(new PropertyValueFactory<>("Analise"));
            RESULTADO.setCellValueFactory(new PropertyValueFactory<>("Resultado"));
            OBSERVACAO.setCellValueFactory(new PropertyValueFactory<>("Oservacao"));
            TableAnalise.setItems(oblist);
//        id_insert, analise, resultado, observacao, id_analise, id_insert, id
            String sql = "insert into analiseinsets(analise, resultado, observacao, id_analise)values(?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Analise.getText());
            pst.setString(2, resultado);
            pst.setString(3, Observacao.getText());
            pst.setString(4, codAnalise.getText());
            pst.execute();
            Analise.setText(null);
            Observacao.setText(null);

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }

    }

    @FXML
    public void PrencherTabelaAnalise(javafx.event.ActionEvent event) {

        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from analiseinsets inner join analise on analiseinsets.id_analise=analise.id_analise where nome_paciente like'%" + txtPesquisa.getText() + "%'";
//            id_analise, id_paciente, nome_paciente, medico, data, id_insert, analise, resultado, observacao, id_analise, id
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModeloTabelaAnalise(rs.getInt("id_analise"), rs.getString("analise"), rs.getString("resultado"), rs.getString("observacao")));
            }

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ANALISE.setCellValueFactory(new PropertyValueFactory<>("Analise"));
        RESULTADO.setCellValueFactory(new PropertyValueFactory<>("Resultado"));
        OBSERVACAO.setCellValueFactory(new PropertyValueFactory<>("Oservacao"));
        TableAnalise.setItems(oblist);

    }

    @FXML
    public void SetarCampos(MouseEvent event) {

        if (event.getClickCount() == 1) {
            Analise.setText(TableAnalise.getFocusModel().getFocusedItem().getAnalise());
            Observacao.setText(TableAnalise.getFocusModel().getFocusedItem().getOservacao());

        }

    }

    public void RemoverDados(javafx.event.ActionEvent event) {

        try {
            conexao = ModeloConexao.conector();

            
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Alerta");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Confirma o cancelamento desta analize?");
            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().addAll(botaoSim, botaoNao);
            Optional<ButtonType> opcao = alert.showAndWait();

            if (opcao.get() == botaoSim) {
                String sql = "delete from analiseinsets where analise=? and id_analise=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, Analise.getText());
                pst.setString(2, codAnalise.getText());
                pst.execute();

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Erro");
                alert1.setHeaderText("Atenção!!!");
                alert1.setContentText("Cancelado com sucesso");
                alert1.show();

            }

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }

    }

    @FXML
    public void deletarAnlise(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Alerta");
        alert.setHeaderText("Atenção!!!");
        alert.setContentText("Confirma o cancelamento desta analize?");
        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().addAll(botaoSim, botaoNao);
        Optional<ButtonType> opcao = alert.showAndWait();

        if (opcao.get() == botaoSim) {
            try {
                String sql = "delete from analise where id_analise=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codAnalise.getText());
                pst.execute();
            } catch (SQLException ex) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("Atenção!!!");
                alert1.setContentText("Erro:\n" + ex);
                alert1.show();
            }
      
        try {
            String sql = "delete from analiseinsets where id_analise=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, codAnalise.getText());
            pst.execute();

            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Confirmaão");
            alert2.setHeaderText("Atenção!!!");
            alert2.setContentText("Análises removidas com sucesso");
            alert2.show();
        } catch (SQLException ex) {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("Erro");
            alert3.setHeaderText("Atenção!!!");
            alert3.setContentText("Erro:\n" + ex);
            alert3.show();
        }
          }

    }

    @FXML
    public void BuscarPaciente(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from pacientes where nome_paciente like'%" + txtPesquisa.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                oblistpm.add(new ModeloTabelaPaciMedico(rs.getString("id_paciente"), rs.getString("nome_paciente")));

            }

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }
        ID2.setCellValueFactory(new PropertyValueFactory<>("cod"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableAnalise2.setItems(oblistpm);

    }

    @FXML
    public void SetarCampos2(MouseEvent event) {

        if (event.getClickCount() == 1) {
            codAbertura.setText(TableAnalise2.getFocusModel().getFocusedItem().getCod());
            Paciente.setText(TableAnalise2.getFocusModel().getFocusedItem().getNome());

        }

    }

    @FXML
    public void BuscarMedico(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from medicos where nome_medico like'%" + txtPesquisa.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                oblistpm1.add(new ModeloTabelaPaciMedico1(rs.getString("id_medico"), rs.getString("nome_medico")));

            }

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }
        ID3.setCellValueFactory(new PropertyValueFactory<>("cod"));
        NOME3.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableAnalise3.setItems(oblistpm1);

    }

    @FXML
    public void SetarCampos3(MouseEvent event) {

        if (event.getClickCount() == 1) {
            IdItem.setText(TableAnalise3.getFocusModel().getFocusedItem().getCod());
            Medico.setText(TableAnalise3.getFocusModel().getFocusedItem().getNome());

        }

    }

    @FXML
    public void AbrirAnalise(ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
//        id_analise, id_paciente, nome_paciente, medico, data, id_analise, medico, id
            String sql = "insert into analise(id_paciente, data)values(?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "00");
            pst.setString(2, Data.getText());
            pst.execute();
            String buscarDados = "select*from analise";
            pst = conexao.prepareStatement(buscarDados);
            rs = pst.executeQuery();
            rs.last();
            codAnalise.setText(rs.getString("id_analise"));

            Paciente.setDisable(false);
            Medico.setDisable(false);
            Analise.setDisable(false);
            Observacao.setDisable(false);
            txtPesquisa.setDisable(false);
            Pesquisa.setDisable(false);
            AbrirAnalise.setDisable(true);
            Adicionar.setDisable(false);
            Editar.setDisable(false);
            Cancelar.setDisable(false);
            btPesquisa.setDisable(false);
            Buscar.setDisable(false);
            Deletar.setDisable(false);
            Finalizar.setDisable(false);
            BuscamMedico.setDisable(false);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }

    }

    @FXML
    public void FinalizarAnalise(ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
//        id_analise, id_paciente, nome_paciente, medico, data, id_analise, medico, id
            String sql = "update analise set id_paciente=?,nome_paciente=?,medico=?,data=? where id_analise=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, codAbertura.getText());
            pst.setString(2, Paciente.getText());
            pst.setString(3, Medico.getText());
            pst.setString(4, Data.getText());
            pst.setString(5, codAnalise.getText());
            pst.execute();

            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Aviso");
            alert2.setHeaderText("Atenção!!!");
            alert2.setContentText("Análise finalizada com sucesso");
            alert2.show();
            //´Método para Chamar o relatório

            Alert alert1 = new Alert(Alert.AlertType.NONE);
            alert1.setTitle("Aviso");
            alert1.setHeaderText("Atenção!!!");
            alert1.setContentText("Confirma a Impressão deste Boletim?");
            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não", ButtonData.CANCEL_CLOSE);
            alert1.getButtonTypes().addAll(botaoSim, botaoNao);
            Optional<ButtonType> opcao = alert1.showAndWait();
            if (opcao.get() == botaoSim) {
                try {
                    HashMap filtro = new HashMap();
                    filtro.put("codigo", (codAnalise.getText()));
//                 filtro.put("id_nota", Integer.parseInt(idnota.getText()));

                    JasperPrint print = JasperFillManager.fillReport("src\\Relatorios\\Analise.jasper", filtro, conexao);
                    JasperViewer.viewReport(print, false);
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Atenção!!!");
                    alert.setContentText("Erro:\n" + ex);
                    alert.show();
                }
            }

            ///////////////////////////////////////////////////////////////
            Paciente.setDisable(true);
            Medico.setDisable(true);
            Analise.setDisable(true);
            Observacao.setDisable(true);
            txtPesquisa.setDisable(true);
            Pesquisa.setDisable(true);
            AbrirAnalise.setDisable(false);
            Adicionar.setDisable(true);
            Editar.setDisable(true);
            Cancelar.setDisable(true);
            btPesquisa.setDisable(true);
            Buscar.setDisable(true);
            Deletar.setDisable(true);
            Finalizar.setDisable(true);
            BuscamMedico.setDisable(true);
            TableAnalise.setItems(null);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Erro:\n" + ex);
            alert.show();
        }

    }

}
