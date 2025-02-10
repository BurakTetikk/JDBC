package query_01;

import java.sql.*;

public class Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1 - Driver yükle
        Class.forName("org.postgresql.Driver");

        // 2 - Bağlantı oluştur
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "postgres", "password");

        // 3 - Statement : SQL kodların yazılması için bir nesne oluştur
        Statement statement = connection.createStatement();

        // 4 - ResultSet
        ResultSet resultSet = statement.executeQuery("select * from students");

        // 5 - Sonuçları al
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
        }

    }
}
