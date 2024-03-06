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
        List list  = new ArrayList();
        String SQL = "SELECT * FROM telefone";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                int id       = rs.getInt("ID_contato");
                int personID = rs.getInt("ID_Pessoa");
                String phone = rs.getString("Fone");

                list.add(new Phone(id, phone, personID));
            }
        }

        return list;
    }

    public List<Phone> findByID(int codigo) throws SQLException
    {
        List list  = new ArrayList();
        String SQL = "SELECT ddd, number FROM phone WHERE personID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
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

    public void create(Phone phone) throws SQLException
    {
        String SQL = "INSERT INTO phone(ddd, number, personID) VALUES (?, ?, ?)";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());
            ps.setInt(3, phone.getPersonID());

            ps.executeUpdate();
        }
    }

    public void update(Phone phone) throws SQLException
    {
        String SQL = "UPDATE phone SET ddd = ?, number = ? WHERE personID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, phone.getDDD());
            ps.setString(2, phone.getNumber());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException
    {
        String SQL = "DELETE FROM phone WHERE personID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

    public Phone search(int index) throws SQLException
    {
        String SQL = "SELECT ddd, number FROM phone WHERE personID = ?";

        try ( PreparedStatement ps = this.connection.prepareStatement(SQL) )
        {
            ps.setInt(1, index);

            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                int id       = rs.getInt("ID_contato");
                int personID = rs.getInt("ID_Pessoa");
                String phone = rs.getString("Fone");

                return new Phone(id, phone, personID);
            }

            return null;
        }
    }
}