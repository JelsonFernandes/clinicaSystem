/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Jelson Fernandes
 */
public class ModeloProdutos {

    private String codProduto;
    private String nomeProduto;
    private String quatidadeProduto;
    private String nomeFabricante;
    private String precoCompra;
    private String precoVenda;
    private String adicionarProduto;
    private String nomeFornecedor;
    private String dataFabrico;
    private String dataExpiracao;
    private String medida;

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
     * @return the adicionarProduto
     */
    public String getAdicionarProduto() {
        return adicionarProduto;
    }

    /**
     * @param adicionarProduto the adicionarProduto to set
     */
    public void setAdicionarProduto(String adicionarProduto) {
        this.adicionarProduto = adicionarProduto;
    }

    /**
     * @return the btnAdicionar
     */
   

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
     * @return the dataFabrico
     */
    public String getDataFabrico() {
        return dataFabrico;
    }

    /**
     * @param dataFabrico the dataFabrico to set
     */
    public void setDataFabrico(String dataFabrico) {
        this.dataFabrico = dataFabrico;
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

    /**
     * @return the medida
     */
    public String getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }

}
