package presenter;

import broadcasting.Broadcast;
import broadcasting.BroadcastBuilder;

import java.io.Serializable;
import java.util.Collection;

public  class LeadHost implements Serializable{
    protected BroadcastBuilder broadcastBuilder;
    public Broadcast createBroadcast(String songName, String songAuthor, int songTime, String productName, int addTime, String person, int interviewTime, String name){
        return broadcastBuilder.chooseSong(songName, songAuthor, songTime).chooseAdd(productName, addTime).chooseInterview(person, interviewTime).createBroadcast(name);
    }

}
