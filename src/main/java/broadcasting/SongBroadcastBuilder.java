package broadcasting;

import java.io.Serializable;

public class SongBroadcastBuilder implements BroadcastBuilder, Serializable {
    private static final int TIME_OF_BROADCAST = 3600;
    private Song song;
    private Advertisement advertisement;
    private Interview interview;

    /**creating song object*/
    @Override
    public BroadcastBuilder chooseSong(String name, String author, int time) {
        //System.out.println("Song was created in broadcast");
        this.song = new Song(name, author, time);
        return this;
    }
    /**creating advertisement object*/
    @Override
    public BroadcastBuilder chooseAdd(String name, int time) {
        //System.out.println("Advertisement was created in broadcast");
        this.advertisement = new Advertisement(name, time);
        return this;
    }
    /**creating interview object*/
    @Override
    public BroadcastBuilder chooseInterview(String person, int time) {
        //System.out.println("Interview was created in broadcast");
        this.interview = new Interview(person, time);
        return this;
    }
    /**build broadcast*/
    @Override
    public Broadcast createBroadcast(String name) {
        Broadcast broadcast = new Broadcast(name, song, advertisement, interview);
        if (broadcast.getCurrentDuration() > TIME_OF_BROADCAST){
            System.out.println("Too big broadcast, can`t start streaming");
            return null;
        }
        if (advertisement.getTime() > TIME_OF_BROADCAST/4){
            System.out.println("Too much advertisements");
            return null;
        }
        if (advertisement.getTime() + interview.getTime() > song.getTime()){
            System.out.println("Too much paid content");
        } else{
            broadcast.getIncome();
            return broadcast;
        }
        return null;
    }

}
