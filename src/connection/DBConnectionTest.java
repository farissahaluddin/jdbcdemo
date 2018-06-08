package connection;

import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    @Test
    public void getConnection() throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        System.out.println(connection.getMetaData());
    }
}