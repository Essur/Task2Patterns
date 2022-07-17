package main;

import broadcasting.*;
import presenter.InvitedLeadHost;
import presenter.LeadHost;
import presenter.MainLeadHost;
import saver.SaveAndLoad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<LeadHost> leadHostList = new ArrayList<>();
    List<Broadcast> broadcastList = new ArrayList<>();
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        BroadcastBuilder broadcastBuilder = new SongBroadcastBuilder();
        LeadHost leadHost = new MainLeadHost(broadcastBuilder, "Oleg", "2 years");
        LeadHost invitedLeadHost = new InvitedLeadHost(broadcastBuilder, "Petr", "petr.pdf");
        leadHostList.add(leadHost);
        leadHostList.add(invitedLeadHost);
        Broadcast broadcast = leadHost.createBroadcast("Lo-fi","Lo-fi Girl",
                1800,"Sprite", 60,"Chris MiW", 1740, "Lo-fi time");
        if (broadcast != null && leadHost instanceof MainLeadHost) {
            broadcastList.add(broadcast);
            ((MainLeadHost) leadHost).setBroadcastList(broadcast.getName());
        }
        Broadcast broadcast2 = leadHost.createBroadcast("Immaculate misconception","MiW",
                1800,"Red-Bull", 60,"Corey Taylor", 1340, "Metal songs");
        if (broadcast2 != null && leadHost instanceof MainLeadHost) {
            broadcastList.add(broadcast2);
            ((MainLeadHost) leadHost).setBroadcastList(broadcast2.getName());
        }
        SaveAndLoad saveAndLoad = new SaveAndLoad(broadcastList, leadHostList);
        saveAndLoad.printData();
    }
}