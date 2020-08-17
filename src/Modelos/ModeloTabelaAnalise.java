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
public class ModeloTabelaAnalise {

    private int Id;
    private String Analise;
    private String Resultado;
    private String Oservacao;

    public ModeloTabelaAnalise(int Id, String Analise, String Resultado, String Oservacao) {
        this.Id = Id;
        this.Analise = Analise;
        this.Resultado = Resultado;
        this.Oservacao = Oservacao;

    }

    /**
     * @return the Analise
     */
    public String getAnalise() {
        return Analise;
    }

    /**
     * @param Analise the Analise to set
     */
    public void setAnalise(String Analise) {
        this.Analise = Analise;
    }

    /**
     * @return the Resultado
     */
    public String getResultado() {
        return Resultado;
    }

    /**
     * @param Resultado the Resultado to set
     */
    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    /**
     * @return the Oservacao
     */
    public String getOservacao() {
        return Oservacao;
    }

    /**
     * @param Oservacao the Oservacao to set
     */
    public void setOservacao(String Oservacao) {
        this.Oservacao = Oservacao;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

}
