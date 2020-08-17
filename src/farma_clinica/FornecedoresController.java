/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleFornecedor;
import Modelos.ModeloConexao;
import Modelos.ModeloFornecedor;
import Modelos.ModeloTabelaFornecedor;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class FornecedoresController implements Initializable {

    @FXML
    public TextField codEmpresa;
    @FXML
    public TextField emailEmpresa;
    @FXML
    public TextField nomeEmpresa;
    @FXML
    public TextField foneEmpresa;
    @FXML
    public TextField produtoEmpresa;
    @FXML
    public TextField webEmpresa;
    @FXML
    public TextField endeEmpresa;
    @FXML
    public TextField pesquisaEmpresa;
    @FXML
    public Button btBuscarEmpresa;
    @FXML
    public TableView<ModeloTabelaFornecedor> TableViewFornecedor;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> ID;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> EMPRESA;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> EMAIL;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> TELEFONE;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> ENDERECO;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> WEBSITE;
    @FXML
    public TableColumn<ModeloTabelaFornecedor, String> PRODUTO;
    @FXML
    public Button btSalvarEmpresa;
    @FXML
    public Button btPesquisarEmpresa;
    @FXML
    public Button btAlteraEmpresa;
    @FXML
    public Button btRemoveEmpresa;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<ModeloTabelaFornecedor> oblist = FXCollections.observableArrayList();
    ModeloFornecedor mod = new ModeloFornecedor();
    ControleFornecedor control = new ControleFornecedor();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handelerSalvar(javafx.event.ActionEvent event) {
        //id_fornecedor, Nome_fornecedor, email_fornecedor, fone_fornecedor, endereco_fornecedor, produto_fornecedor, website, id_fornecedor, id
        mod.setNomeEmpresa(nomeEmpresa.getText());
        mod.setEmailEmpresa(emailEmpresa.getText());
        mod.setFoneEmpresa(foneEmpresa.getText());
        mod.setEndeEmpresa(endeEmpresa.getText());
        mod.setProdutoEmpresa(produtoEmpresa.getText());
        mod.setWebEmpresa(webEmpresa.getText());
        control.SalvarFornecedor(mod);
        nomeEmpresa.setText(null);
        emailEmpresa.setText(null);
        foneEmpresa.setText(null);
        endeEmpresa.setText(null);
        produtoEmpresa.setText(null);
        webEmpresa.setText(null);
        codEmpresa.setText(null);

    }

    @FXML
    public void handelerAlterar(javafx.event.ActionEvent event) {
        //id_fornecedor, Nome_fornecedor, email_fornecedor, fone_fornecedor, endereco_fornecedor, produto_fornecedor, website, id_fornecedor, id
        mod.setNomeEmpresa(nomeEmpresa.getText());
        mod.setEmailEmpresa(emailEmpresa.getText());
        mod.setFoneEmpresa(foneEmpresa.getText());
        mod.setEndeEmpresa(endeEmpresa.getText());
        mod.setProdutoEmpresa(produtoEmpresa.getText());
        mod.setWebEmpresa(webEmpresa.getText());
        mod.setCodEmpresa(codEmpresa.getText());
        control.AlterarFornecedor(mod);
        nomeEmpresa.setText(null);
        emailEmpresa.setText(null);
        foneEmpresa.setText(null);
        endeEmpresa.setText(null);
        produtoEmpresa.setText(null);
        webEmpresa.setText(null);
        codEmpresa.setText(null);

    }

    @FXML
    public void handelerBuscar(javafx.event.ActionEvent event) {

        try {
            conexao = ModeloConexao.conector();
           
            
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("DIALOG INPUT");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("Insira o ID do Fornecedor");
            dialog.showAndWait();
            String sql = "select*from tbfornecedores where id_fornecedor=" +dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                codEmpresa.setText(rs.getString("id_fornecedor"));
                nomeEmpresa.setText(rs.getString("Nome_fornecedor"));
                emailEmpresa.setText(rs.getString("email_fornecedor"));
                foneEmpresa.setText(rs.getString("fone_fornecedor"));
                endeEmpresa.setText(rs.getString("endereco_fornecedor"));
                produtoEmpresa.setText(rs.getString("produto_fornecedor"));
                webEmpresa.setText(rs.getString("website"));
            } else {
               
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Atenção!!!");
                alert.setContentText("Fornecedor não encontrado");
                alert.show();
            }

        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }

    }
   

    @FXML
    public void PreencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from tbfornecedores where Nome_fornecedor like '%" + pesquisaEmpresa.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModeloTabelaFornecedor(rs.getString("id_fornecedor"), rs.getString("Nome_fornecedor"), rs.getString("email_fornecedor"), rs.getString("fone_fornecedor"), rs.getString("endereco_fornecedor"), rs.getString("produto_fornecedor"), rs.getString("website")));

            }
            ID.setCellValueFactory(new PropertyValueFactory<>("codEmpresa"));
            EMPRESA.setCellValueFactory(new PropertyValueFactory<>("nomeEmpresa"));
            EMAIL.setCellValueFactory(new PropertyValueFactory<>("emailEmpresa"));
            TELEFONE.setCellValueFactory(new PropertyValueFactory<>("foneEmpresa"));
            ENDERECO.setCellValueFactory(new PropertyValueFactory<>("endeEmpresa"));
            PRODUTO.setCellValueFactory(new PropertyValueFactory<>("produtoEmpresa"));
            WEBSITE.setCellValueFactory(new PropertyValueFactory<>("webEmpresa"));

            TableViewFornecedor.setItems(oblist);
        } catch (SQLException ex) {
            Alert ale = new Alert(Alert.AlertType.WARNING);
            ale.setTitle("Erro");
            ale.setHeaderText("Atenção!!!");
            ale.setContentText("Erro:" + ex);
            ale.show();
        }
    }

    @FXML
    public void SetarCamposTabela(MouseEvent event) {
//         TableViewFornecedor.getOnMouseClicked();
        if (event.getClickCount() == 1) {
            codEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getCodEmpresa());
            nomeEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getNomeEmpresa());
            emailEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getEmailEmpresa());
            foneEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getFoneEmpresa());
            endeEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getEndeEmpresa());
            produtoEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getProdutoEmpresa());
            webEmpresa.setText(TableViewFornecedor.getFocusModel().getFocusedItem().getWebEmpresa());

        }

    }

    @FXML
    public void handelerRemover(javafx.event.ActionEvent event) {
        mod.setCodEmpresa(codEmpresa.getText());
        control.remover(mod);
        nomeEmpresa.setText(null);
        emailEmpresa.setText(null);
        foneEmpresa.setText(null);
        endeEmpresa.setText(null);
        produtoEmpresa.setText(null);
        webEmpresa.setText(null);
        codEmpresa.setText(null);
    }

}
