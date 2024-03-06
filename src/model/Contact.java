package model;

import java.util.Date;

/**
 *
 */
public class Contact
{

    private int id;
    private String name, nacionality;
    private char sex;
    private Date birthdate;

    public Contact(int id, String name, char sex, Date birthdate, String nacionality)
    {
        this.id          = id;
        this.name        = name;
        this.sex         = sex;
        this.birthdate   = birthdate;
        this.nacionality = nacionality;
    }

    public int getID()
    {
        return this.id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public char getSex()
    {
        return this.sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public Date getBirthdate()
    {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }

    public String getNacionality()
    {
        return this.nacionality;
    }

    public void setNacionality(String nacionality)
    {
        this.nacionality = nacionality;
    }
}