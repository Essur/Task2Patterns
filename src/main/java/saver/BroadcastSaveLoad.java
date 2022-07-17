package saver;

import broadcasting.Broadcast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BroadcastSaveLoad implements Serializable{
    private List<Broadcast> broadcastList = new ArrayList<>();

    public BroadcastSaveLoad(List<Broadcast> broadcasts) {
        if (!broadcasts.isEmpty()) {
            this.broadcastList.addAll(broadcasts);
            saveBroadcast();
        }
    }
    public void saveBroadcast(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("broadcasting.dat"))) {
            oos.writeObject(broadcastList);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }
    public void loadBroadcast() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("broadcasting.dat"))) {
            List<Broadcast> readList = (List<Broadcast>) ois.readObject();
            for (Broadcast broadcast : readList) {
                System.out.println(broadcast);
            }
            broadcastList.addAll(readList);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
