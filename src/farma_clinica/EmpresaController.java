/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Controle.ControleEmpresa;
import Modelos.ModeloConexao;
import Modelos.ModeloEmpresa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class EmpresaController implements Initializable {

    @FXML
    public ImageView FotoEmpresa;
    @FXML
    public TextField IdEmpresa;
    @FXML
    public TextField NomeEmpresa;
    @FXML
    public TextField NifEmpresa;
    @FXML
    public TextField RepresentanteEmpresa;
    @FXML
    public TextField EndeEmpres;
    public TextField NumFuncEmpresa;
    @FXML
    public TextField TelefoneEmpresa;
    @FXML
    public TextField EmaiEmpresa;
    public TextField WebEmpresa;
    @FXML
    public Button RemoverEmpresa;
    public Button EditarEmpresa;
    @FXML
    public Button BuscarEmpres;
    @FXML
    public Button SalvarEmpresa;
    ModeloEmpresa mod = new ModeloEmpresa();
    ControleEmpresa control = new ControleEmpresa();
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private JFXButton AlterarEmpresa;
    @FXML
    private JFXTextField ImageSourceChoose;
    @FXML
    private JFXButton btnBuscarFoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void SalvarEmpresa(javafx.event.ActionEvent event) {
        try {
            //       insert into tbempresa ( nome, representante, nif, endereco, numfunciocionarios, telefone, email, website
            FileInputStream archivofoto;
            mod.setNomeEmpresa(NomeEmpresa.getText());
            mod.setRepresentanteEmpresa(RepresentanteEmpresa.getText());
            mod.setNifEmpresa(NifEmpresa.getText());
            mod.setEndeEmpres(EndeEmpres.getText());
            mod.setNumFuncEmpresa(NumFuncEmpresa.getText());
            mod.setTelefoneEmpresa(TelefoneEmpresa.getText());
            mod.setEmaiEmpresa(EmaiEmpresa.getText());
            mod.setWebEmpresa(WebEmpresa.getText());
            mod.setCaminho(ImageSourceChoose.getText());

            archivofoto = new FileInputStream(ImageSourceChoose.getText());
            mod.setFoto(archivofoto);
//            pst.setBinaryStream(11, archivofoto);
            control.SalvarEmpresa(mod);
            NomeEmpresa.setText(null);
            RepresentanteEmpresa.setText(null);
            NifEmpresa.setText(null);
            EndeEmpres.setText(null);
            NumFuncEmpresa.setText(null);
            TelefoneEmpresa.setText(null);
            EmaiEmpresa.setText(null);
            WebEmpresa.setText(null);
            IdEmpresa.setText(null);
        } catch (FileNotFoundException ex) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção!!");
            alert.setContentText("Erro\n" + ex);
            alert.show();
        }

    }

    @FXML
    public void AlterarEmpresa(javafx.event.ActionEvent event) {
        try {
            //
            FileInputStream archivofoto;
            mod.setNomeEmpresa(NomeEmpresa.getText());
            mod.setRepresentanteEmpresa(RepresentanteEmpresa.getText());
            mod.setNifEmpresa(NifEmpresa.getText());
            mod.setEndeEmpres(EndeEmpres.getText());
            mod.setNumFuncEmpresa(NumFuncEmpresa.getText());
            mod.setTelefoneEmpresa(TelefoneEmpresa.getText());
            mod.setEmaiEmpresa(EmaiEmpresa.getText());
            mod.setWebEmpresa(WebEmpresa.getText());
            mod.setCaminho(ImageSourceChoose.getText());
            archivofoto = new FileInputStream(ImageSourceChoose.getText());
            mod.setFoto(archivofoto);
            mod.setIdEmpresa(IdEmpresa.getText());
            control.AlterarEmpresa(mod);
            NomeEmpresa.setText(null);
            RepresentanteEmpresa.setText(null);
            NifEmpresa.setText(null);
            EndeEmpres.setText(null);
            NumFuncEmpresa.setText(null);
            TelefoneEmpresa.setText(null);
            EmaiEmpresa.setText(null);
            WebEmpresa.setText(null);
            IdEmpresa.setText(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void BuscarEmpresa(javafx.event.ActionEvent event) {
         FileInputStream archivofoto = null;
        try {
            conexao = ModeloConexao.conector();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("ATENÇÃO!!!");
            dialog.setContentText("POR FAVOR INSIRA O ID");
//            Optional<String> result = dialog.showAndWait();
            dialog.showAndWait();
            String sql = "select*from tbempresa where id_empresa=" + dialog.getResult();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                IdEmpresa.setText(rs.getString("id_empresa"));
                NomeEmpresa.setText(rs.getString("nome"));
                RepresentanteEmpresa.setText(rs.getString("representante"));
                NifEmpresa.setText(rs.getString("nif"));
                EndeEmpres.setText(rs.getString("endereco"));
                NumFuncEmpresa.setText(rs.getString("numfunciocionarios"));
                TelefoneEmpresa.setText(rs.getString("telefone"));
                EmaiEmpresa.setText(rs.getString("email"));
                WebEmpresa.setText(rs.getString("website"));
                ImageSourceChoose.setText(rs.getString("caminhoImagem"));
                archivofoto = new FileInputStream(ImageSourceChoose.getText());
                FotoEmpresa.setImage(new javafx.scene.image.Image(rs.getBinaryStream("logimagem")));
//                FotoEmpresa.setImage(new javafx.scene.image.Image(archivofoto));// Este método também funciona

            }
        } catch (SQLException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("ATENÇÃO!!!");
            alert2.setContentText("Erro" + ex);
            alert2.show();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void handelerremover(javafx.event.ActionEvent event) {
        // a estrutura abaixo confirma a remoção do aluno
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("ATENÇÃO!!!");
        alert.setContentText("Tem certeza que dezeja remover este Usuário?");
//            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Usuário ?", "Atenção", JOptionPane.YES_NO_OPTION);
        ButtonType button1 = new ButtonType("Sim");
        ButtonType button2 = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(button1, button2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == button1) {
            String sql = "delete from tbempresa where id_empresa=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, IdEmpresa.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    alert.setContentText("Dados removidos com sucesso!");
                    alert.show();
                    IdEmpresa.setText(null);
                    NomeEmpresa.setText(null);
                    RepresentanteEmpresa.setText(null);
                    NifEmpresa.setText(null);
                    EndeEmpres.setText(null);
                    NumFuncEmpresa.setText(null);
                    TelefoneEmpresa.setText(null);
                    EmaiEmpresa.setText(null);
                    WebEmpresa.setText(null);

                }
            } catch (HeadlessException | SQLException e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("ERRO");
                alert2.setHeaderText("ATENÇÃO!!!");
                alert2.setContentText("Erro" + e);
                alert2.show();

            }
        }
    }

    public void AddPicture(MouseEvent event) {
        if (event.getClickCount() == 1) {
            FileChooser f = new FileChooser();
            f.getExtensionFilters().add(new ExtensionFilter("Archivos", "*.PNG", "*.JPG", "*.JPEG"));
            File file = f.showOpenDialog(new Stage());
            if (file != null) {
                FotoEmpresa.setImage(new javafx.scene.image.Image("file:///" + file.getAbsolutePath()));
                ImageSourceChoose.setText(String.valueOf(file.getAbsolutePath()));
            }

//         FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
//        JFileChooser archivo = new JFileChooser();
//        archivo.addChoosableFileFilter(filtro);
//        archivo.setDialogTitle("Abrir Arquivo");
//        File rute = new File("D:/");
//        archivo.setCurrentDirectory(rute);
//        int ventana = archivo.showOpenDialog(null);
//        if (ventana == JFileChooser.APPROVE_OPTION) {
//            File file = archivo.getSelectedFile();
//            ImageSourceChoose.setText(String.valueOf(file));
//            Image foto = getToolkit().createPlatformImage(ImageSourceChoose.getText());
//            foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
//            FotoEmpresa.setIcon(new ImageIcon(foto));
        }
// javafx.scene.image.Image image1=new  javafx.scene.image.Image("/fotos/bdon.png");
//        jLabelonoff.setImage(image1);

    }

}
