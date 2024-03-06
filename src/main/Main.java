package main;

import java.sql.*;
import model.dao.ConnectionSingleton;
import model.DBConfig;

/**
 *
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    static public void main(String args[])
    {
        DBConfig config = new DBConfig("localhost", "3306", "mysql", "agenda", "root", "");
        
        try ( Connection connection = ConnectionSingleton.getInstance(config) )
        {
            new controller.HomeController(connection);
        }
	catch ( SQLException e )
        {
            throw new RuntimeException(e);
        }
    }
}