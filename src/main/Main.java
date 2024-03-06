package main;

import java.sql.*;
import controller.HomeController;
import model.dao.ConnectionSingleton;
import model.ConfigDataBase;

/**
 *
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        try
        {
            ConfigDataBase config = new ConfigDataBase("localhost", "3306", "mysql", "agenda", "root", "");
            Connection connection = ConnectionSingleton.getInstance(config);

            new HomeController(connection);
        }
	catch ( SQLException e )
        {
            throw new RuntimeException(e);
        }
    }
}