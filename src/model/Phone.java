package model;

/**
 *
 */
public class Phone
{

    private int id, personID;
    private String phone;

    public Phone(int id, String phone, int personID)
    {
        this.id       = id;
        this.phone    = phone;
        this.personID = personID;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
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
