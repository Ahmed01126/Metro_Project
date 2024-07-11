import java.util.ArrayList;

public class Trip {
    private String startStation;
    private String endStation;
    private Line line;
    private byte startStationIndex = getStationIndex(startStation);
    private byte endStationIndex = getStationIndex(endStation);

    // Getters and Setters  
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    // Get the index of th station
    public byte getStationIndex(String station) {
        return (byte) this.getStations().indexOf(station);
    }

    // Calculate the number of stations between the start and end stations
    public byte getNumberOfStations() {
        return (byte) Math.abs(endStationIndex - startStationIndex);
    }

    // Calculate the expected time between the start and end stations (2 minutes per station)
    public byte getExpectedTime() {
        return (byte) (getNumberOfStations() * 2);
    }

    // Calculate the direction of the trip
    public String getDirection() {
        return startStationIndex > endStationIndex ? "Shubra" : "El Monib";
    }

    // Calculate the route of the trip
    public ArrayList<String> getRoute() {
        ArrayList<String> route = new ArrayList<String>(Line.getStations().subList(startStationIndex, endStationIndex + 1));
        return route;
    }

    // Calculate the ticket price of the trip
    public byte getTicketPrice() {
        byte ticketPrice = 0;
        if (getNumberOfStations() < 10) {
            ticketPrice = 6;
        } else {
            ticketPrice = 8;
        }
        return ticketPrice;
    }

    // Constructors
    public Trip() {

    }

    public Trip(String startStation, String endStation, Line line) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.line = line;
    }

}
