/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleEnfermeiro;
import Modelos.ModeloConexao;
import Modelos.ModeloEnfermeiro;
import Modelos.ModeloTabelaEnfermeiro;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class EnfermeiroController implements Initializable {

    @FXML
    public TextField txtPesquisar;
    @FXML
    public TextField txtid;
    @FXML
    public TextField txt_nome;
    @FXML
    public TextField txt_morada;
    @FXML
    public TextField txt_bi;
    @FXML
    public TextField txt_carteira;
    @FXML
    public TextField txt_fone;
    @FXML
    public ImageView img_foto1;
    @FXML
    public Button btSalvar;
    @FXML
    public Button btPesquisar;
    @FXML
    public Button btAlterar;
    @FXML
    public Button btRemover;
    public DatePicker Nascimento;
    @FXML
    public TableView<ModeloTabelaEnfermeiro> ViewTableEnfermeiro;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> ID;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> NOME;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> TELEFONE;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> NASCIMENTO;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> MORADA;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> BI;
    @FXML
    public TableColumn<ModeloTabelaEnfermeiro, String> CARTEIRA;
    ObservableList<ModeloTabelaEnfermeiro> oblist = FXCollections.observableArrayList();
    ModeloEnfermeiro mod = new ModeloEnfermeiro();
    ControleEnfermeiro control = new ControleEnfermeiro();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private JFXButton Buscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handelerSalvarDados(javafx.event.ActionEvent event) {
        mod.setTxt_nome(txt_nome.getText());
        mod.setNascimento(Nascimento.getEditor().getText());
        mod.setTxt_morada(txt_morada.getText());
        mod.setTxt_bi(txt_bi.getText());
        mod.setTxt_carteira(txt_carteira.getText());
        mod.setTxt_fone(txt_fone.getText());
        control.Salvar(mod);

        txt_nome.setText(null);
        txtid.setText(null);
        txt_morada.setText(null);
        Nascimento.setAccessibleText(null);
        txt_bi.setText(null);
        txt_carteira.setText(null);
        txt_fone.setText(null);

    }

    public void handelerAlterarDados(javafx.event.ActionEvent event) {
        mod.setTxt_nome(txt_nome.getText());
        mod.setNascimento(Nascimento.getEditor().getText());
        mod.setTxt_morada(txt_morada.getText());
        mod.setTxt_bi(txt_bi.getText());
        mod.setTxt_carteira(txt_carteira.getText());
        mod.setTxt_fone(txt_fone.getText());
        mod.setTxtid(txtid.getText());
        control.Alterar(mod);

        txt_nome.setText(null);
        txtid.setText(null);
        txt_morada.setText(null);
        Nascimento.setAccessibleText(null);
        txt_bi.setText(null);
        txt_carteira.setText(null);
        txt_fone.setText(null);

    }

    public void handleButtonSelecionar(javafx.event.ActionEvent event) {
        System.out.println("Love forever");
        conexao = ModeloConexao.conector();
        try {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from enfermeiros where id_enfermeiro=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            txtid.setText(rs.getString("id_enfermeiro"));
            txt_nome.setText(rs.getString("nome_enfermeiro"));
            Nascimento.getEditor().setText(rs.getString("nascimento"));
            txt_morada.setText(rs.getString("morada"));
            txt_bi.setText(rs.getString("bi_enfermeiro"));
            txt_carteira.setText(rs.getString("carteira_enfermeiro"));
            txt_fone.setText(rs.getString("fone_enfermeiro"));
//id_enfermeiro, nome_enfermeiro, nascimento, morada, bi_enfermeiro, carteira_enfermeiro, fone_enfermeiro, especial_enfermeiro, id_enfermeiro, id
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }

    }

    @FXML
    public void preencherTabela(KeyEvent event) {

        conexao = ModeloConexao.conector();

        String sql = ("select*from enfermeiros where nome_enfermeiro like'%" + txtPesquisar.getText() + "%'");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//            do {
//                           
                oblist.add(new ModeloTabelaEnfermeiro(rs.getString("id_enfermeiro"), rs.getString("nome_enfermeiro"), rs.getString("nascimento"), rs.getString("morada"), rs.getString("bi_enfermeiro"), rs.getString("fone_enfermeiro"), rs.getString("carteira_enfermeiro")));
            }
//            } while (rs.next());
//id_enfermeiro, nome_enfermeiro, nascimento, morada, bi_enfermeiro, carteira_enfermeiro, fone_enfermeiro, especial_enfermeiro, id_enfermeiro, id
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro\n" + ex);

        }
        ID.setCellValueFactory(new PropertyValueFactory<>("txtid"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("txt_nome"));
        NASCIMENTO.setCellValueFactory(new PropertyValueFactory<>("Nascimento"));
        MORADA.setCellValueFactory(new PropertyValueFactory<>("txt_morada"));
        BI.setCellValueFactory(new PropertyValueFactory<>("txt_bi"));
        TELEFONE.setCellValueFactory(new PropertyValueFactory<>("txt_fone"));
        CARTEIRA.setCellValueFactory(new PropertyValueFactory<>("txt_carteira"));
        ViewTableEnfermeiro.setItems(oblist);

    }
    //PreencherTabela com o botão ActionEvent///////////////////////////////////////////////////

    public void fillTableView(javafx.event.ActionEvent event) {

        conexao = ModeloConexao.conector();

        String sql = ("select*from enfermeiros where nome_enfermeiro like'%" + txtPesquisar.getText() + "%'");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//            do {
//                           
                oblist.add(new ModeloTabelaEnfermeiro(rs.getString("id_enfermeiro"), rs.getString("nome_enfermeiro"), rs.getString("nascimento"), rs.getString("morada"), rs.getString("bi_enfermeiro"), rs.getString("fone_enfermeiro"), rs.getString("carteira_enfermeiro")));
            }
