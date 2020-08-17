/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import Modelos.ModeloTabelaCliente;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ClientesController implements Initializable {

    @FXML
    public TextField codCliente;
    @FXML
    public TextField Endereco;
    @FXML
    public TextField emailCliente;
    @FXML
    public TextField Telefone;
    @FXML
    public TextField Cliente;
    @FXML
    public TextField pesquisar;
    @FXML
    public TableView<ModeloTabelaCliente> TBViewCliente;
    @FXML
    public TableColumn<ModeloTabelaCliente, String> ID;
    @FXML
    public TableColumn<ModeloTabelaCliente, String> CLIENTE;
    @FXML
    public TableColumn<ModeloTabelaCliente, String> ENDERECO;
    @FXML
    public TableColumn<ModeloTabelaCliente, String> EMAIL;
    @FXML
    public TableColumn<ModeloTabelaCliente, String> TELEFONE;
    @FXML
    public Button btSalvar;
    @FXML
    public Button btPesquisar;
    @FXML
    public Button btAlterar;
    @FXML
    public Button btRemover;
    @FXML
    public Button btBuscar;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<ModeloTabelaCliente> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void SalvarClientes(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "insert into tbclientes(nomecli, endecli, fonecli, emailcli)values(?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Cliente.getText());
            pst.setString(2, Endereco.getText());
            pst.setString(3, Telefone.getText());
            pst.setString(4, emailCliente.getText());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Dados Adicionados com sucesso");
            alert.show();
            codCliente.setText(null);
            Cliente.setText(null);
            Endereco.setText(null);
            emailCliente.setText(null);
            Telefone.setText(null);
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    public void AlterarClientes(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "update tbclientes set nomecli=?, endecli=?, fonecli=?, emailcli=? where idcli=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Cliente.getText());
            pst.setString(2, Endereco.getText());
            pst.setString(3, Telefone.getText());
            pst.setString(4, emailCliente.getText());
            pst.setString(5, codCliente.getText());
            pst.execute();
           
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText("Dados Alterados com sucesso");
            alert.show();
            codCliente.setText(null);
            Cliente.setText(null);
            Endereco.setText(null);
            emailCliente.setText(null);
            Telefone.setText(null);
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }

    public void BuscarClientes(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("DIALOG INPUT");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("Ensira o ID do Cliente");
            dialog.showAndWait();
            String sql = "select*from tbclientes where idcli=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {
                codCliente.setText(rs.getString("idcli"));
                Cliente.setText(rs.getString("nomecli"));
                Endereco.setText(rs.getString("endecli"));
                emailCliente.setText(rs.getString("emailcli"));
                Telefone.setText(rs.getString("fonecli"));
            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Cliente não encontrado");
                alert.show();
            }

        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
//       idcli, nomecli, endecli, fonecli, emailcli, idcli, id
    }

    public void PreencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();

            String sql = ("select*from tbclientes  where nomecli like'%" + pesquisar.getText() + "%'");
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModeloTabelaCliente(rs.getString("idcli"), rs.getString("nomecli"), rs.getString("endecli"), rs.getString("fonecli"), rs.getString("emailcli")));
            }
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
        CLIENTE.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        ENDERECO.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
        TELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("emailCliente"));

        TBViewCliente.setItems(oblist);

    }

    public void setarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {
            codCliente.setText(TBViewCliente.getFocusModel().getFocusedItem().getCodCliente());
            Cliente.setText(TBViewCliente.getFocusModel().getFocusedItem().getCliente());
            Endereco.setText(TBViewCliente.getFocusModel().getFocusedItem().getEndereco());
            emailCliente.setText(TBViewCliente.getFocusModel().getFocusedItem().getEmailCliente());
            Telefone.setText(TBViewCliente.getFocusModel().getFocusedItem().getTelefone());
        }

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
            String sql = "delete from tbclientes where idcli=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codCliente.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmação");
                    alert.setHeaderText("Atenção!!!");
                    alert.setContentText("Dados Removidos com sucesso");
                    alert.show();
                    codCliente.setText(null);
                    Cliente.setText(null);
                    Endereco.setText(null);
                    emailCliente.setText(null);
                    Telefone.setText(null);

                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Erro:" + ex);
                alert.show();

            }
        }
    }

}
