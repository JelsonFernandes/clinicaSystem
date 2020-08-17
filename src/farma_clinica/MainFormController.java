/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class MainFormController implements Initializable {

    @FXML
    public Color x4;
    @FXML
    public Font x3;
    @FXML
    public JFXHamburger MenuHamburger;
    @FXML
    public AnchorPane CliPane;
    @FXML
    public JFXButton menucad;
    @FXML
    public JFXButton menuConsu;
    @FXML
    public JFXButton menuFarm;
    @FXML
    public JFXButton menuRel;
//    @FXML
//    public JFXButton menuNatMort;
    @FXML
    public JFXButton menuVis;
    @FXML
    public JFXButton menuFin;
    @FXML
    public JFXButton menuSair;
    public AnchorPane barraDeMenu;
    @FXML
    public JFXButton btnUsuario;
    String Cor;
    @FXML
    public AnchorPane menBar;
    @FXML
    public JFXButton Enfermeiros;
    @FXML
    public JFXButton Medico;
    @FXML
    public JFXButton Paciente;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Stage primaryStage;
    Stage dialogStage = new Stage();
    Stage dialogStage1 = new Stage();
    Stage dialogStage2 = new Stage();
    @FXML
    public JFXButton Fornecedor;
    @FXML
    public JFXButton Cliente;
    @FXML
    public AnchorPane nenuBarCunsulta;
    @FXML
    public JFXButton Agendar;
    @FXML
    public JFXButton Atender;
    @FXML
    public JFXButton Consultar;
    @FXML
    public JFXButton Laboratorio;
    @FXML
    public AnchorPane menBarFarmacia;
    @FXML
    public JFXButton btnMedicamentos;
    @FXML
    public JFXButton btnPontoVenda;
    public AnchorPane Visao;
    @FXML
    private JFXButton btnEmpresa;
    @FXML
    private AnchorPane menuBarEmpresa;
    @FXML
    private JFXButton btnFuncionarios;
    @FXML
    private JFXButton btnServicos;
    @FXML
    private JFXButton btnEmpresa2;
    @FXML
    private JFXButton btnTatalidade;
    @FXML
    private JFXButton btnRelatorio;
    @FXML
    private JFXButton btnMortalidade;
    @FXML
    private JFXButton btnGrafico;
    @FXML
    private Label empresa;
    @FXML
    private Label jfxLabNif;
    @FXML
    private Label user;
    @FXML
    private Label Number;
    @FXML
    private Label Website;
    @FXML
    private ImageView LogoImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao = ModeloConexao.conector();
        CliPane.setPrefWidth(66);
        menucad.setVisible(false);
        menuConsu.setVisible(false);
        menuFarm.setVisible(false);
//        menuNatMort.setVisible(false);
        menuVis.setVisible(false);
        menuFin.setVisible(false);
        menuRel.setVisible(false);
        menuSair.setVisible(false);
        btnEmpresa.setVisible(false);
//        barraDeMenu.setId("menBar");
        try {
            String sql = ("Select*from tbempresa");

            pst = conexao.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                empresa.setText(String.valueOf(nome));
                String nif = rs.getString("nif");
                jfxLabNif.setText(String.valueOf("NIF: " + nif));
                String contacto = rs.getString("telefone");
                Number.setText(String.valueOf("CONTACTO:  " + contacto));
                String site = rs.getString("website");
                Website.setText(String.valueOf("WESITE:    " + site));
                LogoImage.setImage(new javafx.scene.image.Image(rs.getBinaryStream("logimagem")));
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar a Empresa!\nERRO" + error);
        }

    }

    @FXML
    public void ChamarMenu(MouseEvent event) {
        if (event.getClickCount() == 1) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(1.0));
            slide.setNode(CliPane);
            slide.play();
            CliPane.setPrefWidth(213);
            menucad.setVisible(true);
            menuConsu.setVisible(true);
            menuFarm.setVisible(true);
//            menuNatMort.setVisible(true);
            menuVis.setVisible(true);
            menuFin.setVisible(true);
            menuRel.setVisible(true);
            menuSair.setVisible(true);
            btnEmpresa.setVisible(true);
            jfxLabNif.setVisible(false);
            jfxLabNif.setVisible(false);
            user.setVisible(false);
