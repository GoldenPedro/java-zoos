package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.views.CountAnimalInZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Implements the AnimalService Interface
 */
@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    /**
     * Connects this service to the Animal Repository
     */
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<CountAnimalInZoo> getCountAnimalInZoo()
    {
        return animalrepos.getCountAnimalInZoo();
    }
}
