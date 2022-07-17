package broadcasting;

public interface BroadcastBuilder {
    public BroadcastBuilder chooseSong(String name, String author, int time);
    public  BroadcastBuilder chooseAdd(String name, int time);
    public BroadcastBuilder chooseInterview(String person, int time);
    public Broadcast createBroadcast(String name);
}
