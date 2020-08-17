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
public class ModeloTabelaDivida {

    private String codDivida ;
    private String UseDivida;
    private String DataDivida;
    private String ValorDivida;
    private String DescriDivida;
    private String FinalDivida;
    private String dataAliquidarDivida;
    private String dataLiquidadoDivida;
    private String situacaoDivida;

    public ModeloTabelaDivida(String codDivida, String UseDivida, String DataDivida, String ValorDivida, String DescriDivida, String FinalDivida, String dataAliquidarDivida, String dataLiquidadoDivida, String situacaoDivida) {
        this.codDivida = codDivida;
        this.UseDivida = UseDivida;
        this.DataDivida = DataDivida;
        this.ValorDivida = ValorDivida;
        this.DescriDivida = DescriDivida;
        this.FinalDivida = FinalDivida;
        this.dataAliquidarDivida = dataAliquidarDivida;
        this.dataLiquidadoDivida = dataLiquidadoDivida;
        this.situacaoDivida = situacaoDivida;
    }

    /**
     * @return the codDivida
     */
    public String getCodDivida() {
        return codDivida;
    }

    /**
     * @param codDivida the codDivida to set
     */
    public void setCodDivida(String codDivida) {
        this.codDivida = codDivida;
    }

    /**
     * @return the UseDivida
     */
    public String getUseDivida() {
        return UseDivida;
    }

    /**
     * @param UseDivida the UseDivida to set
     */
    public void setUseDivida(String UseDivida) {
        this.UseDivida = UseDivida;
    }

    /**
     * @return the DataDivida
     */
    public String getDataDivida() {
        return DataDivida;
    }

    /**
     * @param DataDivida the DataDivida to set
     */
    public void setDataDivida(String DataDivida) {
        this.DataDivida = DataDivida;
    }

    /**
     * @return the ValorDivida
     */
    public String getValorDivida() {
        return ValorDivida;
    }

    /**
     * @param ValorDivida the ValorDivida to set
     */
    public void setValorDivida(String ValorDivida) {
        this.ValorDivida = ValorDivida;
    }

    /**
     * @return the DescriDivida
     */
    public String getDescriDivida() {
        return DescriDivida;
    }

    /**
     * @param DescriDivida the DescriDivida to set
     */
    public void setDescriDivida(String DescriDivida) {
        this.DescriDivida = DescriDivida;
    }

    /**
     * @return the FinalDivida
     */
    public String getFinalDivida() {
        return FinalDivida;
    }

    /**
     * @param FinalDivida the FinalDivida to set
     */
    public void setFinalDivida(String FinalDivida) {
        this.FinalDivida = FinalDivida;
    }

    /**
     * @return the dataAliquidarDivida
     */
    public String getDataAliquidarDivida() {
        return dataAliquidarDivida;
    }

    /**
     * @param dataAliquidarDivida the dataAliquidarDivida to set
     */
    public void setDataAliquidarDivida(String dataAliquidarDivida) {
        this.dataAliquidarDivida = dataAliquidarDivida;
    }

    /**
     * @return the dataLiquidadoDivida
     */
    public String getDataLiquidadoDivida() {
        return dataLiquidadoDivida;
    }

    /**
     * @param dataLiquidadoDivida the dataLiquidadoDivida to set
     */
    public void setDataLiquidadoDivida(String dataLiquidadoDivida) {
        this.dataLiquidadoDivida = dataLiquidadoDivida;
    }

    /**
     * @return the situacaoDivida
     */
    public String getSituacaoDivida() {
        return situacaoDivida;
    }

    /**
     * @param situacaoDivida the situacaoDivida to set
     */
    public void setSituacaoDivida(String situacaoDivida) {
        this.situacaoDivida = situacaoDivida;
    }

}
