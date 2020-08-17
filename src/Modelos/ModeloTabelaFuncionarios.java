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
public class ModeloTabelaFuncionarios {

    private String IdFunc;
    private String NomeFunc;
    private String Telefone;
    private String Email;
    private String NumDoc;
    private String Funcao;
    private String Salario;

    public ModeloTabelaFuncionarios(String IdFunc, String NomeFunc, String Telefone, String Email, String NumDoc, String Funcao, String Salario) {
        this.IdFunc = IdFunc;
        this.NomeFunc = NomeFunc;
        this.Telefone = Telefone;
        this.Email = Email;
        this.NumDoc = NumDoc;
        this.Funcao = Funcao;
        this.Salario = Salario;
    }

    /**
     * @return the IdFunc
     */
    public String getIdFunc() {
        return IdFunc;
    }

    /**
     * @param IdFunc the IdFunc to set
     */
    public void setIdFunc(String IdFunc) {
        this.IdFunc = IdFunc;
    }

    /**
     * @return the NomeFunc
     */
    public String getNomeFunc() {
        return NomeFunc;
    }

    /**
     * @param NomeFunc the NomeFunc to set
     */
    public void setNomeFunc(String NomeFunc) {
        this.NomeFunc = NomeFunc;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the NumDoc
     */
    public String getNumDoc() {
        return NumDoc;
    }

    /**
     * @param NumDoc the NumDoc to set
     */
    public void setNumDoc(String NumDoc) {
        this.NumDoc = NumDoc;
    }

    /**
     * @return the Funcao
     */
    public String getFuncao() {
        return Funcao;
    }

    /**
     * @param Funcao the Funcao to set
     */
    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    /**
     * @return the Salario
     */
    public String getSalario() {
        return Salario;
    }

    /**
     * @param Salario the Salario to set
     */
    public void setSalario(String Salario) {
        this.Salario = Salario;
    }

}
