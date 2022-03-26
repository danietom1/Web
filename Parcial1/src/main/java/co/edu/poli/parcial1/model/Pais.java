package co.edu.poli.parcial1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pais")
public class Pais {

    @Id
    private String ISO;

    @OneToOne
    @JoinColumn(name = "nombre_id", unique=true)
    private Name name;

    @OneToOne
    @JoinColumn(name = "capital_id", unique=true)
    private Capital capital;

    @ManyToOne
    @JoinColumn(name = "contiente_id")
    private Continente continente;

    private int area;


    public Pais() {
    }

    public Pais(String ISO, Name name, Capital capital, Continente continente, int area) {
        this.ISO = ISO;
        this.name = name;
        this.capital = capital;
        this.continente = continente;
        this.area = area;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name nombrepais) {
        this.name = nombrepais;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

}
