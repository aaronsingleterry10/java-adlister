import java.sql.SQLException;
import java.util.List;

public interface Items {
    List<Item> listAll() throws SQLException;
    long insert(Item item);
}
