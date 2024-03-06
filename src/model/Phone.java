package model;

/**
 *
 */
public class Phone
{

    private int ddd, personID;
    private String number;

    public Phone(int ddd, String number, int personID)
    {
        this.ddd      = ddd;
        this.number   = number;
        this.personID = personID;
    }

    public int getDDD()
    {
        return this.ddd;
    }

    public void setDDD(int ddd)
    {
        this.ddd = ddd;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public int getPersonID()
    {
        return this.personID;
    }

    public void setPersonID(int personID)
    {
        this.personID = personID;
    }
}