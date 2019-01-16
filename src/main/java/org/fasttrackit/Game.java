package org.fasttrackit;

public class Game {

    private Track[] tracks = new Track[10];

    public void addTrack(int index, Track track) {
        tracks[0] = new Track("Highway", 300);
        tracks[index] = track;
    }

    public void displayAvailableTracks(){
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
