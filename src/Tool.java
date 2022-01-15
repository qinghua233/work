import java.sql.*;
import java.util.ResourceBundle;

public class Tool {
    private Tool(){}

    private static ResourceBundle bundle= ResourceBundle.getBundle("resources/db");

    static {
        try {
            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接对象
    public static Connection getConnection() throws SQLException {
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        Connection cnn = null;
        cnn = DriverManager.getConnection(url,user,password);
        return cnn;
    }
    public static void close(Connection cnn, Statement stm,ResultSet rst){
        if(cnn!=null) {
            try {
                cnn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stm!=null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rst!=null) {
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
