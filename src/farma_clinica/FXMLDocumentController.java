/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farma_clinica;

import Modelos.ModeloConexao;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jelson Fernandes
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Label label;
    @FXML
    public Label jfxPermissao;
    @FXML
    public JFXTextField jfxUsuario;
    @FXML
    public JFXPasswordField jfxSenha;
    @FXML
    public Button jfxBtLogin;
    Stage dialogStage = new Stage();
    Stage dialogStage1 = new Stage();
    Stage dialogStage2 = new Stage();
    Stage logStage = new Stage();
    Scene scene;
    Connection conexao = null;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String vencimento;
    public String Usuario;
    ModeloTransportaUsuario modtransUsu = new ModeloTransportaUsuario();
//    public String Usuario=null;
//    String user = (PrincipalAnchorPaneController(Usuario));
    @FXML
    private ImageView jLabelonoff;
    @FXML
    private Label conection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao=ModeloConexao.conector();
        if(conexao!=null){
            Image image1=new  Image("/fotos/bdon.png");
        jLabelonoff.setImage(image1);
         conection.setText("Connected");
        }else{
             Image image2=new  Image("/fotos/bdoff.png");
        jLabelonoff.setImage(image2);
        conection.setText("Disconnected");
            
        }
       
        
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        conexao = ModeloConexao.conector();
        String sql = "select*from usuarios where email_user=? and senha_user=?";
        try {
            conexao = ModeloConexao.conector();
            
            pst = conexao.prepareStatement(sql);
            System.out.println(conexao);
            
            pst.setString(1, jfxUsuario.getText());
            pst.setString(2, jfxSenha.getText());
            
            System.out.println("O usuario é:" + jfxUsuario.getText());
            System.out.println("A senha é:" + jfxSenha.getText());
            
            rs = pst.executeQuery();
            if (rs.next()) {
                pst = conexao.prepareStatement(sql);
                
                Usuario = rs.getString("nome_user");
                
                Node node = (Node) event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                
                String busca = "select nome from tbempresa";
                pst = conexao.prepareStatement(busca);
                rs = pst.executeQuery();
                if (rs.next()) {
//                    Parent princip = FXMLLoader.load(getClass().getResource("principalAnchorPane.fxml"));
//
//                    Scene scene = new Scene(princip);
//
//                    scene = new Scene(FXMLLoader.load(getClass().getResource("principalAnchorPane.fxml")));
//                    dialogStage1.setScene(scene);
////                
//                    dialogStage1.show();
//
//                    dialogStage1.setMaximized(true);
                    //////////////////////////
                    try {
                        FXMLLoader princip = new FXMLLoader(getClass().getResource("principalAnchorPane.fxml"));
                        
                        Parent root = (Parent) princip.load();

//dialogStage.close();
//                    scene = new Scene(FXMLLoader.load(getClass().getResource("receitas.fxml")));
                        PrincipalAnchorPaneController pricipalController = princip.getController();
                        pricipalController.initialize(Usuario);
                        dialogStage.setScene(new Scene(root));
                        dialogStage.show();
                        dialogStage1.setMaximized(true);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao Abrir o Form: " + ex);
                    }

//                    
                } else {
                    int iniciar = JOptionPane.showConfirmDialog(null, "Esta Empresa ainda não foi cdstrada!\nDeszeja cadastrar agora? ", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (iniciar == JOptionPane.YES_OPTION) {
                        Parent empresa = FXMLLoader.load(getClass().getResource("empresa.fxml"));
                        
                        Scene scene = new Scene(empresa);

//dialogStage.close();
                        scene = new Scene(FXMLLoader.load(getClass().getResource("empresa.fxml")));
                        dialogStage2.setScene(scene);
                        dialogStage2.show();

//                dialogStage1.setMaximized(true);  
                    }
                    
                }
                
            } else {
                // JOptionPane.showMessageDialog(null, "E-Mail e//ou Senha inválido(s)");
                jfxPermissao.setText("Insira um E-mail e//ou Senha Válido(s)");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Logar!\nERRO" + e);
            System.out.println(e);
            
        } catch (Throwable ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public static void ChangeScreen(String src,Object userData){
//        
//            
//        
//    }
//    private static ArrayList<OnChangeScreen> listners = new ArrayList<>();
//
//    public static interface OnChangeScreen {
//
//        void onScreenChanged(String newScreen, Object userData);
//    }
//
//    public static void addOnChangeScreenListner(OnChangeScreen newListner) {
//        listners.add(newListner);
//    }
//    private static void notifyallListners(String newScreen, Object userData){
//        for(OnChangeScreen l:listners)
//            l.onScreenChanged(newScreen, userData);
//    }

    void handleButtonAction(String User_Name) {
        try {
            conexao = ModeloConexao.conector();
            String sql = "select*from usuarios where email_user=" + jfxUsuario.getText() + "";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            User_Name = rs.getString("nome_user");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro \n" + ex);
        }
    }
}
