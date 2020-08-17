/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleMortalidade;
import Modelos.ModeloConexao;
import Modelos.ModeloMortalidade;
import Modelos.ModeloTabelaMorte;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class ControlemorteController implements Initializable {

    @FXML
    private JFXTextField Medico;
    @FXML
    private JFXTextField NomePaciente;
    @FXML
    private JFXTextField IdAgenda;
    @FXML
    private JFXDatePicker DataMorte;
    @FXML
    private JFXTextField PrimeraConsulta;
    @FXML
    private JFXTextArea Queixa;
    @FXML
    private JFXTextArea Diagnostico;
    @FXML
    private JFXTextArea MedicacaoRecomendada;
    @FXML
    private JFXDatePicker QuandoPiorou;
    @FXML
    private JFXTextArea TentativaReanimacao;
    @FXML
    private TreeTableView<ModeloTabelaMorte> TableViewMortalidade;
//    @FXML
//    private TreeTableColumn<ModeloTabelaMorte, String> ID;
//    @FXML
//    private TreeTableColumn<ModeloTabelaMorte, String> NOME;
//    @FXML
//    private TreeTableColumn<ModeloTabelaMorte, String> DATA;
    @FXML
    private JFXTimePicker HoraMorte;
    @FXML
    private JFXButton Buscar;
    @FXML
    private JFXTextField Pesquisar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXButton btnActualizar;
    @FXML
    private JFXButton btnRemover;
    @FXML
    private JFXTextField IdMorte;
    @FXML
    private JFXTextField IdConsulta;
    @FXML
    public JFXTextField Data;
    public HBox HBPane;
    ObservableList<ModeloTabelaMorte> oblist = FXCollections.observableArrayList();
    ControleMortalidade control = new ControleMortalidade();
    ModeloMortalidade mod = new ModeloMortalidade();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

//id_morte,id_paciente,nome_paciente,id_agenda,id_consulta,data_morte,hora_morte,pri_consulta,queixa,diagnostico,med_recomed,quando_piorou,data_registro,tenta_anima
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
////        HBPane.layout(javafx.scene.paint.Color.TRANSPARENT);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        Data.setText(dateFormat.format(cal.getTime()));
        System.out.println("1986");
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from consultorio inner join pacientes on consultorio.paciente=pacientes.nome_paciente";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.last();
            IdConsulta.setText(rs.getString("idconsulta"));
            Medico.setText(rs.getString("medico"));
            NomePaciente.setText(rs.getString("paciente"));
            IdAgenda.setText(rs.getString("idagenda"));
            PrimeraConsulta.setText(rs.getString("pri_consulta"));
            Queixa.setText(rs.getString("queixa"));
            Diagnostico.setText(rs.getString("diagpri"));
            MedicacaoRecomendada.setText(rs.getString("recomendacoes"));
            //Faz a inserção

            conexao = ModeloConexao.conector();
            String sql1 = "select*from mortalidade";
            pst = conexao.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.last();
            IdMorte.setText(rs.getString("id_morte"));
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);

        }

    }

    public void ActualizarDados(javafx.event.ActionEvent event) {
        mod.setMedico(Medico.getText());
        mod.setNomePaciente(NomePaciente.getText());
        mod.setIdAgenda(IdAgenda.getText());
        mod.setIdConsulta(IdConsulta.getText());
        mod.setDataMorte(DataMorte.getEditor().getText());
        mod.setHoraMorte(HoraMorte.getEditor().getText());
        mod.setPrimeraConsulta(PrimeraConsulta.getText());
        mod.setQueixa(Queixa.getText());
        mod.setDiagnostico(Diagnostico.getText());
        mod.setMedicacaoRecomendada(MedicacaoRecomendada.getText());
        mod.setQuandoPiorou(QuandoPiorou.getEditor().getText());
        mod.setTentativaReanimacao(TentativaReanimacao.getText());
        mod.setIdMorte(IdMorte.getText());
        control.ActualizaMorte(mod);
        IdMorte.setText(null);
        IdConsulta.setText(null);
        Medico.setText(null);
        NomePaciente.setText(null);
        IdAgenda.setText(null);
        DataMorte.getEditor().setText(null);
        HoraMorte.getEditor().setText(null);
        PrimeraConsulta.setText(null);
        Queixa.setText(null);
        Diagnostico.setText(null);
        MedicacaoRecomendada.setText(null);
        QuandoPiorou.getEditor().setText(null);
        TentativaReanimacao.setText(null);
    }

    public void PesquisarDados(javafx.event.ActionEvent event) {
        try {

            conexao = ModeloConexao.conector();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Pesquisar Morte");
            dialog.setHeaderText("INSIRA O ID DA MORTE");
            dialog.showAndWait();
            String sql = "select*from mortalidade where id_morte=" + dialog.getResult();

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            IdMorte.setText(rs.getString("id_morte"));
            IdConsulta.setText(rs.getString("id_consulta"));
            Medico.setText(rs.getString("medico"));
            NomePaciente.setText(rs.getString("nome_paciente"));
            IdAgenda.setText(rs.getString("id_agenda"));
            DataMorte.getEditor().setText(rs.getString("data_morte"));
            HoraMorte.getEditor().setText(rs.getString("hora_morte"));
            PrimeraConsulta.setText(rs.getString("pri_consulta"));
            Queixa.setText(rs.getString("queixa"));
            Diagnostico.setText(rs.getString("diagnostico"));
            MedicacaoRecomendada.setText(rs.getString("med_recomed"));
            QuandoPiorou.getEditor().setText(rs.getString("quando_piorou"));
            TentativaReanimacao.setText(rs.getString("tenta_anima"));
//            

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);
            System.out.println("Erro:\n" + ex);

        }

    }

    public void Remover(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "delete from mortalidade where id_morte=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, IdMorte.getText());
            pst.execute();
            IdMorte.setText(null);
            IdConsulta.setText(null);
            Medico.setText(null);
            NomePaciente.setText(null);
            IdAgenda.setText(null);
            DataMorte.getEditor().setText(null);
            HoraMorte.getEditor().setText(null);
            PrimeraConsulta.setText(null);
            Queixa.setText(null);
            Diagnostico.setText(null);
            MedicacaoRecomendada.setText(null);
            QuandoPiorou.getEditor().setText(null);
            TentativaReanimacao.setText(null);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);
        }

    }

    public void preencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from mortalidade where nome_paciente like'%" + Pesquisar.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
                
             while (rs.next()){
                 oblist.add(new ModeloTabelaMorte(rs.getString("id_morte"), rs.getString("nome_paciente"), rs.getString("data_morte")));
             }
            JFXTreeTableColumn<ModeloTabelaMorte, String> ID=new JFXTreeTableColumn<>("ID");
            ID.setPrefWidth(80);
            ID.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaMorte, String> param) -> param.getValue().getValue().getId());
             JFXTreeTableColumn<ModeloTabelaMorte, String> NOME=new JFXTreeTableColumn<>("NOME");
            NOME.setPrefWidth(255);
            NOME.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaMorte, String> param) -> param.getValue().getValue().getNome());
             JFXTreeTableColumn<ModeloTabelaMorte, String> DATA=new JFXTreeTableColumn<>("DATA");
            DATA.setPrefWidth(120);
             
            DATA.setCellValueFactory((TreeTableColumn.CellDataFeatures<ModeloTabelaMorte, String> param) -> param.getValue().getValue().getData());
            
final TreeItem<ModeloTabelaMorte> root= new RecursiveTreeItem<>(oblist,RecursiveTreeObject::getChildren);
TableViewMortalidade.getColumns().setAll(ID,NOME,DATA);
TableViewMortalidade.setRoot(root);
TableViewMortalidade.setShowRoot(false);
//            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro:\n" + ex);
            alert.show();
            alert.setResizable(true);
        }
    }
}
