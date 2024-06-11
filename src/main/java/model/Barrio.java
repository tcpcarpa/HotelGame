package model;

import java.util.ArrayList;

public class Barrio {
    @JsonProperty
    private String name;

    @JsonProperty
    private ArrayList<Casa> casas;

    @JsonCreator
    public Barrio(@JsonProperty("name") final String name,
                  @JsonProperty("casas") final ArrayList<Casa> casas) {
        this.name = name;
        this.casas = casas;
    }

    public Barrio() {
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("casas")
    public ArrayList<Casa> getCasas() {
        return casas;
    }

    @JsonProperty("casas")
    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
}
