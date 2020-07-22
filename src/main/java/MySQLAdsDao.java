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
                        rs.getLong("id"),
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
    public Long insert(Ad ad) throws SQLException {
        long lastInsertedId = 0;
        String query = String.format(
                "INSERT INTO ads (user_id, title, description) VALUES ('%d', '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generateKeys = statement.getGeneratedKeys();
            if (generateKeys.next()) {
                lastInsertedId = generateKeys.getLong(1);
            }
        return lastInsertedId;
    }

    public static void main(String[] args) throws SQLException {
//        Ads adsDao = new MySQLAdsDao(new Config());
//        Ad newAd = new Ad(2, "test title", "test description");
//        System.out.println(adsDao.insert(newAd));
    }
}
