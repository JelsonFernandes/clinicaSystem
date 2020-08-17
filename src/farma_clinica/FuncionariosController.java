/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleFuncionarios;
import Modelos.ModeloConexao;
import Modelos.ModeloFuncionarios;
import Modelos.ModeloTabelaFuncionarios;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.awt.HeadlessException;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class FuncionariosController implements Initializable {

    @FXML
    public TextField IdFunc;
    @FXML
    public TextField NomeFunc;
    @FXML
    public TextField NumDoc;
    @FXML
    public TextField Telefone;
     @FXML
    public TextField Email;
    @FXML
    public TextField Funcao;
    @FXML
    public TextField Salario;
    @FXML
    public TextField DuracaoContrato;
    @FXML
    public TextField FimContrato;
    @FXML
    public TextField Endereco;
    @FXML
    public TextField Nacionalidade;
    @FXML
    public JFXComboBox<String> TipoDoc;
    @FXML
    public JFXDatePicker Nascimento;
    @FXML
    public DatePicker InicioContrato;
    @FXML
    public TableView<ModeloTabelaFuncionarios> TableViewFuncionarios;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> ID;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> NOME;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> TELEFONE;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> EMAIL;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> NUMDOC;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> FUNCAO;
    @FXML
    public TableColumn<ModeloTabelaFuncionarios, String> SALARIO;
     @FXML
    ToggleGroup grupo = new ToggleGroup();
    @FXML
    public RadioButton M;
    @FXML
    public RadioButton F;
    @FXML
    public Button btnBuscar;
    @FXML
    public TextField Pesquisar;
    @FXML
    public Button SALVAR;
    @FXML
    public Button PESQUISAR;
    @FXML
    public Button ALTERAR;
    @FXML
    public Button REMOVER;

    String Sexo;
    ModeloFuncionarios mod = new ModeloFuncionarios();
    ObservableList<ModeloTabelaFuncionarios> oblist = FXCollections.observableArrayList();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ControleFuncionarios control = new ControleFuncionarios();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        M.setSelected(true);
        M.setToggleGroup(grupo);
        F.setToggleGroup(grupo);
        ObservableList estadio = FXCollections.observableArrayList();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
//            DataAtual.setText(dateFormat.format(cal.getTime()));
        estadio.addAll("Bilhete de Identidade",
                "Passaport",
                "Carta de Condução",
                "NIF");
        TipoDoc.setItems(estadio);

    }

    @FXML
    public void SalvarDados(javafx.event.ActionEvent event) {

        if (M.isSelected()) {
            Sexo = "Masculino";
        } else if (F.isSelected()) {
            Sexo = "Femenino";
        }
        mod.setSexo(Sexo);
        mod.setNomeFunc(NomeFunc.getText());
        mod.setTipoDoc(TipoDoc.getSelectionModel().getSelectedItem());
        mod.setNumDoc(NumDoc.getText());
        mod.setNascimento(Nascimento.getEditor().getText());
        mod.setNacionalidade(Nacionalidade.getText());
        mod.setEndereco(Endereco.getText());
        mod.setTelefone(Telefone.getText());
        mod.setEmail(Email.getText());
        mod.setFuncao(Funcao.getText());
        mod.setSalario(Salario.getText());
        mod.setInicioContrato(InicioContrato.getEditor().getText());
        mod.setDuracaoContrato(DuracaoContrato.getText());
        mod.setFimContrato(FimContrato.getText());
        control.SalvarDados(mod);
        System.out.println(Sexo);
        NomeFunc.setText(null);
        TipoDoc.getSelectionModel().select(null);
        NumDoc.setText(null);
        Nascimento.getEditor().setText(null);
        Nacionalidade.setText(null);
        Endereco.setText(null);
        Telefone.setText(null);
        Email.setText(null);
        Funcao.setText(null);
        Salario.setText(null);
        InicioContrato.getEditor().setText(null);
        DuracaoContrato.setText(null);
        FimContrato.setText(null);
        IdFunc.setText(null);

    }

    @FXML
    public void EditarDados(javafx.event.ActionEvent event) {
//        
        if (M.isSelected()) {
            Sexo = "Masculino";
        } else if (F.isSelected()) {
            Sexo = "Femenino";
        }
        mod.setSexo(Sexo);
        mod.setNomeFunc(NomeFunc.getText());
        mod.setTipoDoc(TipoDoc.getSelectionModel().getSelectedItem());
        mod.setNumDoc(NumDoc.getText());
        mod.setNascimento(Nascimento.getEditor().getText());
        mod.setNacionalidade(Nacionalidade.getText());
        mod.setEndereco(Endereco.getText());
        mod.setTelefone(Telefone.getText());
        mod.setEmail(Email.getText());
        mod.setFuncao(Funcao.getText());
        mod.setSalario(Salario.getText());
        mod.setInicioContrato(InicioContrato.getEditor().getText());
        mod.setDuracaoContrato(DuracaoContrato.getText());
        mod.setFimContrato(FimContrato.getText());
        mod.setIdFunc(IdFunc.getText());
        control.EditarDados(mod);
        NomeFunc.setText(null);
        TipoDoc.getSelectionModel().select(null);
        NumDoc.setText(null);
        Nascimento.getEditor().setText(null);
        Nacionalidade.setText(null);
        Endereco.setText(null);
        Telefone.setText(null);
        Email.setText(null);
        Funcao.setText(null);
        Salario.setText(null);
        InicioContrato.getEditor().setText(null);
        DuracaoContrato.setText(null);
        FimContrato.setText(null);
        IdFunc.setText(null);

    }

    @FXML
    public void BuscarDados(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();

        try {

             TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from funcionarios where id_func=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdFunc.setText(rs.getString("id_func"));
                Sexo = rs.getString("sexo");
                NomeFunc.setText(rs.getString("nome"));
                TipoDoc.getSelectionModel().select(rs.getString("tipoocumento"));
                NumDoc.setText(rs.getString("numdocumento"));
                Nascimento.getEditor().setText(rs.getString("datanasci"));
                Nacionalidade.setText(rs.getString("nacinalidade"));
                Endereco.setText(rs.getString("endereco"));
                Telefone.setText(rs.getString("telefone"));
                Email.setText(rs.getString("email"));
                Funcao.setText(rs.getString("funcao"));
                Salario.setText(rs.getString("salario"));
                InicioContrato.getEditor().setText(rs.getString("iniciofuncao"));
                DuracaoContrato.setText(rs.getString("prazocontrato"));
                FimContrato.setText(rs.getString("fimContrato"));
                if (Sexo.equals("Masculino")) {
                    M.setSelected(true);
                } else if (Sexo.equals("Femenino")) {
                    F.setSelected(true);
                }

            }

        } catch (SQLException ex) {
            Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Erro:"+ex);
                alert.show();
        }

    }

    public void dataFim(MouseEvent event) {
        float Anos = Float.parseFloat(DuracaoContrato.getText().toString());

        String dataSistema = InicioContrato.getEditor().getText();

        char[] vencimento = (dataSistema).toCharArray();
        ;
        String dvencimento1 = (String.valueOf(" " + vencimento[8] + vencimento[9]));
//        FimContrato.setText(data);
        float valor = Float.parseFloat(dvencimento1);
        float total = valor + Anos;

//        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String dataFim = (String.valueOf(" " + vencimento[0] + vencimento[1] + vencimento[2] + vencimento[3] + vencimento[4] + vencimento[5] + vencimento[6] + vencimento[7] + (total)).toString());

        FimContrato.setText(String.valueOf((dataFim)));
    }

    @FXML
    public void preencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from funcionarios where nome like'%" + NomeFunc.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModeloTabelaFuncionarios(rs.getString("id_func"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("numdocumento"), rs.getString("funcao"), rs.getString("salario")));

            }
            ID.setCellValueFactory(new PropertyValueFactory<>("IdFunc"));
            NOME.setCellValueFactory(new PropertyValueFactory<>("NomeFunc"));
            TELEFONE.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
            EMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
            NUMDOC.setCellValueFactory(new PropertyValueFactory<>("NumDoc"));
            FUNCAO.setCellValueFactory(new PropertyValueFactory<>("Funcao"));
            SALARIO.setCellValueFactory(new PropertyValueFactory<>("Salario"));
            TableViewFuncionarios.setItems(oblist);
        } catch (SQLException ex) {
             Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Erro:"+ex);
                alert.show();
        }
    }

    @FXML
    public void SetaCampos(MouseEvent event) {
        try {
            if (event.getClickCount() == 1) {
                IdFunc.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getIdFunc());
                NomeFunc.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getNomeFunc());
                Telefone.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getTelefone());
                Email.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getEmail());
                NumDoc.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getNumDoc());
                Funcao.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getFuncao());
                Salario.setText(TableViewFuncionarios.getFocusModel().getFocusedItem().getSalario());
                
            }
            String sql = "select*from funcionarios where id_func=" + IdFunc.getText();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                Sexo = rs.getString("sexo");
                TipoDoc.getSelectionModel().select(rs.getString("tipoocumento"));
                Nascimento.getEditor().setText(rs.getString("datanasci"));
                Nacionalidade.setText(rs.getString("nacinalidade"));
                Endereco.setText(rs.getString("endereco"));
                InicioContrato.getEditor().setText(rs.getString("iniciofuncao"));
                DuracaoContrato.setText(rs.getString("prazocontrato"));
                FimContrato.setText(rs.getString("fimContrato"));
                if (Sexo.equals("Masculino")) {
                    M.setSelected(true);
                } else if (Sexo.equals("Femenino")) {
                    F.setSelected(true);
                }
                
            }
        } catch (SQLException ex) {
          Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ATENÇÃO!!!");
                alert.setContentText("Erro:"+ex);
                alert.show();
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
            if (result.get() == button1)  {
            String sql = "delete from funcionarios where id_func=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, IdFunc.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    Alert alert2= new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Erro");
                alert2.setHeaderText("ATENÇÃO!!!");
                alert2.setContentText( "Dados removidos com sucesso");
                alert2.show();
                   
                    IdFunc.setText(null);
                    NomeFunc.setText(null);
                    TipoDoc.getSelectionModel().select(null);
                    NumDoc.setText(null);
                    Nascimento.getEditor().setText(null);
                    Nacionalidade.setText(null);
                    Endereco.setText(null);
                    Telefone.setText(null);
                    Email.setText(null);
                    Funcao.setText(null);
                    Salario.setText(null);
                    InicioContrato.getEditor().setText(null);
                    DuracaoContrato.setText(null);
                    FimContrato.setText(null);

                }
            } catch (HeadlessException | SQLException e) {
                Alert alert1= new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erro");
                alert1.setHeaderText("ATENÇÃO!!!");
                alert1.setContentText("Erro:"+e);
                alert1.show();
                

            }
        }
    }

}
