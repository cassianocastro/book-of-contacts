package model;

/**
 *
 */
public class Phone
{

    private int ddd;
    private String number;

    public Phone(int ddd, String number)
    {
        this.ddd    = ddd;
        this.number = number;
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
}