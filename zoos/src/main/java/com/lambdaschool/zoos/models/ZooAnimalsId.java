package com.lambdaschool.zoos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZooAnimalsId implements Serializable
{
    /**
     * The id of the zoo
     */
    private long zoo;

    /**
     * The id of the animal
     */
    private long animal;

    /**
     * The default constructor required by JPA
     */
    public ZooAnimalsId()
    {
    }

    /**
     * Getter for the zoo id
     *
     * @return long the zoo id
     */
    public long getZoo()
    {
        return zoo;
    }

    /**
     * Setter for the zoo id
     *
     * @param zoo the new zoo id for this object
     */
    public void setZoo(long zoo)
    {
        this.zoo = zoo;
    }

    /**
     * Getter for the animal id
     *
     * @return long the animal id
     */
    public long getAnimal()
    {
        return animal;
    }

    /**
     * The setter for the animal id
     *
     * @param animal the new animal id for this object
     */
    public void setAnimal(long animal)
    {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        // boolean temp = (o.getClass() instanceof Class);
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ZooAnimalsId that = (ZooAnimalsId) o;
        return zoo == that.zoo &&
            animal == that.animal;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
