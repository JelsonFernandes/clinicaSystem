/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleMedicos;
import Modelos.ModeloConexao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import Modelos.ModeloMedicos;
import Modelos.ModeloTabelaEnfermeiro;
import Modelos.ModeloTabelaMedico;
import com.jfoenix.controls.JFXButton;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class MedicosController implements Initializable {

    @FXML
    public TextField txtEspecialidade;
    @FXML
    public TextField txtPesquisar;
    @FXML
    public TextField txtid;
    @FXML
    public TextField txt_nome;
    @FXML
    public DatePicker txt_nascimento;
    @FXML
    public TextField txt_morada;
    @FXML
    public TextField txt_bi;
    @FXML
    public TextField txt_carteira;
    @FXML
    public TextField txt_fone;
    @FXML
    public TableView<ModeloTabelaMedico> Table_medico;
    @FXML
    public TableColumn<ControleMedicos, String> ID;
    @FXML
    public TableColumn<ControleMedicos, String> NOME;
    @FXML
    public TableColumn<ControleMedicos, String> NASCIMENTO;
    @FXML
    public TableColumn<ControleMedicos, String> MORADA;
    @FXML
    public TableColumn<ControleMedicos, String> TELEFONE;
    @FXML
    public TableColumn<ControleMedicos, String> BI;
    @FXML
    public TableColumn<ControleMedicos, String> CARTEIRA;
    @FXML
    public TableColumn<ControleMedicos, String> ESPECIALIDADE;
    @FXML
    public ImageView img_foto;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ControleMedicos control = new ControleMedicos();
    ModeloMedicos mod = new ModeloMedicos();
    ObservableList<ModeloTabelaMedico> oblist = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnsalvar;
    @FXML
    private JFXButton Alterar;
    @FXML
    private JFXButton Remover;
    @FXML
    private JFXButton Buscar;

    public void handleButtonSalvar(ActionEvent event) {
        conexao = ModeloConexao.conector();
//        mod.setNomeUsu(IdUsuario.getText());
        mod.setNomeMedico(txt_nome.getText());
        mod.setNasciMedico(txt_nascimento.getEditor().getText());
        mod.setMoraMedico(txt_morada.getText());
        mod.setBiMedico(txt_bi.getText());
        mod.setCartMedico(txt_carteira.getText());
        mod.setFoneMedico(txt_fone.getText());
        mod.setTxtEspecialidade(txtEspecialidade.getText());
        control.inserirMedico(mod);

        txtid.setText(null);
        txt_nome.setText(null);
        txt_nascimento.getEditor().setText(null);
        txt_morada.setText(null);
        txt_fone.setText(null);
        txt_bi.setText(null);
        txt_carteira.setText(null);
        txtEspecialidade.setText(null);
    }

    public void handleButtonalterar(ActionEvent event) throws IOException {
        mod.setNomeMedico(txt_nome.getText());
        mod.setNasciMedico(txt_nascimento.getEditor().getText());
        mod.setMoraMedico(txt_morada.getText());
        mod.setBiMedico(txt_bi.getText());
        mod.setCartMedico(txt_carteira.getText());
        mod.setFoneMedico(txt_fone.getText());
        mod.setTxtEspecialidade(txtEspecialidade.getText());
        mod.setCodMedico(Integer.parseInt(txtid.getText()));

        control.alterarMedico(mod);
        txtid.setText(null);
        txt_nome.setText(null);
        txt_nascimento.getEditor().setText(null);
        txt_morada.setText(null);
        txt_fone.setText(null);
        txt_bi.setText(null);
        txt_carteira.setText(null);
        txtEspecialidade.setText(null);

    }

    public void handleButtonSelecionar(ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
//        

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from medicos where id_medico=" + dialog.getResult();

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

//mod = control.buscaUsuario(mod);
                txtid.setText(String.valueOf(rs.getInt("id_medico")));
                txt_nome.setText(String.valueOf(rs.getString("nome_medico")));
                txt_nascimento.getEditor().setText(String.valueOf(rs.getString("nascimento")));
                txt_morada.setText(String.valueOf(rs.getString("morada")));
                txt_bi.setText(String.valueOf(rs.getString("bi_medico")));
                txt_carteira.setText(String.valueOf(rs.getString("carteira_medico")));
                txt_fone.setText(String.valueOf(rs.getString("fone_medico")));
                txtEspecialidade.setText(String.valueOf(rs.getString("especial_medico")));

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Médico não Cadastrado");
                alert.show();

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
    public void preencherTabela(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        String sql = ("select*from medicos  where nome_medico like'%" + txtPesquisar.getText() + "%'");
//        where nome_medico ='"+txtPesquisar.getText()+"%'");

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//
//            do {
//                           
                oblist.add(new ModeloTabelaMedico(rs.getString("id_medico"), rs.getString("nome_medico"), rs.getString("nascimento"), rs.getString("morada"), rs.getString("fone_medico"), rs.getString("bi_medico"), rs.getString("carteira_medico"), rs.getString("especial_medico")));
            }
//            } while(rs.next());

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("ATENÇÃO!!!");
            alert.setContentText("Erro:" + ex);
            alert.show();
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("txtid"));
        NOME.setCellValueFactory(new PropertyValueFactory<>("txt_nome"));
        NASCIMENTO.setCellValueFactory(new PropertyValueFactory<>("Nascimento"));
        MORADA.setCellValueFactory(new PropertyValueFactory<>("txt_morada"));
        TELEFONE.setCellValueFactory(new PropertyValueFactory<>("txt_fone"));
        BI.setCellValueFactory(new PropertyValueFactory<>("txt_bi"));
        CARTEIRA.setCellValueFactory(new PropertyValueFactory<>("txt_carteira"));
        ESPECIALIDADE.setCellValueFactory(new PropertyValueFactory<>("Especialidade"));
        Table_medico.setItems(oblist);

    }

    @FXML
    public void SetarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {

            txtid.setText(Table_medico.getFocusModel().getFocusedItem().getTxtid());
            txt_nome.setText(Table_medico.getFocusModel().getFocusedItem().getTxt_nome());
            txt_nascimento.getEditor().setText(Table_medico.getFocusModel().getFocusedItem().getNascimento());
            txt_morada.setText(Table_medico.getFocusModel().getFocusedItem().getTxt_morada());
            txt_fone.setText(Table_medico.getFocusModel().getFocusedItem().getTxt_fone());
            txt_bi.setText(Table_medico.getFocusModel().getFocusedItem().getTxt_bi());
            txt_carteira.setText(Table_medico.getFocusModel().getFocusedItem().getTxt_carteira());
            txtEspecialidade.setText(Table_medico.getFocusModel().getFocusedItem().getEspecialidade());
        }

    }

    public void handelerremover(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText("ATENÇÃO!!!");
        alert.setContentText("Tem certeza que dezeja remover este Usuário?");

        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(button1, button2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == button1) {
            String sql = "delete from medicos where id_medico=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtid.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Confirmação");
                alert1.setHeaderText("ATENÇÃO!!!");
                alert1.setContentText("Médico removido com sucesso");
                alert1.show();
                   
                    txt_nome.setText(null);
                    txt_nascimento.getEditor().setText(null);
                    txt_morada.setText(null);
                    txt_bi.setText(null);
                    txt_carteira.setText(null);
                    txt_fone.setText(null);
                    txtid.setText(null);
                    txtEspecialidade.setText(null);

                }
            } catch (Exception e) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("ATENÇÃO!!!");
                alert1.setContentText("Erro:" + e);
                alert1.show();

            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        conexao = ModeloConexao.conector();
    }

}
