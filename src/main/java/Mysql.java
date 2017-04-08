import java.sql.*;

public class Mysql {

    private static final String DB = "jdbc:mysql://5.135.218.27:3306/spring";
    private static final String USER = "oskar";
    private static final String USERPW = "akademiakodu";
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {



        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(DB, USER, USERPW);
            Statement statement = connection.createStatement();


//           ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
//           while(resultSet.next()) {
//                System.out.println("--------------------");
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getInt("id"));
//                System.out.println("--------------------");
//           }

            statement.execute("INSERT INTO user(username, password, role, gender)" +
                    " VALUES('oskarekasd5','mojetajnehaslo','admin','0')");
            statement.execute("INSERT INTO user(username, password, role, gender)" +
                    " VALUES('oskarekasd2','mojetajnehaslo','admin','0')");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Jeśli wyżej nie ma błędu, to znaczy, że jest połączenie");

    }
}