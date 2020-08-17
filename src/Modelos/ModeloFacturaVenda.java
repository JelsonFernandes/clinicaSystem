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
public class ModeloFacturaVenda {

    private String produto;
    private String vavor;
    private String quantidade;
    private String desconto;
    private String total;

    public ModeloFacturaVenda(String produto, String vavor, String quantidade, String desconto, String total) {
        this.produto = produto;
        this.vavor = vavor;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.total = total;
    }

   

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the vavor
     */
    public String getVavor() {
        return vavor;
    }

    /**
     * @param vavor the vavor to set
     */
    public void setVavor(String vavor) {
        this.vavor = vavor;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the desconto
     */
    public String getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

   
}
