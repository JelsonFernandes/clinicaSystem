/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import Modelos.ModeloTabelaDivida;
import Modelos.ModeloTabelaFinancas;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class FinancasController implements Initializable {

    @FXML
    private JFXTextField codReceita;
    @FXML
    private TextField UseReceita;
    @FXML
    private Label DataReceita;
    @FXML
    private TextField ValorReceita;
    @FXML
    private TextField FinalReceita;
    @FXML
    private ComboBox<String> DescriReceita;
    @FXML
    private TableView<ModeloTabelaFinancas> TBVRECEITASdESPESA;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> ID;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> USUARIO;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> DATA;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> VALOR;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> DESCRICAO;
    @FXML
    private TableColumn<ModeloTabelaFinancas, String> FINALIDADE;
    @FXML
    private Button btBusca;
    @FXML
    private TextField txtPesquisa;
    @FXML
    private Button btAdiciona;
    @FXML
    private Button btPesquisa;
    @FXML
    private Button btAltera;
    @FXML
    private Button btRemove;
    //Formulário das contas a pagar e a receber
    @FXML
    private TableView<ModeloTabelaDivida> TBVRECEITASdESPESA1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> ID1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> USUARIO1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> DATA1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> VALOR1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> DESCRICAO1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> FINALIDADE1;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> LIQUIDAR;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> LIQUIDADO;
    @FXML
    private TableColumn<ModeloTabelaDivida, String> SITUACAO;
    @FXML
    private Button btBusca1;
    @FXML
    private TextField txtPesquisa1;
    @FXML
    private Button btAdiciona1;
    @FXML
    private Button btPesquisa1;
    @FXML
    private Button btAltera1;
    @FXML
    private Button btRemove1;
    @FXML
    private TextField codDivida;
    @FXML
    private TextField UseDivida;
    @FXML
    private TextField DataDivida;
    @FXML
    private TextField ValorDivida;
    @FXML
    private ComboBox<String> DescriDivida;
    @FXML
    private TextField FinalDivida;
    @FXML
    private TextField dataAliquidarDivida;
    @FXML
    private TextField dataLiquidadoDivida;
    @FXML
    private ComboBox<String> situacaoDivida;
    //Formulário dos totais de receitas
    @FXML
    private Label totRec;
    @FXML
    private Label totDesp;
    @FXML
    private Label recMesAno;
    @FXML
    private ComboBox<String> mesRec;
    @FXML
    private TextField anoRec;
    @FXML
    private Label totMesAnoDesp;
    @FXML
    private ComboBox<String> mesDesp;
    @FXML
    private TextField anoDesp;
    @FXML
    private Label totAnoRec;
    @FXML
    private Label totAnoDesp;
    @FXML
    private Label janRec;
    @FXML
    private Label fevRec;
    @FXML
    private Label marcRec;
    @FXML
    private Label abrRec;
    @FXML
    private Label maiRec;
    @FXML
    private Label junRec;
    @FXML
    private Label julRec;
    @FXML
    private Label agoRec;
    @FXML
    private Label setRec;
    @FXML
    private Label outRec;
    @FXML
    private Label novRec;
    @FXML
    private Label dezRec;
    @FXML
    private Label janDesp;
    @FXML
    private Label fevDesp;
    @FXML
    private Label marcDesp;
    @FXML
    private Label abrDesp;
    @FXML
    private Label maiDesp;
    @FXML
    private Label junDesp;
    @FXML
    private Label julDesp;
    @FXML
    private Label agDesp;
    @FXML
    private Label setDesp;
    @FXML
    private Label outDesp;
    @FXML
    private Label novDesp;
    @FXML
    private Label dezDesp;
    //Formulário das dívidas a pagar e receber
    @FXML
    private Label totRec1;
    @FXML
    private Label totDesp1;
    @FXML
    private Label recMesAno1;
    @FXML
    private ComboBox<String> mesRec1;
    @FXML
    private TextField anoRec1;
    @FXML
    private Label totMesAnoDesp1;
    @FXML
    private ComboBox<String> mesDesp1;
    @FXML
    private TextField anoDesp1;
    @FXML
    private Label totAnoRec1;
    @FXML
    private Label totAnoDesp1;
    @FXML
    private Label janRec1;
    @FXML
    private Label fevRec1;
    @FXML
    private Label marcRec1;
    @FXML
    private Label abrRec1;
    @FXML
    private Label maiRec1;
    @FXML
    private Label junRec1;
    @FXML
    private Label julRec1;
    @FXML
    private Label agoRec1;
    @FXML
    private Label setRec1;
    @FXML
    private Label outRec1;
    @FXML
    private Label novRec1;
    @FXML
    private Label dezRec1;
    @FXML
    private Label janDesp1;
    @FXML
    private Label fevDesp1;
    @FXML
    private Label marcDesp1;
    @FXML
    private Label abrDesp1;
    @FXML
    private Label maiDesp1;
    @FXML
    private Label junDesp1;
    @FXML
    private Label julDesp1;
    @FXML
    private Label agDesp1;
    @FXML
    private Label setDesp1;
    @FXML
    private Label outDesp1;
    @FXML
    private Label novDesp1;
    @FXML
    private Label dezDesp1;
    //Formulário de movimentos bancário
    @FXML
//    private TextField IdMovimento;
//    @FXML
//    private TextField OperdorMoviment;
//    @FXML
//    private ComboBox<String> Banco;
//    @FXML
//    private TextField DataMovimento;
//    @FXML
//    private ComboBox<String> TipoMovimento;
//    @FXML
//    private TextField ValorMovimento;
//    @FXML
//    private TextField NMovimento;
//    @FXML
//    private TableView<?> TANLEvIEWmOVIMENTO;
//    @FXML
//    private TableColumn<?, ?> OPERADOR;
//    @FXML
//    private TableColumn<?, ?> BANCO;
//    @FXML
//    private TableColumn<?, ?> MOVIMENTO;
//    @FXML
//    private TableColumn<?, ?> NMOVIMENTO;
//    @FXML
    private Button btBuscar;
    @FXML
    private TextField Pesquisar;
    @FXML
    private Button btAdicionar;
    @FXML
    private Button btPesquisar;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btRemover;
    @FXML
    private TextField Usuario;
    //Formulário de consulta de movimentos
//    @FXML
//    public Label DATAMOVCONSULTA;
//    @FXML
//    private Label FPORBANCO;
//    @FXML
//    private Label FPORMOVIBANCO;
//    @FXML
//    private ComboBox<?> MOVE;
//    @FXML
//    private Label FMOVEBANCO;
//    @FXML
//    private ComboBox<?> CBANCO;
//    @FXML
//    private ComboBox<?> MOVEBANCO;
//    @FXML
//    private TableView<?> TBMOVIBANCO;
//    @FXML
//    private ComboBox<?> MES;
//    @FXML
//    private ComboBox<?> ANO;
    Connection conexao = null;

    PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<ModeloTabelaFinancas> oblist = FXCollections.observableArrayList();
    ObservableList<ModeloTabelaDivida> oblisted = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao = ModeloConexao.conector();
        DataReceita.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
        DataDivida.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
//        DATAMOVCONSULTA.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
//        DataMovimento.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
        ObservableList descricao = FXCollections.observableArrayList();
        descricao.addAll("Receita",
                "Despesa");
        DescriReceita.setItems(descricao);

        /////////////////////////////////////////////////////////////////
        ObservableList descricaoDivida = FXCollections.observableArrayList();
        descricaoDivida.addAll("Conta a Receber",
                "Conta a Pagar");
        DescriDivida.setItems(descricaoDivida);
        ObservableList situacao = FXCollections.observableArrayList();
        situacao.addAll("Paga",
                "Não Paga",
                "A vencer",
                "Vencida");
        situacaoDivida.setItems(situacao);

        try {
            String sql = "select sum(valor) as total from tbrece_despes where tipo='Receita'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totRec.setText(rs.getString("total"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        //Contas a pagar
        try {
            String sql = "select sum(valor) as total from tbdividas where tipo='Conta a Receber'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totRec1.setText(rs.getString("total"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select sum(valor) as total from tbrece_despes where tipo='Despesa'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totDesp.setText(rs.getString("total"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        //Contas a pagar

        try {
            String sql = "select sum(valor) as total from tbdividas where tipo='Conta a Pagar'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totDesp1.setText(rs.getString("total"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, sum(valor) as valortotal from tbrece_despes where tipo='Receita' and year(data_recdesp)='" + DataReceita.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totAnoRec.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        //Contas a receber no ano
        try {
            String sql = "select year(data_div) as dataredp, sum(valor) as valortotal from tbdividas where tipo='Conta a Receber' and year(data_div)='" + DataReceita.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totAnoRec1.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, sum(valor) as valortotal from tbrece_despes where tipo='Despesa' and year(data_recdesp)='" + DataReceita.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totAnoDesp.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as datadiv, sum(valor) as valortotal from tbdividas where tipo='Conta a Pagar' and year(data_div)='" + DataReceita.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totAnoDesp1.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        mesRec.getItems().addAll("1",
                "2", "3", "4", "5", "6", "7", "8", "9", "8", "10", "11", "12");
        mesDesp.getItems().addAll("1",
                "2", "3", "4", "5", "6", "7", "8", "9", "8", "10", "11", "12");
        mesRec1.getItems().addAll("1",
                "2", "3", "4", "5", "6", "7", "8", "9", "8", "10", "11", "12");
        mesDesp1.getItems().addAll("1",
                "2", "3", "4", "5", "6", "7", "8", "9", "8", "10", "11", "12");

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total1 from tbrece_despes where tipo='Receita' and month(data_recdesp)=1 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            janRec.setText(rs.getFloat("total1") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

//         
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total2 from tbrece_despes where tipo='Receita' and month(data_recdesp)=2 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            fevRec.setText(rs.getFloat("total2") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total3 from tbrece_despes where tipo='Receita' and month(data_recdesp)=3 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            marcRec.setText(rs.getFloat("total3") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total4 from tbrece_despes where tipo='Receita' and month(data_recdesp)=4 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            abrRec.setText(rs.getFloat("total4") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total5 from tbrece_despes where tipo='Receita' and month(data_recdesp)=5 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            maiRec.setText(rs.getFloat("total5") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total6 from tbrece_despes where tipo='Receita' and month(data_recdesp)=6 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            junRec.setText(rs.getFloat("total6") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total7 from tbrece_despes where tipo='Receita' and month(data_recdesp)=7 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            julRec.setText(rs.getFloat("total7") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total8 from tbrece_despes where tipo='Receita' and month(data_recdesp)=8 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            agoRec.setText(rs.getFloat("total8") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total9 from tbrece_despes where tipo='Receita' and month(data_recdesp)=9 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            setRec.setText(rs.getFloat("total9") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total10 from tbrece_despes where tipo='Receita' and month(data_recdesp)=10 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            outRec.setText(rs.getFloat("total10") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total11 from tbrece_despes where tipo='Receita' and month(data_recdesp)=11 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            novRec.setText(rs.getFloat("total11") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total12 from tbrece_despes where tipo='Receita' and month(data_recdesp)=12 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            dezRec.setText(rs.getFloat("total12") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        // O espaçp abaixo serve para a área das despesas 
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total1 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=1 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            janDesp.setText(rs.getFloat("total1") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total2 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=2 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            fevDesp.setText(rs.getFloat("total2") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total3 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=3 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            marcDesp.setText(rs.getFloat("total3") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total4 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=4 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            abrDesp.setText(rs.getFloat("total4") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total5 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=5 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            maiDesp.setText(rs.getFloat("total5") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total6 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=6 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            junDesp.setText(rs.getFloat("total6") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total7 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=7 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            julDesp.setText(rs.getFloat("total7") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
//        
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total8 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=8 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            agDesp.setText(rs.getFloat("total8") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total9 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=9 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            setDesp.setText(rs.getFloat("total9") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total10 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=10 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            outDesp.setText(rs.getFloat("total10") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total11 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=11 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            novDesp.setText(rs.getFloat("total11") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total12 from tbrece_despes where tipo='Despesa' and month(data_recdesp)=12 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            dezDesp.setText(rs.getFloat("total12") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        // O campo abaixo serve para o controle de contas a pagar e a receber
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total1 from tbrece_despes where tipo='Receita' and month(data_recdesp)=1 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            janRec.setText(rs.getFloat("total1") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

//         
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total2 from tbrece_despes where tipo='Receita' and month(data_recdesp)=2 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            fevRec.setText(rs.getFloat("total2") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total3 from tbrece_despes where tipo='Receita' and month(data_recdesp)=3 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            marcRec.setText(rs.getFloat("total3") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total4 from tbrece_despes where tipo='Receita' and month(data_recdesp)=4 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            abrRec.setText(rs.getFloat("total4") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total5 from tbrece_despes where tipo='Receita' and month(data_recdesp)=5 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            maiRec.setText(rs.getFloat("total5") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total6 from tbrece_despes where tipo='Receita' and month(data_recdesp)=6 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            junRec.setText(rs.getFloat("total6") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total7 from tbrece_despes where tipo='Receita' and month(data_recdesp)=7 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            julRec.setText(rs.getFloat("total7") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total8 from tbrece_despes where tipo='Receita' and month(data_recdesp)=8 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            agoRec.setText(rs.getFloat("total8") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total9 from tbrece_despes where tipo='Receita' and month(data_recdesp)=9 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            setRec.setText(rs.getFloat("total9") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total10 from tbrece_despes where tipo='Receita' and month(data_recdesp)=10 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            outRec.setText(rs.getFloat("total10") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total11 from tbrece_despes where tipo='Receita' and month(data_recdesp)=11 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            novRec.setText(rs.getFloat("total11") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as total12 from tbrece_despes where tipo='Receita' and month(data_recdesp)=12 and  year(data_recdesp)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            dezRec.setText(rs.getFloat("total12") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

        // O espaçp abaixo serve para a área das despesas 
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total1 from tbdividas where tipo='Conta a Receber' and month(data_div)=1 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            janRec1.setText(rs.getFloat("total1") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total2 from tbdividas where tipo='Conta a Receber' and month(data_div)=2 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            fevRec1.setText(rs.getFloat("total2") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total3 from tbdividas where tipo='Conta a Receber' and month(data_div)=3 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            marcRec1.setText(rs.getFloat("total3") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total4 from tbdividas where tipo='Conta a Receber' and month(data_div)=4 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            abrRec1.setText(rs.getFloat("total4") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total5 from tbdividas where tipo='Conta a Receber' and month(data_div)=5 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            maiRec1.setText(rs.getFloat("total5") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total6 from tbdividas where tipo='Conta a Receber' and month(data_div)=6 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            junRec1.setText(rs.getFloat("total6") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total7 from tbdividas where tipo='Conta a Receber' and month(data_div)=7 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            julRec1.setText(rs.getFloat("total7") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total8 from tbdividas where tipo='Conta a Receber' and month(data_div)=8 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            agoRec1.setText(rs.getFloat("total8") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total9 from tbdividas where tipo='Conta a Receber' and month(data_div)=9 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            setRec1.setText(rs.getFloat("total9") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total10 from tbdividas where tipo='Conta a Receber' and month(data_div)=10 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            outRec1.setText(rs.getFloat("total10") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total11 from tbdividas where tipo='Conta a Receber' and month(data_div)=11 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            novRec1.setText(rs.getFloat("total11") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total12 from tbdividas where tipo='Conta a Receber' and month(data_div)=12 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            dezRec1.setText(rs.getFloat("total12") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total1 from tbdividas where tipo='Conta a Pagar' and month(data_div)=1 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            janDesp1.setText(rs.getFloat("total1") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total2 from tbdividas where tipo='Conta a Pagar' and month(data_div)=2 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            fevDesp1.setText(rs.getFloat("total2") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total3 from tbdividas where tipo='Conta a Pagar' and month(data_div)=3 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            marcDesp1.setText(rs.getFloat("total3") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total4 from tbdividas where tipo='Conta a Pagar' and month(data_div)=4 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            abrDesp1.setText(rs.getFloat("total4") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total5 from tbdividas where tipo='Conta a Pagar' and month(data_div)=5 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            maiDesp1.setText(rs.getFloat("total5") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total6 from tbdividas where tipo='Conta a Pagar' and month(data_div)=6 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            junDesp1.setText(rs.getFloat("total6") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total7 from tbdividas where tipo='Conta a Pagar' and month(data_div)=7 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            julDesp1.setText(rs.getFloat("total7") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total8 from tbdividas where tipo='Conta a Pagar' and month(data_div)=8 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            agDesp1.setText(rs.getFloat("total8") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total9 from tbdividas where tipo='Conta a Pagar' and month(data_div)=9 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            setDesp1.setText(rs.getFloat("total9") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total10 from tbdividas where tipo='Conta a Pagar' and month(data_div)=10 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            outDesp1.setText(rs.getFloat("total10") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total11 from tbdividas where tipo='Conta a Pagar' and month(data_div)=11 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            novDesp1.setText(rs.getFloat("total11") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as total12 from tbdividas where tipo='Conta a Pagar' and month(data_div)=12 and  year(data_div)='" + DataReceita.getText() + "'";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            dezDesp1.setText(rs.getFloat("total12") + " AKZ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
    }

    public void buscarReceita(MouseEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as valortotal from tbrece_despes where tipo='Receita' and year(data_recdesp)='" + anoRec.getText() + "'" + "and  month(data_recdesp)='" + mesRec.getSelectionModel().getSelectedItem() + "'";
//             preencherTabela("select id_recedesp,valor,tipo,descricao,usuario,month (data_recdesp)as mes,year (data_recdesp) as ano from tbrece_despes where  month (data_recdesp)='"+jTextFieldMés.getText()+"'"+"and year (data_recdesp)='"+ jTextFieldAno.getText()+"'"+"and  (tipo)='"+ jComboBoxTipo.getSelectedItem()+"'");
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            recMesAno.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }

    }

    public void buscarContasAreceber(MouseEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as valortotal from tbdividas where tipo='Conta a Receber' and year(data_div)='" + anoRec1.getText() + "'" + "and  month(data_div)='" + mesRec1.getSelectionModel().getSelectedItem() + "'";
//             preencherTabela("select id_recedesp,valor,tipo,descricao,usuario,month (data_recdesp)as mes,year (data_recdesp) as ano from tbrece_despes where  month (data_recdesp)='"+jTextFieldMés.getText()+"'"+"and year (data_recdesp)='"+ jTextFieldAno.getText()+"'"+"and  (tipo)='"+ jComboBoxTipo.getSelectedItem()+"'");
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            recMesAno1.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
    }

    public void buscarDespesa(MouseEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "select year(data_recdesp) as dataredp, month(data_recdesp) as mes,sum(valor)as valortotal from tbrece_despes where tipo='Despesa' and year(data_recdesp)='" + anoDesp.getText() + "'" + "and  month(data_recdesp)='" + mesDesp.getSelectionModel().getSelectedItem() + "'";
//             preencherTabela("select id_recedesp,valor,tipo,descricao,usuario,month (data_recdesp)as mes,year (data_recdesp) as ano from tbrece_despes where  month (data_recdesp)='"+jTextFieldMés.getText()+"'"+"and year (data_recdesp)='"+ jTextFieldAno.getText()+"'"+"and  (tipo)='"+ jComboBoxTipo.getSelectedItem()+"'");
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totMesAnoDesp.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
    }

    public void buscarContasApagar(MouseEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String sql = "select year(data_div) as dataredp, month(data_div) as mes,sum(valor)as valortotal from tbdividas where tipo='Conta a Pagar' and year(data_div)='" + anoDesp1.getText() + "'" + "and  month(data_div)='" + mesDesp1.getSelectionModel().getSelectedItem() + "'";
//             preencherTabela("select id_recedesp,valor,tipo,descricao,usuario,month (data_recdesp)as mes,year (data_recdesp) as ano from tbrece_despes where  month (data_recdesp)='"+jTextFieldMés.getText()+"'"+"and year (data_recdesp)='"+ jTextFieldAno.getText()+"'"+"and  (tipo)='"+ jComboBoxTipo.getSelectedItem()+"'");
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            totMesAnoDesp1.setText(rs.getString("valortotal"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex);
        }
    }

    public void adicionar(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        String sql = "insert into tbrece_despes( valor, tipo, descricao, usuario, data_recdesp)value(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ValorReceita.getText());
            pst.setString(2, (String) DescriReceita.getSelectionModel().getSelectedItem());
            pst.setString(3, FinalReceita.getText());
            pst.setString(4, UseReceita.getText());
            pst.setString(5, DataReceita.getText());
            //validação dos campos obrigatórios

            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados adicionado com sucesso");
                ValorReceita.setText(null);
                DescriReceita.getSelectionModel().select(null);
                FinalReceita.setText(null);
                UseReceita.setText(null);
                DataReceita.setText(null);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void alterar(javafx.event.ActionEvent event) {
        String sql = "Update tbrece_despes set valor=?, tipo=?, descricao=?, usuario=?, data_recdesp=? where id_recedesp=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ValorReceita.getText());
            pst.setString(2, (String) DescriReceita.getSelectionModel().getSelectedItem());
            pst.setString(3, FinalReceita.getText());
            pst.setString(4, UseReceita.getText());
            pst.setString(5, DataReceita.getText());
            pst.setString(6, codReceita.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados  alterados com sucesso");
            codReceita.setText(null);
            ValorReceita.setText(null);
            DescriReceita.getSelectionModel().select(null);
            FinalReceita.setText(null);
            UseReceita.setText(null);
            DataReceita.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void UsuActionPerformed(javafx.event.ActionEvent event) {
        // TODO add your handling code here:
        conexao = ModeloConexao.conector();
        // a linha abaixo cria uma caixa de entrada do tipo JOption Pane
        String num_usuario = JOptionPane.showInputDialog("Número de usuário");
        String sql = "select*from usuarios where senha_user='" + num_usuario + "'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {

                UseReceita.setText(rs.getString("nome_user"));
                // txtDataContrato.setText(rs.getString(2));

                //evitando problemas
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não contratado");
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Nº de Usuário inválido");
            // System.out.println(e);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    public void PesqActionPerformed(javafx.event.ActionEvent evet) {
        // TODO add your handling code here:
        conexao = ModeloConexao.conector();
        // a linha abaixo cria uma caixa de entrada do tipo JOption Pane
        String id = JOptionPane.showInputDialog("Número de usuário");
        String sql = "select*from tbrece_despes where id_recedesp=" + id;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {
                codReceita.setText(rs.getString("id_recedesp"));
                ValorReceita.setText(rs.getString("valor"));
                DescriReceita.getSelectionModel().select(rs.getString("tipo"));
                FinalReceita.setText(rs.getString("descricao"));
                UseReceita.setText(rs.getString("usuario"));
                DataReceita.setText(rs.getString("data_recdesp"));
                //id_recedesp, valor, tipo, descricao, usuario, data_recdesp, id_recedesp, id
            } else {
                JOptionPane.showMessageDialog(null, "ID não contratado");
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            // System.out.println(e);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    public void preencherTabela(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from tbrece_despes where tipo like '%" + txtPesquisa.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            do {
//                valor, tipo, descricao, usuario, data_recdesp
                oblist.add(new ModeloTabelaFinancas(rs.getString("id_recedesp"), rs.getString("usuario"), rs.getString("data_recdesp"), rs.getString("valor"), rs.getString("tipo"), rs.getString("descricao")));
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro \n" + ex);
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("codReceita"));
        USUARIO.setCellValueFactory(new PropertyValueFactory<>("UseReceita"));
        DATA.setCellValueFactory(new PropertyValueFactory<>("DataReceita"));
        VALOR.setCellValueFactory(new PropertyValueFactory<>("ValorReceita"));
        DESCRICAO.setCellValueFactory(new PropertyValueFactory<>("FinalReceita"));
        FINALIDADE.setCellValueFactory(new PropertyValueFactory<>("DescriReceita"));
        TBVRECEITASdESPESA.setItems(oblist);

    }

    public void removeReceDespesa(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover estes dados?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbrece_despes where id_recedesp=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codReceita.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, " Dados removido com sucesso");

                    codReceita.setText(null);
                    DataReceita.setText(null);
                    ValorReceita.setText(null);
                    DescriReceita.getSelectionModel().select(null);
                    FinalReceita.setText(null);
                    UseReceita.setText(null);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public void HendelerSetarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {
            codReceita.setText(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getCodReceita());
            ValorReceita.setText(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getValorReceita());
            DescriReceita.getSelectionModel().select(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getFinalReceita());
            FinalReceita.setText(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getDescriReceita());
            UseReceita.setText(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getUseReceita());
            DataReceita.setText(TBVRECEITASdESPESA.getFocusModel().getFocusedItem().getDataReceita());
        }

    }
//O campo abaixo serve para atender o formulário de Contas a pagar e a receber

    public void adicionaDivida(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        String sql = "insert into tbdividas( valor, tipo, data_div, data_aliquid, data_liquid,situacao,usuario,descri)value(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ValorDivida.getText());
            pst.setString(2, (String) DescriDivida.getSelectionModel().getSelectedItem());
            pst.setString(3, DataDivida.getText());
            pst.setString(4, dataAliquidarDivida.getText());
            pst.setString(5, dataLiquidadoDivida.getText());
            pst.setString(6, (String) situacaoDivida.getSelectionModel().getSelectedItem());
            pst.setString(7, UseDivida.getText());
            pst.setString(8, FinalDivida.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados adicionado com sucesso");
            codDivida.setText(null);
            ValorDivida.setText(null);
            DescriDivida.getSelectionModel().select(null);
            DataDivida.setText(null);
            FinalDivida.setText(null);
            dataAliquidarDivida.setText(null);
            situacaoDivida.getSelectionModel().select(null);
            UseDivida.setText(null);
            dataLiquidadoDivida.setText(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void alterarDivida(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        String sql = "Update tbdividas set valor=?, tipo=?, data_div=?, data_aliquid=?, data_liquid=?,situacao=?,usuario=?,descri=? where id_divida=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ValorDivida.getText());
            pst.setString(2, (String) DescriDivida.getSelectionModel().getSelectedItem());
            pst.setString(3, DataDivida.getText());
            pst.setString(4, dataAliquidarDivida.getText());
            pst.setString(5, dataLiquidadoDivida.getText());
            pst.setString(6, (String) situacaoDivida.getSelectionModel().getSelectedItem());
            pst.setString(7, UseDivida.getText());
            pst.setString(8, FinalDivida.getText());
            pst.setString(9, codDivida.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados  alterados com sucesso");

            codDivida.setText(null);
            ValorDivida.setText(null);
            DescriDivida.getSelectionModel().select(null);
            DataDivida.setText(null);
            FinalDivida.setText(null);
            dataAliquidarDivida.setText(null);
            dataLiquidadoDivida.setText(null);
            situacaoDivida.getSelectionModel().select(null);
            UseDivida.setText(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void removeDivida(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover estes dados?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbdividas where id_divida=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, codDivida.getText());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, " Dados removido com sucesso");
                codDivida.setText(null);
                ValorDivida.setText(null);
                DescriDivida.getSelectionModel().select(null);
                DataDivida.setText(null);
                FinalDivida.setText(null);
                dataAliquidarDivida.setText(null);
                dataLiquidadoDivida.setText(null);
                situacaoDivida.getSelectionModel().select(null);
                UseDivida.setText(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public void jButtonPesq1ActionPerformed(javafx.event.ActionEvent event) {
        // TODO add your handling code here:
        conexao = ModeloConexao.conector();
        // a linha abaixo cria uma caixa de entrada do tipo JOption Pane
        String id = JOptionPane.showInputDialog("Número de usuário");
        String sql = "select*from tbdividas where id_divida=" + id;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {

                codDivida.setText(rs.getString("id_divida"));
                ValorDivida.setText(rs.getString("valor"));
                DescriDivida.getSelectionModel().select(rs.getString("tipo"));
                DataDivida.setText(rs.getString("data_div"));
                FinalDivida.setText(rs.getString("descri"));
                dataAliquidarDivida.setText(rs.getString("data_aliquid"));
                dataLiquidadoDivida.setText(rs.getString("data_liquid"));
                situacaoDivida.getSelectionModel().select(rs.getString("situacao"));
                UseDivida.setText(rs.getString("usuario"));

                //id_divida, valor, tipo, data_div, data_aliquid, data_liquid, situacao, usuario, descri, id_divida, id
            } else {
                JOptionPane.showMessageDialog(null, "ID não contratado");
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            // System.out.println(e);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }

    }

    public void UsuAction(javafx.event.ActionEvent event) {
        // TODO add your handling code here:
        conexao = ModeloConexao.conector();
        // a linha abaixo cria uma caixa de entrada do tipo JOption Pane
        String num_usuario = JOptionPane.showInputDialog("Número de usuário");
        String sql = "select*from usuarios where senha_user='" + num_usuario + "'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.first()) {

                UseDivida.setText(rs.getString("nome_user"));
                // txtDataContrato.setText(rs.getString(2));

                //evitando problemas
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não contratado");
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Nº de Usuário inválido");
            // System.out.println(e);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

    public void preencheTabelaDivida(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from tbdividas where tipo like '%" + txtPesquisa1.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            do {
//                valor, tipo, descricao, usuario, data_recdesp
                oblisted.add(new ModeloTabelaDivida(rs.getString("id_divida"), rs.getString("usuario"), rs.getString("data_div"), rs.getString("valor"), rs.getString("tipo"), rs.getString("descri"), rs.getString("data_aliquid"), rs.getString("data_liquid"), rs.getString("situacao")));
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro \n" + ex);
        }

        ID1.setCellValueFactory(new PropertyValueFactory<>("codDivida"));
        USUARIO1.setCellValueFactory(new PropertyValueFactory<>("UseDivida"));
        DATA1.setCellValueFactory(new PropertyValueFactory<>("DataDivida"));
        VALOR1.setCellValueFactory(new PropertyValueFactory<>("ValorDivida"));
        DESCRICAO1.setCellValueFactory(new PropertyValueFactory<>("DescriDivida"));
        FINALIDADE1.setCellValueFactory(new PropertyValueFactory<>("FinalDivida"));
        LIQUIDAR.setCellValueFactory(new PropertyValueFactory<>("dataAliquidarDivida"));
        LIQUIDADO.setCellValueFactory(new PropertyValueFactory<>("dataLiquidadoDivida"));
        SITUACAO.setCellValueFactory(new PropertyValueFactory<>("situacaoDivida"));
        TBVRECEITASdESPESA1.setItems(oblisted);
        //id_divida, valor, tipo, data_div, data_aliquid, data_liquid, situacao, usuario, descri, id_divida, id

    }

    public void SetarCamposDividas(MouseEvent event) {
        if (event.getClickCount() == 1) {
            codDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getCodDivida());
            ValorDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getValorDivida());
            DescriDivida.getSelectionModel().select(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getDescriDivida());
            FinalDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getFinalDivida());
            UseDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getUseDivida());
            DataDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getDataDivida());
            dataAliquidarDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getDataAliquidarDivida());
            dataLiquidadoDivida.setText(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getDataLiquidadoDivida());
            situacaoDivida.getSelectionModel().select(TBVRECEITASdESPESA1.getFocusModel().getFocusedItem().getSituacaoDivida());
        }

    }

//    public void movimentaBanco(javafx.event.ActionEvent event) {
//         conexao = ModeloConexao.conector();
//           System.out.println("Sta funcionar");
//        try {
//           
////        IdMovimento;
//            String sql = "insert into move_banco(movimentador,banco,data,tipo,valor,numero)values(?,?,?,?,?,?)";
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, OperdorMoviment.getText());
//            pst.setString(2, Banco.getSelectionModel().getSelectedItem());
//            pst.setString(3, DataMovimento.getText());
//            pst.setString(4, TipoMovimento.getSelectionModel().getSelectedItem());
//            pst.setString(5, ValorMovimento.getText());
//            pst.setString(6, NMovimento.getText());
//            pst.execute();
//          
//        } catch (SQLException ex) {
//            Alert dg = new Alert(Alert.AlertType.WARNING);
//            dg.setTitle("Erro " + ex);
//            dg.show();
//            System.out.println("Erro \n" + ex);
//        }
//
//    }
// public void testarMovBanco(javafx.event.ActionEvent event) {
//      conexao = ModeloConexao.conector();
//           System.out.println("Sta funcionar");
//        try {
//           
////        IdMovimento;
//            String sql = "insert into move_banco(movimentador,banco,data,tipo,valor,numero)values(?,?,?,?,?,?)";
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, OperdorMoviment.getText());
//            pst.setString(2, Banco.getSelectionModel().getSelectedItem());
//            pst.setString(3, DataMovimento.getText());
//            pst.setString(4, TipoMovimento.getSelectionModel().getSelectedItem());
//            pst.setString(5, ValorMovimento.getText());
//            pst.setString(6, NMovimento.getText());
//            pst.execute();
//          
//        } catch (SQLException ex) {
//            Alert dg = new Alert(Alert.AlertType.WARNING);
//            dg.setTitle("Erro " + ex);
//            dg.show();
//            System.out.println("Erro \n" + ex);
//        }
//     
// }
}
