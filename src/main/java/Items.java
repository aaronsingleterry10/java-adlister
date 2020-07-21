import java.util.List;

public interface Items {
    List<Item> listAll();
    long insert(Item item);
}
