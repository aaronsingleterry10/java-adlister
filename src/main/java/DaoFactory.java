import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;
    private static Items itemsDao;

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config());
        }
        return adsDao;
    }

    public static Items getItemsDao() throws SQLException {
        if (itemsDao == null) {
            itemsDao = new MySQLItemsDao(new Config());
        }
        return itemsDao;
    }
}
