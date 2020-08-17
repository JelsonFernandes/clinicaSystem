/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javafx.scene.control.TableColumn;

/**
 *
 * @author Jelson Fernandes
 */
public class ModeloTabelaAtendimento {

    private String Id;
    private String Nome;
    private String DataAgenda;
    private String DataConsulta;

    public ModeloTabelaAtendimento(String Id, String Nome, String DataAgenda, String DataConsulta, String Medico) {
        this.Id = Id;
        this.Nome = Nome;
        this.DataAgenda = DataAgenda;
        this.DataConsulta = DataConsulta;
        this.Medico = Medico;
    }
    private String Medico;

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the DataAgenda
     */
    public String getDataAgenda() {
        return DataAgenda;
    }

    /**
     * @param DataAgenda the DataAgenda to set
     */
    public void setDataAgenda(String DataAgenda) {
        this.DataAgenda = DataAgenda;
    }

    /**
     * @return the DataConsulta
     */
    public String getDataConsulta() {
        return DataConsulta;
    }

    /**
     * @param DataConsulta the DataConsulta to set
     */
    public void setDataConsulta(String DataConsulta) {
        this.DataConsulta = DataConsulta;
    }

    /**
     * @return the Medico
     */
    public String getMedico() {
        return Medico;
    }

    /**
     * @param Medico the Medico to set
     */
    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

}
