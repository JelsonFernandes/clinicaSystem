/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.InputStream;
import org.bson.types.Binary;

/**
 *
 * @author Jelson Fernandes
 */
public class ModeloEmpresa {

    private Binary FotoEmpresa;
    private String IdEmpresa;
    private String NomeEmpresa;
    private String NifEmpresa;
    private String RepresentanteEmpresa;
    private String EndeEmpres;
    private String NumFuncEmpresa;
    private String TelefoneEmpresa;
    private String EmaiEmpresa;
    private String WebEmpresa;
    private String Caminho;
    private InputStream Foto;

    /**
     * @return the FotoEmpresa
     */
    public Binary getFotoEmpresa() {
        return FotoEmpresa;
    }

    /**
     * @param FotoEmpresa the FotoEmpresa to set
     */
    public void setFotoEmpresa(Binary FotoEmpresa) {
        this.FotoEmpresa = FotoEmpresa;
    }

    /**
     * @return the IdEmpresa
     */
    public String getIdEmpresa() {
        return IdEmpresa;
    }

    /**
     * @param IdEmpresa the IdEmpresa to set
     */
    public void setIdEmpresa(String IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    /**
     * @return the NomeEmpresa
     */
    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    /**
     * @param NomeEmpresa the NomeEmpresa to set
     */
    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }

    /**
     * @return the NifEmpresa
     */
    public String getNifEmpresa() {
        return NifEmpresa;
    }

    /**
     * @param NifEmpresa the NifEmpresa to set
     */
    public void setNifEmpresa(String NifEmpresa) {
        this.NifEmpresa = NifEmpresa;
    }

    /**
     * @return the RepresentanteEmpresa
     */
    public String getRepresentanteEmpresa() {
        return RepresentanteEmpresa;
    }

    /**
     * @param RepresentanteEmpresa the RepresentanteEmpresa to set
     */
    public void setRepresentanteEmpresa(String RepresentanteEmpresa) {
        this.RepresentanteEmpresa = RepresentanteEmpresa;
    }

    /**
     * @return the EndeEmpres
     */
    public String getEndeEmpres() {
        return EndeEmpres;
    }

    /**
     * @param EndeEmpres the EndeEmpres to set
     */
    public void setEndeEmpres(String EndeEmpres) {
        this.EndeEmpres = EndeEmpres;
    }

    /**
     * @return the NumFuncEmpresa
     */
    public String getNumFuncEmpresa() {
        return NumFuncEmpresa;
    }

    /**
     * @param NumFuncEmpresa the NumFuncEmpresa to set
     */
    public void setNumFuncEmpresa(String NumFuncEmpresa) {
        this.NumFuncEmpresa = NumFuncEmpresa;
    }

    /**
     * @return the TelefoneEmpresa
     */
    public String getTelefoneEmpresa() {
        return TelefoneEmpresa;
    }

    /**
     * @param TelefoneEmpresa the TelefoneEmpresa to set
     */
    public void setTelefoneEmpresa(String TelefoneEmpresa) {
        this.TelefoneEmpresa = TelefoneEmpresa;
    }

    /**
     * @return the EmaiEmpresa
     */
    public String getEmaiEmpresa() {
        return EmaiEmpresa;
    }

    /**
     * @param EmaiEmpresa the EmaiEmpresa to set
     */
    public void setEmaiEmpresa(String EmaiEmpresa) {
        this.EmaiEmpresa = EmaiEmpresa;
    }

    /**
     * @return the WebEmpresa
     */
    public String getWebEmpresa() {
        return WebEmpresa;
    }

    /**
     * @param WebEmpresa the WebEmpresa to set
     */
    public void setWebEmpresa(String WebEmpresa) {
        this.WebEmpresa = WebEmpresa;
    }

    /**
     * @return the Caminho
     */
    public String getCaminho() {
        return Caminho;
    }

    /**
     * @param Caminho the Caminho to set
     */
    public void setCaminho(String Caminho) {
        this.Caminho = Caminho;
    }

    /**
     * @return the Foto
     */
    public InputStream getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(InputStream Foto) {
        this.Foto = Foto;
    }

    

}
