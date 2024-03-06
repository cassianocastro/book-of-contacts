package model.dao;

import model.Phone;
import java.sql.*;
import java.util.*;

/**
 *
 */
public class PhoneDAO
{

    private final Connection connection;

    public PhoneDAO(Connection connection)
    {
        this.connection = connection;
    }

    public List read() throws SQLException
    {
        List list = new ArrayList();
        final String SQL = "SELECT ddd, number, personID FROM phone";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                int ddd       = rs.getInt("ddd");
                String number = rs.getString("number");
                int personID  = rs.getInt("personID");

                list.add(new Phone(ddd, number, personID));
            }
        }

        return list;
    }

    public List<Phone> findByID(int codigo) throws SQLException
    {
        List list  = new ArrayList();
        final String SQL = "SELECT ddd, number FROM phone WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                int ddd = rs.getInt("ddd");
                String number = rs.getString("number");

                list.add(new Phone(ddd, number, codigo));
            }
        }

        return list;
    }

    public void create(final Phone phone) throws SQLException
    {
        final String SQL = "INSERT INTO phone(ddd, number, personID) VALUES (?, ?, ?)";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());
            ps.setInt(3, phone.getPersonID());

            ps.executeUpdate();
        }
    }

    public void update(final Phone phone) throws SQLException
    {
        final String SQL = "UPDATE phone SET ddd = ?, number = ? WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());
//            ps.setInt(3, personID);
            
            ps.executeUpdate();
        }
    }

    public void delete(final int id) throws SQLException
    {
        final String SQL = "DELETE FROM phone WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

    public Phone search(final int index) throws SQLException
    {
        final String SQL = "SELECT ddd, number FROM phone WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, index);

            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                int ddd       = rs.getInt("ddd");
                String number = rs.getString("number");

                return new Phone(ddd, number, index);
            }

            return null;
        }
    }
}