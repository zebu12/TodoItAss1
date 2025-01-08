package se.lexicon.db;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {

    static Properties properties =new Properties();

    private static String url;
    private static String password;
    private static String username;

    static {
        try (
                Reader in =  Files.newBufferedReader(Path.of("src/main/resources/database.properties"), StandardCharsets.UTF_8);
        )
        {
            properties.load(in);
            System.out.println("File Read ...");

        }catch (IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Reading properties ...");
        url = properties.getProperty("jdbc.url");
        password = properties.getProperty("jdbc.password");
        username = properties.getProperty("jdbc.username");
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;

    }


}
