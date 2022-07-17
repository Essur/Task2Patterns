package presenter;

import broadcasting.BroadcastBuilder;

public class InvitedLeadHost extends LeadHost{
    private String name;
    private String cv;

    public InvitedLeadHost(BroadcastBuilder broadcastBuilder, String name, String cv) {
        this.broadcastBuilder = broadcastBuilder;
        this.name = name;
        this.cv = cv;
    }


    public String getName() {
        return name;
    }

    public String getCv() {
        return cv;
    }

    @Override
    public String toString() {
        return "InvitedLeadHost{" +
                ", name='" + name + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }

}