//            nifl.setVisible(false);
            Number.setVisible(false);
            Website.setVisible(false);
            LogoImage.setVisible(false);

        } else if (CliPane.isVisible() && event.getClickCount() == 1) {

            CliPane.setPrefWidth(66);
            menucad.setVisible(false);
            menuConsu.setVisible(false);
            menuFarm.setVisible(false);
//            menuNatMort.setVisible(false);
            menuVis.setVisible(false);
            menuFin.setVisible(false);
            menuRel.setVisible(false);
            menuSair.setVisible(false);
            btnEmpresa.setVisible(true);
            jfxLabNif.setVisible(true);
            jfxLabNif.setVisible(true);
            user.setVisible(true);
//            nifl.setVisible(true);
            Number.setVisible(true);
            Website.setVisible(true);
            LogoImage.setVisible(true);
        } else if (event.getClickCount() == 2) {

            CliPane.setPrefWidth(66);
            menucad.setVisible(false);
            menuConsu.setVisible(false);
            menuFarm.setVisible(false);
//            menuNatMort.setVisible(false);
            menuVis.setVisible(false);
            menuFin.setVisible(false);
            menuRel.setVisible(false);
            menuSair.setVisible(false);
            jfxLabNif.setVisible(true);
            jfxLabNif.setVisible(true);
            user.setVisible(true);
//            nifl.setVisible(true);
            Number.setVisible(true);
            Website.setVisible(true);
            LogoImage.setVisible(true);
        }

    }

    @FXML
    public void FechararMenu(MouseEvent event) {
        if (event.getClickCount() == 1) {

            CliPane.setPrefWidth(66);
            menucad.setVisible(false);
            menuConsu.setVisible(false);
            menuFarm.setVisible(false);
//            menuNatMort.setVisible(false);
            menuVis.setVisible(false);
            menuFin.setVisible(false);
            menuRel.setVisible(false);
            menuSair.setVisible(false);
            jfxLabNif.setVisible(true);
            btnEmpresa.setVisible(false);
            jfxLabNif.setVisible(true);
            user.setVisible(true);
//            nifl.setVisible(true);
            Number.setVisible(true);
            Website.setVisible(true);
            LogoImage.setVisible(true);
        }

    }


    @FXML
    public void AbrirMenuCadastro(MouseEvent event) {
        if (event.getClickCount() == 1) {

            menBar.setVisible(true);
            nenuBarCunsulta.setVisible(false);
            menBarFarmacia.setVisible(false);
            Visao.setVisible(false);
            menuBarEmpresa.setVisible(false);
            empresa.setVisible(false);
        }

    }

    @FXML
    public void AbrirMenuConsulta(MouseEvent event) {
        if (event.getClickCount() == 1) {

            nenuBarCunsulta.setVisible(true);
            menBar.setVisible(false);
            menBarFarmacia.setVisible(false);
            Visao.setVisible(false);
            menuBarEmpresa.setVisible(false);
            empresa.setVisible(false);

        }

    }

    @FXML
    public void AbrirMenuFarmacia(MouseEvent event) {
        if (event.getClickCount() == 1) {

            menBarFarmacia.setVisible(true);
            nenuBarCunsulta.setVisible(false);
            menBar.setVisible(false);
            Visao.setVisible(false);
            menuBarEmpresa.setVisible(false);
            empresa.setVisible(false);

        }

    }

    @FXML
    public void AbrirVisao(MouseEvent event) {
        if (event.getClickCount() == 1) {
            Visao.setVisible(true);
            menBarFarmacia.setVisible(false);
            nenuBarCunsulta.setVisible(false);
            menBar.setVisible(false);
            menuBarEmpresa.setVisible(false);
            empresa.setVisible(false);
        }
    }

    @FXML
    public void AbrirEmpresa(MouseEvent event) {
        if (event.getClickCount() == 1) {
            menuBarEmpresa.setVisible(true);
            Visao.setVisible(false);
            menBarFarmacia.setVisible(false);
            nenuBarCunsulta.setVisible(false);
            menBar.setVisible(false);
            empresa.setVisible(false);
        }
    }
//      public void AbrirNatalidade(MouseEvent event) {
//
//        menBar.setVisible(false);
//
//    }
//     public void Abririsao(MouseEvent event) {
//
//        menBar.setVisible(false);
//
//    }

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

    @FXML
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

    @FXML
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

    @FXML
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

    @FXML
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

    @FXML
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

    @FXML
    public void HandlercontroleMainForm(ActionEvent event) {
        System.exit(0);
    }
}
