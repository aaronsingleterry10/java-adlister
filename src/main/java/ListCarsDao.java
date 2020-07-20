import java.util.ArrayList;
import java.util.List;

public class ListCarsDao implements Cars {
    private List<Car> cars;
    @Override
    public List<Car> all() {
        if (cars == null) {
            cars = generateCars();
        }
        return cars;
    }

    private List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new CarModel(1, "Ford", "F150", 2017, "XLT", 8, true));
        cars.add(new CarModel(2, "Chevy", "Silverado", 2009, "LT", 8, true));
        cars.add(new CarModel(3, "Cadillac", "XT5", 2017, "Luxury", 6, false));
        return cars;
    }
}
