package co.edu.poli.parcial1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Capital")
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long population;
    private double density;

    @OneToOne(mappedBy = "capital")
    @JsonIgnore
    private Pais pais;

    public Capital() {
    }


    public Capital(int id, String name, long population, double density, Pais pais) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.density = density;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long poblacion) {
        this.population = poblacion;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double densidad) {
        this.density = densidad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
