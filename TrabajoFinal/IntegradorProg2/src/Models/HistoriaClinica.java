/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Asus
 */
public class HistoriaClinica extends Base {
       private String nroHistoria;
       private GrupoSanguineo grupoSanguineo;
       private String antecedentes;
       private String medicacionActual;
       private String observaciones;
       
       private Paciente paciente;
       
       public HistoriaClinica(){}
       
       public HistoriaClinica(int id,boolean eliminado,String nroHistoria,GrupoSanguineo grupoSanguineo,
               String antecedentes,String medicacionActual,String observaciones){
         super(id,eliminado);
         this.nroHistoria= nroHistoria;
         this.grupoSanguineo = grupoSanguineo;
         this.antecedentes = antecedentes;
         this.medicacionActual = medicacionActual;
         this.observaciones = observaciones;
         this.paciente = paciente;
         
       
       }

    public String getNroHistoria() {return nroHistoria;}

    public void setNroHistoria(String nroHistoria) {
        this.nroHistoria = nroHistoria;
    }

    public GrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getMedicacionActual() {
        return medicacionActual;
    }

    public void setMedicacionActual(String medicacionActual) {
        this.medicacionActual = medicacionActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Paciente getPaciente() { return paciente; }

    public void setPaciente(Paciente paciente) {
    this.paciente = paciente; }
    
    
    
    
   @Override
    public String toString() {
        return "HistoriaClinica{" +
                "id=" + getId() +
                ", nroHistoria='" + nroHistoria + '\'' +
                ", grupoSanguineo=" + grupoSanguineo +
                ", antecedentes='" + antecedentes + '\'' +
                ", medicacionActual='" + medicacionActual + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", pacienteId=" + (paciente != null ? paciente.getId() : "null") +
                '}';
    }
}

