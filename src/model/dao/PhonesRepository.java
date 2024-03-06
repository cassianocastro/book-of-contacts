package model.dao;

import model.Phone;
import java.sql.*;
import java.util.*;

/**
 *
 */
public class PhonesRepository
{

    private final Connection connection;

    public PhonesRepository(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(final Phone phone, final int contactID) throws SQLException
    {
        final String SQL = "INSERT INTO phone(ddd, number, personID) VALUES (?, ?, ?)";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());
            ps.setInt(3, contactID);

            ps.executeUpdate();
        }
    }

    public void update(final Phone phone, final int contactID) throws SQLException
    {
        final String SQL = "UPDATE phone SET ddd = ?, number = ? WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());
            ps.setInt(3, contactID);
            
            ps.executeUpdate();
        }
    }

    public void delete(final int contactID) throws SQLException
    {
        final String SQL = "DELETE FROM phone WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, contactID);

            ps.executeUpdate();
        }
    }

    public List<Phone> findByContact(final int contactID) throws SQLException
    {
        final String SQL = "SELECT ddd, number FROM phone WHERE personID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, contactID);

            var rs = ps.executeQuery();
            
            List list = new ArrayList();

            while ( rs.next() )
            {
                var ddd    = rs.getInt("ddd");
                var number = rs.getString("number");

                list.add(new Phone(ddd, number));
            }
            
            return list;
        }
    }
}