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
        new ObjectOutputStream(
            new FileOutputStream("lib/config.json")
        )
		.writeObject(json);
    }

    public JSONObject read() throws IOException, ClassNotFoundException
    {
        return (JSONObject) new ObjectInputStream(
            new FileInputStream("lib/config.json")
        )
		.readObject();
    }
}