package co.edu.poli.parcial1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "Continente")
public class Continente {
    @Id
    private String Nombre;

    private int CantidadPaises;

    @OneToMany(mappedBy = "continente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pais> pais;

    public Continente() {
    }

    public Continente(String nombre, int cantidadPaises, Set<Pais> pais) {
        Nombre = nombre;
        CantidadPaises = cantidadPaises;
        this.pais = pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Set<Pais> getPais() {
        return pais;
    }

    public void setPais(Set<Pais> pais) {
        this.pais = pais;
    }

    public int getCantidadPaises() {
        return CantidadPaises;
    }

    public void setCantidadPaises(int cantidadPaises) {
        CantidadPaises = cantidadPaises;
    }
}
