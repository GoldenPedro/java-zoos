package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Entity allowing interaction with the animals table
 */
@Entity
@Table(name = "animals")
public class Animal extends Auditable
{
    /**
     * The primary key (long) of the animals table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    /**
     * The name or type of the animal (String)
     */
    @Column(nullable = false,
        unique = true)
    private String animaltype;

    /**
     * Part of the join relationship between animals and zoos
     * connects animals to the zoo animal combination
     */
    @OneToMany(mappedBy = "animal",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal",
        allowSetters = true)
    private Set<ZooAnimals> zoos = new HashSet<>();

    /**
     * Default constructor used primarily by the JPA.
     */
    public Animal()
    {
    }

    /**
     * Getter for the Animal Id
     *
     * @return the animal id, primary key, (long) of this animal
     */
    public long getAnimalid()
    {
        return animalid;
    }

    /**
     * Setter for animal id
     *
     * @param animalid the new primary key (long) for this animal
     */
    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    /**
     * Getter for animal type
     *
     * @return the animal type (String) of this animal
     */
    public String getAnimaltype()
    {
        return animaltype;
    }

    /**
     * Setter for animal type
     *
     * @param animaltype the new animal type (String) for this animal
     */
    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    /**
     * Getter for zoos associated with this animal
     *
     * @return list of animal zoo combinations associated with this animal
     */
    public Set<ZooAnimals> getZoos()
    {
        return zoos;
    }

    /**
     * Setter for animal zoo combinations associated with this animal
     *
     * @param zoos the new complete list of animal zoo combinations to be associated with this animal
     */
    public void setZoos(Set<ZooAnimals> zoos)
    {
        this.zoos = zoos;
    }
}
