import java.util.ArrayList;

public class Line {
    private byte id;
    private static ArrayList<String> stations;

    // Getters and Setters
    public byte getId() {
        return id;
    }
    public void setId(byte id) {
        this.id = id;
    }

    public static ArrayList<String> getStations() {
        return stations;
    }

    public static void setStations(ArrayList<String> stations) {
        Line.stations = stations;
    }

    // Constructors
    public Line() {
    }
    public Line(byte id, ArrayList<String> stations) {
        this.id = id;
        Line.stations = stations;
    }


}
