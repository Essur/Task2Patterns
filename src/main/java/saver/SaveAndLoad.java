package saver;

import broadcasting.Broadcast;
import presenter.InvitedLeadHost;
import presenter.LeadHost;
import presenter.MainLeadHost;

import java.io.*;
import java.util.List;

public class SaveAndLoad {
    private List<Broadcast> broadcastList;
    private List<LeadHost> leadHostList;

    public SaveAndLoad(List<Broadcast> broadcastList, List<LeadHost> leadHostList) {
        this.broadcastList = broadcastList;
        this.leadHostList = leadHostList;
        saveData();
    }
    public void saveData(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("broadcast_leadHost.dat"))) {
            oos.writeObject(broadcastList);
            oos.writeObject(leadHostList);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }
    public void loadData(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("broadcast_leadHost.dat"))) {
            Object object = ois.readObject();
            if (object instanceof MainLeadHost){
                leadHostList.add((MainLeadHost) object);
            }
            if (object instanceof InvitedLeadHost){
                leadHostList.add((InvitedLeadHost) object);
            }
            if (object instanceof Broadcast){
                broadcastList.add((Broadcast) object);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printData(){
        loadData();
        if(!broadcastList.isEmpty()){
            System.out.println("Broadcasts");
            for(Broadcast broadcast: broadcastList){
                System.out.println(broadcast);
            }
        } else System.out.println("No broadcasts");
        if(!leadHostList.isEmpty()){
            System.out.println("Lead hosts");
            for(LeadHost leadHost: leadHostList){
                System.out.println(leadHost);
            }
        } else System.out.println("No lead hosts");
    }
}
