package org.fasttrackit;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[10];
    private List<Vehicle> competitors = new ArrayList<>();


    public void start() throws Exception {
        addCompetitors(2);
        displayCompetitors();
        addTrack(0, new Track("1.Highway", 300));
        addTrack(1, new Track("2.Seaside", 100));
        displayAvailableTracks();


        int trackNumber = getTrackNumberFromUser();
        Track track = tracks[trackNumber - 1];
        System.out.println("Chosen track:" + track.getName());

        boolean noWinnerYet = true;
        int competitorsWithoutFuel = 0;

        while (noWinnerYet && competitorsWithoutFuel < competitors.size()) {
            for (Vehicle vehicle : competitors) {
                double speed = getVehicleAccelerationFromUser();
                vehicle.accelerate(speed);

                if(vehicle.getFuelLevel() <= 0) {
                    competitorsWithoutFuel++;
                }

                if (vehicle.getTotalKm() >= track.getLength()) {
                    noWinnerYet = false;
                    System.out.println("The winner is:" + vehicle.getName());
                    break; // intrerupe bucla for ; continue; --> face skip la iteratie
                }
            }
        }

    }

    private int getTrackNumberFromUser() throws Exception {
        System.out.println("Please choose one of the available tracks:");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception)  {
//            throw new Exception("Expected an integer number.");
            System.out.println("Expected an integer number");
            return getTrackNumberFromUser();
        }
    }
//    public Track getTrackFromUser() {
//        System.out.println("Please choose your track: ");
//        Scanner scanner = new Scanner(System.in);
//        int chooseTrackNumber = scanner.nextInt();
//        if (chooseTrackNumber == 1) {
//            System.out.println("Your track number is: " + tracks[0]);
//            return tracks[0];
//        } else if (chooseTrackNumber == 2) {
//            System.out.println("Your track number is: " + tracks[1]);
//            return tracks[1];
//
//        } else {
//            return null;
//        }
//
//    }


    public void addCompetitors(int competitorCount) {
        for (int i = 0; i < competitorCount; i++) {
            Vehicle vehicle = new Vehicle();

            String name = getVehicleNameFromUser();
            vehicle.setName(name);

            double mileage = ThreadLocalRandom.current().nextDouble(5, 15);
            vehicle.setMileage(mileage);
            System.out.println("Your mileage is:" + mileage);

            // vehicle details will be populated when we learn to get user's input
            competitors.add(vehicle); // to add an element to the list

        }
    }


    private String getVehicleNameFromUser() {
        System.out.println("Please enter vehicle name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Your vehicle name is: " + name);
        return name;

    }

    private double getVehicleAccelerationFromUser() {
        System.out.println("Please enter acceleration speed:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();


    }


    public void displayCompetitors() {
        System.out.println("Welcome! Race is starting with:");
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i) != null)
                System.out.println(competitors.get(i).getName());
        }
    }


    public void addTrack(int index, Track track) {
        tracks[0] = new Track("Highway", 300);
        tracks[index] = track;
    }

    public void displayAvailableTracks() {
        System.out.println("Available tracks:");

        //classic for loop
//        for (int i = 0; i < tracks.length; i++) {
//            if (tracks[i] != null) {
//                System.out.println(tracks[i].getName());
//            }
//        }
        // enhanced for loop (for-each)
        for (Track track : tracks) {
            if (track != null) {
                System.out.println(track.getName());
            }
        }
    }

}
