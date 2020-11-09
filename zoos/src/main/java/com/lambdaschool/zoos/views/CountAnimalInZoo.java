package com.lambdaschool.zoos.views;

/**
 * Used to format the JSON for a custom query that gathers information on animal type and id and how many zoos have such animals
 */
public interface CountAnimalInZoo
{
    /**
     * The primary key of the animal type
     *
     * @return the animal id (long)
     */
    long getAnimalid();

    /**
     * The type of animal being counted
     *
     * @return Animal Type (String)
     */
    String getAnimaltype();

    /**
     * The count of the zoos where the animal type lives
     *
     * @return The count (int) of zoos housing the animal type
     */
    int getCountzoos();
}
