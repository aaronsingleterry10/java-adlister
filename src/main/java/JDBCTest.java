import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    private static List<String> getEmployeeFirstNames() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
                "root",
                "codeup"
        );
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM employees LIMIT 10";
        ResultSet rs = statement.executeQuery(query);
        List<String> firstNames = new ArrayList<>();
        while (rs.next()) {
            firstNames.add(rs.getString("first_name"));
        }
        return firstNames;
    }
    private static List<String> getEmployeeFirstNames(int numOfNames) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
                "root",
                "codeup"
        );
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM employees LIMIT 10";
        ResultSet rs = statement.executeQuery(query);
        List<String> firstNames = new ArrayList<>();
        for(int i = 1; i <= numOfNames; i++) {
            rs.next();
            firstNames.add(rs.getString("first_name"));
        }
        return firstNames;
    }

    public static void main(String[] args) throws SQLException {

        System.out.println(getEmployeeFirstNames());
        System.out.println(getEmployeeFirstNames(5));
        System.out.println(getEmployeeFirstNames(2));
    }
}
