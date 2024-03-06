package model.dao;

import model.Contact;
import java.sql.*;
import java.util.*;

/**
 *
 */
public class PeopleRepository
{

    private final Connection connection;

    public PeopleRepository(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(final Contact contact) throws SQLException
    {
        final String SQL = "INSERT INTO person(name, sex, birthdate, nacionality) VALUES (?, ?, ?, ?)";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setString(1, contact.getName());
            ps.setString(2, Character.toString(contact.getSex()));
            ps.setDate(3, new java.sql.Date(contact.getBirthdate().getTime()));
            ps.setString(4, contact.getNacionality());

            ps.executeUpdate();
        }
    }

    public void update(final Contact contact) throws SQLException
    {
        final String SQL = "UPDATE person SET name = ?, sex = ?, birthdate = ?, nacionality = ? WHERE ID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setString(1, contact.getName());
            ps.setString(2, Character.toString(contact.getSex()));
            ps.setDate(3, new java.sql.Date(contact.getBirthdate().getTime()));
            ps.setString(4, contact.getNacionality());
            ps.setInt(5, contact.getID());

            ps.executeUpdate();
        }
    }

    public void delete(final int id) throws SQLException
    {
        final String SQL = "DELETE FROM person WHERE ID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }
    
    public List getAll() throws SQLException
    {
        final String SQL = "SELECT ID, name, sex, birthdate, nacionality FROM person ORDER BY name";

        try (
            var ps = this.connection.prepareStatement(SQL);
            var rs = ps.executeQuery()
	)
        {
            List list = new ArrayList();
            
            while ( rs.next() )
            {
                var id          = rs.getInt("ID");
                var name        = rs.getString("name");
                var sex         = rs.getString("sex").charAt(0);
                var date        = rs.getDate("birthdate");
                var nacionality = rs.getString("nacionality");

                list.add(new Contact(id, name, sex, date, nacionality));
            }
            
            return list;
        }
    }
    
    public Contact findByID(final int id) throws SQLException
    {
        final String SQL = "SELECT name, sex, birthdate, nacionality FROM person WHERE ID = ?";

        try ( var ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            var rs = ps.executeQuery();

            while ( rs.next() )
            {
                var name = rs.getString("name");
                var sex  = rs.getString("sex").charAt(0);
                var date = rs.getDate("birthdate");
                var nacionality = rs.getString("nacionality");

                return new Contact(id, name, sex, date, nacionality);
            }

            return null;
        }
    }
}