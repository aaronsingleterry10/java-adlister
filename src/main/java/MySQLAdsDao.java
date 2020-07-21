import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                        ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long lastInsertedId = 0;
        String query = String.format(
                "INSERT INTO ads (user_id, title, description) VALUES ('%d', '%s', '%s')",
                ad.getId(),
                ad.getTitle(),
                ad.getDescription()
        );
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generateKeys = statement.getGeneratedKeys();
            if (generateKeys.next()) {
                lastInsertedId = generateKeys.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastInsertedId;
    }
}
