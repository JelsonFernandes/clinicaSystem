/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleVenda;
import Modelos.ModeloConexao;
import Modelos.ModeloTabelaVenda;
import Modelos.ModeloTabelaVendaProduto;
import Modelos.ModeloVenda;
import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class VendasController implements Initializable {

    @FXML
    public Button AbrirVenda;
    @FXML
    public TextField CodVenda;
    @FXML
    public TextField Pesquisar;
    @FXML
    public TextField Cliente;
    @FXML
    public TextField Nif;
    @FXML
    public TextField Endereco;
    @FXML
    public TextArea Retorno;
    @FXML
    public TextField Operador;
    @FXML
    public TextField IdProduto;
    @FXML
//    public Label Retorno;
//    @FXML
    public Label Data;
    @FXML
    public Label Total;
    @FXML
    public Label TotalDesconto;
    @FXML
    public TextField ValorRecebido;
    @FXML
    public Label Troco;
    @FXML
    public Label ValorFinal;
    @FXML
    public ComboBox<String> TipoPagamento;
    @FXML
    public Button FinalizarVenda;
    @FXML
    public TableView<ModeloTabelaVenda> TableViewVenda;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> ID;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> DESCRICAO;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> MEDIDA;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> VALOR;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> QUANTIDADE;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> DESCONTO;
    @FXML
    public TableColumn<ModeloTabelaVenda, String> TOTAL;
    ////////////////////////////////////////////////////
    @FXML
    public TableView<ModeloTabelaVendaProduto> TableViewProduto;
    public TableColumn<ModeloTabelaVendaProduto, String> IDPROD;
    @FXML
    public TableColumn<ModeloTabelaVendaProduto, String> DESCRIPROD;
    @FXML
    public TableColumn<ModeloTabelaVendaProduto, String> MEDPROD;
    @FXML
    public TableColumn<ModeloTabelaVendaProduto, String> VALORPROD;
    @FXML
    public TextField Produto;
    @FXML
    public Button Buscar;
    @FXML
    public TextField Medida;
    @FXML
    public TextField Valor;
    @FXML
    public TextField Quantidade;
    public TextField DescontoUtnit;
    @FXML
    public Button Adicionar;
    @FXML
    public Button LeituraX;
    @FXML
    public Button Pagamento;
    public Button GerarFactura;

    @FXML
    public Button CancelarVenda;
    String sexo;
    String cliente;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ModeloVenda mod = new ModeloVenda();
    ControleVenda control = new ControleVenda();
    ObservableList<ModeloTabelaVenda> oblist = FXCollections.observableArrayList();
    ObservableList<ModeloTabelaVendaProduto> obplist = FXCollections.observableArrayList();

    int nOrdem = 1;
    Double ValorTotal = 0.0;

    Double Desconto = 0.0;
    Double TotaValor = 0.0;
    Double FinalValor = 0.0;
    Double bHeigtht = 0.0;
    Double DescontoTotal = 0.0;
    Double valorRecebido = 0.0;
    Double troco = 0.0;
    int quantidade = 0;
    int quantiStock = 0;
//    ArrayList<String> produto = new ArrayList();
//    ArrayList<String> medida = new ArrayList();
//    ArrayList<String> valor = new ArrayList();
//    ArrayList<String> quantidade = new ArrayList();
//    ArrayList<String> desconto = new ArrayList();
//    ArrayList<String> total = new ArrayList();
////    ArrayList<Double> bHeigtht = new ArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList tipo = FXCollections.observableArrayList();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        Data.setText(dateFormat.format(cal.getTime()));
        Quantidade.setText("01");
        DescontoUtnit.setText("0.0");
        TotalDesconto.setText("0.0");
        tipo.addAll("Dinheiro A Vista",
                "A Vista Cartão",
                "Transferencia A Vista",
                "Cheque A Vista",
                "A Prazo");
        TipoPagamento.setItems(tipo);
//        Retorno.setPrefColumnCount(5);
        Retorno.setPrefColumnCount(5);
        Retorno.setPrefRowCount(20);
        Retorno.setPrefColumnCount(5);
//        Retorno.setRotate(2.5);
//        Retorno.setPadding(Insets.EMPTY);
    }

    public void AbrirVenda(javafx.event.ActionEvent event) {
        conexao = ModeloConexao.conector();
        try {
            String usuario = JOptionPane.showInputDialog("INSIRA A TUA SENHA DE USUÁRIO");
            String sql = "select*from usuarios where senha_user='" + usuario + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            Operador.setText(rs.getString("nome_user"));
            int confirma = JOptionPane.showConfirmDialog(null, "Este é um cliente Cadastrado?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                cliente = JOptionPane.showInputDialog("INSIRA O ID DO CLIENTE");
                String sql1 = "select*from tbclientes where idcli='" + cliente + "'";
                pst = conexao.prepareStatement(sql1);
                rs = pst.executeQuery();
                rs.first();
                Cliente.setText(rs.getString("nomecli"));
            }

            Produto.setDisable(false);
            Buscar.setDisable(false);
            Medida.setDisable(false);
            Valor.setDisable(false);
            Quantidade.setDisable(false);
            DescontoUtnit.setDisable(false);
            Adicionar.setDisable(false);
            LeituraX.setDisable(false);
            Pagamento.setDisable(false);
            FinalizarVenda.setDisable(false);
            AbrirVenda.setDisable(true);
            GerarFactura.setDisable(false);
            CancelarVenda.setDisable(false);
            String sql2 = "insert into vendas(data_venda,total,desconto_venda,id_cli)value(?,?,?,?)";
            pst = conexao.prepareStatement(sql2);
            pst.setString(1, Data.getText());
            pst.setString(2, "0.0");
            pst.setString(3, "0.0");
            if (cliente == null) {
                pst.setString(4, "0");
            } else {
                pst.setString(4, cliente);
            }

            pst.execute();
            String sql3 = "select*from vendas";
            pst = conexao.prepareStatement(sql3);
            rs = pst.executeQuery();
            rs.last();
            CodVenda.setText(rs.getString("id_venda"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca\n" + ex);
        }

    }

    public void InserirItem() throws SQLException {

        mod.setProduto(IdProduto.getText());
        mod.setMedida(Medida.getText());
        mod.setCodVenda(CodVenda.getText());
        mod.setValor(Valor.getText());
        mod.setQuantidade(Quantidade.getText());
        control.InserirItem(mod);
    }

    public void GerarFactura(javafx.event.ActionEvent event) {
//        Desconto = Double.valueOf(Troco.getText());
        if (ValorRecebido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor Recebido");
        } else {

            valorRecebido = Double.valueOf(ValorRecebido.getText());

            Double total = Double.valueOf(Total.getText());
            Double totDescont = Double.valueOf(TotalDesconto.getText());
            FinalValor = (total - totDescont);
            ValorFinal.setText(String.valueOf(FinalValor));
            troco = valorRecebido - FinalValor;
            Troco.setText(String.valueOf(troco));
            PrintBill();
        }
    }

    public void preencherTabelaProduto(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from produtos where nome_produto like '%" + Pesquisar.getText() + "%'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                obplist.add(new ModeloTabelaVendaProduto(rs.getString("Id_produto"), rs.getString("nome_produto"), rs.getString("medida"), rs.getString("Preco_venda")));

            }
            IDPROD.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
            DESCRIPROD.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
            MEDPROD.setCellValueFactory(new PropertyValueFactory<>("Medida"));
            VALORPROD.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
            TableViewProduto.setItems(obplist);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro\n " + ex);
        }
    }

    public void setarCampos(MouseEvent event) {
        if (event.getClickCount() == 1) {

            IdProduto.setText(String.valueOf(TableViewProduto.getFocusModel().getFocusedItem().getCodProduto()));
            Produto.setText(String.valueOf(TableViewProduto.getFocusModel().getFocusedItem().getNomeProduto()));
            Medida.setText(String.valueOf(TableViewProduto.getFocusModel().getFocusedItem().getMedida()));
            Valor.setText(String.valueOf(TableViewProduto.getFocusModel().getFocusedItem().getPrecoVenda()));
        }
    }

    public void preencherTabela(javafx.event.ActionEvent event) {

        try {
            Double TotalUnit = null;
            conexao = ModeloConexao.conector();
            String sql = "select*from produtos where nome_produto='" + Produto.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            quantiStock = rs.getInt("quantidade");

            quantidade = Integer.valueOf(Quantidade.getText());

            if (quantiStock >= quantidade) {
                int stock = quantiStock - quantidade;
                System.out.println(stock);
                String sql1 = "update produtos set quantidade=? where nome_produto='" + Produto.getText() + "'";
                pst = conexao.prepareStatement(sql1);
                pst.setInt(1, stock);
                pst.execute();

                Desconto = Double.valueOf(DescontoUtnit.getText());
                Double ValorUnit = Double.valueOf(Valor.getText());
                int Quanti = Integer.valueOf(Quantidade.getText());
                TotalUnit = (ValorUnit * Quanti) - Desconto;
                oblist.add(new ModeloTabelaVenda(nOrdem, Produto.getText(), Medida.getText(), Valor.getText(), Quantidade.getText(), DescontoUtnit.getText(), TotalUnit));

                nOrdem++;
//
                ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
                DESCRICAO.setCellValueFactory(new PropertyValueFactory<>("DEscricao"));
                MEDIDA.setCellValueFactory(new PropertyValueFactory<>("Medida"));
                VALOR.setCellValueFactory(new PropertyValueFactory<>("Valor"));
                QUANTIDADE.setCellValueFactory(new PropertyValueFactory<>("QUuantidade"));
                DESCONTO.setCellValueFactory(new PropertyValueFactory<>("Desconto"));
                TOTAL.setCellValueFactory(new PropertyValueFactory<>("Total"));
                TableViewVenda.setItems(oblist);
                InserirItem();
                Desconto = Double.valueOf(DescontoUtnit.getText());
                Double valor = Double.valueOf(Valor.getText());
                quantidade = Integer.valueOf(Quantidade.getText());
//        ValorTotal = Double.valueOf(Total.getText());
                ValorTotal = (valor * quantidade);
                TotaValor = TotaValor + ValorTotal;

                Total.setText(String.valueOf(TotaValor));

                DescontoTotal = DescontoTotal + Desconto;

                TotalDesconto.setText(String.valueOf(DescontoTotal));

            } else {
                JOptionPane.showMessageDialog(null, "A quantidade especificada não se encontra disponivel no Stock!");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro\n " + ex);
        }

    }

    public void CancelaVenda(javafx.event.ActionEvent event) {

        // a estrutura abaixo confirma a remoção do aluno
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Produto?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from produtos where id_produto=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, CodVenda.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                    CodVenda.setText(null);
                    Produto.setText(null);
                    Medida.setText(null);
                    Valor.setText(null);
                    Quantidade.setText(null);
                    DescontoUtnit.setText(null);
                    Total.setText(null);
                    TotalDesconto.setText(null);
                    ValorRecebido.setText(null);
                    Troco.setText(null);
                    ValorFinal.setText(null);

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public void cancelarVenda(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from vendas inner join venda_produtos on vendas.id_venda=venda_produtos.id_venda inner join produtos on venda_produtos.id_produto=produtos.id_produto where vendas.total=0";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            do {
                int quantiStockProd = rs.getInt("quantidade");
                int quantVendaProd = rs.getInt("venda_pro_quanti");
                int soma = quantiStockProd + quantVendaProd;
                String sql1 = "update produtos set quantidade=? where id_produto=?";
                pst = conexao.prepareStatement(sql1);
                pst.setInt(1, soma);
                pst.setInt(2, rs.getInt("Id_produto"));
                pst.execute();
                String sql2 = "delete from venda_produtos where id_venda=?";
                pst = conexao.prepareStatement(sql2);
                pst.setInt(1, rs.getInt("Id_venda"));
                pst.execute();

            } while (rs.next());

            String sql3 = "delete from vendas where total=?";
            pst = conexao.prepareStatement(sql3);
            pst.setInt(1, 0);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda Removida com sucesso");
        } catch (SQLException ex1) {
            JOptionPane.showMessageDialog(null, ex1);
        }
    }

    public void setarItens(MouseEvent event) {
        if (event.getClickCount() == 1) {

            IdProduto.setText(String.valueOf(TableViewVenda.getFocusModel().getFocusedItem().getId()));
            Produto.setText(String.valueOf(TableViewVenda.getFocusModel().getFocusedItem().getDEscricao()));
            Medida.setText(String.valueOf(TableViewVenda.getFocusModel().getFocusedItem().getMedida()));
            Valor.setText(String.valueOf(TableViewVenda.getFocusModel().getFocusedItem().getValor()));

        }
    }

    public void eliminarItem(javafx.event.ActionEvent event) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from produtos where nome_produto='" + Produto.getText() + "'";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            quantiStock = rs.getInt("quantidade");

            quantidade = Integer.valueOf(Quantidade.getText());

            if (quantiStock >= quantidade) {
                int stock = quantiStock + quantidade;
                System.out.println(stock);
                String sql1 = "update produtos set quantidade=? where nome_produto='" + Produto.getText() + "'";
                pst = conexao.prepareStatement(sql1);
                pst.setInt(1, stock);
                pst.execute();
//////////////////////////////////////////////////////////////////
                Desconto = Double.valueOf(DescontoUtnit.getText());
                Double valor = Double.valueOf(Valor.getText());
                quantidade = Integer.valueOf(Quantidade.getText());
//        ValorTotal = Double.valueOf(Total.getText());
                ValorTotal = (valor * quantidade);
                TotaValor = TotaValor - ValorTotal;

                Total.setText(String.valueOf(TotaValor));

                DescontoTotal = DescontoTotal - Desconto;

                TotalDesconto.setText(String.valueOf(DescontoTotal));

//              Deletar o item da Venda  
                String sql2 = "delete from venda_produtos where id_venda=? and id_produto=?";
                pst = conexao.prepareStatement(sql2);
                pst.setString(1, CodVenda.getText());
                pst.setString(2, IdProduto.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Item Removido com sucesso");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro\n " + ex);
        }
    }

    public void SalvarVendas(javafx.event.ActionEvent event) throws SQLException {
        if (ValorFinal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Precisa de Efectuar primeiro a cobrança");
        } else {

            mod.setTipoPagamento(TipoPagamento.getSelectionModel().getSelectedItem());
            mod.setTotal(Total.getText());
            mod.setDesconto(TotalDesconto.getText());
            mod.setValorRecebido(ValorRecebido.getText());
            mod.setTroco(Troco.getText());
            mod.setValorFinal(ValorFinal.getText());
            mod.setCodVenda(CodVenda.getText());
            control.SalvarVenda(mod);
             int comfirma = JOptionPane.showConfirmDialog(null, "Confirma a Impressão desta Factura?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (comfirma == JOptionPane.YES_OPTION) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("codVenda", (CodVenda.getText()));
//                 filtro.put("id_nota", Integer.parseInt(idnota.getText()));
                
                JasperPrint print = JasperFillManager.fillReport("src\\Relatorios\\BillSellPoint.jasper", filtro, conexao);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        }

    }

    public void FinalizarVenda(javafx.event.ActionEvent event) {
        Produto.setDisable(true);
        Buscar.setDisable(true);
        Medida.setDisable(true);
        Valor.setDisable(true);
        Quantidade.setDisable(true);
        DescontoUtnit.setDisable(true);
        Adicionar.setDisable(true);
        LeituraX.setDisable(true);
        Pagamento.setDisable(true);
        FinalizarVenda.setDisable(true);
        AbrirVenda.setDisable(false);
        GerarFactura.setDisable(true);
        CancelarVenda.setDisable(true);

    }

//    public void PrintBill() {
//
//        oblist = TableViewVenda.getItems();
//        Retorno.autosize();
//        Retorno.setText(Retorno.getText() + "******************************************\n");
//        Retorno.setText(Retorno.getText() + "*****SISTEMA DE VENDA PARA FARMACIAS******\n");
//        Retorno.setText(Retorno.getText() + "*********************************************\n");
//        Retorno.setText(Retorno.getText() + "PRODUTO" + "\t MDA" + "\t VALOR" + "\t QTDE" + "\t TOTAL\n");
//        for (int i = 0; i < oblist.size(); i++) {
//            String produto = oblist.get(i).getDEscricao();
//            String medida = oblist.get(i).getMedida();
//            String valor = oblist.get(i).getValor();
//            String qtde = oblist.get(i).getQUuantidade();
//            Double total = oblist.get(i).getTotal();
//            Retorno.setText(Retorno.getText() + produto + "\t\t" + medida + "\t\t" + valor + "\t\t" + qtde + "\t\t" + total + "\n");
//
//        }
//        Retorno.setText(Retorno.getText() + "\n");
//        Retorno.setText(Retorno.getText() + "\n");
//
//        Retorno.setText(Retorno.getText() + "SUBTOTAL:        " + "\t" + "\t" + "\t" + "\t" + TotaValor + "\n");
//        Retorno.setText(Retorno.getText() + "DESCONTO:        " + "\t" + "\t" + "\t" + "\t" + DescontoTotal + "\n");
//        Retorno.setText(Retorno.getText() + "RECEBIDO:        " + "\t" + "\t" + "\t" + "\t" + valorRecebido + "\n");
//        Retorno.setText(Retorno.getText() + "TROCO:           " + "\t" + "\t" + "\t" + "\t" + troco + "\n");
//        Retorno.setText(Retorno.getText() + "VALOR FINAL:     " + "\t" + "\t" + "\t" + "\t" + FinalValor + "\n");
//        Retorno.setText(Retorno.getText() + "\n");
//        Retorno.setText(Retorno.getText() + "\n");
//        Retorno.setText(Retorno.getText() + "*********************************************\n");
//        Retorno.setText(Retorno.getText() + "***OBRIGADO PELA PREFERÊNCIA VOLTE SEMPRE****\n");
//
//    }
     public void PrintBill() {
         Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        
        try {
            String conteudoImprimir="";
            oblist = TableViewVenda.getItems();
            for (int i = 0; i < oblist.size(); i++) {
                conteudoImprimir+=oblist.get(i).getDEscricao()+""+
                        oblist.get(i).getValor()+""+
                        oblist.get(i).getQUuantidade()+""+
                        oblist.get(i).getTotal()+"\n\r";   
            }
            this.imprimir("SISTEMA PARA GESTÃO DE FARMÁCIAS\n\r"
                         +formatador.format(data)
                         + "\n" + data + "\n\n"
                         +"***********************************\n\r"
                         +"         NOME DA EMPRESA           \n\r"
                         +"         NIF                       \n\r"
                         +"         ENDEREÇO                   \n\r"
                         +"DESCRIÇÃO      VALOR  QTDE   TOTAL  \n\r"
                         +conteudoImprimir+""
                         +"***********************************\n\r"
                         +"SUBTOTAL:       \t" + "  \t" + "\t"+TotaValor
                         +"DESCONTO:       \t" + "\t" + "\t"  +DescontoTotal
                         +"RECEBIDO:       \t" + "\t" + "\t"  + valorRecebido
                         +"TROCO:          \t" + "\t" + "\t"  + troco
                         +"VALOR FINAL:    \t" + "\t" + "\t"  + FinalValor
                         +"\n"
                         +"\n"
                         +"***********************************\n\r"
                         +"        OBRIGADO VALTE SEMPRE       \n\r"
                         +"\n\r"
                         +"\n\r"
                         +"\f");
                        
            Retorno.appendText("SISTEMA PARA GESTÃO DE FARMÁCIAS\n\r"
                         +formatador.format(data)
                         + "\n" + data + "\n\n"
                         +"***********************************\n\r"
                         +"         NOME DA EMPRESA           \n\r"
                         +"         NIF                       \n\r"
                         +"         ENDEREÇO                   \n\r"
                         +"DESCRIÇÃO      VALOR  QTDE   TOTAL  \n\r"
                         +conteudoImprimir+""
                         +"***********************************\n\r"
                         +"SUBTOTAL:       \t" + "  \t" + "\t"+TotaValor
                         +"DESCONTO:       \t" + "\t" + "\t"  +DescontoTotal
                         +"RECEBIDO:       \t" + "\t" + "\t"  + valorRecebido
                         +"TROCO:          \t" + "\t" + "\t"  + troco
                         +"VALOR FINAL:    \t" + "\t" + "\t"  + FinalValor
                         +"\n"
                         +"\n"
                         +"***********************************\n\r"
                         +"        OBRIGADO VALTE SEMPRE       \n\r"
                         +"\n"
                         +"\n"
                         +"\f");
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,"Erro "+ex);
        }
         
     }
     public void imprimir(String pTexto) throws IOException{
         InputStream prin=new ByteArrayInputStream(pTexto.getBytes());
         DocFlavor docFlavor=DocFlavor.INPUT_STREAM.AUTOSENSE;
         SimpleDoc documentoTexto=new SimpleDoc(prin,docFlavor,null);
         PrintService impressora=PrintServiceLookup.lookupDefaultPrintService();
         PrintRequestAttributeSet printerAttribute=new HashPrintRequestAttributeSet();
         printerAttribute.add(new JobName("Impressão",null));
         printerAttribute.add(OrientationRequested.PORTRAIT);
         printerAttribute.add(MediaSizeName.ISO_A4);
         DocPrintJob printJob=impressora.createPrintJob();
        try {
            printJob.print(documentoTexto,(PrintRequestAttributeSet) printerAttribute);
        } catch (PrintException ex) {
           JOptionPane.showMessageDialog(null,"Erro "+ex);
        }prin.close();
     }


}
