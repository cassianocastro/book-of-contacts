package model;

import java.util.Date;

public class Contact {

    private int id;
    private String name, nacionality;
    private char sex;
    private Date dateNasc;


    public Contact(int id, String name, char sex, Date dateNasc, String nacionality) {
        this.id          = id;
        this.name        = name;
        this.sex         = sex;
        this.dateNasc    = dateNasc;
        this.nacionality = nacionality;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDateNasc() {
        return dateNasc;
    }

    public void setDateNasc(Date dateNasc) {
        this.dateNasc = dateNasc;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

}
