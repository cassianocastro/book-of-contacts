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
            new FileOutputStream("src/lib/config.json")
        )
		.writeObject(json);
    }

    public JSONObject read() throws IOException, ClassNotFoundException
    {
        return (JSONObject) new ObjectInputStream(
            new FileInputStream("src/lib/config.json")
        )
		.readObject();
    }
}