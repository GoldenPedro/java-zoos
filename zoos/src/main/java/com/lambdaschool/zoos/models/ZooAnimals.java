package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The entity allowing interaction with the zooanimals table.
 * The join table between zoo and animals
 */
@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable
{
    /**
     * Foreign key into the zoo table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    /**
     * Foreign key into the animal table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    String incomingzoo;

    /**
     * Default constructor used primarily by the JPA.
     */
    public ZooAnimals()
    {
    }

    /**
     * Given the params, create a new zoo animal combination
     *
     * @param zoo         The zoo object of the zoo animal combination
     * @param animal      The animal object of the zoo animal combination
     * @param incomingzoo The zoo object of the zoo where the animal is coming from.
     */
    public ZooAnimals(
        Zoo zoo,
        Animal animal,
        String incomingzoo)
    {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = incomingzoo;
    }

    /**
     * Given the params, create a new zoo animal combination
     *
     * @param zoo    The zoo object of the zoo animal combination
     * @param animal The animal object of the zoo animal combination
     *               incomingzoo is set to null
     */
    public ZooAnimals(
        Zoo zoo,
        Animal animal)
    {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = null;
    }

    /**
     * The getter for zoo
     *
     * @return the complete zoo object of this zoo animal combination
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    /**
     * The setter for zoo
     *
     * @param zoo change the zoo object associated with this zoo animal combination to this one.
     */
    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    /**
     * The getter for animal
     *
     * @return the complete animal object of this zoo animal combination
     */
    public Animal getAnimal()
    {
        return animal;
    }

    /**
     * The setter for animal
     *
     * @param animal change the animal object associated with this zoo animal combination to this one.
     */
    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    /**
     * The getter for originating zoo
     *
     * @return The complete zoo object where this animal at this zoo originated
     */
    public String getIncomingzoo()
    {
        return incomingzoo;
    }

    /**
     * the setter for originating zoo
     *
     * @param incomingzoo change the zoo where this animal at this zoo come from
     */
    public void setIncomingzoo(String incomingzoo)
    {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ZooAnimals that = (ZooAnimals) o;
        return ((this.zoo == null) ? 0 : this.zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
            ((this.animal == null) ? 0 : this.animal.getAnimalid()) == ((that.animal == null) ? 0 : that.animal.getAnimalid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
