package model;


import java.util.ArrayList;

public class Casa {

    @JsonProperty("id")
    private int id;

    @JsonProperty("barrio")
    private String barrio;

    @JsonProperty("inquilinos")
    private ArrayList<Inquilino> inquilinos;

    @JsonCreator
    public Casa(@JsonProperty("id") final int id,
                @JsonProperty("barrio") final String barrio,
                @JsonProperty("inquilinos") final ArrayList<Inquilino> inquilinos) {
        this.id = id;
        this.barrio = barrio;
        this.inquilinos = inquilinos;
    }

    public Casa() {
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("barrio")
    public String getBarrio() {
        return barrio;
    }

    @JsonProperty("barrio")
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @JsonProperty("inquilinos")
    public ArrayList<Inquilino> getInquilinos() {
        return inquilinos;
    }

    @JsonProperty("inquilinos")
    public void setInquilinos(ArrayList<Inquilino> inquilinos) {
        this.inquilinos = inquilinos;
    }
}