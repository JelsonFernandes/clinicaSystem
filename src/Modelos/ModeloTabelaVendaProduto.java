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
public class ModeloTabelaVendaProduto {
    private String codProduto;
    private String nomeProduto;
    private String Medida;
    private String precoVenda;
 

    public ModeloTabelaVendaProduto(String codProduto, String nomeProduto, String Medida, String precoVenda) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.Medida = Medida;
        this.precoVenda = precoVenda;
       
    }

    /**
     * @return the codProduto
     */
    public String getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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

    /**
     * @return the precoVenda
     */
    public String getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the quatidadeProduto
     */
   
    
}
