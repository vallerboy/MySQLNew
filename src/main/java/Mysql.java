import java.sql.*;

public class Mysql {

    private static final String DB = "jdbc:mysql://5.135.218.27:3306/spring?useUnicode=true&characterEncoding=UTF-8";
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

            addUser(connection, "Oski", "mojehaselko");
            addUser(connection, "oskix", "mojehaselko1");

//          ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
//           while(resultSet.next()) {
//                System.out.println("--------------------");
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getInt("id"));
//                System.out.println("--------------------");
//           }
//            resultSet.close();

//            statement.execute("INSERT INTO user(username, password, role, gender)" +
//                    " VALUES('oskarekasd5','mojetajnehaslo','admin','0')");
//            statement.execute("INSERT INTO user(username, password, role, gender)" +
//                    " VALUES('oskarekasd2','mojetajnehaslo','admin','0')");
            //  statement.executeUpdate("UPDATE user SET username = 'oskar' WHERE id = 23");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Jeśli wyżej nie ma błędu, to znaczy, że jest połączenie");

    }

    public static void addUser(Connection connection, String name, String password) throws SQLException {

        String sql = "INSERT INTO user(username, password, gender, role) VALUES(?, ?, '0', 'ADMIN')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, password);

        statement.execute();

        statement.close();

        System.out.println("Dodałem użytkownika!");
    }
}