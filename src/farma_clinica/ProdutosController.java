/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleProdutos;
import Modelos.ModeloConexao;
import Modelos.ModeloProdutos;
import Modelos.ModeloTabelaProdutos;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class ProdutosController implements Initializable {

    @FXML
    public TextField codProduto;
    @FXML
    public TextField nomeProduto;
    @FXML
    public TextField quatidadeProduto;
    @FXML
    public TextField nomeFabricante;
    @FXML
    public TextField precoCompra;
    @FXML
    public TextField precoVenda;
    @FXML
    public TextField adicionarProduto;
    @FXML
    public Button btnAdicionar;
    @FXML
    public ComboBox<String> nomeFornecedor;
    @FXML
    public DatePicker dataFabrico;
    @FXML
    public DatePicker dataExpiracao;
    @FXML
    public TableView<ModeloTabelaProdutos> tableViewProduto;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> ID;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> PRODUTO;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> FORNECEDOR;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> FABRICO;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> PRECOCOMPRA;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> PRECOVENDA;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> QUANTIDADE;
    @FXML
    public TableColumn<ModeloTabelaProdutos, String> DATAEXPIRACAO;
    @FXML
    public Button btnBuscar;
    @FXML
    public TextField pesquisarProduto;
    @FXML
    public Button Salvar;
    @FXML
    public Button Pesquisar;
    @FXML
    public Button Alterar;
    @FXML
    public Button Remover;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int IdFornecedor;
    int Quantidade;
    int NovaQuantidade;
    int TotalQuantidade;
    String NomeFornecedor;
    ModeloProdutos mod = new ModeloProdutos();
    ObservableList<ModeloTabelaProdutos> oblist = FXCollections.observableArrayList();
    ControleProdutos control = new ControleProdutos();
    @FXML
    private JFXTextField Medida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conexao = ModeloConexao.conector();
            ObservableList fornecedor = FXCollections.observableArrayList();
            String buscar = "select*from tbfornecedores";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            while (rs.next()) {
                fornecedor.add(rs.getString("Nome_fornecedor"));
                nomeFornecedor.setItems(fornecedor);
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }

    }

    public void buscarIdFornecedor(javafx.event.ActionEvent even) throws SQLException {
        try {
            String buscar = "select*from tbfornecedores where Nome_fornecedor='" + nomeFornecedor.getSelectionModel().getSelectedItem() + "'";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdFornecedor = rs.getInt("id_fornecedor");
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
        rs.close();
    }

    @FXML
    public void handelerSalvar(javafx.event.ActionEvent event) throws SQLException {
          try {
            String buscar = "select*from tbfornecedores where Nome_fornecedor='" + nomeFornecedor.getSelectionModel().getSelectedItem() + "'";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdFornecedor = rs.getInt("id_fornecedor");
            }
            System.out.println(IdFornecedor);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }


        mod.setNomeProduto(nomeProduto.getText());
        mod.setMedida(Medida.getText());
        mod.setPrecoVenda(precoVenda.getText());
        mod.setPrecoCompra(precoCompra.getText());
        mod.setQuatidadeProduto(quatidadeProduto.getText());
        mod.setNomeFornecedor(String.valueOf(IdFornecedor));
        mod.setNomeFabricante(nomeFabricante.getText());
        mod.setDataFabrico(dataFabrico.getEditor().getText());
        mod.setDataExpiracao(dataExpiracao.getEditor().getText());
        control.AdicionatrProdutos(mod);
        nomeProduto.setText(null);
        Medida.setText(null);
        precoVenda.setText(null);
        precoCompra.setText(null);
        quatidadeProduto.setText(null);
        nomeFornecedor.getSelectionModel().select(null);
        nomeFabricante.setText(null);
        dataFabrico.getEditor().setText(null);
        dataExpiracao.getEditor().setText(null);
        codProduto.setText(null);

    }

    @FXML
    public void handelerAlterar(javafx.event.ActionEvent event) throws SQLException, SQLException, SQLException {
        try {
            String buscar = "select*from tbfornecedores where Nome_fornecedor='" + nomeFornecedor.getSelectionModel().getSelectedItem() + "'";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdFornecedor = rs.getInt("id_fornecedor");
            }
            System.out.println(IdFornecedor);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }

        mod.setNomeProduto(nomeProduto.getText());
        mod.setMedida(Medida.getText());
        mod.setPrecoVenda(precoVenda.getText());
        mod.setPrecoCompra(precoCompra.getText());
        mod.setQuatidadeProduto(quatidadeProduto.getText());
        mod.setNomeFornecedor(String.valueOf(IdFornecedor));
        mod.setNomeFabricante(nomeFabricante.getText());
        mod.setDataFabrico(dataFabrico.getEditor().getText());
        mod.setDataExpiracao(dataExpiracao.getEditor().getText());
        mod.setCodProduto(codProduto.getText());
        control.AlterarProdutos(mod);
        nomeProduto.setText(null);
        Medida.setText(null);
        precoVenda.setText(null);
        precoCompra.setText(null);
        quatidadeProduto.setText(null);
        nomeFornecedor.getSelectionModel().select(null);
        nomeFabricante.setText(null);
        dataFabrico.getEditor().setText(null);
        dataExpiracao.getEditor().setText(null);
        codProduto.setText(null);

    }

    @FXML
    public void handelerBuscar(javafx.event.ActionEvent event) throws SQLException {

//            Id_produto, nome_produto, Preco_venda, Preco_compra, quantidade, id_fornecedor, fabricante, data_fabrico, data_expiracao, Id_produto, id
        conexao = ModeloConexao.conector();
        try {

           
             TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("Insira o ID do Produto");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from produtos where id_produto=" +dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                codProduto.setText(rs.getString("Id_produto"));
                nomeProduto.setText(rs.getString("nome_produto"));
                precoVenda.setText(rs.getString("Preco_venda"));
                Medida.setText(rs.getString("Medida"));
                precoCompra.setText(rs.getString("Preco_compra"));
                quatidadeProduto.setText(rs.getString("quantidade"));
                IdFornecedor = rs.getInt("id_fornecedor");
                nomeFabricante.setText(rs.getString("fabricante"));
                dataFabrico.getEditor().setText(rs.getString("data_fabrico"));
                dataExpiracao.getEditor().setText(rs.getString("data_expiracao"));
                String buscar = "select*from tbfornecedores where id_fornecedor=" + IdFornecedor;
                pst = conexao.prepareStatement(buscar);
                rs = pst.executeQuery();
                if (rs.next()) {
                    NomeFornecedor = rs.getString("nome_fornecedor");

                }
                nomeFornecedor.getSelectionModel().select(NomeFornecedor);

            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
        rs.close();

    }

    @FXML
    public void adicionarProduto(javafx.event.ActionEvent event) throws SQLException {
        try {
            conexao = ModeloConexao.conector();
            NovaQuantidade = Integer.parseInt(adicionarProduto.getText());
            String buscar = "select*from produtos where id_produto='" + codProduto.getText() + "'";
            pst = conexao.prepareStatement(buscar);
            rs = pst.executeQuery();
            if (rs.next()) {
                Quantidade = rs.getInt("quantidade");

            }
            TotalQuantidade = Quantidade + NovaQuantidade;
            quatidadeProduto.setText(String.valueOf(TotalQuantidade));
            String alterar = "update produtos set quantidade=? where id_produto='" + codProduto.getText() + "'";
            pst = conexao.prepareStatement(alterar);
            pst.setString(1, quatidadeProduto.getText());
            pst.execute();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Atenção!!!");
            alert.setContentText(" A Quatidade foi adicionada com sucesso");
            alert.show();

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
        rs.close();
    }

    @FXML
    public void preencherTabela(javafx.event.ActionEvent event) throws SQLException {
        try {
            conexao = ModeloConexao.conector();

            String sql = "select*from produtos  inner join tbfornecedores on produtos.id_fornecedor=tbfornecedores.id_fornecedor where produtos.nome_produto like '%" + pesquisarProduto.getText() + "%'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
//            rs.first();
//             IdFornecedor = rs.getInt("id_fornecedor");
//             System.out.println("Fornecedor Nº: "+IdFornecedor);
            while (rs.next()) {
                oblist.add(new ModeloTabelaProdutos(rs.getString("Id_produto"), rs.getString("nome_produto"), rs.getString("Nome_fornecedor"), rs.getString("fabricante"), rs.getString("Preco_compra"),rs.getString("Preco_venda"), rs.getString("quantidade"), rs.getString("data_expiracao")));

            }
            ID.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
            PRODUTO.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
            FORNECEDOR.setCellValueFactory(new PropertyValueFactory<>("nomeFornecedor"));
            FABRICO.setCellValueFactory(new PropertyValueFactory<>("nomeFabricante"));
            PRECOCOMPRA.setCellValueFactory(new PropertyValueFactory<>("precoCompra"));
            PRECOVENDA.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
            QUANTIDADE.setCellValueFactory(new PropertyValueFactory<>("quatidadeProduto"));
            DATAEXPIRACAO.setCellValueFactory(new PropertyValueFactory<>("dataExpiracao"));
            tableViewProduto.setItems(oblist);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
        rs.close();

    }

    @FXML
    public void setarCampos(MouseEvent event) {
        conexao = ModeloConexao.conector();
        try {
            if (event.getClickCount() == 1) {
                codProduto.setText(tableViewProduto.getFocusModel().getFocusedItem().getCodProduto());
                nomeProduto.setText(tableViewProduto.getFocusModel().getFocusedItem().getNomeProduto());
                precoVenda.setText(tableViewProduto.getFocusModel().getFocusedItem().getPrecoVenda());
                precoCompra.setText(tableViewProduto.getFocusModel().getFocusedItem().getPrecoCompra());
                quatidadeProduto.setText(tableViewProduto.getFocusModel().getFocusedItem().getQuatidadeProduto());
                nomeFornecedor.getSelectionModel().select(tableViewProduto.getFocusModel().getFocusedItem().getNomeFornecedor());
                nomeFabricante.setText(tableViewProduto.getFocusModel().getFocusedItem().getNomeFabricante());

                dataExpiracao.getEditor().setText(tableViewProduto.getFocusModel().getFocusedItem().getDataExpiracao());

            }
            String sql = "select*from produtos where id_produto='" + codProduto.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                dataFabrico.getEditor().setText(rs.getString("data_fabrico"));
                Medida.setText(rs.getString("Medida"));
                

            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }
    }

    @FXML
    public void handelerremover(javafx.event.ActionEvent event) throws SQLException {
      conexao=ModeloConexao.conector();
       
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Confirmação");
        alert.setHeaderText("ATENÇÃO!!!");
        alert.setContentText("Tem certeza que deseja remover este Produto?");

        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(button1, button2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == button1) {
            String sql = "delete from produtos where id_produto=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codProduto.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {

                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmação");
                    alert1.setHeaderText("Atenção!!!");
                    alert1.setContentText("Produto removido com sucesso");
                    alert1.show();
                    codProduto.setText(null);
                    nomeProduto.setText(null);
                    precoVenda.setText(null);
                    precoCompra.setText(null);
                    quatidadeProduto.setText(null);
                    nomeFornecedor.getSelectionModel().select(null);
                    nomeFabricante.setText(null);
                    dataFabrico.getEditor().setText(null);
                    dataExpiracao.getEditor().setText(null);

                }
            } catch (HeadlessException | SQLException ex) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Erro");
                alert2.setHeaderText("Atenção!!");
                alert2.setContentText("Erro\n" + ex);
                alert2.show();

            }
            rs.close();
        }
    }
}
