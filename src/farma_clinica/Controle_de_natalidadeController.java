/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleNatalidade;
import Modelos.ModeloConexao;
import Modelos.ModeloNatalidade;
import Modelos.ModeloTabelaMorte;
import Modelos.ModeloTabelaNatalidade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class Controle_de_natalidadeController implements Initializable {

    @FXML
    private JFXRadioButton Masculino;
    @FXML
    private JFXRadioButton Femenino;
    @FXML
    private JFXRadioButton RNegra;
    @FXML
    private JFXRadioButton RBranca;
    @FXML
    private JFXRadioButton RMista;
    @FXML
    private JFXTextField IdPaciente;
    @FXML
    private JFXTextField NomePaciente;
    @FXML
    private JFXTextField IdNatalidade;
    @FXML
    private JFXTextArea Descricao;
    @FXML
    private JFXTextField Parteira;
    @FXML
    private JFXButton btnParteira;
    @FXML
    private JFXTextField Data;
    @FXML
    private JFXTextField NomePai;
    @FXML
    private JFXDatePicker DataNascimento;
    @FXML
    private JFXTimePicker HoraNascimento;
    @FXML
    private JFXComboBox<String> EstadoRNascido;
    @FXML
    private JFXComboBox<String> EstadoMãe;
    @FXML
    private JFXComboBox<String> TipoParto;
    @FXML
    private JFXTextField Peso;
    @FXML
    private JFXTextField NomeRNascido;
    @FXML
    private TreeTableView<ModeloTabelaNatalidade> TableViewNatalidade;
//    @FXML
//    private TableColumn<?, ?> ID;
//    @FXML
//    private TableColumn<?, ?> PACIENTE;
//    @FXML
//    private TableColumn<?, ?> RECEM_NASCIDO;
//    @FXML
//    private TableColumn<?, ?> PARTEIRA;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXTextField Pesquisar;
    @FXML
    private JFXButton btnAlterar;
    @FXML
    private JFXButton btnRemover;
    @FXML
    private JFXButton btnSalvar;
    public ToggleGroup grupo = new ToggleGroup();
    public ToggleGroup grupo1 = new ToggleGroup();
    String Sexo = null;
    String Raca = null;
    ModeloNatalidade mod = new ModeloNatalidade();
    ControleNatalidade control = new ControleNatalidade();
    ObservableList<ModeloTabelaNatalidade> oblist=FXCollections.observableArrayList();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal= Calendar.getInstance();
        Data.setText(df.format(cal.getTime()));
        Masculino.setSelected(true);
        Masculino.setToggleGroup(grupo);
        Femenino.setToggleGroup(grupo);
        RNegra.setSelected(true);
        RNegra.setToggleGroup(grupo1);
        RBranca.setToggleGroup(grupo1);
        RMista.setToggleGroup(grupo1);
        EstadoRNascido.getItems().addAll("Normal",
                "A Normal");
        EstadoMãe.getItems().addAll("Normal",
                "A Normal");
        TipoParto.getItems().addAll("Sem conplicações",
                "Com conplicações");

    }

    public void SalvarDados(javafx.event.ActionEvent event) {
        if (Masculino.isSelected()) {
            Sexo = "Masculino";
        } else if (Femenino.isSelected()) {
            Sexo = "Femenino";
        }
        if (RNegra.isSelected()) {
            Raca = "Negra";
        } else if (RBranca.isSelected()) {
            Raca = "Branca";
        } else if (RMista.isSelected()) {
            Raca = "Mista";
        }
        mod.setSexo(Sexo);
        mod.setRaca(Raca);
        mod.setIdPaciente(IdPaciente.getText());
        mod.setNomePaciente(NomePaciente.getText());
        mod.setParteira(Parteira.getText());
        mod.setDescricao(Descricao.getText());
//        mod.setData(Data.getText());
        mod.setNomePai(NomePai.getText());
        mod.setDataNascimento(DataNascimento.getEditor().getText());
        mod.setHoraNascimento(HoraNascimento.getEditor().getText());
        mod.setEstadoRNascido(EstadoRNascido.getSelectionModel().getSelectedItem());
        mod.setEstadoMãe(EstadoMãe.getSelectionModel().getSelectedItem());
        mod.setTipoParto(TipoParto.getSelectionModel().getSelectedItem());
        mod.setPeso(Peso.getText());
        mod.setNomeRNascido(NomeRNascido.getText());
        control.salvarDados(mod);

        IdPaciente.setText(null);
        NomePaciente.setText(null);
        Parteira.setText(null);
        Data.setText(null);
        NomePai.setText(null);
        DataNascimento.getEditor().setText(null);
        HoraNascimento.getEditor().setText(null);
        EstadoRNascido.getSelectionModel().select(null);
        EstadoRNascido.getSelectionModel().select(null);
        EstadoMãe.getSelectionModel().select(null);
        TipoParto.getSelectionModel().select(null);
        Peso.setText(null);
        NomeRNascido.setText(null);

    }

    public void AlterarDados(javafx.event.ActionEvent event) {
        if (Masculino.isSelected()) {
            Sexo = "Masculino";
        } else if (Femenino.isSelected()) {
            Sexo = "Femenino";
        }
        if (RNegra.isSelected()) {
            Raca = "Negra";
        } else if (RBranca.isSelected()) {
            Raca = "Branca";
        } else if (RMista.isSelected()) {
            Raca = "Mista";
        }
        mod.setSexo(Sexo);
        mod.setRaca(Raca);
        mod.setIdPaciente(IdPaciente.getText());
        mod.setNomePaciente(NomePaciente.getText());
        mod.setParteira(Parteira.getText());
        mod.setDescricao(Descricao.getText());
//        mod.setData(Data.getText());
        mod.setNomePai(NomePai.getText());
        mod.setDataNascimento(DataNascimento.getEditor().getText());
        mod.setHoraNascimento(HoraNascimento.getEditor().getText());
        mod.setEstadoRNascido(EstadoRNascido.getSelectionModel().getSelectedItem());
        mod.setEstadoMãe(EstadoMãe.getSelectionModel().getSelectedItem());
        mod.setTipoParto(TipoParto.getSelectionModel().getSelectedItem());
        mod.setPeso(Peso.getText());
        mod.setNomeRNascido(NomeRNascido.getText());
        mod.setIdNatalidade(IdNatalidade.getText());
        control.alterarDados(mod);

        IdPaciente.setText(null);
        NomePaciente.setText(null);
        Parteira.setText(null);
        Data.setText(null);
        NomePai.setText(null);
        DataNascimento.getEditor().setText(null);
        HoraNascimento.getEditor().setText(null);
        EstadoRNascido.getSelectionModel().select(null);
        EstadoRNascido.getSelectionModel().select(null);
        EstadoMãe.getSelectionModel().select(null);
        TipoParto.getSelectionModel().select(null);
        Peso.setText(null);
        NomeRNascido.setText(null);
        IdNatalidade.setText(null);

    }

    public void BuscarPorId(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        System.out.println("A vida é assim");
        try {
//             String resultado=null;
//            String  codigo="select*from natalidade";
//             pst = conexao.prepareStatement(codigo);
//            rs = pst.executeQuery();
//            while(rs.next()){
//              resultado=rs.getString("id_natal");
//            }
            String resultado = null;
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("Look, a Text Input Dialog");
//            dialog.setContentText("Please enter your name:");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from natalidade where id_natal=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdNatalidade.setText(rs.getString("id_natal"));
                Sexo = rs.getString("sexo");
                Raca = rs.getString("raca");
                IdPaciente.setText("id_paciente");
                NomePaciente.setText(rs.getString("nome_paciente"));
                Descricao.setText(rs.getString("descricao"));
                Parteira.setText(rs.getString("parteiira"));
                Data.setText(rs.getString("data"));
                NomePai.setText(rs.getString("nome_pai"));
                DataNascimento.getEditor().setText(rs.getString("datanascimento"));
                HoraNascimento.getEditor().setText(rs.getString("hora_nascimento"));
                EstadoRNascido.getSelectionModel().select(rs.getString("estado_rnascido"));
                EstadoMãe.getSelectionModel().select(rs.getString("estado_mae"));
                TipoParto.getSelectionModel().select(rs.getString("tipo_parto"));
                Peso.setText(rs.getString("peso"));
                NomeRNascido.setText(rs.getString("nome_rnascido"));
//                
                System.out.println("O Código é: " + rs.getString("id_natal"));
//                sexo,raca,id_paciente,nome_paciente,descricao,parteiira,nome_pai,datanascimento,hora_nascimento,estado_rnascido,estado_mae,tipo_parto,peso,nome_rnascido
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Dados não ecnontrados");
                alert.setResizable(true);
//        alert.setDialogPane(root);
                alert.initModality(Modality.WINDOW_MODAL);
            }
            System.out.println("A vida é assim");

        } catch (SQLException ex) {
//           Alert alert = new Alert(Alert.AlertType.ERROR);
//           alert.setTitle("Erro ao Buscar:\n"+ex);
//           alert.show();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro ao Buscar:\n" + ex);
            alert.setResizable(true);
//        alert.setDialogPane(root);
            alert.show();
            System.out.println("Erro:\n" + ex);
        }

    }
    public void RemoverDados(javafx.event.ActionEvent event){
        conexao=ModeloConexao.conector();
      ChoiceDialog choiceDialog= new ChoiceDialog();
      choiceDialog.getItems().addAll("SIM","NÃO");
      choiceDialog.setTitle("Dezeja mesmos remover estes dados?");
      choiceDialog.showAndWait();
if(choiceDialog.equals("SIM")){
            try {
                Alert al =new Alert(Alert.AlertType.INFORMATION);
                al.setTitle("Reconheceu");
                al.show();
                String sql="delete from natalidade where id_natal=?";
                pst=conexao.prepareStatement(sql);
                pst.setString(1, IdNatalidade.getText());
                pst.execute();
            } catch (SQLException ex) {
               Alert alert= new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Erro:"+ex);
               alert.show();
            }
    
};
      
    }
     public void preencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from natalidade where nome_paciente like'%" + Pesquisar.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
                
             while (rs.next()){
                 oblist.add(new ModeloTabelaNatalidade(rs.getString("id_natal"),rs.getString("nome_paciente"), rs.getString("nome_rnascido"),rs.getString("parteiira")));
             }
            JFXTreeTableColumn<ModeloTabelaNatalidade, String> ID=new JFXTreeTableColumn<>("ID");
            ID.setPrefWidth(80);
            ID.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaNatalidade, String> param) -> param.getValue().getValue().getId());
             JFXTreeTableColumn<ModeloTabelaNatalidade, String> PACIENTE=new JFXTreeTableColumn<>("PACIENTE");
            PACIENTE.setPrefWidth(200);
            PACIENTE.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaNatalidade, String> param) -> param.getValue().getValue().getPaciente());
             JFXTreeTableColumn<ModeloTabelaNatalidade, String> RECEM_NASCIDO=new JFXTreeTableColumn<>("RECEM NASCIDO");
            RECEM_NASCIDO.setPrefWidth(200);
             
            RECEM_NASCIDO.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaNatalidade, String> param) -> param.getValue().getValue().getRecem_Nascido());
            JFXTreeTableColumn<ModeloTabelaNatalidade, String> PARTEIRA=new JFXTreeTableColumn<>("PARTEIRA");
            PARTEIRA.setPrefWidth(200);
            PARTEIRA.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaNatalidade, String> param) -> param.getValue().getValue().getParteira());
            
            
final TreeItem<ModeloTabelaNatalidade> root= new RecursiveTreeItem<>(oblist,RecursiveTreeObject::getChildren);
TableViewNatalidade.getColumns().setAll(ID,PACIENTE,RECEM_NASCIDO,PARTEIRA);
TableViewNatalidade.setRoot(root);
TableViewNatalidade.setShowRoot(false);

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);
        }
    }

}
