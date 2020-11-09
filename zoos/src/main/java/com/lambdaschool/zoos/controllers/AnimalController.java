package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The entry point for clients to work primary with animal type data
 */
@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{
    /**
     * Using the Animal service to process Animal data
     */
    @Autowired
    private AnimalService animalService;

    /**
     * Finds the animal and the number of zoos where they are located
     * <br>Example: <a href="http://localhost:2019/animals/count">"http://localhost:2019/animals/count"</a>
     *
     * @return JSON List of all animals, their names and ids, with the number of zoos where they are located
     * @see AnimalService#getCountAnimalInZoo() AnimalService.getCountAnimalInZoo()
     */
    @GetMapping(value = "/count",
        produces = {"application/json"})
    public ResponseEntity<?> getNumZoosAnimalsIn()
    {
        return new ResponseEntity<>(animalService.getCountAnimalInZoo(),
            HttpStatus.OK);
    }
}
