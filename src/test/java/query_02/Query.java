package query_02;

import java.sql.*;

public class Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 - Driver oluştur
        Class.forName("org.postgresql.Driver");

        // 2 - Bağlantı oluştur
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "postgres", "password");

        // 3 - Statement oluşturma
        Statement statement = connection.createStatement();

        // 4 - SQL Query oluşturma

        ResultSet resultSet = statement.executeQuery("select * from students where gender = 'K'");

        while (resultSet.next()) {
            System.out.printf("%S %S\n", resultSet.getString("student_name"), resultSet.getString("gender"));
        }


        resultSet.close();
        statement.close();
        connection.close();

    }
}
