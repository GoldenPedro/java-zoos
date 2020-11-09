package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The entity allowing interaction with the zoos table
 */
@Entity
@Table(name = "zoos")
public class Zoo extends Auditable
{
    /**
     * Primary key (logn) for this zoo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    /**
     * Name (String) of this zoo. Cannot be null and must be unique
     */
    @Column(nullable = true,
        unique = true)
    private String zooname;

    /**
     * List of telephone numbers associated with this zoo. Does not get saved in the database directly.
     * Forms a one to many relationship with telephone. One zoo to many telephone numbers.
     */
    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    /**
     * Part of the join relationship between zoo and animal
     * connects zoos to a zoo animal combination
     */
    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo",
        allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    /**
     * Getter for primary key of this zoo
     *
     * @return the primary key (long) for this zoo
     */
    public long getZooid()
    {
        return zooid;
    }

    /**
     * Setter for the primary key of this zoo
     *
     * @param zooid the new primary key (long) for this zoo
     */
    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    /**
     * Getter for the name of this zoo
     *
     * @return The name (String) of this zoo
     */
    public String getZooname()
    {
        return zooname;
    }

    /**
     * Setter for the name of this zoo
     *
     * @param zooname the new name (String) for this zoo
     */
    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    /**
     * Getter for the list of telephone numbers of this zoo
     *
     * @return the list of telephones (list(Telephone)) for this user
     */
    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    /**
     * Setter for the list of telephone numbers for this zoo
     *
     * @param telephones the new list of telephone numbers (list(Telephone)) for this zoo
     */
    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }

    /**
     * Getter for the zoo animal combinations for this zoo
     *
     * @return A list of zoo animal combinations for this zoo
     */
    public Set<ZooAnimals> getAnimals()
    {
        return animals;
    }

    /**
     * Setter for the zoo animal combinations for this zoo
     *
     * @param animals A new list of user role combinations associated with zoo
     */
    public void setAnimals(Set<ZooAnimals> animals)
    {
        this.animals = animals;
    }
}
