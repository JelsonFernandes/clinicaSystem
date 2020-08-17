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
public class ModeloTabelaFornecedor {

    private String codEmpresa;
    private String nomeEmpresa;
    private String emailEmpresa;
    private String foneEmpresa;
    private String endeEmpresa;
    private String produtoEmpresa;
    private String webEmpresa;

    public ModeloTabelaFornecedor(String codEmpresa, String nomeEmpresa, String emailEmpresa, String foneEmpresa, String endeEmpresa, String produtoEmpresa, String webEmpresa) {
        this.codEmpresa = codEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.foneEmpresa = foneEmpresa;
        this.endeEmpresa = endeEmpresa;
        this.produtoEmpresa = produtoEmpresa;
        this.webEmpresa = webEmpresa;
    }

    /**
     * @return the codEmpresa
     */
    public String getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * @param codEmpresa the codEmpresa to set
     */
    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * @return the emailEmpresa
     */
    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    /**
     * @param emailEmpresa the emailEmpresa to set
     */
    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    /**
     * @return the foneEmpresa
     */
    public String getFoneEmpresa() {
        return foneEmpresa;
    }

    /**
     * @param foneEmpresa the foneEmpresa to set
     */
    public void setFoneEmpresa(String foneEmpresa) {
        this.foneEmpresa = foneEmpresa;
    }

    /**
     * @return the endeEmpresa
     */
    public String getEndeEmpresa() {
        return endeEmpresa;
    }

    /**
     * @param endeEmpresa the endeEmpresa to set
     */
    public void setEndeEmpresa(String endeEmpresa) {
        this.endeEmpresa = endeEmpresa;
    }

    /**
     * @return the produtoEmpresa
     */
    public String getProdutoEmpresa() {
        return produtoEmpresa;
    }

    /**
     * @param produtoEmpresa the produtoEmpresa to set
     */
    public void setProdutoEmpresa(String produtoEmpresa) {
        this.produtoEmpresa = produtoEmpresa;
    }

    /**
     * @return the webEmpresa
     */
    public String getWebEmpresa() {
        return webEmpresa;
    }

    /**
     * @param webEmpresa the webEmpresa to set
     */
    public void setWebEmpresa(String webEmpresa) {
        this.webEmpresa = webEmpresa;
    }

}
