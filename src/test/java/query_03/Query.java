package query_03;

import java.sql.*;

public class Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "postgres", "password");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select not_ortalamasi, cinsiyet, bolum from ogrenci_bilgiler order by not_ortalamasi, bolum");

        while (resultSet.next()){

            System.out.printf("%d %S %S\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

        }

        resultSet.close();
        statement.close();
        connection.close();


    }
}
