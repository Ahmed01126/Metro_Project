import java.util.ArrayList;

public class Line {
    private byte id;
    private ArrayList<String> stations;

    // Getters and Setters
    public byte getId() {
        return id;
    }
    public void setId(byte id) {
        this.id = id;
    }

    public  ArrayList<String> getStations() {
        return stations;
    }

    public void setStations(ArrayList<String> stations) {
        this.stations = stations;
    }

    // Constructors
    public Line() {
    }
    public Line(byte id, ArrayList<String> stations) {
        this.id = id;
        this.stations = stations;
    }


}
