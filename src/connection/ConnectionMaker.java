package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by user on 2017-07-26.
 */
public class ConnectionMaker {
    private static Connection conn;

    public static Connection MakeConnection(){
        if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "1234");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return conn;
    }
}
