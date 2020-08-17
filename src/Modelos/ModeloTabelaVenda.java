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
public class ModeloTabelaVenda {

    private int Id;
    private String DEscricao;
     private String Medida;
     private String Valor;
    private String QUuantidade;
    private String Desconto;
    private Double Total;

    public ModeloTabelaVenda(int Id, String DEscricao,String Medida, String Valor, String QUuantidade, String Desconto, Double Total) {
        this.Id = Id;
        this.DEscricao = DEscricao;
         this.Medida = Medida;
        this.Valor = Valor;
        this.QUuantidade = QUuantidade;
        this.Desconto = Desconto;
        this.Total = Total;
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

    /**
     * @return the DEscricao
     */
    public String getDEscricao() {
        return DEscricao;
    }

    /**
     * @param DEscricao the DEscricao to set
     */
    public void setDEscricao(String DEscricao) {
        this.DEscricao = DEscricao;
    }

    /**
     * @return the Valor
     */
    public String getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the QUuantidade
     */
    public String getQUuantidade() {
        return QUuantidade;
    }

    /**
     * @param QUuantidade the QUuantidade to set
     */
    public void setQUuantidade(String QUuantidade) {
        this.QUuantidade = QUuantidade;
    }

    /**
     * @return the Desconto
     */
    public String getDesconto() {
        return Desconto;
    }

    /**
     * @param Desconto the Desconto to set
     */
    public void setDesconto(String Desconto) {
        this.Desconto = Desconto;
    }

    /**
     * @return the Total
     */
    public Double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.Total = Total;
    }

    /**
     * @return the Medida
     */
    public String getMedida() {
        return Medida;
    }

    /**
     * @param Medida the Medida to set
     */
    public void setMedida(String Medida) {
        this.Medida = Medida;
    }

}
