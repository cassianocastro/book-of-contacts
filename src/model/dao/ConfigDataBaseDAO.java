package model.dao;

import java.io.*;
import org.json.JSONObject;

/**
 *
 */
public class ConfigDataBaseDAO
{

    public void write(JSONObject json) throws IOException
    {
        try (ObjectOutputStream output
            = new ObjectOutputStream(
                new FileOutputStream("lib/config.json")))
        {
            output.writeObject(json);
        } catch (IOException e)
        {
            throw new IOException(e);
        }
    }

    public JSONObject read() throws IOException
    {
        try (ObjectInputStream input
            = new ObjectInputStream(
                new FileInputStream("lib/config.json")))
        {
            return (JSONObject) input.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new IOException(e);
        }
    }

}
