package co.edu.poli.parcial1.controller;

import co.edu.poli.parcial1.model.Capital;
import co.edu.poli.parcial1.model.Continente;
import co.edu.poli.parcial1.model.Name;
import co.edu.poli.parcial1.model.Pais;
import co.edu.poli.parcial1.repository.CapitalRepository;
import co.edu.poli.parcial1.repository.ContinenteRepository;
import co.edu.poli.parcial1.repository.NombrePaisRepository;
import co.edu.poli.parcial1.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ContinenteRepository continenteRepository;

    @Autowired
    private CapitalRepository capitalRepository;

    @Autowired
    private NombrePaisRepository nombrepaisRepository;

    @GetMapping("/pais")
    public List<Pais> getPersonas() {
        return paisRepository.findAll();
    }

    @GetMapping("/pais/{idPais}")
    public Pais getPersona(@PathVariable String idPais) {
        Pais a = paisRepository.getById(idPais);
        return a;
    }

    @PostMapping("/pais")
    public Pais savePersona(@RequestBody Pais pais) {
        paisRepository.save(pais);
        return pais;
    }

    @PostMapping("/paises")
    public String savePersona(@RequestBody List<Pais> paisList) {

        for (Pais a:paisList
             ) {
            if (a.getName()!=null){
                nombrepaisRepository.save(a.getName());
            }
            if (a.getCapital()!=null){
                capitalRepository.save(a.getCapital());
            }
            paisRepository.save(a);
        }


        return "done";
    }

    @PutMapping("/pais/{idPais}")
    public Pais putPersona(@PathVariable String idPais, @RequestBody Pais pais) {

        Pais a = paisRepository.getById(idPais);

        a.setName(pais.getName());
        a.setArea(pais.getArea());

        paisRepository.save(a);
        return a;
    }

    @DeleteMapping("/pais/{idPais}")
    public Pais delPersona(@PathVariable String idPais) {
        Pais a = paisRepository.getById(idPais);
        paisRepository.deleteById(idPais);
        return a;
    }

    @PutMapping("/pais/{idPais}/{idNombrePais}/{idContinente}/{idCapital}")
    public Pais associate(@PathVariable String idPais, @PathVariable String idNombrePais, @PathVariable String idContinente, @PathVariable String idCapital) {

        Pais pais = paisRepository.findById(idPais).get();
        Name nombrepais = nombrepaisRepository.findById(idNombrePais).get();
        Continente continente = continenteRepository.findById(idContinente).get();
        Capital capital =  capitalRepository.findById(idCapital).get();

        pais.setName(nombrepais);
        pais.setCapital(capital);
        continente.getPais().add(pais);

        paisRepository.save(pais);
        return pais;
    }

    @PutMapping("/pais/{idPais}/{idContinente}")
    public Pais associate2(@PathVariable String idPais, @PathVariable String idContinente) {

        Pais pais = paisRepository.findById(idPais).get();
        Continente continente = continenteRepository.findById(idContinente).get();

        continente.getPais().add(pais);
        pais.setContinente(continente);

        paisRepository.save(pais);
        return pais;
    }

    @GetMapping("/paisq1/{Continente}/{Valor1}/{Valor2}")
    public List<Pais> getQuery1 (@PathVariable String Continente, @PathVariable int Valor1, @PathVariable int Valor2) {
        return paisRepository.filterPais1(Continente,Valor1,Valor2);
    }

    @GetMapping("/paisq2/{Pais}")
    public List<String> getQuery2 (@PathVariable String Pais) {
        return paisRepository.filterPais2(Pais);
    }
}
