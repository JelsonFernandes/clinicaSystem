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
public class ModeloTabelaProdutos {

    private String codProduto;
    private String nomeProduto;
    private String nomeFornecedor;
    private String nomeFabricante;
    private String precoCompra;
    private String precoVenda;
    private String quatidadeProduto;
    private String dataExpiracao;

    public ModeloTabelaProdutos(String codProduto, String nomeProduto, String nomeFornecedor, String nomeFabricante, String precoCompra, String precoVenda, String quatidadeProduto, String dataExpiracao) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeFabricante = nomeFabricante;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quatidadeProduto = quatidadeProduto;
        this.dataExpiracao = dataExpiracao;
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
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the nomeFabricante
     */
    public String getNomeFabricante() {
        return nomeFabricante;
    }

    /**
     * @param nomeFabricante the nomeFabricante to set
     */
    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }

    /**
     * @return the precoCompra
     */
    public String getPrecoCompra() {
        return precoCompra;
    }

    /**
     * @param precoCompra the precoCompra to set
     */
    public void setPrecoCompra(String precoCompra) {
        this.precoCompra = precoCompra;
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
    public String getQuatidadeProduto() {
        return quatidadeProduto;
    }

    /**
     * @param quatidadeProduto the quatidadeProduto to set
     */
    public void setQuatidadeProduto(String quatidadeProduto) {
        this.quatidadeProduto = quatidadeProduto;
    }

    /**
     * @return the dataExpiracao
     */
    public String getDataExpiracao() {
        return dataExpiracao;
    }

    /**
     * @param dataExpiracao the dataExpiracao to set
     */
    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

   
}
