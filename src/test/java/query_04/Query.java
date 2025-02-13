package query_04;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    @Test
    public void createTable() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "create table teachers (id int, name varchar(20), branch varchar(10))";
        statement.execute(sql);

    }


    @Test
    public void deleteTable() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "drop table teachers";
        statement.execute(sql);

    }


    @Test
    public void alterTable() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "alter table teachers add lastname varchar(20), add age int";
        statement.execute(sql);
    }

    @Test
    public void renameColumn() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "alter table teachers rename column branch to title";
        statement.execute(sql);
    }

    @Test
    public void renameTable() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "alter table teachers rename to tbl_teachers";
        statement.execute(sql);
    }

    @Test
    public void alterColumnType() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/school",
                "postgres",
                "password");

        Statement statement = connection.createStatement();

        String sql = "alter table tbl_teachers alter column age type varchar(3)";
        statement.execute(sql);
    }
}
