/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jelson Fernandes
 */
public class ModeloTabelaMorte extends RecursiveTreeObject< ModeloTabelaMorte> {

    private StringProperty Id;
    private StringProperty Nome;
    private StringProperty Data;

    public ModeloTabelaMorte(String Id, String Nome, String Data) {
        this.Id = new SimpleStringProperty(Id);
        this.Nome = new SimpleStringProperty(Nome);
        this.Data = new SimpleStringProperty(Data);
    }

    /**
     * @return the Id
     */
    public StringProperty getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(StringProperty Id) {
        this.Id = Id;
    }

    /**
     * @return the Nome
     */
    public StringProperty getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(StringProperty Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Data
     */
    public StringProperty getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(StringProperty Data) {
        this.Data = Data;
    }

   

}
