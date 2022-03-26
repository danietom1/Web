package co.edu.poli.parcial1.controller;

import co.edu.poli.parcial1.model.Continente;
import co.edu.poli.parcial1.repository.ContinenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1")
public class ContinenteController {

    @Autowired
    private ContinenteRepository continenteRepository;

    @GetMapping("/continente")
    public List<Continente> getPersonas() {
        return continenteRepository.findAll();
    }

    @GetMapping("/continente/{idContinente}")
    public Continente getPersona(@PathVariable String idContinente) {
        Continente a = continenteRepository.getById(idContinente);
        return a;
    }

    @PostMapping("/continente")
    public Continente savePersona(@RequestBody Continente persona) {
        continenteRepository.save(persona);
        return persona;
    }

    @PostMapping("/continentes")
    public String savePersona(@RequestBody List<Continente> personasList) {
        continenteRepository.saveAll(personasList);
        return "done";
    }

    @PutMapping("/continente/{idContinente}")
    public Continente putPersona(@PathVariable String idContinente, @RequestBody Continente continente) {

        Continente a = continenteRepository.getById(idContinente);

        a.setNombre(continente.getNombre());
        a.setCantidadPaises(continente.getCantidadPaises());

        continenteRepository.save(a);
        return a;
    }

    @DeleteMapping("/continente/{idContinente}")
    public Continente delPersona(@PathVariable String idContinente) {
        Continente a = continenteRepository.getById(idContinente);
        continenteRepository.deleteById(idContinente);
        return a;
    }
}
