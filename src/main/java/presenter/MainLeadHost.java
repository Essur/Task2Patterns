package presenter;

import broadcasting.Broadcast;
import broadcasting.BroadcastBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainLeadHost extends LeadHost {
    private static final List<String> broadcastList = new ArrayList<>();
    private String name;
    private String experience;

    public MainLeadHost(BroadcastBuilder broadcastBuilder,String name, String experience) {
        this.broadcastBuilder = broadcastBuilder;
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getExperience() {
        return experience;
    }

    public void setBroadcastList(String name){
        broadcastList.add(name);
    }
    @Override
    public String toString() {
        return "MainLeadHost{" +
                "name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                ", broadcasts='" + broadcastList + '\'' +
                '}';
    }
}
