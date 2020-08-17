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
public class ModeloTabelaServicos {

    private String codServico;
    private String tipoServico;
    private String valorServico;

    public ModeloTabelaServicos(String codServico, String tipoServico, String valorServico) {
        this.codServico = codServico;
        this.tipoServico = tipoServico;
        this.valorServico = valorServico;
    }

    /**
     * @return the codServico
     */
    public String getCodServico() {
        return codServico;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setCodServico(String codServico) {
        this.codServico = codServico;
    }

    /**
     * @return the tipoServico
     */
    public String getTipoServico() {
        return tipoServico;
    }

    /**
     * @param tipoServico the tipoServico to set
     */
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    /**
     * @return the valorServico
     */
    public String getValorServico() {
        return valorServico;
    }

    /**
     * @param valorServico the valorServico to set
     */
    public void setValorServico(String valorServico) {
        this.valorServico = valorServico;
    }

}
