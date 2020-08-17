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
public class ModeloTabelaFinancas {

    private String codReceita;
    private String UseReceita;
    private String DataReceita;
    private String ValorReceita;
    private String FinalReceita;
    private String DescriReceita;

    public ModeloTabelaFinancas(String codReceita, String UseReceita, String DataReceita, String ValorReceita, String FinalReceita, String DescriReceita) {
        this.codReceita = codReceita;
        this.UseReceita = UseReceita;
        this.DataReceita = DataReceita;
        this.ValorReceita = ValorReceita;
        this.FinalReceita = FinalReceita;
        this.DescriReceita = DescriReceita;
    }

    /**
     * @return the codReceita
     */
    public String getCodReceita() {
        return codReceita;
    }

    /**
     * @param codReceita the codReceita to set
     */
    public void setCodReceita(String codReceita) {
        this.codReceita = codReceita;
    }

    /**
     * @return the UseReceita
     */
    public String getUseReceita() {
        return UseReceita;
    }

    /**
     * @param UseReceita the UseReceita to set
     */
    public void setUseReceita(String UseReceita) {
        this.UseReceita = UseReceita;
    }

    /**
     * @return the DataReceita
     */
    public String getDataReceita() {
        return DataReceita;
    }

    /**
     * @param DataReceita the DataReceita to set
     */
    public void setDataReceita(String DataReceita) {
        this.DataReceita = DataReceita;
    }

    /**
     * @return the ValorReceita
     */
    public String getValorReceita() {
        return ValorReceita;
    }

    /**
     * @param ValorReceita the ValorReceita to set
     */
    public void setValorReceita(String ValorReceita) {
        this.ValorReceita = ValorReceita;
    }

    /**
     * @return the FinalReceita
     */
    public String getFinalReceita() {
        return FinalReceita;
    }

    /**
     * @param FinalReceita the FinalReceita to set
     */
    public void setFinalReceita(String FinalReceita) {
        this.FinalReceita = FinalReceita;
    }

    /**
     * @return the DescriReceita
     */
    public String getDescriReceita() {
        return DescriReceita;
    }

    /**
     * @param DescriReceita the DescriReceita to set
     */
    public void setDescriReceita(String DescriReceita) {
        this.DescriReceita = DescriReceita;
    }
    

}
