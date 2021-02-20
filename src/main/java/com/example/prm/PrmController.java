package com.example.prm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class PrmController {

    @Autowired
    private PrmRepository prmRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam Integer compteur
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
        // This returns a JSON or XML with the users
        return prmRepository.findAll();
    }

}