/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jelson Fernandes
 */

 public class ModeloConexao{
    
    
   
     public static Connection conector() {
        java.sql.Connection conexao = null;
        java.sql.Connection conn=null;
        
        /* A linha abaixo chama o driver*/
        String driver = "com.mysql.jdbc.Driver";
        /*Armazenando informações referente ao banco*/
        String url = "jdbc:mysql://localhost:3306/clinica_database";
        String user = "root";
        String password = "";
        
        /*Estabelecendo a conexão com o banco*/
        try {
            Class.forName(driver);
            conexao=DriverManager.getConnection(url, user, password);
             System.out.println("Conectado");
            return conexao;
        } catch (Exception e) {
            /*A linha abaixo serve de apoio ao erro*/
            System.out.println("Erro ao conectar"+e);
            
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
   
    
}


