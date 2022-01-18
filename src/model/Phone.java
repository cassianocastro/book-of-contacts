package model;

/**
 *
 * @author cesar
 */
public class Phone {

    private int id, personID;
    private String phone;

    public Phone(int id, String phone, int personID) {
        this.id = id;
        this.phone = phone;
        this.personID = personID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

}
