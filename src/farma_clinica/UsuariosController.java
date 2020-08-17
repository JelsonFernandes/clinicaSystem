/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleUsuarios;
import Modelos.ModeloConexao;
import Modelos.ModeloTabelaUsuarios;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import Modelos.ModeloUsuarios;
import com.jfoenix.controls.JFXButton;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class UsuariosController implements Initializable {

    @FXML
    public TextField IdPesquisar;
    @FXML
    public TextField IdUsuario;
    @FXML
    public TextField NomeUsuario;
    @FXML
    public TextField EmailUsuario;
    @FXML
    public TextField SenhaUsuario;
    @FXML
    public TableView<ModeloTabelaUsuarios> ViewTable;
    @FXML
    public TableColumn<ModeloTabelaUsuarios, String> ID;
    public TableColumn<ModeloTabelaUsuarios, String> NOME;
    public TableColumn<ModeloTabelaUsuarios, String> EMAIL;
    public TableColumn<ModeloTabelaUsuarios, String> PERFIL;
    public TableColumn<ModeloTabelaUsuarios, String> SENHA;
    @FXML
    public ComboBox<String> PerfilUsuario;
    @FXML
    public Button btnsalvar;
    @FXML
    public Button btnpesquisar;
    @FXML
    public Button btnalterar;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ControleUsuarios control = new ControleUsuarios();
    ModeloUsuarios mod = new ModeloUsuarios();
    ObservableList<ModeloTabelaUsuarios> oblist = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnRemover;
    @FXML
    private JFXButton btnBuscar;

    @FXML
    public void handleButtonSalvar(ActionEvent event) throws IOException {
        conexao = ModeloConexao.conector();
//        mod.setNomeUsu(IdUsuario.getText());
        mod.setNomeUsu(NomeUsuario.getText());
        mod.setPerfilUsu((String) PerfilUsuario.getSelectionModel().getSelectedItem());
        mod.setEmailUsu(EmailUsuario.getText());
        mod.setSenhaUsu(SenhaUsuario.getText());
        control.inserirUsuario(mod);

        NomeUsuario.setText(null);
//        PerfilUsuario.setText(null);
        EmailUsuario.setText(null);
        SenhaUsuario.setText(null);

    }

    @FXML
    public void handleButtonalterar(ActionEvent event) throws IOException {
        conexao = ModeloConexao.conector();
//        mod.setNomeUsu(NomeUsuario.getText());
        mod.setNomeUsu(NomeUsuario.getText());
        mod.setPerfilUsu((String) PerfilUsuario.getSelectionModel().getSelectedItem());
        mod.setEmailUsu(EmailUsuario.getText());
        mod.setSenhaUsu(SenhaUsuario.getText());
        mod.setCodUsu(Integer.parseInt(IdUsuario.getText()));
        control.alterarUsuario(mod);

        NomeUsuario.setText(null);
        PerfilUsuario.setId(null);
        EmailUsuario.setText(null);
        SenhaUsuario.setText(null);
        IdUsuario.setText(null);

    }

    @FXML
    public void handleButtonSelecionar(ActionEvent event) {
        ObservableList buscaperfil = FXCollections.observableArrayList();
        conexao = ModeloConexao.conector();
        try {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();

            String sql = "select*from usuarios where id_user=" + dialog.getResult();

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                buscaperfil.add(rs.getString("perfil_user"));

                IdUsuario.setText(String.valueOf(rs.getInt("id_user")));
                NomeUsuario.setText(String.valueOf(rs.getString("nome_user")));
                PerfilUsuario.setItems(buscaperfil);
                EmailUsuario.setText(String.valueOf(rs.getString("email_user")));
                SenhaUsuario.setText(String.valueOf(rs.getString("senha_user")));

            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setContentText("Usuário não Cadastrado");
                alert.show();

            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro"+ex);
            alert.show();
           
        }

    }

    @FXML
    public void PrencherTabela(ActionEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "select*from usuarios";
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            rs.first();
            do {
                oblist.add(new ModeloTabelaUsuarios(rs.getString("id_user"), rs.getString("nome_user"), rs.getString("perfil_user"), rs.getString("email_user"), rs.getString("senha_user")));
            } while (rs.next());

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro"+ex);
            alert.show();
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("IdUsuario"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("NomeUsuario"));
        PERFIL.setCellValueFactory(new PropertyValueFactory<>("PerfilUsuario"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("EmailUsuario"));
        SENHA.setCellValueFactory(new PropertyValueFactory<>("SenhaUsuario"));
        ViewTable.setItems(oblist);
    }

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList perfil = FXCollections.observableArrayList();
        perfil.addAll("Administrador",
                "Usuário",
                "Enfermeiros",
                "Doctor");
        PerfilUsuario.setItems(perfil);

    }

    @FXML
    public void remover(ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Tem certeza que dezeja remover este Usuário?");
        
            ButtonType button1 = new ButtonType("Sim");
            ButtonType button2 = new ButtonType("Não", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(button1, button2);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == button1) {
                String sql = "delete from usuarios where id_user=?";

                pst = conexao.prepareStatement(sql);
                pst.setString(1, IdUsuario.getText());
                pst.execute();
                alert.setContentText("Usuário Removido com sucesso!");
                alert.show();
                NomeUsuario.setText(null);
                PerfilUsuario.setId(null);
                EmailUsuario.setText(null);
                SenhaUsuario.setText(null);
                IdUsuario.setText(null);

            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro"+ex);
            alert.show();
        }

    }

    @FXML
    public void setarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {
            IdUsuario.setText(ViewTable.getFocusModel().getFocusedItem().getIdUsuario());
            NomeUsuario.setText(ViewTable.getFocusModel().getFocusedItem().getNomeUsuario());
            PerfilUsuario.getSelectionModel().select(ViewTable.getFocusModel().getFocusedItem().getPerfilUsuario());
            EmailUsuario.setText(ViewTable.getFocusModel().getFocusedItem().getEmailUsuario());
            SenhaUsuario.setText(ViewTable.getFocusModel().getFocusedItem().getSenhaUsuario());

        }

    }

}
