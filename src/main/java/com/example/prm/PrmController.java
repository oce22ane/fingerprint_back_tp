package com.example.prm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PrmController {

    @Autowired
    private PrmRepository prmRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPrm (@RequestParam Integer compteur
            , @RequestParam String cc, @RequestParam Date date, @RequestParam String fingerprint ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        prm p = new prm();
        p.setCompteur(compteur);
        p.setCc(cc);
        p.setDate(date);
        p.setFingerprint(fingerprint);
        prmRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<prm> getAllPrm() {
        return prmRepository.findAll();
    }

    @GetMapping(path="/nbVisite")
    public @ResponseBody
    long getCountPrm() {
        return prmRepository.count();
    }

    @GetMapping(path="/nbCollisionH")
    public @ResponseBody
    long getCountCollisionH() {
        List<Integer> listNb = prmRepository.findNbCollision();
        int nb =0;
        for( int value : listNb ) {
            nb = nb + value;
        }
        return nb;
    }


    @GetMapping(path="/nbdiff")
    public @ResponseBody
    long getCountDiff() {
        List<Integer> listNb = prmRepository.findNbDiff();
        int nb =0;
        for( int value : listNb ) {
            nb = nb + value;
        }
        return nb;
    }

    @GetMapping(path="/nbVraiCollision")
    public @ResponseBody
    long getCountVraiCollision() {
        List<Integer> listNb = prmRepository.findNbVraiCollision();
        int nb =0;
        for( int value : listNb ) {
            nb = nb + value;
        }
        return nb;
    }
}