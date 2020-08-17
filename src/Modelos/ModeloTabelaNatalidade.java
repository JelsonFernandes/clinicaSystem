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
public class ModeloTabelaNatalidade extends RecursiveTreeObject<ModeloTabelaNatalidade> {
   private StringProperty Id;
   private StringProperty Paciente;
   private StringProperty Recem_Nascido;
   private StringProperty Parteira;

    public ModeloTabelaNatalidade(String Id, String Paciente, String Recem_Nascido, String Parteira) {
        this.Id = new SimpleStringProperty(Id);
        this.Paciente = new SimpleStringProperty(Paciente);
        this.Recem_Nascido = new SimpleStringProperty(Recem_Nascido);
        this.Parteira = new SimpleStringProperty(Parteira);
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
     * @return the Paciente
     */
    public StringProperty getPaciente() {
        return Paciente;
    }

    /**
     * @param Paciente the Paciente to set
     */
    public void setPaciente(StringProperty Paciente) {
        this.Paciente = Paciente;
    }

    /**
     * @return the Recem_Nascido
     */
    public StringProperty getRecem_Nascido() {
        return Recem_Nascido;
    }

    /**
     * @param Recem_Nascido the Recem_Nascido to set
     */
    public void setRecem_Nascido(StringProperty Recem_Nascido) {
        this.Recem_Nascido = Recem_Nascido;
    }

    /**
     * @return the Parteira
     */
    public StringProperty getParteira() {
        return Parteira;
    }

    /**
     * @param Parteira the Parteira to set
     */
    public void setParteira(StringProperty Parteira) {
        this.Parteira = Parteira;
    }

   
}
