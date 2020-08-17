/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Jelson Fernandes
 */
public class ModeloTabelaUsuarios {

    private String IdUsuario;
    private String NomeUsuario;
    private String PerfilUsuario;
    private String EmailUsuario;
    private String SenhaUsuario;

    public ModeloTabelaUsuarios(String IdUsuario, String NomeUsuario, String PerfilUsuario, String EmailUsuario, String SenhaUsuario) {
        this.IdUsuario = IdUsuario;
        this.NomeUsuario = NomeUsuario;
        this.PerfilUsuario = PerfilUsuario;
        this.EmailUsuario = EmailUsuario;
        this.SenhaUsuario = SenhaUsuario;
    }

    /**
     * @return the IdUsuario
     */
    public String getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the NomeUsuario
     */
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    /**
     * @param NomeUsuario the NomeUsuario to set
     */
    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    /**
     * @return the PerfilUsuario
     */
    public String getPerfilUsuario() {
        return PerfilUsuario;
    }

    /**
     * @param PerfilUsuario the PerfilUsuario to set
     */
    public void setPerfilUsuario(String PerfilUsuario) {
        this.PerfilUsuario = PerfilUsuario;
    }

    /**
     * @return the EmailUsuario
     */
    public String getEmailUsuario() {
        return EmailUsuario;
    }

    /**
     * @param EmailUsuario the EmailUsuario to set
     */
    public void setEmailUsuario(String EmailUsuario) {
        this.EmailUsuario = EmailUsuario;
    }

    /**
     * @return the SenhaUsuario
     */
    public String getSenhaUsuario() {
        return SenhaUsuario;
    }

    /**
     * @param SenhaUsuario the SenhaUsuario to set
     */
    public void setSenhaUsuario(String SenhaUsuario) {
        this.SenhaUsuario = SenhaUsuario;
    }

}
