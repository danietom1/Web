package co.edu.poli.parcial1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NombrePais")
public class Name {

    //private String ISO;
    @Id
    private String common;
    private String official;

    @OneToOne(mappedBy = "name")
    @JsonIgnore
    private Pais pais;


    public Name() {
    }

    public Name(String common, String official, Pais pais) {
        this.common = common;
        this.official = official;
        this.pais = pais;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
