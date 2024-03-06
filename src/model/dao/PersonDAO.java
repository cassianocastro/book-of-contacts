package model.dao;

import model.Contact;
import java.sql.*;
import java.util.*;

/**
 *
 */
public class PersonDAO
{

    private final Connection connection;

    public PersonDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void create(Contact contact) throws SQLException
    {
        String SQL = "INSERT INTO person(name, sex, birthdate, nacionality) VALUES (?, ?, ?, ?)";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setString(1, contact.getName());
            ps.setString(2, Character.toString(contact.getSex()));
            ps.setDate(3, new java.sql.Date(contact.getBirthdate().getTime()));
            ps.setString(4, contact.getNacionality());

            ps.executeUpdate();
        }
    }

    public void update(Contact contact) throws SQLException
    {
        String SQL = "UPDATE person SET name = ?, sex = ?, birthdate = ?, nacionality = ? WHERE ID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setString(1, contact.getName());
            ps.setString(2, Character.toString(contact.getSex()));
            ps.setDate(3, new java.sql.Date(contact.getBirthdate().getTime()));
            ps.setString(4, contact.getNacionality());
            ps.setInt(5, contact.getID());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException
    {
        String SQL = "DELETE FROM person WHERE ID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }
    
    public List read() throws SQLException
    {
        List list  = new ArrayList();
        String SQL = "SELECT ID, name, sex, birthdate, nacionality FROM person ORDER BY name";

        try (
            PreparedStatement ps = this.connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery()
	)
        {
            while ( rs.next() )
            {
                int id              = rs.getInt("ID");
                String name         = rs.getString("name");
                String nacionality  = rs.getString("nacionality");
                char sex            = rs.getString("sex").charAt(0);
                java.util.Date date = rs.getDate("birthdate");

                list.add(new Contact(id, name, sex, date, nacionality));
            }
        }

        return list;
    }
    
    public Contact findByID(int id) throws SQLException
    {
        String SQL = "SELECT name, sex, birthdate, nacionality FROM person WHERE ID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                String name = rs.getString("name");
                String nacionality = rs.getString("nacionality");
                char sex = rs.getString("sex").charAt(0);
                java.util.Date date = rs.getDate("birthdate");

                return new Contact(id, name, sex, date, nacionality);
            }

            return null;
        }
    }
}