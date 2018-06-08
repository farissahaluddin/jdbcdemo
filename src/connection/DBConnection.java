package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static volatile DBConnection instance = null;

    private Connection connection = null;

    private DBConnection()
    {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/demo?user=root&password=super");
            System.out.println("Connected database successfully...");
        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public  static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance ==null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


}
