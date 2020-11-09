package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;

import java.util.ArrayList;

/**
 * The Service that works with the Zoo Model
 */
public interface ZooService
{
    /**
     * Returns a list of all the Zoos
     *
     * @return List of Zoos. If no zoos, empty list.
     */
    ArrayList<Zoo> findAll();

    /**
     * Returns the zoo with the given primary key.
     *
     * @param id The primary key (long) of the zoo you seek.
     * @return The given Zoo or throws an exception if not found.
     */
    Zoo findZooById(long id);

    /**
     * Given a complete zoo object, saves that zoo object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     *
     * @param zoo the zoo object to be saved
     * @return the saved zoo object including any automatically generated fields
     */
    Zoo save(Zoo zoo);

    /**
     * Updates the provided fields in the zoo record referenced by the primary key.
     * <p>
     * Regarding Animal Types and Telephone items, this process only allows replace those list completely. Deleting and editing those lists
     * is done through a separate endpoint.
     *
     * @param zoo just the user fields to be updated.
     * @return the complete zoo object that got updated
     */
    Zoo update(Zoo zoo);

    /**
     * Deletes the zoo record, it animal zoo combinations, and its telephone items from the database based off of the provided primary key
     *
     * @param id id The primary key (long) of the zoo you seek.
     */
    void delete(long id);
}