//            } while (rs.next());
//id_enfermeiro, nome_enfermeiro, nascimento, morada, bi_enfermeiro, carteira_enfermeiro, fone_enfermeiro, especial_enfermeiro, id_enfermeiro, id
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList!|nERRO:" + ex);
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("txtid"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("txt_nome"));
        NASCIMENTO.setCellValueFactory(new PropertyValueFactory<>("Nascimento"));
        MORADA.setCellValueFactory(new PropertyValueFactory<>("txt_morada"));
        BI.setCellValueFactory(new PropertyValueFactory<>("txt_bi"));
        TELEFONE.setCellValueFactory(new PropertyValueFactory<>("txt_fone"));
        CARTEIRA.setCellValueFactory(new PropertyValueFactory<>("txt_carteira"));
        ViewTableEnfermeiro.setItems(oblist);

    }

    public void handelerremover(javafx.event.ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("ATENÇÃO!!!");
        alert.setContentText("Tem certeza que dezeja remover este Usuário?");

        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(button1, button2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == button1){
            String sql = "delete from enfermeiros where id_enfermeiro=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtid.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("ERRO");
                    alert1.setHeaderText("ATENÇÃO!!!");
                    alert1.setContentText(" Enfermeiro removido com sucesso");
                    txt_nome.setText(null);
                    txtid.setText(null);
                    txt_morada.setText(null);
                    Nascimento.setAccessibleText(null);
                    txt_bi.setText(null);
                    txt_carteira.setText(null);
                    txt_fone.setText(null);

                }
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Erro");
                alert2.setHeaderText("ATENÇÃO!!!");
                alert2.setContentText("Erro:" + e);
                alert2.show();

            }
        }
    }

    @FXML
    public void setarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {
            txtid.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxtid());
            txt_nome.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxt_nome());
            Nascimento.getEditor().setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getNascimento());
            txt_morada.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxt_morada());
            txt_bi.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxt_bi());
            txt_fone.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxt_fone());
            txt_carteira.setText(ViewTableEnfermeiro.getFocusModel().getFocusedItem().getTxt_carteira());

        }

    }

}
