package broadcasting;

import java.io.Serializable;

public class Advertisement implements Serializable {
    private static final double PRICE_PER_SECOND = 5.0;
    private String name;
    private int time;

    public Advertisement(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCost() {
        return this.time * PRICE_PER_SECOND;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
