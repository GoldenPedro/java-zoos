package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * The entity allowing interaction with the telephones table
 */
@Entity
@Table(name = "telephones")
public class Telephone extends Auditable
{
    /**
     * The primary key (long) of the telephones table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    /**
     * The type of this phone number (String)
     * or enumerated type of TelephoneType (Stretch goal)
     */
    @Column(nullable = false)
    private String phonetype;

    /**
     * The telephone (String) in any format
     */
    @Column(nullable = false)
    private String phonenumber;

    /**
     * The zoo object (Zoo) of this telephone
     * <br>
     * Forms a Many to one relationship between telephone numbers and zoos.
     * A zoo has many telephone numbers!
     */
    @ManyToOne
    @JoinColumn(name = "zooid",
        nullable = false)
    @JsonIgnoreProperties(value = "telephones",
        allowSetters = true)
    private Zoo zoo;

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Telephone()
    {
    }

    /**
     * Given the phone type, telephone number, and zoo object
     *
     * @param phonetype   The type of this phone number (String) or enumerated type of TelephoneType (Stretch goal)
     * @param phonenumber The telephone (String) in any format
     * @param zoo         The zoo object (Zoo) of this telephone
     */
    public Telephone(
        String phonetype,
        String phonenumber,
        Zoo zoo)
    {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
        this.zoo = zoo;
    }

    /**
     * Getter for the phone id
     *
     * @return The primary key (long) for this telephone number
     */
    public long getPhoneid()
    {
        return phoneid;
    }

    /**
     * Setter for the phone id
     *
     * @param phoneid The new primary key (long) for this telephone number
     */
    public void setPhoneid(long phoneid)
    {
        this.phoneid = phoneid;
    }

    /**
     * Getter for the telephone number type
     *
     * @return The type of this phone number (String) or enumerated type of TelephoneType (Stretch goal)
     */
    public String getPhonetype()
    {
        return phonetype;
    }

    /**
     * Setter for the telephone type of this telephone number
     *
     * @param phonetype The new type of this phone number (String) or enumerated type of TelephoneType (Stretch goal)
     */
    public void setPhonetype(String phonetype)
    {
        this.phonetype = phonetype;
    }

    /**
     * the telephone number
     *
     * @return the telephone number (String) any format allowed
     */
    public String getPhonenumber()
    {
        return phonenumber;
    }

    /**
     * Setter for the telephone number
     *
     * @param phonenumber the new telephone number (String) any format allowed
     */
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    /**
     * Getter for zoo
     *
     * @return A full Zoo object of the zoo who is assigned this telephone number
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    /**
     * Setter for zoo
     *
     * @param zoo The new full Zoo object of the zoo to assigned to this telephone number
     */
    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }
}
