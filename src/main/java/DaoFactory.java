public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    private static Cars carsDao;

    public static Cars getCarsDao() {
        if (carsDao == null) {
            carsDao = new ListCarsDao();
        }
        return carsDao;
    }

}
