package model;

import java.io.Serializable;
import org.json.JSONObject;

/**
 *
 */
final public class ConfigDataBase implements Serializable
{

    private final String host, port, dbName, dataBase, userName, password;

    public ConfigDataBase(String host, String port, String dbName,
            String dataBase, String userName, String password)
    {
        this.host     = host;
        this.port     = port;
        this.dbName   = dbName;
        this.dataBase = dataBase;
        this.userName = userName;
        this.password = password;
    }

    public ConfigDataBase(JSONObject json)
    {
        this.host     = json.getString("host");
        this.port     = json.getString("port");
        this.dbName   = json.getString("dbName");
        this.dataBase = json.getString("dataBase");
        this.userName = json.getString("userName");
        this.password = json.getString("password");
    }

    public JSONObject toJSON()
    {
        JSONObject json = new JSONObject();

        json.put("host",     this.host);
        json.put("port",     this.port);
        json.put("dbName",   this.dbName);
        json.put("dataBase", this.dataBase);
        json.put("userName", this.userName);
        json.put("password", this.password);

        return json;
    }

    public String getHost()
    {
        return this.host;
    }

    public String getPort()
    {
        return this.port;
    }

    public String getDBname()
    {
        return this.dbName;
    }

    public String getDataBase()
    {
        return this.dataBase;
    }

    public String getUser()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getURL()
    {
        return "jdbc:"  + this.dbName
                + "://" + this.host
                + ":"   + this.port
                + "/"   + this.dataBase;
    }
}