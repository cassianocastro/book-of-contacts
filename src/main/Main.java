package main;

import controll.HomeControll;
import model.dao.ConnectionSingleton;
import java.sql.*;
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
            HomeControll c        = new HomeControll(connection);
        }
		catch ( SQLException e )
        {
            throw new RuntimeException(e);
        }
    }
}