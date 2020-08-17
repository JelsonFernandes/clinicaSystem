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
public class ModeloTabelaEnfermeiro {

    private String txtid;
    private String txt_nome;
    private String Nascimento;
    private String txt_morada;
    private String txt_bi;
    private String txt_fone;
    private String txt_carteira;

    public ModeloTabelaEnfermeiro(String txtid, String txt_nome, String Nascimento, String txt_morada, String txt_bi, String txt_fone, String txt_carteira) {
        this.txtid = txtid;
        this.txt_nome = txt_nome;
        this.Nascimento = Nascimento;
        this.txt_morada = txt_morada;
        this.txt_bi = txt_bi;
        this.txt_fone = txt_fone;
        this.txt_carteira = txt_carteira;
    }

    /**
     * @return the txtid
     */
    public String getTxtid() {
        return txtid;
    }

    /**
     * @param txtid the txtid to set
     */
    public void setTxtid(String txtid) {
        this.txtid = txtid;
    }

    /**
     * @return the txt_nome
     */
    public String getTxt_nome() {
        return txt_nome;
    }

    /**
     * @param txt_nome the txt_nome to set
     */
    public void setTxt_nome(String txt_nome) {
        this.txt_nome = txt_nome;
    }

    /**
     * @return the Nascimento
     */
    public String getNascimento() {
        return Nascimento;
    }

    /**
     * @param Nascimento the Nascimento to set
     */
    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    /**
     * @return the txt_morada
     */
    public String getTxt_morada() {
        return txt_morada;
    }

    /**
     * @param txt_morada the txt_morada to set
     */
    public void setTxt_morada(String txt_morada) {
        this.txt_morada = txt_morada;
    }

    /**
     * @return the txt_bi
     */
    public String getTxt_bi() {
        return txt_bi;
    }

    /**
     * @param txt_bi the txt_bi to set
     */
    public void setTxt_bi(String txt_bi) {
        this.txt_bi = txt_bi;
    }

    /**
     * @return the txt_fone
     */
    public String getTxt_fone() {
        return txt_fone;
    }

    /**
     * @param txt_fone the txt_fone to set
     */
    public void setTxt_fone(String txt_fone) {
        this.txt_fone = txt_fone;
    }

    /**
     * @return the txt_carteira
     */
    public String getTxt_carteira() {
        return txt_carteira;
    }

    /**
     * @param txt_carteira the txt_carteira to set
     */
    public void setTxt_carteira(String txt_carteira) {
        this.txt_carteira = txt_carteira;
    }

    
}
