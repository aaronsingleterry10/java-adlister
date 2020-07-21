import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLItemsDao implements Items {
    private Connection connection;

    public MySQLItemsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

    }

    @Override
    public List<Item> listAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            items.add(new Item(
                    rs.getString("name"),
                    rs.getInt("price_in_cents")
            ));
        }
        return items;
    }

    @Override
    public long insert(Item item) {
        long lastInsertId = 0;
        String query = String.format("INSERT INTO items (name, price_in_cents) VALUES ('%s', '%d')",
                item.getName(),
                item.getPriceInCents()
        );
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generateKeys = statement.getGeneratedKeys();
            if (generateKeys.next()) {
                lastInsertId = generateKeys.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastInsertId;
    }
}
