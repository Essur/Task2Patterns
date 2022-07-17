package broadcasting;

import java.io.*;
import java.util.List;

public class Broadcast implements Serializable {
    private static final int TIME_OF_BROADCAST = 3600;
    static final long serialVersionUID = 12345678912346L;
    private String name;
    protected int currentDuration;
    protected double income;
    private Song song;
    private Advertisement advertisement;
    private Interview interview;

    public String getName() {
        return name;
    }

    public Song getSong() {
        return song;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public Interview getInterview() {
        return interview;
    }

    public Broadcast(String name, Song song, Advertisement advertisement, Interview interview) {
        this.name = name;
        this.song = song;
        this.advertisement = advertisement;
        this.interview = interview;
    }


    @Override
    public String toString() {
        return name + '{' +
                    "income=" + income +
                    ", song=" + song +
                    ", advertisement=" + advertisement +
                    ", interview=" + interview +
                    '}';
    }
    public int getCurrentDuration(){
        return this.currentDuration = song.getTime() + advertisement.getTime() + interview.getTime();
    }

    public void getIncome(){
        this.income += advertisement.getCost() + interview.getCost();
    }

}
