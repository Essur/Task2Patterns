package saver;

import presenter.InvitedLeadHost;
import presenter.LeadHost;
import presenter.MainLeadHost;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeadHostSaver implements Serializable{
    private List<LeadHost> leadHostList = new ArrayList<>();
    public LeadHostSaver(List<LeadHost> leadHosts){
        leadHostList.addAll(leadHosts);
        saveLeadHost();
    }
    public void saveLeadHost(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("leadHost.dat"))) {
            if(!leadHostList.isEmpty()){
                oos.writeObject(leadHostList);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }
    public void loadLeadHost() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("leadHost.dat"))) {
            Object object = ois.readObject();
            if (object instanceof MainLeadHost){
                leadHostList.add((MainLeadHost) object);
            }
            if (object instanceof InvitedLeadHost){
                leadHostList.add((InvitedLeadHost) object);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void printLeadHost(){
        loadLeadHost();
        if (!leadHostList.isEmpty()){
            for (LeadHost leadHosts: leadHostList) {
                System.out.println(leadHosts);
            }
        }
    }
}
