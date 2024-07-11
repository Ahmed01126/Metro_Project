import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Metro Stations

public class Main {
    public static void calcIndex(ArrayList<String> lineStations, String startStation, String endStation){
        byte startIndex = (byte) lineStations.indexOf(startStation);
        byte endIndex = (byte) lineStations.indexOf(endStation);
        if (startIndex > endIndex) {
            Collections.reverse(lineStations);
            startIndex = (byte) lineStations.indexOf(startStation);
            endIndex = (byte) lineStations.indexOf(endStation);
        }
    }
    public static void printResult(ArrayList<String>lineStations, String startStation, String endStation){
        // Calculate the start and end index
        byte startIndex , endIndex;
        calcIndex(lineStations, startStation, endStation);
    
        // Calculate the direction
        String direction = "";
        direction = lineStations.get(endIndex);
    
        // Calculate the route
        ArrayList<String> route = new ArrayList<String>(lineStations.subList(startIndex, endIndex + 1));
    
        // Calculate the ticket price
        byte numberOfStations = (byte) Math.abs(endIndex - startIndex);
        byte ticketPrice = 0;
        if (numberOfStations < 10) {
            ticketPrice = 5;
        } else {
            ticketPrice = 7;
        }
    
        // Calculate the expected time
        short expectedTime = (short) (numberOfStations * 2);
    
        // Output
        System.out.println("Number of stations: " + numberOfStations);
        if (expectedTime >= 60) {
            byte expectedTimeInHours = (byte) (expectedTime / 60);
            byte expectedTimeInMinutes = (byte) (expectedTime % 60);
            System.out.println(
                    "Expected time: " + expectedTimeInHours + " hours and " + expectedTimeInMinutes + " minutes");
        } else {
            System.out.println("Expected time: " + expectedTime + " minutes");
        }
        System.out.println("Ticket price: " + ticketPrice + " EGP");
        System.out.println("Route: " + route);
        System.out.println("Direction: " + direction);
        return;
    }
    public static void main(String[] args) {
        // input from user
        ArrayList<String> line1Stations = new ArrayList<String>();
        Collections.addAll(line1Stations, "","Helwan", "Ain Helwan", "Helwan University",
        "Wadi Hof", "Hadayek Helwan", "El-Maasara", "Tora El-Asmant", "Kolet El-Maadi",
        "Tora El-Balad", "Sakanat El-Maadi", "Maadi", "Hadayek El-Maadi", "Dar El-Salam",
        "Zahraa El-Maadi", "Mar Girgis", "El-Malek El-Saleh", "Sayeda Zeinab", "Saad Zaghloul",
        "Sadat", "Nasser", "Orabi", "Al-Shohadaa", "Ghamra", "El-Demerdash", "Manshiet El-Sadr",
        "Kobri El-Qobba", "Hammamat El-Qobba", "Saray El-Qobba", "Hadayek El-Zaitoun",
        "Helmeyet El-Zaitoun", "El-Matareyya", "Ain Shams", "Ezbet El-Nakhl", "El-Marg",
        "New El-Marg");

        ArrayList<String> line2Stations = new ArrayList<String>();
        Collections.addAll(line2Stations, "","Shubra El-Kheima", "Kolleyet El-Zeraa",
        "El-Mazallat", "El-Khalafawi", "Saint Teresa", "Rod El-Farag", "Massara", "Al-Shohadaa",
        "Attaba", "Mohamed Naguib", "Sadat", "Opera", "Dokki", "El Bohoth", "Cairo University",
        "Fayoum", "Giza","Omm El-Misryeen", "Sakiat Mekki", "El-Mounib");

        Scanner iScanner = new Scanner(System.in);

        boolean check = false;
        while (!check) {
            check = true;
            System.out.println("Enter your start station:");
            String startStation = iScanner.nextLine();
            System.out.println("Enter your end station:");
            String endStation = iScanner.nextLine();
            if(startStation.equals(endStation)){
                System.out.println("You are in the same station!");
            } 
            else if(line1Stations.contains(startStation) && line1Stations.contains(endStation)){
                printResult(line1Stations, startStation, endStation);
            }
            else if (line2Stations.contains(startStation) && line2Stations.contains(endStation)) {
                printResult(line2Stations, startStation, endStation);
            }
            else if(line1Stations.contains(startStation) && line2Stations.contains(endStation)){
                printResult(line1Stations, startStation, endStation);
            }
            else if (line2Stations.contains(startStation) && line1Stations.contains(endStation)) {
                printResult(line2Stations, startStation, endStation);
            }
            else {
                System.out.println("Invalid stations");
                check = false;
            }
        }
    }
}
