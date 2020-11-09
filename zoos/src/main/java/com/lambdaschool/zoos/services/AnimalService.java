package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.views.CountAnimalInZoo;

import java.util.ArrayList;

/**
 * The service that works with the Animal Model
 */
public interface AnimalService
{
    /**
     * Listing of each animal and the number of zoos where it is located
     *
     * @return List of animal id, animal type, count of the number zoos who host the animal
     */
    ArrayList<CountAnimalInZoo> getCountAnimalInZoo();
}
