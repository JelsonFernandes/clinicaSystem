
package farma_clinica;

import Modelos.ModeloConexao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class PrincipalAnchorPaneController implements Initializable {

    @FXML
    private Button jfxUsuario;
    @FXML
    private Button jfxEnfermeiro;
    @FXML
    private Button jfxFarmácia;
    @FXML
    private Button jfxPacientes;
    @FXML
    private Button jfxAgenda;
    @FXML
    private Label jfxLabLogo;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private Label jfxLabNome;
    @FXML
    private Label jfxLabNif;
    @FXML
    private Label jfxLabContacto;
    @FXML
    private Label jfxLabWebsite;
    @FXML
    private ImageView jfxFacebook;
    @FXML
    private ImageView jfxTwiter;
    @FXML
    private Button jfxInfotokes;
    @FXML
    private Label jfxData;
    @FXML
    public Label LabelUsuario;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
//    String Usuario;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Stage primaryStage;
    Stage dialogStage = new Stage();
    Stage dialogStage1 = new Stage();
     Stage dialogStage2 = new Stage();
    public FXMLDocumentController User = new FXMLDocumentController();
//   
    ModeloTransportaUsuario modtransUsu = new ModeloTransportaUsuario();
//     User.modtransUsu.setUsuario(Usuario);

    public String Usuario;
    @FXML
    private Button jfxFornecedor;
    @FXML
    private Button jfxClientes;
    @FXML
    private Button jfxAgenda111;
    @FXML
    private Button jfxAtender;
    
    /**
     *
     * @param User
     */
    protected void initialize(FXMLDocumentController User){
     String User_Name = null;
      User.handleButtonAction(User_Name);
        System.out.println("O usuário é :"+User_Name);
        
  
}
  

   

    
    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println("<< " +Usuario + " >>");
        conexao = ModeloConexao.conector();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy " + "\n" + "HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        jfxData.setText(dateFormat.format(cal.getTime()));

        try {
            String sql = ("Select*from tbempresa");

            pst = conexao.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
//               jlabelempresa.setText(String.valueOf(nome));
                String nif = rs.getString("nif");
                jfxLabNif.setText(String.valueOf(nif));
                String contacto = rs.getString("telefone");
                jfxLabContacto.setText(String.valueOf(contacto));
                String site = rs.getString("website");
                jfxLabWebsite.setText(String.valueOf(site));
               

            }
              

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar a Empresa!\nERRO" + error);
        }
      

    }
    void initialize(String text){
         jfxLabNome.setText(String.valueOf(text));
    }


    @FXML
    public void HandlerMenuItemUsuario(ActionEvent event) {
        try {
            Parent usuario = FXMLLoader.load(getClass().getResource("Usuarios.fxml"));

            Scene scene = new Scene(usuario);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Usuarios.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }

    }

    @FXML
    public void HandlerPacientes(ActionEvent event) {
        try {
            Parent pacientes = FXMLLoader.load(getClass().getResource("Pacientes.fxml"));

            Scene scene = new Scene(pacientes);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Pacientes.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }

    }

    @FXML
    public void HandlerEnfermeiros(ActionEvent event) {
        try {
            Parent enfermeiros = FXMLLoader.load(getClass().getResource("Enfermeiro.fxml"));

            Scene scene = new Scene(enfermeiros);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Enfermeiro.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }

    }

    @FXML
    public void HandlerMedicos(ActionEvent event) {
        try {
            Parent medicos = FXMLLoader.load(getClass().getResource("Medicos.fxml"));

            Scene scene = new Scene(medicos);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Medicos.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerAgenda(ActionEvent event) {
        try {
            Parent agenda = FXMLLoader.load(getClass().getResource("Agenda_Medica.fxml"));

            Scene scene = new Scene(agenda);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Agenda_Medica.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerAtenderAgenda(ActionEvent event) {
        try {
            Parent atenderagenda = FXMLLoader.load(getClass().getResource("AtenderAgendamento.fxml"));

            Scene scene = new Scene(atenderagenda);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("AtenderAgendamento.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerConsultorio(ActionEvent event) {
        try {
            Parent Consultorio = FXMLLoader.load(getClass().getResource("consultorio.fxml"));

            Scene scene = new Scene(Consultorio);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("consultorio.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerLaboratorio(ActionEvent event) {
        try {
            Parent laboratorio = FXMLLoader.load(getClass().getResource("Laboratorio1.fxml"));

            Scene scene = new Scene(laboratorio);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Laboratorio1.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerClientes(ActionEvent event) {
        try {
            Parent clientes = FXMLLoader.load(getClass().getResource("Clientes.fxml"));

            Scene scene = new Scene(clientes);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Clientes.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerFronecedor(ActionEvent event) {
        try {
            Parent fornecedor = FXMLLoader.load(getClass().getResource("Fornecedores.fxml"));

            Scene scene = new Scene(fornecedor);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Fornecedores.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerProdutos(ActionEvent event) {
        try {
            Parent produtos = FXMLLoader.load(getClass().getResource("produtos.fxml"));

            Scene scene = new Scene(produtos);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("produtos.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerServicos(ActionEvent event) {
        try {
            Parent servicos = FXMLLoader.load(getClass().getResource("servicos.fxml"));

            Scene scene = new Scene(servicos);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("servicos.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerFuncionarios(ActionEvent event) {
        try {
            Parent funcionarios = FXMLLoader.load(getClass().getResource("funcionarios.fxml"));

            Scene scene = new Scene(funcionarios);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("funcionarios.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerEmpresa(ActionEvent event) {
        try {
            Parent empresa = FXMLLoader.load(getClass().getResource("empresa.fxml"));

            Scene scene = new Scene(empresa);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("empresa.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    @FXML
    public void HandlerFarmacia(ActionEvent event) {
        try {
            Parent empresa = FXMLLoader.load(getClass().getResource("vendas.fxml"));

            Scene scene = new Scene(empresa);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("vendas.fxml")));
            dialogStage1.setScene(scene);
            dialogStage1.show();
            dialogStage1.setMaximized(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

    public void HandlerFinancas(ActionEvent event) {
        try {
            Parent financas = FXMLLoader.load(getClass().getResource("financas.fxml"));

            Scene scene = new Scene(financas);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("financas.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }
    public void HandlercontroleClinica(ActionEvent event) {
        try {
            Parent clinica = FXMLLoader.load(getClass().getResource("controleClinica.fxml"));

            Scene scene = new Scene(clinica);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("controleClinica.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }

         public void HandlercontroleNatalidade(ActionEvent event) {
        try {
            Parent natalidade = FXMLLoader.load(getClass().getResource("controle_de_natalidade.fxml"));

            Scene scene = new Scene(natalidade);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("controle_de_natalidade.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }
         public void HandlercontroleMortalidade(ActionEvent event) {
        try {
            Parent morte = FXMLLoader.load(getClass().getResource("controlemorte.fxml"));

            Scene scene = new Scene(morte);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("controlemorte.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }
          public void HandlercontroleNatalMortalidade(ActionEvent event) {
        try {
            Parent natalmorte = FXMLLoader.load(getClass().getResource("Indece_Natal_Morte.fxml"));

            Scene scene = new Scene(natalmorte);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Indece_Natal_Morte.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
            dialogStage.setResizable(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }
           public void HandlercontroleMainForm(ActionEvent event) {
        try {
            Parent  MainForm = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

            Scene scene = new Scene( MainForm);

//dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("MainForm.fxml")));
            scene.getStylesheets().add("/css/StyleSheet.css");
            dialogStage2.setScene(scene);
            dialogStage2.show();
            dialogStage2.setMaximized(true);
            dialogStage2.setTitle("SISTEMA DE GESTÃO DE CLINICAS & FARMÁCIAS");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
        }
    }
          
    @FXML
    private void jfxWatp(MouseEvent event) {
        if (event.getClickCount() == 1) {
            JOptionPane.showMessageDialog(null, "Ainda não esta em funcionamento", "Atenção!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void jfxYoutube(MouseEvent event) {
    }

    @FXML
    private void HandlerMenuItemAction(MouseEvent event) {
    }

    @FXML
    private void HandlerFactura(ActionEvent event) {
    }

    @FXML
    private void Handlerclinica(ActionEvent event) {
    }

    @FXML
    private void HandlerFinanca(ActionEvent event) {
    }

   
}
