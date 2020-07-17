import java.util.ArrayList;
import java.util.List;

public class ListInstrumentsDao implements Instruments {
    private List<Instrument> inst;

    public List<Instrument> all() {
        if (inst == null) {
            inst = generateInst();
        }
        return inst;
    }

    private List<Instrument> generateInst() {
        List<Instrument> inst = new ArrayList<>();

        inst.add(new Instrument(1, "Electric Guitar", "String Instrument", "Opens the gates of Rock"));

        inst.add(new Instrument(2, "Alto Sax", "Woodwinds", "Smooth things out.."));

        inst.add(new Instrument(3, "Trumpet", "Brass", "Jazz things up a bit.."));

        inst.add(new Instrument(4, "Drums", "Percussion", "Lays down the groove..."));

        return inst;
    }
}
