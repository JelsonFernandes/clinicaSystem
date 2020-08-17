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
public class ModeloTabelaAgenda {

    private String txtId;
    private String txtPaciente;
    private String txtDataAtual;
    private String txtDataConsulta;
    private String cboMedico;
    private String cboTurno;

    public ModeloTabelaAgenda(String txtId, String txtPaciente, String txtDataAtual, String txtDataConsulta, String cboMedico, String cboTurno) {
        this.txtId = txtId;
        this.txtPaciente = txtPaciente;
        this.txtDataAtual = txtDataAtual;
        this.txtDataConsulta = txtDataConsulta;
        this.cboMedico = cboMedico;
        this.cboTurno = cboTurno;
    }

    /**
     * @return the txtId
     */
    public String getTxtId() {
        return txtId;
    }

    /**
     * @param txtId the txtId to set
     */
    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    /**
     * @return the txtPaciente
     */
    public String getTxtPaciente() {
        return txtPaciente;
    }

    /**
     * @param txtPaciente the txtPaciente to set
     */
    public void setTxtPaciente(String txtPaciente) {
        this.txtPaciente = txtPaciente;
    }

    /**
     * @return the txtDataAtual
     */
    public String getTxtDataAtual() {
        return txtDataAtual;
    }

    /**
     * @param txtDataAtual the txtDataAtual to set
     */
    public void setTxtDataAtual(String txtDataAtual) {
        this.txtDataAtual = txtDataAtual;
    }

    /**
     * @return the txtDataConsulta
     */
    public String getTxtDataConsulta() {
        return txtDataConsulta;
    }

    /**
     * @param txtDataConsulta the txtDataConsulta to set
     */
    public void setTxtDataConsulta(String txtDataConsulta) {
        this.txtDataConsulta = txtDataConsulta;
    }

    /**
     * @return the cboMedico
     */
    public String getCboMedico() {
        return cboMedico;
    }

    /**
     * @param cboMedico the cboMedico to set
     */
    public void setCboMedico(String cboMedico) {
        this.cboMedico = cboMedico;
    }

    /**
     * @return the cboTurno
     */
    public String getCboTurno() {
        return cboTurno;
    }

    /**
     * @param cboTurno the cboTurno to set
     */
    public void setCboTurno(String cboTurno) {
        this.cboTurno = cboTurno;
    }

   
}
