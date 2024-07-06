import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Metro Stations
public class Main {
    public static void main(String[] args) {
        // input from user
        ArrayList<String> line2Stations = new ArrayList<String>();
        line2Stations.add("");
        line2Stations.add("Shubra");
        line2Stations.add("Koleyet El Zeraat");
        line2Stations.add("El Mazallat");
        line2Stations.add("El Khalafawi");
        line2Stations.add("St. Teresa");
        line2Stations.add("Rod El Farag");
        line2Stations.add("Massara");
        line2Stations.add("Al-Shohadaa");
        line2Stations.add("Attaba");
        line2Stations.add("M. Naguib");
        line2Stations.add("Sadat");
        line2Stations.add("Opera");
        line2Stations.add("Dokki");
        line2Stations.add("El Bohoos");
        line2Stations.add("Cairo University");
        line2Stations.add("Faisal");
        line2Stations.add("Guiza");
        line2Stations.add("Omm el Misryeen");
        line2Stations.add("Sakiat Mekki");
        line2Stations.add("El Monib");
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your start station:");
            String startStation = iScanner.nextLine();
            System.out.println("Enter your end station:");
            String endStation = iScanner.nextLine();
            if (line2Stations.contains(startStation) && line2Stations.contains(endStation)) {
                // Calculate the number of stations, expected time
                byte startIndex = (byte) line2Stations.indexOf(startStation);
                byte endIndex = (byte) line2Stations.indexOf(endStation);
                byte numberOfStations = (byte) Math.abs(endIndex - startIndex);
                byte expectedTime = (byte) (numberOfStations * 2);

                // Calculate the direction
                String direction = "";
                if (startIndex > endIndex) {
                    Collections.reverse(line2Stations);
                    startIndex = (byte) line2Stations.indexOf(startStation);
                    endIndex = (byte) line2Stations.indexOf(endStation);
                    direction = "Shubra";
                } else {
                    direction = "El Monib";
                }
                // Calculate the route, ticket price
                ArrayList<String> route = new ArrayList<String>(line2Stations.subList(startIndex, endIndex + 1));
                byte ticketPrice = 0;
                if (numberOfStations < 10) {
                    ticketPrice = 6;
                } else {
                    ticketPrice = 8;
                }
                // Output
                System.out.println("Number of stations: " + numberOfStations);
                if (expectedTime >= 60) {
                    byte expectedTimeInHours = (byte) (expectedTime / 60);
                    byte expectedTimeInMinutes = (byte) (expectedTime % 60);
                    System.out.println("Expected time: " + expectedTimeInHours + " hours and " + expectedTimeInMinutes + " minutes");
                } else {
                    System.out.println("Expected time: " + expectedTime + " minutes");
                }
                System.out.println("Ticket price: " + ticketPrice + " EGP");
                System.out.println("Route: " + route);
                System.out.println("Direction: " + direction);
                break;
            } else {
                System.out.println("Invalid stations");
            }
        }
    }
}
