package broadcasting;

import java.io.Serializable;

public class Interview implements Serializable {
    private static final double COST_PER_SEC_INTERVIEW = 30.0;
    private String person;
    private int time;

    public Interview(String person, int time) {
        this.person = person;
        this.time = time;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCost() {
        return this.time * COST_PER_SEC_INTERVIEW;
    }

    @Override
    public String toString() {
        return "{" +
                "person='" + person + '\'' +
                ", time=" + time +
                '}';
    }
}
