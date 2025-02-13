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

        System.out.println("=============================================================");

        resultSet = statement.executeQuery("select not_ortalamasi, cinsiyet, bolum from ogrenci_bilgiler order by not_ortalamasi, bolum");
        int counter = 0;
        while (resultSet.next()){
            counter++;
        }

        System.out.println("Counter: " + counter);

        ResultSetMetaData metaData = resultSet.getMetaData();

        System.out.println("=======================================================");

        System.out.println(metaData.getColumnCount());
        System.out.println(metaData.getColumnName(1));
        System.out.println(metaData.getColumnName(2));
        System.out.println(metaData.getColumnName(3));
        System.out.println(metaData.getColumnLabel(2));
        System.out.println(metaData.getColumnType(2));
        System.out.println(metaData.getColumnTypeName(2));
        System.out.println(metaData.isNullable(3));
        System.out.println("metaData = " + metaData); // org.postgresql.jdbc.PgResultSetMetaData@6356695f

        System.out.println(metaData.getTableName(1));// tablodaki herbir sütunun hangi tablodan geldiğini gösterir

        resultSet.close();
        statement.close();
        connection.close();


    }
}
