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

    public int getId()
    {
        return this.ddd;
    }

    public void setId(int ddd)
    {
        this.ddd = ddd;
    }

    public String getPhone()
    {
        return this.number;
    }

    public void setPhone(String number)
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