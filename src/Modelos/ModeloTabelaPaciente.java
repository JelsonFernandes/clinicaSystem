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
public class ModeloTabelaPaciente {

    private String codPaciente;
    private String NomePaciente;
    private String nascipaciente;
    private String FonePaciente;
    private String emailPaciente;
    private String muniPaciente;
    private String casaPaciente;

    public ModeloTabelaPaciente(String codPaciente, String NomePaciente, String nascipaciente, String FonePaciente, String emailPaciente, String muniPaciente, String casaPaciente) {
        this.codPaciente = codPaciente;
        this.NomePaciente = NomePaciente;
        this.nascipaciente = nascipaciente;
        this.FonePaciente = FonePaciente;
        this.emailPaciente = emailPaciente;
        this.muniPaciente = muniPaciente;
        this.casaPaciente = casaPaciente;
    }

    /**
     * @return the codPaciente
     */
    public String getCodPaciente() {
        return codPaciente;
    }

    /**
     * @param codPaciente the codPaciente to set
     */
    public void setCodPaciente(String codPaciente) {
        this.codPaciente = codPaciente;
    }

    /**
     * @return the NomePaciente
     */
    public String getNomePaciente() {
        return NomePaciente;
    }

    /**
     * @param NomePaciente the NomePaciente to set
     */
    public void setNomePaciente(String NomePaciente) {
        this.NomePaciente = NomePaciente;
    }

    /**
     * @return the nascipaciente
     */
    public String getNascipaciente() {
        return nascipaciente;
    }

    /**
     * @param nascipaciente the nascipaciente to set
     */
    public void setNascipaciente(String nascipaciente) {
        this.nascipaciente = nascipaciente;
    }

    /**
     * @return the FonePaciente
     */
    public String getFonePaciente() {
        return FonePaciente;
    }

    /**
     * @param FonePaciente the FonePaciente to set
     */
    public void setFonePaciente(String FonePaciente) {
        this.FonePaciente = FonePaciente;
    }

    /**
     * @return the emailPaciente
     */
    public String getEmailPaciente() {
        return emailPaciente;
    }

    /**
     * @param emailPaciente the emailPaciente to set
     */
    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    /**
     * @return the muniPaciente
     */
    public String getMuniPaciente() {
        return muniPaciente;
    }

    /**
     * @param muniPaciente the muniPaciente to set
     */
    public void setMuniPaciente(String muniPaciente) {
        this.muniPaciente = muniPaciente;
    }

    /**
     * @return the casaPaciente
     */
    public String getCasaPaciente() {
        return casaPaciente;
    }

    /**
     * @param casaPaciente the casaPaciente to set
     */
    public void setCasaPaciente(String casaPaciente) {
        this.casaPaciente = casaPaciente;
    }

  
}
