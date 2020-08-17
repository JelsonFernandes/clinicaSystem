/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import Modelos.ModeloTabelaServicos;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ServicosController implements Initializable {

    @FXML
    public TextField codServico;
    @FXML
    public TextField tipoServico;
    @FXML
    public TextField valorServico;
    @FXML
    public TextField Pesquisar;
    @FXML
    public TableView<ModeloTabelaServicos> TableViewServicos;
    @FXML
    public TableColumn<ModeloTabelaServicos, String> ID;
    @FXML
    public TableColumn<ModeloTabelaServicos, String> SERVICOS;
    @FXML
    public TableColumn<ModeloTabelaServicos, String> VALOR;
    @FXML
    public Button btnBuscar;
    @FXML
    public Button btnAdicionar;
    public Button btPesquisar;
    @FXML
    public Button btAlterar;
    @FXML
    public Button btEliminar;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<ModeloTabelaServicos> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void HandelerSalvar(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into servicos(tipo_serv,valor)value(?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipoServico.getText());
            pst.setString(2, valorServico.getText());
            pst.execute();
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmação");
            alert1.setHeaderText("ATENÇÃO!!!");
            alert1.setContentText("Dados adicionados com sucesso");
            alert1.show();
            tipoServico.setText(null);
            valorServico.setText(null);
            codServico.setText(null);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }

    }

    public void HandelerAlterar(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update servicos set tipo_serv=?,valor=? where id_serv=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipoServico.getText());
            pst.setString(2, valorServico.getText());
            pst.setString(3, codServico.getText());
            pst.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Dados alterados com sucesso");
            alert.show();
            tipoServico.setText(null);
            valorServico.setText(null);
            codServico.setText(null);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }

    }

    public void HandelerBuscar(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from servicos where id_serv=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                codServico.setText(rs.getString("id_serv"));
                tipoServico.setText(rs.getString("tipo_serv"));
                valorServico.setText(rs.getString("valor"));
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }

    }

    @FXML
    public void HandelerPreencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();

            String sql = "select*from servicos where tipo_serv like'%" + Pesquisar.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModeloTabelaServicos(rs.getString("id_serv"), rs.getString("tipo_serv"), rs.getString("valor")));

            }
            ID.setCellValueFactory(new PropertyValueFactory<>("codServico"));
            SERVICOS.setCellValueFactory(new PropertyValueFactory<>("tipoServico"));
            VALOR.setCellValueFactory(new PropertyValueFactory<>("valorServico"));
            TableViewServicos.setItems(oblist);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }

    }
    public void SetarCampos(MouseEvent event){
        if(event.getClickCount()==1){
             codServico.setText(TableViewServicos.getFocusModel().getFocusedItem().getCodServico());
                tipoServico.setText(TableViewServicos.getFocusModel().getFocusedItem().getTipoServico());
                valorServico.setText(TableViewServicos.getFocusModel().getFocusedItem().getValorServico());
            
        }
        
    }

    public void handelerremover(javafx.event.ActionEvent event) {
        // a estrutura abaixo confirma a remoção do aluno
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("ATENÇÃO!!!");
        alert.setContentText("Tem certeza que dezeja remover este Usuário?");

        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(button1, button2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == button1) {
            String sql = "delete from servicos where id_serv=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codServico.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Erro");
                    alert2.setHeaderText("ATENÇÃO!!!");
                    alert2.setContentText("Dados removidos com sucesso");
                    alert2.show();
                    codServico.setText(null);
                    tipoServico.setText(null);
                    valorServico.setText(null);

                }
            } catch (HeadlessException | SQLException e) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("ATENÇÃO!!!");
                alert1.setContentText("Erro:" + e);
                alert1.show();

            }
        }
    }

}
