package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

/**
 * Implements the ZooService
 */
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    /**
     * Connects this service to the ZooRepository
     */
    @Autowired
    private ZooRepository zoorepos;

    /**
     * Connects this service to the AnimalRepository
     */
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id)
    {
        return zoorepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " not found!"));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo)
    {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0)
        {
            Zoo oldZoo = zoorepos.findById(zoo.getZooid())
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zoo.getZooid() + " not found!"));

            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname());

        newZoo.getAnimals()
            .clear();
        for (ZooAnimals za : zoo.getAnimals())
        {
            Animal newAnimal = animalrepos.findById(za.getAnimal()
                .getAnimalid())
                .orElseThrow(() -> new EntityNotFoundException("Animal id " + za.getAnimal()
                    .getAnimalid()));

            newZoo.getAnimals()
                .add(new ZooAnimals(newZoo,
                    newAnimal,
                    za.getIncomingzoo()));
        }

        // work with telephone list
        newZoo.getTelephones()
            .clear();
        for (Telephone t : zoo.getTelephones())

        {
            newZoo.getTelephones()
                .add(new Telephone(t.getPhonetype(),
                    t.getPhonenumber(),
                    newZoo));
        }

        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo)
    {
        Zoo currentZoo = zoorepos.findById(zoo.getZooid())
            .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zoo.getZooid() + " not found!"));

        if (zoo.getZooname() != null)
        {
            currentZoo.setZooname(zoo.getZooname());
        }

        if (zoo.getAnimals()
            .size() > 0)
        {
            for (ZooAnimals za : zoo.getAnimals())
            {
                Animal newAnimal = animalrepos.findById(za.getAnimal()
                    .getAnimalid())
                    .orElseThrow(() -> new EntityNotFoundException("Animal id " + za.getAnimal()
                        .getAnimalid()));

                currentZoo.getAnimals()
                    .add(new ZooAnimals(currentZoo,
                        newAnimal,
                        za.getIncomingzoo()));
            }
        }

        if (zoo.getTelephones()
            .size() > 0)
        {
            currentZoo.getAnimals()
                .clear();
            // adds new phone numbers to list
            for (Telephone t : zoo.getTelephones())
            {
                currentZoo.getTelephones()
                    .add(new Telephone(t.getPhonetype(),
                        t.getPhonenumber(),
                        currentZoo));
            }
        }

        return zoorepos.save(currentZoo);
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (zoorepos.findById(id)
            .isPresent())
        {
            zoorepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Zoo id " + id + " not found!");
        }
    }

}
