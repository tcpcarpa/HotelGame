package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Inquilino {
    @JsonProperty("id")
    private int id;

    @JsonProperty("casa")
    private int casa;

    @JsonCreator
    public Inquilino(@JsonProperty("id") int id, @JsonProperty("casa") int casa) {
        this.id = id;
        this.casa = casa;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("casa")
    public int getCasa() {
        return casa;
    }

    @JsonProperty("casa")
    public void setCasa(int casa) {
        this.casa = casa;
    }
}



