package com.altran.solution.controller;

import com.altran.solution.model.ResultsDTO;
import com.altran.solution.service.AjuntamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjuntamentController {

    private final AjuntamentService service;

    @Autowired
    public AjuntamentController(AjuntamentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/result/{language}", method = RequestMethod.GET)
    public ResponseEntity<ResultsDTO> get(@PathVariable String language) {
        ResultsDTO results = service.getResults(language);

        if (results == null) {
            throw new RuntimeException("No results found!");
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ResponseEntity<ResultsDTO> get() {
        ResultsDTO results = service.getResults("ca");

        if (results == null) {
            throw new RuntimeException("No results found!");
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
